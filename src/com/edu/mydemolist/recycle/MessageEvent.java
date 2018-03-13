package com.edu.mydemolist.recycle;

public class MessageEvent {
	public final int position;
	public final String info;

	public MessageEvent(int position, String info) {
		this.position = position;
		this.info = info;
	}
}