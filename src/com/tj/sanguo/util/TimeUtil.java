package com.tj.sanguo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {

	public static String transferLongToDate(Long millSec){
		return transferLongToDate("YYYY-MM-dd HH:mm:ss", millSec);
    }
	
	public static String transferLongToDate(String dateFormat,Long millSec){
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Date date= new Date(millSec);
        return sdf.format(date);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long time = System.currentTimeMillis();
		
		System.out.println(transferLongToDate("YYYY-MM-dd HH:mm:ss", time));
	}

}
