package com.example.naveengaur.xbrldataprototype;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ScrollingTabContainerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public class DashBoard extends AppCompatActivity {
    protected static  TextView mTextView;
    protected  static LinearLayout sLinearLayout;
    protected static final int DIALOG_DOWNLOAD_PROGRESS=0;


    //protected static Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
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
        LinearLayout linearLayout=new LinearLayout(DashBoard.this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);



        mTextView=(TextView) findViewById(R.id.textView);
        mTextView.setText(MainActivity.abc);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DashBoard.this,DashBoard2.class);
                startActivity(intent);
                Download2 async=new Download2();

                async.execute(MainActivity.abc);
            }
        });






               // mTextView.append(Long.toString(MainActivity.ab));





    }









}
