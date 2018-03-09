package com.leicasimile.comp304.angelicacatalan_comp304_lab_assign3;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class Task3Activity extends AppCompatActivity {

    ImageView imgEarth;
    ImageView imgSun;
    Animation an;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task3);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

        // Render images
        imgSun = findViewById(R.id.task3_imgSun);
        imgSun.setImageResource(R.drawable.sun);
        imgSun.setVisibility(View.VISIBLE);

        imgEarth = findViewById(R.id.task3_imgEarth);
        imgEarth.setImageResource(R.drawable.earth);
        imgEarth.setVisibility(View.VISIBLE);

        // Event-handlers
        Button btnStart = findViewById(R.id.task3_btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAnimation();
            }
        });

        Button btnStop = findViewById(R.id.task3_btnStop);
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopAnimation();
            }
        });
    }

    private void startAnimation() {
        an = AnimationUtils.loadAnimation(this, R.anim.revolve);
        imgEarth.startAnimation(an);
    }

    private void stopAnimation() {
        imgEarth.clearAnimation();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
