package com.leicasimile.comp304.angelicacatalan_comp304_pizzaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

// Angelica Catalan, 300846458
public class OrderInfoActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_info);

        Intent i = getIntent();
        String name = i.getStringExtra("name");
        String pizzaType = i.getStringExtra("type");
        String pizzaSize = i.getStringExtra("size");
        TextView txtThanks = findViewById(R.id.orderInfo_txtThanks);

        txtThanks.setText(String.format("%s, thank you for placing an online order. Your %s %s pizza order successfully received and will be delivered soon.",
                name, pizzaSize, pizzaType));

        // Set btnMenu colour to orange
        Button btnMenu = findViewById(R.id.orderInfo_btnMenu);
        btnMenu.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

        // Add event-handler
        btnMenu.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.orderInfo_btnMenu: {
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
                break;
            }
        }
    }
}
