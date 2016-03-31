package com.example.android.piecciekawostekorobotach;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

        /// Changing the colors of the buttons according to the knowsFact value
        String baseString = "btn";
        for(int i = 0; i < 5; i++) {
            if (((App) this.getApplication()).getKnowsFact(i)) {
                String idString=baseString.concat(Integer.toString(i+1));
                int idResource = getResources().getIdentifier(idString, "id", getPackageName());
                Button btn = (Button) findViewById(idResource);
                if (btn != null) {
                    btn.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                }
            }
        }

        /// Congratulations section
        App app = (App) this.getApplication();
        int i = 0;
        while(i < 5 && app.getKnowsFact(i)) {
            i++;
        }
        if (i == 5) {   /// If the user has read everything
            TextView tw = (TextView) findViewById(R.id.congrats);
            tw.setText(getResources().getString(R.string.congrats));

            /// Displaying of the congrats video
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

        startActivity(intent);
    }
}
