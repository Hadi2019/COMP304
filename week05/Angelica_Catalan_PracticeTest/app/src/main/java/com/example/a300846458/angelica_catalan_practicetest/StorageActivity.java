package com.example.a300846458.angelica_catalan_practicetest;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class StorageActivity extends AppCompatActivity {
    ImageView imageView;
    Paint paint;
    Bitmap bitmap;
    Canvas canvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);

        Bundle extras = getIntent().getExtras();
        String selectedSetting = extras.getString("selectedSetting");
        this.getSupportActionBar().setTitle(selectedSetting);

        TextView tView = findViewById(R.id.txtView);

        // Set up the paint
        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(20);

        imageView = findViewById(R.id.imageView);
        int width = (int) getResources().getDimension(R.dimen.img_width);
        int height = (int) getResources().getDimension(R.dimen.img_height);

        // Create a bitmap as content view for the canvas
        bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        imageView.draw(canvas);

        // Set a bitmap as content view for the image
        imageView.setImageBitmap(bitmap);
        //compute the ratio of free space
        long memory[] = getTotalMemorySize();
        double ratio = (double) memory[1] / (double) memory[0];
        int percentAv = (int) (ratio * 100);
        tView.setText("Memory map: " + String.valueOf(percentAv) + "% free");

        // Draw occupied space with blue
        double widthOfOccupiedSpace = (1. - ratio) * width;
        canvas.drawRect(0, 0, (int) widthOfOccupiedSpace, height, paint);

        // Draw available space with yellow
        paint.setColor(Color.YELLOW);
        canvas.drawRect((int) widthOfOccupiedSpace, 0, width, height, paint);
        imageView.invalidate();

        // Display total memory
        TextView tvTotalMemory = findViewById(R.id.txtTotalMemory);
        tvTotalMemory.setText("Total memory: " + String.valueOf(memory[0]));

        // Create the legend for available space
        ColorDrawable avDraw = (ColorDrawable) getResources().getDrawable(R.drawable.yellowDrawable);
        ImageView imgViewAv = findViewById(R.id.iconAvailableSpace);
        imgViewAv.setImageDrawable(avDraw);

        // Create the legend for used space
        ColorDrawable usDraw = (ColorDrawable) getResources().getDrawable(R.drawable.blueDrawable);
        ImageView imgViewUs = findViewById(R.id.iconUsedSpace);
        imgViewUs.setImageDrawable(usDraw);
    }

    // Returns used and available memory in Mb
    public static long[] getTotalMemorySize() {
        long size[] = new long[2];
        try {
            Runtime info = Runtime.getRuntime();
            size[0] = info.totalMemory() / 1024;
            size[1] = info.freeMemory() / 1024;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return size;
    }
}