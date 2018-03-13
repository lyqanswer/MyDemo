package com.edu.mydemolist.evenbus;

import com.edu.mydemolist.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;

/**
 * @author ZH-SW-
 *
 */
public class BMainActivity extends Activity implements OnClickListener {
	private EditText m_EditText;
	private Button m_Button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_evenbus_b);
		// 订阅EventBus这个必须写
		EventBus.getDefault().register(this);
		initView();
	}

	/**
	 * 初始化控件
	 */
	private void initView() {
		m_EditText = (EditText) findViewById(R.id.b_text);
		m_Button = (Button) findViewById(R.id.b_bt);
		m_Button.setOnClickListener(this);
		// TODO Auto-generated method stub

	}

	// 接收消息 每个订阅的都要写接收消息方法
	// 我们添加了注解@Subscribe，其含义为订阅者，在其内传入了threadMode，
	// 我们定义为ThreadMode.MainThread，其含义为该方法在UI线程完成就不用抛弃异常了。
	@Subscribe(threadMode = ThreadMode.MainThread)
	public void helloEventBus(MessageEvent message) {
		// 在这里已经接收到消息 我加判断是为了实现群发单实现的效果
		m_EditText.setText(message.name + "");
		Toast.makeText(this, message.name + "", 1).show();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.b_bt:
			// 发布消息MessageEvent是bean类也可以post（String）注意post（String）接收的方法也需要改变
			EventBus.getDefault().post(new MessageEvent("answer", m_EditText.getText().toString().trim()));

			this.finish();
			break;
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		//
		EventBus.getDefault().unregister(this);
	}
}
