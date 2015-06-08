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
import android.widget.Toast;


public class Semester extends ActionBarActivity {

    String[] semester;
    String str1;
    String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester);
//        Toast.makeText(Semester.this,
//                str, Toast.LENGTH_LONG).show();
        str1= getIntent().getStringExtra("str");
        str=str1;
        if(str.equals("0")){
            semester=new String[]{"I","II"};
        }
        else
        {
            semester=new String[]{"III","IV","V","VI","VII","VIII"};
        }
        ArrayAdapter<String> myAdapter2=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,
                semester);
        final ListView myList2=
                (ListView) findViewById(R.id.listView2);
        myList2.setAdapter(myAdapter2);
        myList2.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//                String value = myList2.getAdapter().getItem(position).toString();
                int value= (int) myList2.getAdapter().getItemId(position);
                //display value here
                if(str.length()==1)
                str=str+value;
                else
                str=str1+value;
                if(str.equals("25")||str.equals("30")||str.equals("33")||str.equals("34")||str.equals("35")) {
               Toast.makeText(Semester.this,
                       "We don't have notes for this semester", Toast.LENGTH_LONG).show();
                }
                else {
                    Intent i = new Intent(Semester.this, Subject.class);
                    i.putExtra("str", str);
                    startActivity(i);
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_semester, menu);
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
