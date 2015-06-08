package com.creativitycreatedus.vtuneeds;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class Notes extends Subject {
    String[] nots={"Notes-Unit wise","Important Questions","Previous Year Papers"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        ArrayAdapter<String> myAdapter4=new
                ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                nots);
        final ListView myList4=
                (ListView) findViewById(R.id.listView4);
        myList4.setAdapter(myAdapter4);


        myList4.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//                String value = myList2.getAdapter().getItem(position).toString();
                int value= (int) myList4.getAdapter().getItemId(position);
                //display value here
                str=str+value;
                Toast.makeText(Notes.this,
                        str, Toast.LENGTH_LONG).show();
                
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_notes, menu);
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
