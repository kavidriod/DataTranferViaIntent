package com.apps.datatranferviaintent;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {


    TextView nameTextview,phoneTextview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        nameTextview = (TextView) findViewById(R.id.nameTextview);
        phoneTextview = (TextView) findViewById(R.id.phoneTextview);

        //Get Values from Calling Activity

        Bundle bundle = getIntent().getExtras();

        String name = bundle.getString("NAME");
        int phoneNo = bundle.getInt("PHONENO");

        nameTextview.setText("Name ? "+name);
        phoneTextview.setText("PhoneNo ? "+phoneNo);

    }

}
