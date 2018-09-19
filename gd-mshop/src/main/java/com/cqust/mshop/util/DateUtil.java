package com.cqust.mshop.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    public static  Date getPastBeginDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String result = format.format(today);
        result += " 00:00:00";
        try {
			Date date  = com.cqust.commom.utils.DateUtil.stringToDate(result, "yyyy-MM-dd hh:mm:ss");
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
        
        return null;
    }
    public static  Date getPastEndDate(int past) {
    	Calendar calendar = Calendar.getInstance();
    	calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
    	Date today = calendar.getTime();
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    	String result = format.format(today);
    	result += " 23:59:59";
    	try {
    		Date date  = com.cqust.commom.utils.DateUtil.stringToDate(result, "yyyy-MM-dd hh:mm:ss");
    		return date;
    	} catch (ParseException e) {
    		e.printStackTrace();
    	}
    	
    	return null;
    }
    
    public static void main(String[] args) {
		System.out.println(getPastBeginDate(1));
		System.out.println(getPastEndDate(1));
	}
}
