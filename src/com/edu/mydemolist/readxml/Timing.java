package com.edu.mydemolist.readxml;

public class Timing {
	private String endTime;
	private String startTime;
	private String weekTime;

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getWeekTime() {
		return weekTime;
	}

	public void setWeekTime(String weekTime) {
		this.weekTime = weekTime;
	}

	@Override
	public String toString() {
		return "Person [endTime=" + endTime + ", startTime=" + startTime + ", weekTime=" + weekTime + "]";
	}

	public Timing(String endTime, String startTime, String weekTime) {
		this.endTime = endTime;
		this.startTime = startTime;
		this.weekTime = weekTime;
	}

	public Timing() {

	}
}
