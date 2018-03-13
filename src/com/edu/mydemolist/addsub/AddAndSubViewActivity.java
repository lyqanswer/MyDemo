package com.edu.mydemolist.addsub;

import com.edu.mydemolist.R;
import com.edu.mydemolist.addsub.AddAndSubView.OnNumChangeListener;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class AddAndSubViewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_addsub);
		setView();
	}

	private void setView() {
		LinearLayout linearLayout1 = (LinearLayout) findViewById(R.id.linearLayout1);
		LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.linearLayout2);
		Button button1 = (Button) findViewById(R.id.button1);
		Button button2 = (Button) findViewById(R.id.button2);
		final TextView textView = (TextView) findViewById(R.id.textView);
		final AddAndSubView addAndSubView1 = new AddAndSubView(AddAndSubViewActivity.this, 5);
		final AddAndSubView addAndSubView2 = new AddAndSubView(AddAndSubViewActivity.this);

		linearLayout1.addView(addAndSubView1);
		linearLayout2.addView(addAndSubView2);

		button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				addAndSubView1.setNum(30);
			}
		});

		button2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(AddAndSubViewActivity.this, "数值为：" + addAndSubView1.getNum(), Toast.LENGTH_SHORT).show();
			}
		});

		// 设置监听EditText内数值变化
		addAndSubView2.setOnNumChangeListener(new OnNumChangeListener() {

			@Override
			public void onNumChange(View view, int num) {
				textView.setText(Integer.toString(num));
			}
		});

	}

}
