package com.leicasimile.comp304.angelicacatalan_comp304_pizzaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

// Angelica Catalan, 300846458
public class ToppingsActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toppings);

        // Set btnNext colour to orange
        Button btnNext = findViewById(R.id.toppings_btnNext);
        btnNext.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

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
            case R.id.toppings_btnNext: {
                Intent currentI = getIntent();
                Intent newI = new Intent(this, CustomerInfoActivity.class);

                // Get selected toppings
                CheckBox[] chklistToppings = {
                        findViewById(R.id.toppings_chkTopping1),
                        findViewById(R.id.toppings_chkTopping2),
                        findViewById(R.id.toppings_chkTopping3),
                        findViewById(R.id.toppings_chkTopping4),
                        findViewById(R.id.toppings_chkTopping5),
                        findViewById(R.id.toppings_chkTopping6)
                };
                List<String> toppings = new ArrayList<String>();

                for (CheckBox chk : chklistToppings) {
                    if (chk.isChecked()) {
                        toppings.add(chk.getText().toString());
                    }
                }

                newI.putExtra("type", currentI.getStringExtra("type"));
                newI.putExtra("size", currentI.getStringExtra("size"));
                newI.putExtra("toppings", toppings.toArray());

                // Go to next activity
                startActivity(newI);
                break;
            }
        }
    }
}
