package com.leicasimile.comp304.angelicacatalan_comp304_pizzaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class CustomerInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_info);

        Button btnNext = findViewById(R.id.customerInfo_btnOrder);
        btnNext.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

        // Set spinner values
        Spinner spnCardType = findViewById(R.id.customerInfo_spnCardType);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.card_types,
                android.R.layout.simple_spinner_dropdown_item);
        spnCardType.setAdapter(adapter);
    }

    protected boolean validateForm() {
        EditText editName = findViewById(R.id.customerInfo_editName);
        EditText editAddress = findViewById(R.id.customerInfo_editAddress);
        EditText editPostalCode = findViewById(R.id.customerInfo_editPostalCode);
        EditText editPhone = findViewById(R.id.customerInfo_editPhone);
        EditText editCardNo = findViewById(R.id.customerInfo_editCardNo);
        EditText editCvv = findViewById(R.id.customerInfo_editCvv);

        return false;
    }
}