package com.leicasimile.comp304.angelicacatalan_comp304_pizzaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;

public class SizeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_size);

        // Display sizes in radiobutton text
        RadioButton radSmall = findViewById(R.id.size_radSmall);
        radSmall.setText(getResources().getText(R.string.size_small));
        RadioButton radMedium = findViewById(R.id.size_radMedium);
        radMedium.setText(getResources().getText(R.string.size_medium));
        RadioButton radLarge = findViewById(R.id.size_radLarge);
        radLarge.setText(getResources().getText(R.string.size_large));
        RadioButton radXl = findViewById(R.id.size_radXl);
        radXl.setText(getResources().getText(R.string.size_xl));

        // Set btnNext colour to orange
        Button btnNext = findViewById(R.id.size_btnNext);
        btnNext.setBackgroundColor(getResources().getColor(R.color.nextButton));
    }
}
