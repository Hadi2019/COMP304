package com.leicasimile.comp304.comp304_001_assignment4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class RegisterActivity extends AppCompatActivity {
    private Spinner spnPrograms;
    private DatabaseManager db;
    private String username;
    private String program;
    private double tuitionFee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = DatabaseManager.getInstance(this);

        spnPrograms = findViewById(R.id.register_spnPrograms);
        setWelcomeMessage();
        setSpinnerValues();

        // Event-handlers
        final Spinner spnPrograms = findViewById(R.id.register_spnPrograms);
        spnPrograms.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                program = spnPrograms.getSelectedItem().toString();
                tuitionFee = Double.parseDouble(db.getField("Program", "tuitionFee",
                        "programName", program));
                displayTuition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        final EditText editPayment = findViewById(R.id.register_editPayment);
        editPayment.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String paymentString = editPayment.getText().toString();
                if (paymentString.isEmpty()) {
                    editPayment.setText("0");
                    editPayment.setSelection(1);
                    return;
                }

                String[] paymentSplit = paymentString.split("\\.");
                double payment = Double.parseDouble(paymentString);

                if (payment > tuitionFee) {
                    // Payment cannot exceed tuition fee
                    editPayment.setText(String.format("%.2f", tuitionFee));
                } else if (paymentSplit.length > 1) {
                    // Limit to two decimal places
                    String paymentDecimal = paymentSplit[1];
                    if (paymentDecimal.length() > 2 ) {
                        editPayment.setText(String.format("%s.%s",
                                paymentSplit[0], paymentDecimal.substring(0, 2)));
                    }
                } else {
                    return;
                }
                editPayment.setSelection(editPayment.getText().length());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        Button btnRegister = findViewById(R.id.register_btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });
    }

    private void setWelcomeMessage() {
        // Set welcome message for student
        TextView txtName = findViewById(R.id.register_txtName);
        username = getSharedPreferences("UserRegistration", MODE_PRIVATE)
                .getString("username", "");
        String firstname = db.getField("Student", "firstname",
                "username", username);
        String lastname = db.getField("Student", "lastname",
                "username", username);
        txtName.setText(String.format("Hi, %s %s", firstname, lastname));
    }

    private void setSpinnerValues() {
        // Populate spinner with programs
        List programRecords = db.getRecords("Program", new String[]{"programName"});
        String[] programs = new String[programRecords.size()];

        for (int i = 0; i < programRecords.size(); i++) {
            programs[i] = ((ArrayList)programRecords.get(i)).get(i).toString();
        }

        ArrayAdapter<String> adapter;

        adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, programs);
        spnPrograms.setAdapter(adapter);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    }

    private void displayTuition() {
        TextView txtTuition = findViewById(R.id.register_txtTuition);
        txtTuition.setText(String.format("Tuition: %s", Formatter.getCurrency(tuitionFee)));
    }

    private boolean validateForm() {
        EditText editCardNo = findViewById(R.id.register_editCardNo);
        EditText editCvv = findViewById(R.id.register_editCvv);
        boolean isValid = true;

        if (editCardNo.getText().toString().length() < 15) {
            editCardNo.setError("Card number is too short.");
            isValid = false;
        }
        if (editCvv.getText().toString().length() < 3) {
            editCvv.setError("CVV required.");
            isValid = false;
        }

        return isValid;
    }

    private void register() {
        if (validateForm()) {
            String programCode = db.getField("Program", "programCode",
                    "programName", program);
            double totalAmount = Double.parseDouble(db.getField("Program", "tuitionFee",
                    "programName", program));
            String studentId = db.getField("Student", "studentId",
                    "username", username);

            // Store payment in database
            /* "studentId", "programCode", "totalAmount", "amountPaid",
                        "balance", "paymentDate", "cardNo", "status" */



            // Go to registration info activity
            Intent i = new Intent(this, RegistrationInfoActivity.class);

            i.putExtra("program", program);
            startActivity(i);
        }
    }
}
