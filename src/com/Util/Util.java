package com.Util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

	public static String systemDate() {
		DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
		Date date = new Date();
		// System.out.println(dateFormat.format(date));
		String Expected_date = dateFormat.format(date);
		return Expected_date;
	}

}
