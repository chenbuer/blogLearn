package com.chenbuer.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	public static String formatDate(String fmt,Date date){
		SimpleDateFormat sdf=new SimpleDateFormat(fmt);
		return sdf.format(date);
	}

}
