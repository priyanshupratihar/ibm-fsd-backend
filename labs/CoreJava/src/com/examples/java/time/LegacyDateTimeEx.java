package com.examples.java.time;

import java.util.Date;
import java.util.Calendar;
public class LegacyDateTimeEx {

	public static void main(String[] args) {
		
		//today's date
		Date today=new Date();
		System.out.println(today);
		
		//yestarday's date
		@SuppressWarnings("deprecation")
		Date yestarday=new Date("2019/03/14 14:30:30");
		System.out.println(yestarday);
		
		Calendar todayc= Calendar.getInstance();
		
	}

}
