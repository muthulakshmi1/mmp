package org.iit.healthcare.mmp;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Utility {
	
	public static Calendar calendar;
	public static SimpleDateFormat sdf;
	
	public static void getCurrentDate(){
		
		// current date
		calendar = Calendar.getInstance();
		Date calDate = calendar.getTime();
		sdf = new SimpleDateFormat("MMMM dd yyyy");
		String formattedCalDate = sdf.format(calDate);
		System.out.println("Current Date: " + formattedCalDate);
		//return formattedCalDate;
	}
	
	public static String getRandomFutureDate(){

		// Random date
		getCurrentDate();
		Random random = new Random();
		int randValue = random.nextInt(365);
		System.out.println(randValue);
		calendar.add(Calendar.DAY_OF_YEAR, randValue);
		Date randomDate = calendar.getTime();
		String formattedRandomDate = sdf.format(randomDate);
		System.out.println("Random Date: " + formattedRandomDate);
		return formattedRandomDate;
		
	}
}
