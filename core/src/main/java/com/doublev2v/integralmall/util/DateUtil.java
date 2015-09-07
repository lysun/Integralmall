package com.doublev2v.integralmall.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	
	public static Date parse(String str) throws ParseException{
		SimpleDateFormat sdf=null;
		try {
			sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return sdf.parse(str);
		} catch (ParseException e) {
			sdf=new SimpleDateFormat("yyyy-MM-dd");
			return sdf.parse(str);
		}
	}
	
	public static String format(Date date){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
}
