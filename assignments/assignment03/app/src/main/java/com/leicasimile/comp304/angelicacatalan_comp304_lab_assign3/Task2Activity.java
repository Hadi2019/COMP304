package com.leicasimile.comp304.angelicacatalan_comp304_lab_assign3;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Task2Activity extends AppCompatActivity {

    AnimationDrawable mframeAnimation = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task2);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

        final Button btnStart = findViewById(R.id.task2_btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAnimation();
            }
        });

        final Button btnStop = findViewById(R.id.task2_btnStop);
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopAnimation();
            }
        });
    }

    private void startAnimation() {
        ImageView img = findViewById(R.id.task2_imgAnimation);

        BitmapDrawable frame1 = (BitmapDrawable) getResources().getDrawable(R.drawable.chtholly02);
        BitmapDrawable frame2 = (BitmapDrawable) getResources().getDrawable(R.drawable.chtholly04);
        BitmapDrawable frame3 = (BitmapDrawable) getResources().getDrawable(R.drawable.chtholly05);
        BitmapDrawable frame4 = (BitmapDrawable) getResources().getDrawable(R.drawable.chtholly06);
        BitmapDrawable frame5 = (BitmapDrawable) getResources().getDrawable(R.drawable.chtholly07);

        // Get the background, which has been compiled to an AnimationDrawable object.
        int reasonableDuration = 250;
        mframeAnimation = new AnimationDrawable();
        mframeAnimation.setOneShot(false);    // loop continuously
        mframeAnimation.addFrame(frame1, reasonableDuration);
        mframeAnimation.addFrame(frame2, reasonableDuration);
        mframeAnimation.addFrame(frame3, reasonableDuration);
        mframeAnimation.addFrame(frame4, reasonableDuration);
        mframeAnimation.addFrame(frame5, reasonableDuration);

        img.setBackground(mframeAnimation);

        mframeAnimation.setVisible(true, true);
        mframeAnimation.start();
    }

    private void stopAnimation() {
        mframeAnimation.stop();
        mframeAnimation.setVisible(false, false);
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