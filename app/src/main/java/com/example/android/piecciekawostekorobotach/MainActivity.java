package com.example.android.piecciekawostekorobotach;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Button btn1 = (Button) findViewById(R.id.btn1);
//        Button btn2 = (Button) findViewById(R.id.btn2);
//        Button btn3 = (Button) findViewById(R.id.btn3);
//        Button btn4 = (Button) findViewById(R.id.btn4);
//        Button btn5 = (Button) findViewById(R.id.btn5);
//
//        btn1.setOnClickListener();

        String baseString = "btn";
        for(int i = 0; i < 5; i++) {
            if (((App) this.getApplication()).getKnowsFact(i)) {
                Log.d("Main", "w srodku if " + i);
                String idString=baseString.concat(Integer.toString(i+1));
                Log.d("Main", baseString);
                int idResource = getResources().getIdentifier(idString, "id", getPackageName());
                Button btn = (Button) findViewById(idResource);
                if (btn != null) {
                    btn.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                }
            }
        }


        /// Nagroda
        App app = (App) this.getApplication();
        int i = 0;
        while(i < 5 && app.getKnowsFact(i)) {
            i++;
        }
        if (i == 5) {       /// if the user read everything
            TextView tw = (TextView) findViewById(R.id.congrats);
            tw.setText(getResources().getString(R.string.congrats));


            /// displaying of the vine
            String frameVideo = "<center><iframe src=\"https://vine.co/v/iXWz6516Ipz/embed/simple\" width=\"300\" height=\"300\" frameborder=\"0\"></iframe></center><script src=\"https://platform.vine.co/static/scripts/embed.js\"></script>";

            WebView displayVideo = (WebView)findViewById(R.id.webView);
            displayVideo.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    return false;
                }
            });
            WebSettings webSettings = displayVideo.getSettings();
            displayVideo.setBackgroundColor(getResources().getColor(R.color.transparent));
            webSettings.setJavaScriptEnabled(true);

            /// resizing displayVideo WebView to be the size of the contents
    //        RelativeLayout layout = new RelativeLayout(this);
    //        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
    //                RelativeLayout.LayoutParams.WRAP_CONTENT,
    //                RelativeLayout.LayoutParams.WRAP_CONTENT);
    //        displayVideo.setLayoutParams(lp);

            displayVideo.loadData(frameVideo, "text/html", "utf-8");
        }
    }

    public void openFact(View view) {
        int idView = view.getId();

        Intent intent = new Intent(MainActivity.this, SubActivity.class);

        switch(idView) {
            case R.id.btn1:
                intent.putExtra("number", 0);
                break;
            case R.id.btn2:
                intent.putExtra("number", 1);
                break;
            case R.id.btn3:
                intent.putExtra("number", 2);
                break;
            case R.id.btn4:
                intent.putExtra("number", 3);
                break;
            case R.id.btn5:
                intent.putExtra("number", 4);
                break;
        }

        //Intent intent = new Intent(MainActivity.this, Sub1Activity.class);
        startActivity(intent);
    }



}
