package com.edu.mydemolist.horizontalselectedview;

import java.util.ArrayList;
import java.util.List;

import com.edu.mydemolist.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class HorizontalselectedViewActivity extends Activity implements OnClickListener {

	private View leftImageView;
	private View rightImageView;
	private HorizontalselectedView hsMain;
	private Button btMain;
	List<String> strings = new ArrayList<String>();
	private TextView tvMain;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_horizontalselected);
		initView();
		initdata();
	}

	private void initdata() {

		for (int i = 0; i < 20; i++) {
			strings.add(i + "00");
		}
		hsMain.setData(strings);
	}

	private void initView() {
		hsMain = (HorizontalselectedView) findViewById(R.id.hd_main);
		leftImageView = findViewById(R.id.iv_left);
		rightImageView = findViewById(R.id.iv_right);
		btMain = ((Button) findViewById(R.id.bt_main));
		tvMain = ((TextView) findViewById(R.id.tv_main));

		leftImageView.setOnClickListener(this);
		rightImageView.setOnClickListener(this);
		btMain.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.iv_left:
			hsMain.setAnLeftOffset();
			break;
		case R.id.iv_right:
			hsMain.setAnRightOffset();
			break;
		case R.id.bt_main:

			tvMain.setText("所选文本：" + hsMain.getSelectedString());

			break;
		default:
			break;
		}
	}
}
