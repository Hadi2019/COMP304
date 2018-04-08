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

public class MainActivity extends ListActivity {
    String[] colleges;
    ListView lstView;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstView = getListView();
        TextView textView = new TextView(getApplicationContext());
        textView.setText(getResources().getString(R.string.main_txtPrompt));

        lstView.addHeaderView(textView);
        lstView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lstView.setTextFilterEnabled(true);

        colleges = getResources().getStringArray(R.array.colleges);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, colleges);
        lstView.setAdapter(adapter);

        // Event-handlers
        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                displayNextActivity(position);
            }
        });
    }

    private void displayNextActivity(int index) {
        intent = new Intent(this, CampusActivity.class);
        intent.putExtra("college", lstView.getItemAtPosition(index).toString());
        startActivity(intent);
    }
}
