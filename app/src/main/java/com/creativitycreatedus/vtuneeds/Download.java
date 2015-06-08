package com.creativitycreatedus.vtuneeds;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class Download extends ActionBarActivity {

    String link, save, str;
    private ProgressDialog pDialog;
    public static final int progress_bar_type = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        str = getIntent().getStringExtra("str");
        save = str + ".pdf";
        link = "http://vtuneedsn.parseapp.com/" + str + ".pdf";
    }

    public void download(View v) {

        new DownloadFile().execute(link, save);
    }

    public void view(View v) {
        File pdfFile = new File(Environment.getExternalStorageDirectory() + "/PassVTU/" + save);  // -> filename = maven.pdf
        Uri path = Uri.fromFile(pdfFile);
        Intent pdfIntent = new Intent(Intent.ACTION_VIEW);
        pdfIntent.setDataAndType(path, "application/pdf");
        pdfIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        try {
            startActivity(pdfIntent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(Download.this, "No Application available to view PDF", Toast.LENGTH_SHORT).show();
        }
    }



    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case progress_bar_type: // we set this to 0
                pDialog = new ProgressDialog(this);
                pDialog.setMessage("Downloading file. Please wait...");
                pDialog.setIndeterminate(false);
                pDialog.setMax(100);
                pDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                pDialog.setCancelable(true);
                pDialog.show();
                return pDialog;
            default:
                return null;
        }
    }

    class DownloadFile extends AsyncTask<String, String, String> {
        int count;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            showDialog(progress_bar_type);
        }

        @Override
        protected String doInBackground(String... strings) {

            String fileUrl = strings[0];   // -> http://maven.apache.org/maven-1.x/maven.pdf
            String fileName = strings[1];  // -> maven.pdf
//            String fileUrl =link;
//            String fileName =save;
            String extStorageDirectory = Environment.getExternalStorageDirectory().toString();
            File folder = new File(extStorageDirectory, "PassVTU");
            folder.mkdir();
            File pdfFile = new File(folder, fileName);

            try {
                pdfFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            downloadFile(fileUrl, pdfFile);
            return null;
        }

        public void downloadFile(String fileUrl, File directory) {



            try {

                URL url = new URL(fileUrl);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

                urlConnection.connect();

                int lenghtOfFile = urlConnection.getContentLength();
                Log.d("ANDRO_ASYNC", "Lenght of file: " + lenghtOfFile);



                InputStream inputStream = urlConnection.getInputStream();
                FileOutputStream fileOutputStream = new FileOutputStream(directory);
                int totalSize = urlConnection.getContentLength();


                final int MEGABYTE = 1024 * 1024;
                byte[] buffer = new byte[MEGABYTE];
                int bufferLength = 0;
                long total = 0;
                int k;
                String pqr;
                while ((bufferLength = inputStream.read(buffer)) > 0) {

                    total+=bufferLength;
                    k=(int)((total*100)/lenghtOfFile);
                    pqr=""+k;
                    publishProgress(pqr);
                    fileOutputStream.write(buffer, 0, bufferLength);
                }

                fileOutputStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                //Toast.makeText(Download.this,
                  //      "We don't have notes for this", Toast.LENGTH_LONG).show();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



        /**
         * Updating progress bar
         */
        protected void onProgressUpdate(String... progress) {
            // setting progress percentage
            //Log.d("ANDRO_ASYNC",progress[0]);
            pDialog.setProgress(Integer.parseInt(progress[0]));
        }


        protected void onPostExecute(String unused) {
            dismissDialog(progress_bar_type);
        }


    }

}


