package test.samples;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

public class AndroidTestActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	public void callIntent(View view) {
		Intent intent = null;
		switch (view.getId()) {
		case R.id.Button01:
			intent = new Intent(Intent.ACTION_VIEW,
					Uri.parse("http://centennialcollege.ca"));
			startActivity(intent);
			break;
		case R.id.Button02:
			intent = new Intent(Intent.ACTION_CALL,
					Uri.parse("tel:(416)289-5000"));
			startActivity(intent);
			break;
			default:
			break;
		
		case R.id.Button03:
			intent = new Intent(this, DisplayActivity.class);
			intent.putExtra("message", "Hi DisplayActivity! How Are You!");
			startActivity(intent); 
			break;
		}
	}
	
}
