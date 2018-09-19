package com.cqust.commom.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static void main(String[] args) throws ParseException {
/*		String start = "2013-11-27 00:00:00.0";
		String end = "2013-11-30 00:00:00.0";
		Timestamp costTime = Timestamp.valueOf(start); // 收款时间
		Timestamp receivableTime = Timestamp.valueOf(end);// 付款时间
		Timestamp curentTime = new Timestamp(System.currentTimeMillis());

		Timestamp test = Timestamp.valueOf("2013-12-14 00:00:00.0");
		System.out.println(getTrueDays(curentTime, test));

		int days = getDays(receivableTime, costTime);
		System.out.println("相差[" + days + "]天");

		long str = 1385354603827L;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(str);
		System.out.println(format.format(calendar.getTime()));
		System.out.println(System.currentTimeMillis());
		dateToString(new Date(), "yyyy-MM-dd hh:mm:ss");
		System.out.println(new Date().toString());
		String s = null;
		java.text.DateFormat format1 = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		s = format1.format(new Date());
		System.out.println(s);
		System.out.println(dateToString(new Date(), "yyyy-MM-dd hh:mm:ss"));*/
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long timeStart=sdf.parse("2011-09-20 12:30:45").getTime();
		System.out.println(timeStart);
		Date date = new Date(timeStart);
		System.out.println(sdf.format(date));
		System.out.println(new DateUtil().longToString(1316493045000L, "yyyy-MM-dd hh:mm:ss"));
	}

	// long类型转换为String类型
	// currentTime要转换的long类型的时间
	// formatType要转换的string类型的时间格式
	public static String longToString(Long currentTime, String formatType){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(currentTime);
		return sdf.format(date);
	}

	/*
	 * public String dateToString(Date date,String dateFormat){
	 * java.text.DateFormat format = new java.text.SimpleDateFormat(dateFormat);
	 * return format.format(date).toString(); }
	 */

	/**
	 * 计算两个日期之间相差的天数
	 * 
	 * @param costTime
	 * @param receivableTime
	 * @return
	 */
	public static int getDays(Timestamp end, Timestamp start) {
		Calendar aCalendar = Calendar.getInstance();
		Calendar bCalendar = Calendar.getInstance();
		aCalendar.setTime(end);
		bCalendar.setTime(start);
		int days = 0;
		while (aCalendar.before(bCalendar)) {
			days++;
			aCalendar.add(Calendar.DAY_OF_YEAR, 1);
		}

		if (days == 0) {
			aCalendar.setTime(start);
			bCalendar.setTime(end);
			while (aCalendar.before(bCalendar)) {
				days++;
				aCalendar.add(Calendar.DAY_OF_YEAR, 1);
			}
		}
		return days;
	}

	/**
	 * 计算两个日期之间相差的天数
	 * 
	 * @param costTime
	 * @param receivableTime
	 * @return
	 */
	public static int getTrueDays(Timestamp end, Timestamp start) {
		Calendar aCalendar = Calendar.getInstance();
		Calendar bCalendar = Calendar.getInstance();
		aCalendar.setTime(end);
		bCalendar.setTime(start);
		int days = 0;
		while (aCalendar.before(bCalendar)) {
			days++;
			aCalendar.add(Calendar.DAY_OF_YEAR, 1);
		}
		return days;
	}

	/**
	 * 将字符串转换为Timestamp类型
	 * 
	 * @param str
	 *            日期字符串
	 * @return Timestamp类型对象
	 */
	public static Timestamp stringToTimestamp(String str) {
		return Timestamp.valueOf(str);
	}

	/**
	 * 将Timestamp类型对象转换为指定格式的字符串
	 * 
	 * @param timestamp
	 *            Timestamp类型对象
	 * @param format
	 *            字符串格式
	 * @return String字符串
	 */
	public static String timestampToString(Timestamp timestamp, String format) {
		DateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(timestamp);
	}

	/**
	 * 将Timestamp类型对象转换为Date类型对象
	 * 
	 * @param timestamp
	 *            Timestamp类型对象
	 * @return Date类型对象
	 */
	public static Date timestampToDate(Timestamp timestamp) {
		Date date = new Date();
		date = timestamp;
		return date;
	}

	/**
	 * 将Date类型对象转换为Timestamp类型对象
	 * 
	 * @param date
	 *            Date类型对象
	 * @return Timestamp类型对象
	 */
	public static Timestamp dateToTimestamp(Date date) {
		return new Timestamp(date.getTime());
	}

	/**
	 * 将一个字符串转换为指定的日期格式，返回Date类型对象
	 * 
	 * @param dateStr
	 *            日期字符串
	 * @param format
	 *            日期格式
	 * @return Date类型对象
	 * @throws ParseException
	 *             转换异常
	 */
	public static Date stringToDate(String dateStr, String format) throws ParseException {
		Date date = new Date();
		// 注意format的格式要与日期String的格式相匹配
		DateFormat sdf = new SimpleDateFormat(format);
		return sdf.parse(dateStr);
	}

	/**
	 * 将一个Date类型对象转换为指定格式的字符串
	 * 
	 * @param date
	 *            Date类型对象
	 * @param format
	 *            指定的字符串格式
	 * @return String字符串
	 */
	public static String dateToString(Date date, String format) {
		DateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date).toString();
	}

}