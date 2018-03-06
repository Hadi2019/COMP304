package com.leicasimile.comp304.angelicacatalan_comp304_lab_assign3;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {
    String[] tasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listTasks = getListView();
        listTasks.setChoiceMode(ListView.CHOICE_MODE_NONE);
        listTasks.setTextFilterEnabled(true);

        tasks = getResources().getStringArray(R.array.tasks);

        // Bind array to ListView
        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, tasks));
    }
}
