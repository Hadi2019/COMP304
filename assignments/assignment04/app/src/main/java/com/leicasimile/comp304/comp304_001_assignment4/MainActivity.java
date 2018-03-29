package com.leicasimile.comp304.comp304_001_assignment4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static final String tables[] = {"Student", "Admin", "Program", "Payment"};
    private static final String tableCreatorString[] = {
        "CREATE TABLE Student (studentId INTEGER PRIMARY KEY AUTOINCREMENT," +
                "username TEXT, password TEXT," +
                "firstname TEXT, lastname TEXT," +
                "address TEXT, city TEXT, postalCode TEXT);",
        "CREATE TABLE Admin (employeeId INTEGER PRIMARY KEY AUTOINCREMENT," +
                "username TEXT, password TEXT," +
                "firstname TEXT, lastname TEXT);",
        "CREATE TABLE Program (programCode INTEGER PRIMARY KEY AUTOINCREMENT," +
                "programName TEXT, tuitionFee NUMERIC," +
                "duration INTEGER, semester INTEGER);",
        "CREATE TABLE Payment (paymentId INTEGER PRIMARY KEY AUTOINCREMENT" +
                "studentId INTEGER PRIMARY KEY, programCode INTEGER," +
                "totalAmount NUMERIC, amountPaid NUMERIC, balance NUMERIC," +
                "paymentDate INTEGER, status TEXT);"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}