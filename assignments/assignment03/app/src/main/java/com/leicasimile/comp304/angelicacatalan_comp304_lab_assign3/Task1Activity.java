package com.leicasimile.comp304.angelicacatalan_comp304_lab_assign3;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class Task1Activity extends AppCompatActivity {

    ImageView imgCanvas;
    TextView tvX;
    TextView tvY;

    // Coords for the line
    int startX = 10;
    int startY = 10;
    int endX = 10;
    int endY = 10;

    // User settings
    int lineThickness;
    int lineColour;

    Paint paint;
    Bitmap bitmap;
    Canvas canvas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task1);

        // Set spinner values
        final Spinner spnLineThickness = findViewById(R.id.task1_spnLineThickness);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.line_thicknesses,
                android.R.layout.simple_spinner_dropdown_item);
        spnLineThickness.setAdapter(adapter);

        // Set arrow key images
        ImageButton imgArrowUp = findViewById(R.id.imgArrowUp);
        ImageButton imgArrowLeft = findViewById(R.id.imgArrowLeft);
        ImageButton imgArrowRight = findViewById(R.id.imgArrowRight);
        ImageButton imgArrowDown = findViewById(R.id.imgArrowDown);
        imgArrowUp.setImageDrawable(getResources().getDrawable(R.drawable.ic_keyboard_arrow_up_black_24dp));
        imgArrowLeft.setImageDrawable(getResources().getDrawable(R.drawable.ic_keyboard_arrow_left_black_24dp));
        imgArrowRight.setImageDrawable(getResources().getDrawable(R.drawable.ic_keyboard_arrow_right_black_24dp));
        imgArrowDown.setImageDrawable(getResources().getDrawable(R.drawable.ic_keyboard_arrow_down_black_24dp));

        // Initialize drawing objects
        paint = new Paint();

        Point size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);
        int defaultWidth = size.x;
        int defaultHeight = size.y;

        bitmap = Bitmap.createBitmap(defaultWidth, defaultHeight, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);

        imgCanvas = findViewById(R.id.task1_imgCanvas);
        imgCanvas.setImageBitmap(bitmap);
        tvX = findViewById(R.id.task1_tvX);
        tvY = findViewById(R.id.task1_tvY);

        // Event-handlers
        spnLineThickness.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                lineThickness = Integer.parseInt(spnLineThickness.getSelectedItem().toString());
                paint.setStrokeWidth(lineThickness);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        RadioGroup rgrpLineColour = findViewById(R.id.rgrpColours);
        rgrpLineColour.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radColourRed:
                        lineColour = Color.RED;
                        break;
                    case R.id.radColourGreen:
                        lineColour = Color.GREEN;
                        break;
                    case R.id.radColourYellow:
                        lineColour = Color.YELLOW;
                        break;
                }
                paint.setColor(lineColour);
            }
        });

        // Set default options
        spnLineThickness.setSelection(0);
        rgrpLineColour.check(R.id.radColourRed);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode) {
            case KeyEvent.KEYCODE_DPAD_DOWN:
                drawLine(Direction.DOWN,canvas);
                return true;

            case KeyEvent.KEYCODE_DPAD_UP:
                drawLine(Direction.UP,canvas);
                return true;

            case KeyEvent.KEYCODE_DPAD_RIGHT:
                drawLine(Direction.RIGHT,canvas);
                return true;
            case KeyEvent.KEYCODE_DPAD_LEFT:
                drawLine(Direction.LEFT,canvas);
                return true;
        }
        return false;
    }

    private void drawLine(Direction direction, Canvas canvas) {
        imgCanvas.setFocusable(true);
        imgCanvas.requestFocus();

        switch(direction) {
            case DOWN:
                endY += 5;
                break;
            case UP:
                endY -= 5;
                break;
            case RIGHT:
                endX += 5;
                break;
            case LEFT:
                endX -= 5;
                break;
        }

        tvX.setText(String.format("%s %s", getResources().getString(R.string.task1_x), String.valueOf(endX)));
        tvY.setText(String.format("%s %s", getResources().getString(R.string.task1_y), String.valueOf(endY)));
        canvas.drawLine(startX, startY, endX, endY, paint);
        startX = endX;
        startY = endY;

        imgCanvas.invalidate();
    }
}
