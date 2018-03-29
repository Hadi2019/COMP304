package com.leicasimile.comp304.comp304_001_assignment4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private final String tables[] = getResources().getStringArray(R.array.tables);
    private final String tableCreatorString[] = getResources().getStringArray(R.array.tableCreator);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DatabaseManager db = new DatabaseManager(this);
        db.createDatabase(getApplicationContext());
        db.dbInitialize(tables, tableCreatorString);
    }
}