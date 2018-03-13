package com.edu.mydemolist.viewpager;

import com.edu.mydemolist.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

public class MyPagerActivity extends Activity {
	MyPageView myPageView;
	int[] pic = new int[] { R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pager);
		initView();
	}

	private void initView() {
		myPageView = (MyPageView)findViewById(R.id.my_page);
		 //给自定义ViewPage添加孩子组件
        for (int i = 0; i < pic.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(pic[i]);
            myPageView.addView(imageView);
        }
		
	}
}
