package com.leicasimile.comp304.comp304_001_assignment4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    private static String tables[];
    private static String tableCreatorString[];
    private DatabaseManager db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tables = getResources().getStringArray(R.array.tables);
        tableCreatorString = getResources().getStringArray(R.array.tableCreator);

        db = DatabaseManager.getInstance(this);
        db.dbInitialize(tables, tableCreatorString);
        db.createDatabase(getApplicationContext());

        RadioButton radStudent = findViewById(R.id.main_radStudent);
        radStudent.setChecked(true);

        // Event-handlers
        Button btnLogin = findViewById(R.id.main_btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isValidLogin()) {
                    displayNextActivity();
                } else {
                    // Warn user
                }
            }
        });
    }

    private boolean isValidLogin() {
        EditText editUsername = findViewById(R.id.main_editUsername);
        EditText editPassword = findViewById(R.id.main_editPassword);
        String username = editUsername.getText().toString();
        String password = editPassword.getText().toString();
        String actualPassword;
        String table = "";

        RadioGroup rgrpUserType = findViewById(R.id.main_rgrpUserType);

        switch (rgrpUserType.getCheckedRadioButtonId()) {
            case R.id.main_radStudent:
                table = "Student";
                break;
            case R.id.main_radAdmin:
                table = "Admin";
                break;
        }

        actualPassword = db.getField(table, "password", "username", username);
        if (password.equals(actualPassword)) {
            return true;
        }

        return false;
    }

    private void displayNextActivity() {
        Intent i = null;
        RadioGroup rgrpUserType = findViewById(R.id.main_rgrpUserType);
        EditText editUsername = findViewById(R.id.main_editUsername);
        String table;
        String column;

        switch (rgrpUserType.getCheckedRadioButtonId()) {
            case R.id.main_radStudent:
                i = new Intent(this, RegisterActivity.class);
                table = "Student";
                column = "studentId";
                break;
            case R.id.main_radAdmin:
                i = new Intent(this, RegistrationListActivity.class);
                table = "Admin";
                column = "employeeId";
                break;
            default:
                return;
        }

        // Pass username to next activity
        i.putExtra("username", editUsername.getText().toString());
        startActivity(i);
    }
}