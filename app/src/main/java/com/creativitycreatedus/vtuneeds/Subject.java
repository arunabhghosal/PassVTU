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


public class Subject extends ActionBarActivity {

    String[] subs;
    String str,str1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);
        str1= getIntent().getStringExtra("str");
        str=str1;
        if (str.equals("00")){
             subs= new String[]{ "Basic Electronics", "Computer Aided Drawing",
                     "Computer Programing Lab",
                      "Engg Chemistry", "Enng Chemistry Lab", "Engg Maths I"
                     ,   "Environmental Studies", "Programming in C"
                     };
        }
       if(str.equals("01")){
           subs=new String[]{
                   "Basi Electrical", "Constitutional & Ethics","Element of Civil Engg","Elements of Mech Engg",
                   "Engg Maths II","Engg Physics", "Engg Physics Lab","Workshop Lab"
           };
       }



        else if(str.equals("10")){
             subs= new String[]{"DMS","Data Structure with C","Engg Maths III", "DS Lab", "EC & LD Lab", "Electronic Circuits"
                     ,  "Logic Design", "OOPS with C++"
             };
        }
        else if(str.equals("11")){
             subs= new String[]{"Computer Organisation", "DAA", "DAA Lab", "Engg Maths IV", "GTC", "MP",
                     "MP Lab", "Unix & Shell"
             };
        }
        else if(str.equals("12")){
            subs= new String[]{
                    "Computer Networks","Databse Applications Lab","DBMS",
                    "Formal language & Automata Therory","Operating Systems",
                    "Software Engineering","System Softwares","System Software Labs"
            };
        }




           else if(str.equals("13")) {
           subs = new String[]{
                   //"Data Compression",
                   "Operation Research",
                   //"Pattern Recognition",
                   "Programming Languages",
                   //"Signals and Systems", "Stochastic Models and Applications",
                   "Compiler Design", //"File Structures Lab",
                   "Unix System Prog& Compiler Design Lab", "Unix System Programming"
           };
       }

           else if(str.equals("14")) {
           subs = new String[]{
                   "Advanced Computer Architectures", "Data Werehousing and Data Mining", "JAVA and J2EE", "Storage Area Networks", "Networks Lab",
                   "Object Oriented Modeling and Design", "Programming the Web", "Web Programming Lab"
           };
       }

           else if(str.equals("15")) {
           subs = new String[]{"Web 2.0 and Rich Internet Applications", "System Modeling and Simulation"

           };
       }





           else if(str.equals("20")) {
           subs = new String[]{"Analog Electronic Circuits", "Analog Electronic Lab", "Electronic Instrumentaion","Mathamatics",
                   "Field Theory","Logic Design Lab", "Network Analysis"
           };
       }

           else if(str.equals("21")) {
           subs = new String[]{
                   "HDL Lab", "MicroController Lab", "Microcontrollers"
           };
       }


           else if(str.equals("22")) {
           subs = new String[]{"Analog Communication Lab", "Digital Signal Processing", "Information Theory and Coding", "Management & Enterpreneurship", "Microwaves and Radar"

           };
       }

           else if(str.equals("23")) {
           subs = new String[]{"Analog and Mixed Mode VLSI Design", "Advanced Communication Lab",
                   "Antennas and Propagation", "Microprocessor Lab","Microprocessor",
           };
       }

           else if(str.equals("24")) {
           subs = new String[]{
                   "VLSI Lab", "Power Electronics Lab", "Embedded System",
                   "DSP Algorithms and Architecture", "Computer Communication Networks", "Image Processing"
           };
       }

           else if(str.equals("31")) {
           subs = new String[]{
                   "Applied Thermodynamics", "Engineering Mathematics 4", "Fluid Machines"
           };
       }



           else if(str.equals("32")){
           subs = new String[]{"Dynamics of Machine", "Manufacturing Machines"
           };

       }



























        //
        ArrayAdapter<String> myAdapter3=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,
                subs);
        final ListView myList3=
                (ListView) findViewById(R.id.listView3);
        myList3.setAdapter(myAdapter3);
        myList3.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//                String value = myList2.getAdapter().getItem(position).toString();
                int value= (int) myList3.getAdapter().getItemId(position);
                //display value here
                if(str.length()==2) {
                    str = str + value;
                    str = str + "1";
                }
                else
                {
                    str=str1+value;
                    str=str+"1";
                }
                if (str.equals("0011")||str.equals("0021")||str.equals("0031")||str.equals("0041")
                        ||str.equals("0061")||str.equals("0111")||str.equals("0161")
                        ||str.equals("0171")||str.equals("1141")||str.equals("1151")
                        ||str.equals("1071")||str.equals("1211")||str.equals("1451")) {
                    str=str1;
                    Toast.makeText(Subject.this,
                        "We don't have Notes for this Subject", Toast.LENGTH_LONG).show();
                }
                else {
                    Intent i = new Intent(Subject.this, Download.class);
                    i.putExtra("str", str);
                    startActivity(i);
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_subject, menu);
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
