package com.example.filewriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	private File root;
	private File myFile;
	private EditText write;
	private Button save;
	private TextView read;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Create the file.
		createFile();

		write = (EditText) findViewById(R.id.editText1);
		save = (Button) findViewById(R.id.button1);
		read = (TextView) findViewById(R.id.textView1);

		save.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// Write to file.
				writeFile(write.getText().toString());
				read.setText(readFile());
			}
		});

		// Read the file.
		read.setText(readFile());
	}

	/**
	 * Create the file.
	 */
	public void createFile() {
		String fileName = "myfile";
		try {
			root = new File(Environment.getExternalStorageDirectory(),
					"iWriter");
			if (!root.exists()) {
				root.mkdirs();
			}

			myFile = new File(root, fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * write the file.
	 */
	public void writeFile(String text) {
		try {
			FileWriter writer = new FileWriter(myFile, true);
			writer.append(text + "\n");
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * read the file.
	 */
	public String readFile() {
		StringBuilder text = new StringBuilder();
		try {
			BufferedReader bufferReader = new BufferedReader(new FileReader(myFile));
			String line;

			while ((line = bufferReader.readLine()) != null) {
				text.append(line);
				text.append('\n');
			}
			bufferReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 

		return text.toString();
	}

}
