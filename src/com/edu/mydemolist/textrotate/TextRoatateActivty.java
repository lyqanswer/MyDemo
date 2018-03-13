package com.edu.mydemolist.textrotate;

import com.edu.mydemolist.R;

import android.app.Activity;
import android.os.Bundle;

public class TextRoatateActivty extends Activity {
	private RotateTextView mTextView;
	private RotateTextView mTextView1;
	private RotateTextView mTextView2;
	private RotateTextView mTextView3;
	private RotateTextView mTextView4;
	private RotateTextView mTextView5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rotate);
		mTextView = (RotateTextView) findViewById(R.id.ceshi);
		mTextView.setDegrees(10);
		mTextView1 = (RotateTextView) findViewById(R.id.ceshi1);
		mTextView1.setDegrees(350);
		mTextView2 = (RotateTextView) findViewById(R.id.ceshi2);
		mTextView2.setDegrees(180);
		mTextView3 = (RotateTextView) findViewById(R.id.ceshi3);
		mTextView3.setDegrees(90);
		mTextView4 = (RotateTextView) findViewById(R.id.ceshi4);
		mTextView4.setDegrees(290);

	}
}
