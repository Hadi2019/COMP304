package com.leicasimile.comp304.task1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        TextView txt_student = findViewById(R.id.txt_student);
        TextView txt_program = findViewById(R.id.txt_program);
        TextView txt_duration = findViewById(R.id.txt_duration);
        Intent i = getIntent();

        txt_student.setText(String.format("Student name: %s", i.getStringExtra("student")));
        txt_program.setText(String.format("Program name: %s", i.getStringExtra("program")));
        txt_duration.setText(String.format("Duration: %s years", i.getStringExtra("duration")));
    }
}
