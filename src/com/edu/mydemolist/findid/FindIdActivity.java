package com.edu.mydemolist.findid;

import com.edu.mydemolist.R;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//简化findviewbyId
public class FindIdActivity extends Activity implements OnClickListener {
	@ViewInject(R.id.tv)
	private TextView tv;
	@ViewInject(R.id.bt)
	private Button bt;
	@ViewInject(R.id.et)
	private EditText et;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.actvity_findid);
		AnnotateUtils.injectViews(this);
		initView();
	}

	private void initView() {
		bt.setOnClickListener(this);
		tv.setText("测试");
		et.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				Toast.makeText(getApplicationContext(), et.getText().toString(), Toast.LENGTH_LONG).show();
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub

			}
		});

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bt:
			Toast.makeText(this, "点击", Toast.LENGTH_LONG).show();
			break;

		default:
			break;
		}

	}
}
