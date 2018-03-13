package com.edu.mydemolist;

import java.util.ArrayList;
import java.util.List;

import com.edu.mydemolist.MainAdapter.OnRecyclerClickLitener;
import com.edu.mydemolist.addsub.AddAndSubViewActivity;
import com.edu.mydemolist.bearsms.BearSMSCaptchaActivity;
import com.edu.mydemolist.clearedittext.ClearEditTextActivity;
import com.edu.mydemolist.clearedittext.EditTextActivity;
import com.edu.mydemolist.evenbus.EvenBusActivity;
import com.edu.mydemolist.findid.FindIdActivity;
import com.edu.mydemolist.guide.MyGuideViewActivity;
import com.edu.mydemolist.horizontalselectedview.HorizontalselectedViewActivity;
import com.edu.mydemolist.popup.PopupWindowActivity;
import com.edu.mydemolist.readxml.ReadWriteXMLActivity;
import com.edu.mydemolist.recycle.RecycleActivity;
import com.edu.mydemolist.sortlist.SortListActivity;
import com.edu.mydemolist.spanned.SpannedActivity;
import com.edu.mydemolist.textrotate.TextRoatateActivty;
import com.edu.mydemolist.thread.TreadActivity;
import com.edu.mydemolist.timebutton.TimeButtonActivity;
import com.edu.mydemolist.viewpager.MyPagerActivity;
import com.edu.mydemolist.zoonin.ZoomInActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity implements OnRecyclerClickLitener {

	private RecyclerView rView;
	private List<String> s;
	private MainAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
	}

	private void initView() {
		rView = (RecyclerView) findViewById(R.id.view);
		RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
		rView.setLayoutManager(layoutManager);
		// 设置适配器
		setAdapertData();
		// 设置item之间的间隔
		SpacesItemDecoration decoration = new SpacesItemDecoration(10);
		rView.addItemDecoration(decoration);

		DisplayMetrics metrics = getResources().getDisplayMetrics();// 7寸A33获取为：1024x552
		Log.d("", "width:" + metrics.widthPixels + ",height:" + metrics.heightPixels + ",density:" + metrics.density + ",dpi:" + metrics.densityDpi);
		TextView tv = (TextView) findViewById(R.id.text);
		tv.setTextSize(20);
		tv.setText("width:" + metrics.widthPixels + ",height:" + metrics.heightPixels + ",density:" + metrics.density + ",dpi:" + metrics.densityDpi);
	}

	public class SpacesItemDecoration extends RecyclerView.ItemDecoration {

		// 间距
		private int space;

		public SpacesItemDecoration(int space) {
			this.space = space;
		}

		@Override
		public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
			outRect.left = space;
			outRect.right = space;
			outRect.bottom = space;
			outRect.top = space;
		}
	}

	private void setAdapertData() {
		s = new ArrayList<String>();
		s.add("AddAndSubActivity");
		s.add("BearSMSCaptchaActivity");
		s.add("ClearEditTextActivity");
		s.add("SortListActivity");
		s.add("TimeButtonActivity");
		s.add("TextRoatateActivty");
		s.add("EvenBusActivity");
		s.add("MyGuideViewActivity");
		s.add("FindIdActivity");
		s.add("MyPagerActivity");
		s.add("ReadWriteXMLActivity");
		s.add("PopupWindowActivity");
		s.add("TreadActivity");
		s.add("ZoomInActivity");
		s.add("EditTextActivity");
		s.add("SpannedActivity");
		s.add("RecycleActivity");
		s.add("HorizontalselectedViewActivity");
		mAdapter = new MainAdapter(this, s);
		rView.setAdapter(mAdapter);
		mAdapter.setOnRecyclerClickLitener(this);
	}

	@Override
	public void onItemClick(View view, int position) {
		if (position == 0) {
			startActivity(AddAndSubViewActivity.class);
		} else if (position == 1) {
			startActivity(BearSMSCaptchaActivity.class);
		} else if (position == 2) {
			startActivity(ClearEditTextActivity.class);
		} else if (position == 3) {
			startActivity(SortListActivity.class);
		} else if (position == 4) {
			startActivity(TimeButtonActivity.class);
		} else if (position == 5) {
			startActivity(TextRoatateActivty.class);
		} else if (position == 6) {
			startActivity(EvenBusActivity.class);
		} else if (position == 7) {
			startActivity(MyGuideViewActivity.class);
		} else if (position == 8) {
			startActivity(FindIdActivity.class);
		} else if (position == 9) {
			startActivity(MyPagerActivity.class);
		} else if (position == 10) {
			startActivity(ReadWriteXMLActivity.class);
		} else if (position == 11) {
			startActivity(PopupWindowActivity.class);
		} else if (position == 12) {
			startActivity(TreadActivity.class);
		} else if (position == 13) {
			startActivity(ZoomInActivity.class);
		} else if (position == 14) {
			startActivity(EditTextActivity.class);
		} else if (position == 15) {
			startActivity(SpannedActivity.class);
		} else if (position == 16) {
			startActivity(RecycleActivity.class);
		} else if (position == 17) {
			startActivity(HorizontalselectedViewActivity.class);
		}
	}

	/**
	 * 界面跳转
	 * 
	 * @param cls
	 */
	protected void startActivity(Class cls) {
		Intent intent = new Intent(this, cls);
		startActivity(intent);
	}

	/**
	 * 界面跳转，带参数
	 * 
	 * @param context
	 * @param cls
	 * @param bundle
	 */
	protected void startActivity(Class cls, Bundle bundle) {
		Intent intent = new Intent(this, cls);
		intent.putExtras(bundle);
		startActivity(intent);
	}

}