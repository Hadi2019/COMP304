package com.leicasimile.comp304.webkitexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView wv = findViewById(R.id.main_webview);
        WebSettings wvSettings = wv.getSettings();
        wvSettings.setJavaScriptEnabled(true);
        wv.loadUrl("http://www.tomroyal.com/teaandkittens/");
        wv.setInitialScale(65);
    }
}
