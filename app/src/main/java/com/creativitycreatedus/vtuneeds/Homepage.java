package com.creativitycreatedus.vtuneeds;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class Homepage extends ActionBarActivity {
    static String str;
    String[] stream={"Science & Humanities","CSE/ISE","ECE","Mech"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        str="";
        ArrayAdapter<String> myAdapter=new
                ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                stream);
        final ListView myList=
                (ListView) findViewById(R.id.listView);
        myList.setAdapter(myAdapter);
//
//        AdapterView.OnItemClickListener
//                mMessageClickedHandler =
//                new AdapterView.OnItemClickListener() {
//                    public void onItemClick(AdapterView parent,
//                                            View v,
//                                            int position,
//                                            long id) {
//                        ((TextView)v).setText("selected");
//                    }
//
//                };
        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                int value = (int) myList.getAdapter().getItemId(position);
                str= "" + value;
                Intent i =new Intent(Homepage.this,Semester.class);
                i.putExtra("str",str);
                startActivity(i);

            }
        });

//        myList.setOnItemClickListener(
//                mMessageClickedHandler);
//        int position = 0;
//        myList.setSelection(position);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_homepage, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
