package com.qa.ninja.utilities;

import java.util.Date;

public class Utilities {

	public static String generateDateTimeSetUp() {
		Date date = new Date();
		String timeStamp = date.toString().replace(" ", "_").replace(":", "_");  //To generate a value for negative testing for password and email
		return "zulysaidi" + timeStamp + "@gmail.com";
	}
	
	public static final int IMPLICIT_WAIT_TIME = 10;
	public static final int PAGELOAD_TIME = 10;
}
