package com.edu.mydemolist.spanned;

import com.edu.mydemolist.R;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.widget.TextView;

public class SpannedActivity extends Activity {
	private TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.spanned_activity);
		inintView();
	}

	private void inintView() {
		tv = (TextView) findViewById(R.id.tv_text);
		SpannableString showString = new SpannableString("我们的侣行环球飞行开着中国32年前自己产的飞机飞越大西洋横跨赤道超级白飞到南极");
		MyIm imageSpan = new MyIm(this, R.drawable.ic_launcher);
		MyIm imageSpan2 = new MyIm(this, R.drawable.ic_launcher);
		MyIm imageSpan21 = new MyIm(this, R.drawable.ic_launcher);
		showString.setSpan(imageSpan, 2, 3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		showString.setSpan(imageSpan2, 10, 12, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		showString.setSpan(imageSpan21, 20, 22, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		tv.setText(showString);

	}

	public class MyIm extends ImageSpan {
		public MyIm(Context arg0, int arg1) {
			super(arg0, arg1);
		}

		public int getSize(Paint paint, CharSequence text, int start, int end, FontMetricsInt fm) {
			Drawable d = getDrawable();
			Rect rect = d.getBounds();
			if (fm != null) {
				FontMetricsInt fmPaint = paint.getFontMetricsInt();
				// 获得文字、图片高度
				int fontHeight = fmPaint.bottom - fmPaint.top;
				int drHeight = rect.bottom - rect.top;
				// 对于这段算法LZ表示也不解，正常逻辑应该同draw中的计算一样但是显示的结果不居中，经过几次调试之后才发现这么算才会居中
				int top = drHeight / 2 - fontHeight / 4;
				int bottom = drHeight / 2 + fontHeight / 4;

				fm.ascent = -bottom;
				fm.top = -bottom;
				fm.bottom = top;
				fm.descent = top;
			}
			return rect.right;
		}

		@Override
		public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
			Drawable b = getDrawable();
			canvas.save();
			int transY = 0;
			// 获得将要显示的文本高度-图片高度除2等居中位置+top(换行情况)
			transY = ((bottom - top) - b.getBounds().bottom) / 2 + top;
			// 偏移画布后开始绘制
			canvas.translate(x, transY);
			b.draw(canvas);
			canvas.restore();
		}
	}

}
