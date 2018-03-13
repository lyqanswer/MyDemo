package com.edu.mydemolist.recycle;

import java.util.ArrayList;
import java.util.List;

import com.edu.mydemolist.R;
import com.edu.mydemolist.recycle.RecycleAdapter.OnRecycleItemClickLitener;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

public class RecycleActivity extends Activity {
	RecyclerView rv;
	RecycleAdapter adapter;
	List<String> s;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recycle);
		initView();
	}

	private void initView() {
		s = new ArrayList<String>();
		s.add("111111");
		s.add("222222");
		s.add("333333");

		rv = (RecyclerView) findViewById(R.id.rv);
		rv.setLayoutManager(new LinearLayoutManager(this));

		// rv.setLayoutManager(new LinearLayoutManager(this));//这里用线性显示
		// 类似于listview
		rv.setLayoutManager(new GridLayoutManager(this, 2));// 这里用线性宫格显示 类似于grid
															// view
		// rv.setLayoutManager(new StaggeredGridLayoutManager(2,
		// OrientationHelper.VERTICAL));//这里用线性宫格显示 类似于瀑布流

		adapter = new RecycleAdapter(RecycleActivity.this, s);
		rv.setAdapter(adapter);

		adapter.setOnRecycleItemClickLitener(new OnRecycleItemClickLitener() {

			@Override
			public void onItemClick(View view, int position) {
				Toast.makeText(RecycleActivity.this, "" + position, 1).show();
				startActivity(AActivity.class);
			}
		});
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
}
