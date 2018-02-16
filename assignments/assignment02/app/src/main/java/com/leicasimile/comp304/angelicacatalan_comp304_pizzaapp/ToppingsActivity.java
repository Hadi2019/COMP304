package com.leicasimile.comp304.angelicacatalan_comp304_pizzaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class ToppingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toppings);

        Button btnNext = findViewById(R.id.toppings_btnNext);
        btnNext.setBackgroundColor(getResources().getColor(R.color.nextButton));
    }
}
