package com.cqust.commom.utils;

public class DoubleUtil {
	public static Double twoDouble(Double doublenum){
		String c = new java.text.DecimalFormat("#.00").format(doublenum);
		return new Double(c);
	}
}
