package com.leicasimile.comp304.task1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
    }

    public void btnSubmit_click(View view) {
        EditText edit_student =  findViewById(R.id.edit_student);
        EditText edit_program =  findViewById(R.id.edit_program);
        EditText edit_duration =  findViewById(R.id.edit_duration);
        String student = edit_student.getText().toString();
        String program = edit_program.getText().toString();
        String duration = edit_duration.getText().toString();

        Intent i = new Intent(this, InfoActivity.class);
        i.putExtra("student", student);
        i.putExtra("program", program);
        i.putExtra("duration", duration);
        startActivity(i);
    }
}
