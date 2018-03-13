package com.edu.mydemolist.readxml;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;

import android.util.Xml;

public class TimingService {
	public static List<Timing> getTimings(FileInputStream xml) throws Exception {
		List<Timing> timings = null;
		Timing timing = null;
		XmlPullParser pullParser = Xml.newPullParser();
		pullParser.setInput(xml, "UTF-8");
		int event = pullParser.getEventType();

		while (event != XmlPullParser.END_DOCUMENT) {

			switch (event) {

			case XmlPullParser.START_DOCUMENT:
				timings = new ArrayList<Timing>();
				break;
			case XmlPullParser.START_TAG:
				if ("timing".equals(pullParser.getName())) {
					String endTime = pullParser.getAttributeValue(0);
					timing = new Timing();
					timing.setEndTime(endTime);
				}
				if ("startTime".equals(pullParser.getName())) {
					String startTime = pullParser.nextText();
					timing.setStartTime(startTime);
				}
				if ("weekTime".equals(pullParser.getName())) {
					String weekTime = pullParser.nextText();
					timing.setWeekTime(weekTime);
				}
				break;

			case XmlPullParser.END_TAG:
				if ("timing".equals(pullParser.getName())) {
					timings.add(timing);
					timing = null;
				}
				break;

			}

			event = pullParser.next();
		}

		return timings;
	}

}
