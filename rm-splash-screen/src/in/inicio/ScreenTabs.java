package in.inicio;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ScreenTabs extends Activity {

	boolean backgroundServiceRunning;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_screen_tabs);

		Button startService = (Button) findViewById(R.id.button1);
		Button stopService = (Button) findViewById(R.id.button2);
		startService.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent startOurBackgroundService = new Intent(ScreenTabs.this,
						BackgroundService.class);
				startService(startOurBackgroundService);
				backgroundServiceRunning = true;
				Toast.makeText(ScreenTabs.this, "Background service started",
						Toast.LENGTH_SHORT).show();
			}
		});

		stopService.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent stopOurBackgroundService = new Intent(ScreenTabs.this,
						BackgroundService.class);
				stopService(stopOurBackgroundService);
				backgroundServiceRunning = false;
				Toast.makeText(ScreenTabs.this, "Background service stopped",
						Toast.LENGTH_SHORT).show();
			}
		});

	}

	@Override
	public void onPause() {
		super.onPause();
		Toast.makeText(this, "Activity paused. Splash is OFF.",
				Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		// Check if the music player service is running in Background
		// if yes than don't set splash to TRUE, as our application is still
		// running
		if (backgroundServiceRunning) {
			Toast.makeText(this, "Service is running. Splash is OFF.",
					Toast.LENGTH_SHORT).show();
		} else {
			Toast.makeText(this, "Service is not running. Splash is ON.",
					Toast.LENGTH_SHORT).show();
			SharedPreferences prefs = PreferenceManager
					.getDefaultSharedPreferences(this);
			SharedPreferences.Editor editor = prefs.edit();
			editor.putBoolean("first_time", true);
			editor.commit();
		}

	}

}
