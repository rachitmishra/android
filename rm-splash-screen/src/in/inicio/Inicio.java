package in.inicio;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.widget.Toast;

public class Inicio extends Activity {

	private Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			Intent i = new Intent(Inicio.this, ScreenTabs.class);
			Inicio.this.startActivity(i);
			Inicio.this.finish();
		}
	};

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		SharedPreferences prefs = PreferenceManager
				.getDefaultSharedPreferences(this);
		if (!prefs.getBoolean("first_time", false)) {

			Toast.makeText(this, "Starting ScreenTabs", Toast.LENGTH_SHORT)
					.show();

			Intent i = new Intent(Inicio.this, ScreenTabs.class);
			this.startActivity(i);
			this.finish();

		} else {
			this.setContentView(R.layout.inicio);
			handler.sendEmptyMessageDelayed(0, 2000);
		}
	}
}
