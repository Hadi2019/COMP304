package com.leicasimile.comp304.comp304_001_assignment4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RegisterActivity extends AppCompatActivity {
    private Spinner spnPrograms;
    private List<String> listPrograms = new ArrayList<>();
    private DatabaseManager db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = DatabaseManager.getInstance(this);
        List programRecords = db.getRecords("Program", new String[]{"programName"});
        String[] programs = new String[programRecords.size()];

        // Set welcome message for student
        TextView txtName = findViewById(R.id.register_txtName);
        String firstname = db.getField("Student", "firstname",
                "username", getIntent().getStringExtra("username"));
        String lastname = db.getField("Student", "lastname",
                "username", getIntent().getStringExtra("username"));
        txtName.setText(String.format("Hi, %s %s", firstname, lastname));

        // Populate spinner with programs
        for (int i = 0; i < programRecords.size(); i++) {
            programs[i] = ((ArrayList)programRecords.get(i)).get(i).toString();
        }

        spnPrograms = findViewById(R.id.register_spnPrograms);
        ArrayAdapter<String> adapter;

        adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, programs);
        spnPrograms.setAdapter(adapter);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Event-handlers
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
}
