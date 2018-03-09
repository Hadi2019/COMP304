package com.leicasimile.comp304.angelicacatalan_comp304_lab_assign3;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

    public void onListItemClick(ListView parent, View v, int position, long id) {
        Intent i = null;
        switch (position) {
            case 0:
                i = new Intent(this, Task1Activity.class);
                break;
            case 1:
                i = new Intent(this, Task2Activity.class);
                break;
            case 2:
                i = new Intent(this, Task3Activity.class);
                break;
        }
        startActivity(i);
    }
}
