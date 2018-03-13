package com.edu.mydemolist.popup;

import java.util.List;

import com.edu.mydemolist.R;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by MQ on 2017/4/8.
 */

public class PopupAdapter extends RecyclerView.Adapter<PopupAdapter.MyViewHolder> {
	private Context mContext;
	private List<String> list;
	private MyPopupOnclickListener myItemClickListener;

	public PopupAdapter(Context mContext) {
		this.mContext = mContext;
	}

	public interface MyPopupOnclickListener {
		void onItemClick(View view, int position);

	}

	public void setOnPopupItemClickListener(MyPopupOnclickListener listener) {
		this.myItemClickListener = listener;
	}

	@Override
	public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(mContext).inflate(R.layout.popup_item, parent, false);
		return new MyViewHolder(view);
	}

	@Override
	public void onBindViewHolder(MyViewHolder holder, final int position) {
		holder.choice_text.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (myItemClickListener != null) {
					myItemClickListener.onItemClick(v, position);
				}
			}
		});
	}

	@Override
	public int getItemCount() {
		return 15;
	}

	public class MyViewHolder extends RecyclerView.ViewHolder {
		TextView choice_text;

		public MyViewHolder(final View itemView) {
			super(itemView);
			choice_text = (TextView) itemView.findViewById(R.id.choice_text);
		}
	}
}
