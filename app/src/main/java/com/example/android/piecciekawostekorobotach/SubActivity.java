package com.example.android.piecciekawostekorobotach;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Bundle extras = getIntent().getExtras();
        int factNumber = extras.getInt("number");
        //Log.d("haha", String.valueOf(value));



        /// Handling of the I know this checkbox
        CheckBox knowCheckBox = (CheckBox) findViewById(R.id.i_know_this_checkbox);
        boolean knowsAlready = ((App) this.getApplication()).getKnowsFact(factNumber);
        assert knowCheckBox != null;
        knowCheckBox.setChecked(knowsAlready);

        /// Set up all the views in the layout for changing
        TextView title = (TextView) findViewById(R.id.title);
        ImageView illustration = (ImageView) findViewById(R.id.illustration);
        TextView content = (TextView) findViewById(R.id.content);

        Log.d("haha", String.valueOf(factNumber));

        switch(factNumber) {
            case 0:
                title.setText(getResources().getString(R.string.fact1_title));
                illustration.setImageResource(R.drawable.rur_plakat);
                content.setText(getResources().getString(R.string.fact1_content));
                break;
            case 1:
                title.setText(getResources().getString(R.string.fact2_title));
                content.setText(getResources().getString(R.string.fact2_content));
                break;
            case 2:
                title.setText(getResources().getString(R.string.fact3_title));
                content.setText(getResources().getString(R.string.fact3_content));
                break;
            case 3:
                title.setText(getResources().getString(R.string.fact4_title));
                content.setText(getResources().getString(R.string.fact4_content));
                break;
            case 4:
                title.setText(getResources().getString(R.string.fact5_title));
                content.setText(getResources().getString(R.string.fact5_content));
                break;
        }
    }

    // TODO make the checkbox isChecked separate for every "fact"
    /// there's an array of 5 booleans
    public void saveCheck(View view) {
        Bundle extras = getIntent().getExtras();
        int factNumber = extras.getInt("number");
        // ^ czy to musi byc tu?  :/
        CheckBox knowCheckBox = (CheckBox) findViewById(R.id.i_know_this_checkbox);
        boolean knows = knowCheckBox != null && knowCheckBox.isChecked();
        ((App) this.getApplication()).setKnowsFact(factNumber, knows);
    }
}
