package com.leicasimile.comp304.angelicacatalan_comp304_pizzaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ToppingsActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toppings);

        // Set btnNext colour to orange
        Button btnNext = findViewById(R.id.toppings_btnNext);
        btnNext.setBackgroundColor(getResources().getColor(R.color.nextButton));

        // Set event-handlers
        Button btnBack = findViewById(R.id.toppings_btnBack);
        btnBack.setOnClickListener(this);
        btnNext.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toppings_btnBack: {
                // Go back to SizeActivity
                Intent i = new Intent(this, SizeActivity.class);
                i.putExtra("type", getIntent().getStringExtra("type"));
                startActivity(i);
                break;
            }
            case R.id.size_btnNext: {
                Intent currentI = getIntent();
                Intent newI = new Intent(this, CustomerInfoActivity.class);

                // Get selected toppings
                String[] toppings = {};

                newI.putExtra("type", currentI.getStringExtra("type"));
                newI.putExtra("size", currentI.getStringExtra("size"));

                // Go to next activity
                startActivity(newI);
                break;
            }
        }
    }
}
