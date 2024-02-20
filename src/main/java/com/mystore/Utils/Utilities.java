package com.mystore.Utils;

import java.util.Date;

public class Utilities {

//	Methods for page timeouts
	public static final int IMPLICIT_WAIT_TIME = 20;
	public static final int PAGE_LOAD_TIME = 10;
	
	
//	Time Stamp Generator Method
	public static String timeStamp() {
		Date date = new Date();
		String timeStamp = date.toString().replace(" ", "_").replace(":", "_"); 
		return timeStamp;
	}
}
