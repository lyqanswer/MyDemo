package com.edu.mydemolist.readxml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import com.edu.mydemolist.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ReadWriteXMLActivity extends Activity {
	FileInputStream fileInputStream;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		Button btn1 = null;
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_readxml);

		btn1 = (Button) findViewById(R.id.button1);
		btn1.setOnClickListener(new Btn1Click());
	}

	private final class Btn1Click implements View.OnClickListener {
		public void onClick(View v) {
			// InputStream inputStream =
			// getClass().getClassLoader().getResourceAsStream("timing.xml");
			File file = new File(Environment.getExternalStorageDirectory(), "timing.xml");
			try {
				fileInputStream = new FileInputStream(file);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			List<Timing> timings;
			try {
				timings = TimingService.getTimings(fileInputStream);
				for (Timing t : timings) {
					Toast.makeText(getApplicationContext(), t.getEndTime() + "--" + t.getStartTime() + "--" + t.getWeekTime(), Toast.LENGTH_SHORT).show();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
