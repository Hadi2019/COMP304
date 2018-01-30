package com.leicasimile.comp304.intentapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtMessage = (TextView) findViewById(R.id.txtMessage);
        txtMessage.setText(R.string.message);
    }

}
