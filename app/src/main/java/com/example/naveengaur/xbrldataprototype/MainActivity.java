package com.example.naveengaur.xbrldataprototype;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
private EditText compName;
private Button submit;
private TextView text;
    protected static  ProjectA A=null;  //  static because  we need this variable in other activities
    protected static Thread t;
    private static final String  URL1="http://edgaronline.api.mashery.com/v2/companies?companynames=*";
    private static final String  URL1_2="*&limit=10&appkey=geff5qfm8ce9ndqvve7hu9yy";
   private URL url;
   protected static String abc="";
   protected static long ab;
   protected static boolean finish=false;
   protected  static AsyncTask<String,Void,Long>asyncTask1;
protected static String cik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // assigning  the variables  to widget we created by ID
        compName=(EditText)  findViewById(R.id.editText);
        submit=(Button) findViewById(R.id.button);
        //text=(TextView)findViewById(R.id.textView2);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    abc=compName.getText().toString();

                         // get the response


               //asyncTask1= new download().execute( abc);
                //if you have a async task ina differrnt class,that's how you do it.

               // Download2 async=new Download2();
                //async.execute(abc);


                Intent intent = new Intent(MainActivity.this, DashBoard.class);
                startActivity(intent);


            }
        });




    }
    //  similar to multi Threading in java
     protected class download extends AsyncTask<String,Void,Long>
    {
        @Override
        protected Long doInBackground(String... params) {
            int count=params.length;
            for(int i=0;i<count;i++) {
                A = new ProjectA(params[i]);
            }
            return A.getAssetsAmountAmount();
        }
        // after the process is done in the background ,then this will  execute
        @Override
        protected void onPostExecute(Long result)
        {              // Intent intent = new Intent(MainActivity.this, DashBoard.class);

                   // startActivity(intent);
            finish=true;


            ab=result;


            // after storing the result it will update in the dashboard


            DashBoard.mTextView.setBackgroundColor(Color.parseColor("#ff33b5e5"));
            DashBoard.mTextView.append(Long.toString(MainActivity.ab));


            //text.setText(Long.toString(result));
        }

    }
}
