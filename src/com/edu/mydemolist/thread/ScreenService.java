package com.edu.mydemolist.thread;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

public class ScreenService extends Service {

	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}

	public void onCreate() {
		super.onCreate();
		/* 注册屏幕唤醒时的广播 */
		IntentFilter mScreenOnFilter = new IntentFilter("android.intent.action.SCREEN_ON");
		ScreenService.this.registerReceiver(mScreenOReceiver, mScreenOnFilter);

		/* 注册机器锁屏时的广播 */
		IntentFilter mScreenOffFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
		ScreenService.this.registerReceiver(mScreenOReceiver, mScreenOffFilter);
	}

	public void onDestroy() {
		super.onDestroy();
		ScreenService.this.unregisterReceiver(mScreenOReceiver);
	}

	/**
	 * 锁屏的管理类叫KeyguardManager，
	 * 通过调用其内部类KeyguardLockmKeyguardLock的对象的disableKeyguard方法可以取消系统锁屏，
	 * newKeyguardLock的参数用于标识是谁隐藏了系统锁屏
	 */
	private BroadcastReceiver mScreenOReceiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			String action = intent.getAction();

			if (action.equals("android.intent.action.SCREEN_ON")) {
				System.out.println("—— SCREEN_ON ——");
				Intent intent1 = new Intent("com.edu.killer.action.KILL_METHOD");
				intent1.putExtra("cmd", 1);
				sendBroadcast(intent1);
				 PollingUtils.startPollingService(getApplicationContext(), 5,
				 PollingService.class, PollingService.ACTION);
				startService(new Intent(getApplicationContext(), EduCoreService.class));
			} else if (action.equals("android.intent.action.SCREEN_OFF")) {
				System.out.println("—— SCREEN_OFF ——");
				Intent intent2 = new Intent("com.edu.killer.action.KILL_METHOD");
				intent2.putExtra("cmd", 2);
				sendBroadcast(intent2);
				PollingUtils.stopPollingService(getApplicationContext(), PollingService.class, PollingService.ACTION);
			}
		}

	};

}
