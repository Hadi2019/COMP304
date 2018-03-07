package com.leicasimile.comp304.angelicacatalan_comp304_pizzaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

// Angelica Catalan, 300846458
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

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.customerInfo_btnBack: {
                // Go back to MainActivity
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
                break;
            }
            case R.id.customerInfo_btnOrder: {
                if (validateForm()) {
                    Intent currentI = getIntent();
                    Intent newI = new Intent(this, ToppingsActivity.class);
                    EditText editName = findViewById(R.id.customerInfo_editName);

                    newI.putExtra("type", currentI.getStringExtra("type"));
                    newI.putExtra("size", currentI.getStringExtra("size"));
                    newI.putExtra("name", editName.getText());

                    // Go to next activity
                    startActivity(newI);
                }
                break;
            }
        }
    }

    protected boolean validateForm() {
        EditText editName = findViewById(R.id.customerInfo_editName);
        EditText editAddress = findViewById(R.id.customerInfo_editAddress);
        EditText editPostalCode = findViewById(R.id.customerInfo_editPostalCode);
        EditText editPhone = findViewById(R.id.customerInfo_editPhone);
        EditText editCardNo = findViewById(R.id.customerInfo_editCardNo);
        EditText editCvv = findViewById(R.id.customerInfo_editCvv);
        boolean isValid = true;

        if (editName.getText().toString().length() < 1) {
            editName.setError("Name required.");
            isValid = false;
        }
        if (editAddress.getText().toString().length() < 1) {
            editAddress.setError("Address required.");
            isValid = false;
        }
        if (editPostalCode.getText().toString().length() < 5) {
            editPostalCode.setError("Postal code must have at least 5 characters.");
            isValid = false;
        }
        if (editPhone.getText().toString().length() < 5) {
            editPhone.setError("Phone number must have at least 5 digits.");
            isValid = false;
        }
        if (editCardNo.getText().toString().length() < 15) {
            editCardNo.setError("Card number is too short.");
            isValid = false;
        }
        if (editCvv.getText().toString().length() < 3) {
            editCvv.setError("CVV required.");
            isValid = false;
        }
        if (editAddress.getText().toString().length() < 4) {
            editAddress.setError("Date required (MMYY).");
            isValid = false;
        }

        return isValid;
    }
}