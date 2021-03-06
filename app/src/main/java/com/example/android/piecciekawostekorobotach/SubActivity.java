package com.example.android.piecciekawostekorobotach;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

        /// Handling of the I know this checkbox
        CheckBox knowCheckBox = (CheckBox) findViewById(R.id.i_know_this_checkbox);
        boolean knowsAlready = ((App) this.getApplication()).getKnowsFact(factNumber);
        assert knowCheckBox != null;
        knowCheckBox.setChecked(knowsAlready);

        /// Set up all the views in the layout for changing
        TextView title = (TextView) findViewById(R.id.title);
        ImageView illustration = (ImageView) findViewById(R.id.illustration);
        TextView content = (TextView) findViewById(R.id.content);

        switch(factNumber) {
            case 0:
                title.setText(getResources().getString(R.string.fact1_title));
                illustration.setImageResource(R.drawable.rur_plakat);
                illustration.getLayoutParams().height = 600;
                content.setText(getResources().getString(R.string.fact1_content));
                break;
            case 1:
                title.setText(getResources().getString(R.string.fact2_title));
                illustration.setImageResource(R.drawable.asimov);
                content.setText(getResources().getString(R.string.fact2_content));
                break;
            case 2:
                title.setText(getResources().getString(R.string.fact3_title));
                illustration.setImageResource(R.drawable.serv);
                content.setText(getResources().getString(R.string.fact3_content));
                break;
            case 3:
                title.setText(getResources().getString(R.string.fact4_title));
                illustration.setImageResource(R.drawable.metropolis_c3po);
                content.setText(getResources().getString(R.string.fact4_content));
                break;
            case 4:
                title.setText(getResources().getString(R.string.fact5_title));
                illustration.setImageResource(R.drawable.go);
                content.setText(getResources().getString(R.string.fact5_content));
                break;
        }
    }

    /**
     * A method setting the app-wide variables.
     * Sets the appropriate variable in the App.knowsFact array if the checkbox is checked.
     */
    public void saveCheck(View view) {
        Bundle extras = getIntent().getExtras();
        int factNumber = extras.getInt("number");

        CheckBox knowCheckBox = (CheckBox) findViewById(R.id.i_know_this_checkbox);
        boolean knows = knowCheckBox != null && knowCheckBox.isChecked();
        ((App) this.getApplication()).setKnowsFact(factNumber, knows);
    }
}
