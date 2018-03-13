package com.edu.mydemolist.timebutton;

import com.edu.mydemolist.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

/**
 * 测试主界面
 * 
 */
public class TimeButtonActivity extends Activity implements OnClickListener {

	private TimeButton v;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_time_button);
		v = (TimeButton) findViewById(R.id.button1);
		v.onCreate(savedInstanceState);
		v.setTextAfter("秒后重新获取").setTextBefore("点击获取验证码").setLenght(15 * 1000);
		v.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Toast.makeText(TimeButtonActivity.this, "这是处理调用者onclicklistnenr", Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		v.onDestroy();
		super.onDestroy();
	}
}
