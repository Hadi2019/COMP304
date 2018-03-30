package com.leicasimile.comp304.comp304_001_assignment4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    private final String tables[] = getResources().getStringArray(R.array.tables);
    private final String tableCreatorString[] = getResources().getStringArray(R.array.tableCreator);
    private final DatabaseManager db = DatabaseManager.getInstance(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db.dbInitialize(tables, tableCreatorString);
        db.createDatabase(getApplicationContext());

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

        
        return false;
    }

    private void displayNextActivity() {
        Intent i = null;
        RadioGroup rgrpUserType = findViewById(R.id.main_rgrpUserType);

        switch (rgrpUserType.getCheckedRadioButtonId()) {
            case R.id.main_radStudent:
                i = new Intent(this, RegisterActivity.class);
                break;
            case R.id.main_radAdmin:
                i = new Intent(this, RegistrationListActivity.class);
                break;
        }
        startActivity(i);
    }
}