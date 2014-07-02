package in.inicio;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.util.Log;

public class BackgroundService extends Service {
	public BackgroundService() {
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.w("Inicio", "Background service stopped");
		SharedPreferences prefs = PreferenceManager
				.getDefaultSharedPreferences(this);
		SharedPreferences.Editor editor = prefs.edit();
		editor.putBoolean("first_time", true);
		editor.commit();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.w("Inicio", "Background service started");

		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				Log.w("Inicio", "Background service running");

			}

		}, 1 * 1000);

		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO: Return the communication channel to the service.
		throw new UnsupportedOperationException("Not yet implemented");
	}
}
