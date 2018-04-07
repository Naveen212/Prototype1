package com.example.naveengaur.xbrldataprototype;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;

/**
 * Created by naveengaur on 7/4/18.
 */

public class Download2 extends AsyncTask<String,Integer,String>
{



    @Override
    protected String doInBackground(String... params) {
        int count=params.length;
        for(int i=0;i<count;i++) {
            MainActivity.A = new ProjectA(params[i]);

        }
        return  MainActivity.A.getCIK();

    }

    @Override
    protected void onPostExecute(String result)
    {
        //MainActivity.finish=true;




              DashBoard2.Assets.append("Assets : "+MainActivity.A.getAssetsAmountAmount());
              DashBoard2.Liabilities.append("Liabilities : "+MainActivity.A.getLiabilitiesAmount());






        // Intent intent = new Intent(MainActivity.this, DashBoard.class);

        // startActivity(intent);



       // MainActivity.cik=result;


        // after storing the result it will update in the dashboard


        //DashBoard.mTextView.setBackgroundColor(Color.parseColor("#ff33b5e5"));
        //DashBoard.mTextView.append(MainActivity.cik);


        //text.setText(Long.toString(result));
    }


}
