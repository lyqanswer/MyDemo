package com.edu.mydemolist.thread;

import com.edu.mydemolist.R;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;

public class MessageActivity extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_message);

		NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		manager.cancelAll();
	}
}
