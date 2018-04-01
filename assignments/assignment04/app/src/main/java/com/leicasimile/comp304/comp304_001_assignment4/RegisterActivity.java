package com.leicasimile.comp304.comp304_001_assignment4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

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

        for (int i = 0; i < programRecords.size(); i++) {
            programs[i] = ((ArrayList)programRecords.get(i)).get(i).toString();
        }

        spnPrograms = findViewById(R.id.register_spnPrograms);
        ArrayAdapter<String> adapter;

        adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, programs);
        spnPrograms.setAdapter(adapter);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    }
}
