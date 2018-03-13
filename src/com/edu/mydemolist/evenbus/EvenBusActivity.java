package com.edu.mydemolist.evenbus;

import com.edu.mydemolist.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;

/**
 * 可以发单个String 也可以发bin类 建议发bin类参考https://segmentfault.com/a/1190000004279679
 * 
 * @author ZH-SW-
 * 
 */
public class EvenBusActivity extends Activity implements OnClickListener {
	private TextView m_TextView;
	private Button m_Button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_evenbus_a);
		// 订阅EventBus这个必须写
		EventBus.getDefault().register(this);
		initView();
	}

	/**
	 * 初始化控件
	 */
	private void initView() {
		m_TextView = (TextView) findViewById(R.id.a_text);
		m_Button = (Button) findViewById(R.id.a_bt);
		m_Button.setOnClickListener(this);
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 * @param string
	 */
	@Subscribe(threadMode = ThreadMode.MainThread)
	public void setText(String string) {
		if (string != null) {
			m_TextView.setText(string);
		}
	}

	// // 这个是post（String）的接收方法
	// @Subscribe(threadMode = ThreadMode.MainThread)
	// public void helloEventBus(String message){
	// m_TextView.setText(message);
	// }

	// 接收消息 每个订阅的都要写接收消息方法
	// 我们添加了注解@Subscribe，其含义为订阅者，在其内传入了threadMode，
	// 我们定义为ThreadMode.MainThread，其含义为该方法在UI线程完成就不用抛弃异常了。
	@Subscribe(threadMode = ThreadMode.MainThread)
	public void helloEventBus(MessageEvent message) {
		// 在这里已经接收到消息 我加判断是为了实现群发单实现的效果
		if (message.name.equals("answer")) {
			m_TextView.setText(message.name);
			Toast.makeText(this, message.name + "", 1).show();
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.a_bt:
			// 在这里不finish来测试EventBus线程见的通信
			Intent in = new Intent(EvenBusActivity.this, BMainActivity.class);
			EventBus.getDefault().post(new MessageEvent("lim", "1"));
			startActivity(in);
			break;
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		// 取消订阅EventBus这个必须写
		EventBus.getDefault().unregister(this);
	}
}
