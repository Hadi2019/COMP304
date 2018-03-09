package com.leicasimile.comp304.angelicacatalan_comp304_lab_assign3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;

public class Task1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task1);

        // Set spinner values
        Spinner spnCardType = findViewById(R.id.task1_spnLineThickness);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.line_thicknesses,
                android.R.layout.simple_spinner_dropdown_item);
        spnCardType.setAdapter(adapter);

        // Set arrow key images
        ImageButton imgArrowUp = findViewById(R.id.imgArrowUp);
        ImageButton imgArrowLeft= findViewById(R.id.imgArrowLeft);
        ImageButton imgArrowRight = findViewById(R.id.imgArrowRight);
        ImageButton imgArrowDown = findViewById(R.id.imgArrowDown);
        imgArrowUp.setImageDrawable(getResources().getDrawable(R.drawable.ic_keyboard_arrow_up_black_24dp));
        imgArrowLeft.setImageDrawable(getResources().getDrawable(R.drawable.ic_keyboard_arrow_left_black_24dp));
        imgArrowRight.setImageDrawable(getResources().getDrawable(R.drawable.ic_keyboard_arrow_right_black_24dp));
        imgArrowDown.setImageDrawable(getResources().getDrawable(R.drawable.ic_keyboard_arrow_down_black_24dp));
    }
}
