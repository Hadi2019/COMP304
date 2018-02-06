package test.simpleresources;


import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SimpleResource extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
                
        String myString = getResources().getString(R.string.display);
        int myColor = getResources().getColor(R.color.prettyTextColor);
        float myDimen = getResources().getDimension(R.dimen.textPointSize);
        ColorDrawable myDraw = (ColorDrawable)getResources().getDrawable(R.drawable.redDrawable);
        ImageView imgView = (ImageView)findViewById(R.id.imageView1);

        imgView.setImageDrawable(myDraw);
        //String[] flavors = getResources().getStringArray(R.array.flavors);

        TextView tv = (TextView)findViewById(R.id.txtView);
        tv.setTextSize(myDimen);
        tv.setTextColor(myColor);
        tv.setText(myString);

        
        
    }
}