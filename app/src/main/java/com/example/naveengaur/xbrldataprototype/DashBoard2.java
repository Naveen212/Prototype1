package com.example.naveengaur.xbrldataprototype;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DashBoard2 extends AppCompatActivity {
protected static EditText Assets;

    protected static EditText  Liabilities;
protected static EditText LiquidityRatio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Assets=(EditText)findViewById(R.id.assets1);
        Liabilities=(EditText)findViewById(R.id.liab);
        LiquidityRatio=(EditText)findViewById(R.id.ratio);
        //Assets.setText("Hey");
        //Liabilities.setText("bye");
       //LiquidityRatio.setText("HII");










    }

}
