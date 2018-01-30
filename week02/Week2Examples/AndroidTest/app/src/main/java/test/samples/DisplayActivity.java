package test.samples;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayActivity extends Activity{
	
	
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.display_layout);
		Bundle extras = getIntent().getExtras();
	    String inputString = extras.getString("message");
	    TextView view = (TextView) findViewById(R.id.extra_text);
	    view.setText(inputString);

		
	}

}
