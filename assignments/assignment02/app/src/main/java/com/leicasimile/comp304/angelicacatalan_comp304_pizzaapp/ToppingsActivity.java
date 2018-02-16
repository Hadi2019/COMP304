package com.leicasimile.comp304.angelicacatalan_comp304_pizzaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;

public class ToppingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toppings);

        // Display toppings in CheckBox text
        CheckBox chkTopping1 = findViewById(R.id.toppings_chkTopping1);
        chkTopping1.setText(getResources().getText(R.string.toppings_1));
        CheckBox chkTopping2 = findViewById(R.id.toppings_chkTopping2);
        chkTopping2.setText(getResources().getText(R.string.toppings_2));
        CheckBox chkTopping3 = findViewById(R.id.toppings_chkTopping3);
        chkTopping3.setText(getResources().getText(R.string.toppings_3));
        CheckBox chkTopping4 = findViewById(R.id.toppings_chkTopping4);
        chkTopping4.setText(getResources().getText(R.string.toppings_4));
        CheckBox chkTopping5 = findViewById(R.id.toppings_chkTopping5);
        chkTopping5.setText(getResources().getText(R.string.toppings_5));
        CheckBox chkTopping6 = findViewById(R.id.toppings_chkTopping6);
        chkTopping6.setText(getResources().getText(R.string.toppings_6));

        // Set btnNext colour to orange
        Button btnNext = findViewById(R.id.toppings_btnNext);
        btnNext.setBackgroundColor(getResources().getColor(R.color.nextButton));
    }
}
