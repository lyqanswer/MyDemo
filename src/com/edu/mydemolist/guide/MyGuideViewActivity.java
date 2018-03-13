package com.edu.mydemolist.guide;

import java.util.ArrayList;

import com.edu.mydemolist.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Android实现左右滑动指引效果
 * 
 * @Description: Android实现左右滑动指引效果
 * 
 * @File: MyGuideViewActivity.java
 * 
 * @Package com.test.guide
 * 
 * @Author Hanyonglu
 * 
 * @Date 2012-4-6 下午11:15:18
 * 
 * @Version V1.0
 */
public class MyGuideViewActivity extends Activity {
	private ViewPager viewPager;
	private ArrayList<View> pageViews;
	private ImageView imageView;
	private ImageView[] imageViews;

	private ViewGroup main;
	// 包裹小圆点的LinearLayout
	private ViewGroup group;
	private WebView webView;
	private TextView textView;
	private TextView textViewjis, textView2tdui, textViewlinian, textViewjis2, textView2tdui2, textViewlinian2, textViewjis3, textView2tdui3, textViewlinian3;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 设置无标题窗口
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);
		// LayoutInflater inflater = getLayoutInflater();
		viewPager = (ViewPager) findViewById(R.id.guidePages);
		textViewjis = (TextView) findViewById(R.id.tiancaijieshao);
		textView2tdui = (TextView) findViewById(R.id.tuanduijieshao);
		textViewlinian = (TextView) findViewById(R.id.jingyanglinian);
		textViewjis.setOnClickListener(new MyOnClickListener(0));
		textView2tdui.setOnClickListener(new MyOnClickListener(1));
		textViewlinian.setOnClickListener(new MyOnClickListener(2));
		pageViews = new ArrayList<View>();
		pageViews.add(addview(R.layout.item01, "http://xgcs.zz.hntcwl.net/tiancaikehuduan/tiancaijieshao.html"));
		pageViews.add(addview(R.layout.item02, "http://xgcs.zz.hntcwl.net/tiancaikehuduan/tuanduijieshao.html"));
		pageViews.add(addview(R.layout.item03, "http://xgcs.zz.hntcwl.net/tiancaikehuduan/jingyinglinian.html"));

		viewPager.setAdapter(new GuidePageAdapter());
		viewPager.setCurrentItem(0);
		viewPager.setOnPageChangeListener(new GuidePageChangeListener());
	}

	public View addview(int layout, String url) {
		LayoutInflater inflater = getLayoutInflater();
		View view = inflater.inflate(layout, null);
		webView = (WebView) view.findViewById(R.id.webView1);
		webView.loadUrl(url);
		return view;

	}

	/**
	 * 头标点击监听
	 */
	public class MyOnClickListener implements View.OnClickListener {
		private int index = 0;

		public MyOnClickListener(int i) {
			index = i;

		}

		@Override
		public void onClick(View v) {
			if (index == 0) {
				textViewjis.setBackgroundResource(R.drawable.beijing2);
				textView2tdui.setBackgroundResource(R.drawable.beijing1);
				textViewlinian.setBackgroundResource(R.drawable.beijing1);
			}
			if (index == 1) {
				textViewjis.setBackgroundResource(R.drawable.beijing1);
				textView2tdui.setBackgroundResource(R.drawable.beijing2);
				textViewlinian.setBackgroundResource(R.drawable.beijing1);
			}
			if (index == 2) {
				textViewjis.setBackgroundResource(R.drawable.beijing1);
				textView2tdui.setBackgroundResource(R.drawable.beijing1);
				textViewlinian.setBackgroundResource(R.drawable.beijing2);
			}
			viewPager.setCurrentItem(index);

		}
	};

	// 指引页面数据适配器
	class GuidePageAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			return pageViews.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public int getItemPosition(Object object) {
			// TODO Auto-generated method stub
			return super.getItemPosition(object);
		}

		@Override
		public void destroyItem(View arg0, int arg1, Object arg2) {
			// TODO Auto-generated method stub
			((ViewPager) arg0).removeView(pageViews.get(arg1));
		}

		@Override
		public Object instantiateItem(View arg0, int arg1) {
			// TODO Auto-generated method stub
			((ViewPager) arg0).addView(pageViews.get(arg1));
			return pageViews.get(arg1);
		}

		@Override
		public void restoreState(Parcelable arg0, ClassLoader arg1) {
			// TODO Auto-generated method stub

		}

		@Override
		public Parcelable saveState() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void startUpdate(View arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void finishUpdate(View arg0) {
			// TODO Auto-generated method stub

		}
	}

	// 指引页面更改事件监听器
	class GuidePageChangeListener implements OnPageChangeListener {

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageSelected(int arg0) {
			if (arg0 == 0) {
				textViewjis.setBackgroundResource(R.drawable.beijing2);
				textView2tdui.setBackgroundResource(R.drawable.beijing1);
				textViewlinian.setBackgroundResource(R.drawable.beijing1);
			}
			if (arg0 == 1) {
				textViewjis.setBackgroundResource(R.drawable.beijing1);
				textView2tdui.setBackgroundResource(R.drawable.beijing2);
				textViewlinian.setBackgroundResource(R.drawable.beijing1);
			}
			if (arg0 == 2) {
				textViewjis.setBackgroundResource(R.drawable.beijing1);
				textView2tdui.setBackgroundResource(R.drawable.beijing1);
				textViewlinian.setBackgroundResource(R.drawable.beijing2);
			}

			/*
			 * for (int i = 0; i < imageViews.length; i++) { imageViews[arg0]
			 * .setBackgroundResource(R.drawable.page_indicator_focused);
			 * 
			 * if (arg0 != i) { imageViews[i]
			 * .setBackgroundResource(R.drawable.page_indicator); } }
			 */

		}
	}
}