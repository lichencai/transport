package com.zriot.elicense.illegal.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	/**
	 * 当前时间往前推dayCount天
	 */
	public static Date getSpecifiedDayBefore(Date date, int dayCount) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day - dayCount);
		c.getTime();
		return c.getTime();
	}
	
}
