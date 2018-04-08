package com.leicasimile.comp304.angelicacatalan_comp304_lab_assign5;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class CampusActivity extends ListActivity {
    String[] campuses;
    ListView lstView;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campus);

        lstView = getListView();
        TextView textView = new TextView(getApplicationContext());
        textView.setText(getResources().getString(R.string.campus_txtPrompt));

        lstView.addHeaderView(textView);
        lstView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lstView.setTextFilterEnabled(true);

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

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, campuses);
        lstView.setAdapter(adapter);

        // Event-handlers
        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                displayMap(position);
            }
        });
    }

    private void displayMap(int index) {
        intent = new Intent(this, MapActivity.class);
        startActivity(intent);
    }
}
