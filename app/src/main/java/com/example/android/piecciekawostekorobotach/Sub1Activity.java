package com.example.android.piecciekawostekorobotach;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;

public class Sub1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub1);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //checkIfKnows(this.getParent());

        CheckBox knowCheckBox = (CheckBox) findViewById(R.id.i_know_this_checkbox);
        boolean knowsAlready = ((App) this.getApplication()).getKnowsFact1();
        knowCheckBox.setChecked(knowsAlready);
        Log.d("Sub1Activity", "knowsAlready: " + knowsAlready);
    }

    public void saveCheck(View view) {
        CheckBox knowCheckBox = (CheckBox) findViewById(R.id.i_know_this_checkbox);
        boolean knows = knowCheckBox.isChecked();
        ((App) this.getApplication()).setKnowsFact1(knows);
    }


//    public void checkIfKnows(Activity view) {
//        CheckBox knowCheckBox = (CheckBox) findViewById(R.id.i_know_this_checkbox);
//        boolean knowsAlready = ((App) this.getApplication()).getKnowsFact1();
//        knowCheckBox.setChecked(knowsAlready);
//    }
}
