package com.edu.mydemolist.thread;

import com.edu.mydemolist.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class TreadActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_thread);

		PollingUtils.startPollingService(this, 5, PollingService.class, PollingService.ACTION);
		System.out.println("Start polling service...");

		Button btn = (Button) findViewById(R.id.btn);
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startService(new Intent(TreadActivity.this, EduCoreService.class));
				Toast.makeText(TreadActivity.this, "启动服务", Toast.LENGTH_LONG).show();

			}
		});
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		// Stop polling service
		PollingUtils.stopPollingService(this, PollingService.class, PollingService.ACTION);
		System.out.println("Stop polling service...");
	}
}
