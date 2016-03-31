package com.example.android.piecciekawostekorobotach;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Sub2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub2);

        Bundle extras = getIntent().getExtras();
        int factNumber = extras.getInt("number");
        //Log.d("haha", String.valueOf(value));


//        TextView title = (TextView) findViewById(R.id.)
//
//        switch(factNumber) {
//            case 1:
//
//        }
    }


}
