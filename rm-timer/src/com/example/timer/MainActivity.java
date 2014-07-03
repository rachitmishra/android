package com.example.timer;


import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private Button start;
	private Button stop;
	private Date startTime, stopTime;
	private TextView elapsedView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		start = (Button) findViewById(R.id.button1);
		stop = (Button) findViewById(R.id.button2);
		elapsedView = (TextView) findViewById(R.id.textView1);
		
		start.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startTime = Calendar.getInstance().getTime();
				elapsedView.setText("Timer running ...");
			}
		});
		
		stop.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				stopTime = Calendar.getInstance().getTime();
				printElapsed();
			}
		});
	}
	
	public void printElapsed(){
		Log.w("iTimer", startTime.getTime() +"");
		Log.w("iTimer", stopTime.getTime() +"");
		
		long elapsed = stopTime.getTime() - startTime.getTime();
		long hours = TimeUnit.MILLISECONDS.toHours(elapsed);
		long minutes = TimeUnit.MILLISECONDS.toMinutes(elapsed);
		long seconds = TimeUnit.MILLISECONDS.toSeconds(elapsed);
		elapsedView.setText(hours+" : "+minutes+" : "+seconds);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
