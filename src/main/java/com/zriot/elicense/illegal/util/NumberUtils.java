package com.zriot.elicense.illegal.util;

public class NumberUtils {
	
	/**
	 * 将数字转成两位小数的百分比
	 */
	public static String change2percent(Double number) {
		number = number * 100;
		java.text.DecimalFormat df = new java.text.DecimalFormat("#.00");
		String format = df.format(number);
		return format + "%";
	}
	

	/**
	 * 将数字转成百分比不保留小数点
	 */
	public static String change0percent(Double number) {
		number = number * 100;
		long temp = Math.round(number);
		return temp + "%";
	}
	
}
