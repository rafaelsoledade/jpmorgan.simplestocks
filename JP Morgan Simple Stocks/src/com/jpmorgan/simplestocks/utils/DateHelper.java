package com.jpmorgan.simplestocks.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * 
 * Helper class for Date operations
 * 
 * @author rafaelmatos
 *
 */
public class DateHelper {

    /**
     * 
     * Method that verifies if a given date is within the last 15 minutes
     * 
     * @param timeStamp
     * @param timeSpanInMinutes
     * @return
     */
    public static boolean isTradeProcessedWithinTimeSpan(Date timeStamp, int timeSpanInMinutes) {

	Calendar currentDate = Calendar.getInstance();

	Calendar targetDate = Calendar.getInstance();
	targetDate.setTimeInMillis(currentDate.getTimeInMillis());
	targetDate.add(Calendar.MINUTE, -timeSpanInMinutes);
	
	return timeStamp.compareTo(targetDate.getTime()) >= 0;
    }
}
