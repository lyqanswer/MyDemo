package com.edu.mydemolist.recycle;

import java.util.ArrayList;
import java.util.List;

import com.edu.mydemolist.R;
import com.edu.mydemolist.recycle.ARecycleAdapter.OnRecycleItemClickLitener;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

public class AActivity extends Activity {
	RecyclerView r;
	ARecycleAdapter aAdapter;
	List<String> s;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_a);
		initView();
	}

	private void initView() {

		s = new ArrayList<String>();
		s.add("性别");
		s.add("年龄");
		s.add("学校");

		r = (RecyclerView) findViewById(R.id.rv_a);
		aAdapter = new ARecycleAdapter(AActivity.this, s);
		r.setLayoutManager(new LinearLayoutManager(this));// 这里用线性显示

		r.setAdapter(aAdapter);

		aAdapter.setOnRecycleItemClickLitener(new OnRecycleItemClickLitener() {

			@Override
			public void onItemClick(View view, int position) {
				Toast.makeText(AActivity.this, position + "'", 1).show();
				showSexDialog(position);

			}
		});
	}

	/**
	 * 显示设置性别对话框
	 */
	private void showSexDialog(final int position) {
		AlertDialog.Builder builder = new AlertDialog.Builder(AActivity.this);
		builder.setTitle("设置性别");
		// 指定下拉列表的显示数据
		final String[] sex = { "男", "女" };
		// 设置一个下拉的列表选择项
		builder.setItems(sex, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// userSex.refreshView(sex[which]);
				// userSex.tvUser.setTag(2);
				String strSex = sex[which];
				// aAdapter.notifyDataSetChanged();
				aAdapter.notifyItemChanged(position);
			}
		});
		builder.show();

	}

}
