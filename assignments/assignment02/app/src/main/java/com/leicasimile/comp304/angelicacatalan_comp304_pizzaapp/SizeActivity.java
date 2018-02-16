package com.leicasimile.comp304.angelicacatalan_comp304_pizzaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SizeActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_size);

        // Display sizes in RadioButton text
        RadioButton radSmall = findViewById(R.id.size_radSmall);
        radSmall.setText(getResources().getText(R.string.size_small));
        RadioButton radMedium = findViewById(R.id.size_radMedium);
        radMedium.setText(getResources().getText(R.string.size_medium));
        RadioButton radLarge = findViewById(R.id.size_radLarge);
        radLarge.setText(getResources().getText(R.string.size_large));
        RadioButton radXl = findViewById(R.id.size_radXl);
        radXl.setText(getResources().getText(R.string.size_xl));

        // Set default size
        radSmall.setChecked(true);

        // Set btnNext colour to orange
        Button btnNext = findViewById(R.id.size_btnNext);
        btnNext.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

        // Set event-handlers
        Button btnBack = findViewById(R.id.size_btnBack);
        btnBack.setOnClickListener(this);
        btnNext.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.size_btnBack: {
                // Go back to MainActivity
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
                break;
            }
            case R.id.size_btnNext: {
                Intent currentI = getIntent();
                Intent newI = new Intent(this, ToppingsActivity.class);

                // Get selected size
                RadioGroup grpSize = findViewById(R.id.size_radgrpSize);
                RadioButton radSelected = findViewById(grpSize.getCheckedRadioButtonId());

                newI.putExtra("type", currentI.getStringExtra("type"));
                newI.putExtra("size", radSelected.getText());

                // Go to next activity
                startActivity(newI);
                break;
            }
        }
    }
}
