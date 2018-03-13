package com.edu.mydemolist;

import java.util.List;

import com.edu.mydemolist.R;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * 书adapter
 * 
 * @author lyq
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
	private static final String TAG = "MainAdapter";
	private LayoutInflater mInflater;
	private Context mContext;
	// 测试数据
	private List<String> s;

	public interface OnRecyclerClickLitener {
		void onItemClick(View view, int position);

	}

	private OnRecyclerClickLitener mOnRecyclerClickLitener;

	public void setOnRecyclerClickLitener(OnRecyclerClickLitener mOnRecyclerClickLitener) {
		this.mOnRecyclerClickLitener = mOnRecyclerClickLitener;
	}

	@Override
	public int getItemCount() {
		return s.size();
	}

	public MainAdapter(Context context, List<String> ss) {
		this.mInflater = LayoutInflater.from(context);
		this.s = ss;
		this.mContext = context;

	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int arg1) {
		View view = mInflater.inflate(R.layout.main_item_name, viewGroup, false);
		ViewHolder viewHolder = new ViewHolder(view);
		viewHolder.name = (TextView) view.findViewById(R.id.name);
		viewHolder.mView = view;

		return viewHolder;
	}

	public static class ViewHolder extends RecyclerView.ViewHolder {
		public ViewHolder(View arg0) {
			super(arg0);
		}

		TextView name;
		View mView;
	}

	@Override
	public void onBindViewHolder(final ViewHolder viewHolder, final int i) {
		viewHolder.name.setText(s.get(i));
		if (mOnRecyclerClickLitener != null) {
			viewHolder.name.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					mOnRecyclerClickLitener.onItemClick(viewHolder.name, i);

				}
			});
		}
	}
}
