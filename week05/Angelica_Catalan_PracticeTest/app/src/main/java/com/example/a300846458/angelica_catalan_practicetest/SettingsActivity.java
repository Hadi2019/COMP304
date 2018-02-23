package com.example.a300846458.angelica_catalan_practicetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        final ListView lvSettings = findViewById(R.id.listView);

        // Item click event handler
        lvSettings.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent intent;
                String selectedSetting = (String)lvSettings.getItemAtPosition(position);
                //
                switch (position)
                {
                    case 0:
                        intent = new Intent(SettingsActivity.this,StorageActivity.class);
                        intent.putExtra("selectedSetting",selectedSetting );

                        startActivity(intent);
                        break;
                }


            }
        });
    }

}
