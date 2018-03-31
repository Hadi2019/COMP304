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
        listPrograms = db.getRecords("Program", new String[]{"programName"});

        spnPrograms = findViewById(R.id.register_spnPrograms);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, listPrograms);
        spnPrograms.setAdapter(adapter);
    }
}
