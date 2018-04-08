package com.leicasimile.comp304.angelicacatalan_comp304_lab_assign5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CampusActivity extends AppCompatActivity {
    String[] campuses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campus);

        String college = getIntent().getStringExtra("college");
        switch (college) {
            case "Centennial":
                campuses = getResources().getStringArray(R.array.campuses_centennial);
                break;
            case "George Brown":
                campuses = getResources().getStringArray(R.array.campuses_georgeBrown);
                break;
            case "Humber":
                campuses = getResources().getStringArray(R.array.campuses_humber);
                break;
            case "Seneca":
                campuses = getResources().getStringArray(R.array.campuses_seneca);
                break;
            case "Sheridan":
                campuses = getResources().getStringArray(R.array.campuses_sheridan);
                break;
        }
    }
}
