package com.leicasimile.comp304.angelicacatalan_comp304_pizzaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class CustomerInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_info);

        Button btnNext = findViewById(R.id.customerInfo_btnOrder);
        btnNext.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
    }

    protected boolean validateForm() {
        return false;
    }
}
