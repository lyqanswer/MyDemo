package com.edu.mydemolist.recycle;

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
public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {
	private static final String TAG = "RecycleAdapter";
	private LayoutInflater mInflater;
	private Context mContext;
	// 测试数据
	private List<String> s;

	public interface OnRecycleItemClickLitener {
		void onItemClick(View view, int position);

	}

	private OnRecycleItemClickLitener mOnRecycleItemClickLitener;

	public void setOnRecycleItemClickLitener(OnRecycleItemClickLitener mOnRecycleItemClickLitener) {
		this.mOnRecycleItemClickLitener = mOnRecycleItemClickLitener;
	}

	@Override
	public int getItemCount() {
		return s.size();
	}

	public RecycleAdapter(Context context, List<String> s) {
		this.mInflater = LayoutInflater.from(context);
		this.s = s;
		this.mContext = context;

	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int arg1) {
		View view = mInflater.inflate(R.layout.recycle_item, viewGroup, false);
		ViewHolder viewHolder = new ViewHolder(view);
		viewHolder.name = (TextView) view.findViewById(R.id.tv_name);
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
		viewHolder.name.setText(s.get(i) + "");
		if (mOnRecycleItemClickLitener != null) {
			viewHolder.name.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					mOnRecycleItemClickLitener.onItemClick(viewHolder.name, i);

				}
			});
		}
	}
}
