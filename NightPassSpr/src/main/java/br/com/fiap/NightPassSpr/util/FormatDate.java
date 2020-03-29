package br.com.fiap.NightPassSpr.util;

import java.util.Calendar;

public class FormatDate {

	/**
	
	* @param DateTimeString Date Time in format "aaaa/mm/dd 00:00"
	* @return Return a Calendar based on de DateTimeString

	*/

	public static Calendar fmtDateTime(String DateTimeString) {

		//Cria uma Data e Hora a partir do String no formato "aaaa/mm/dd 00:00"


		int Day;
		int Month;
		int Year;
		int Hour;
		int Minute;

		Calendar finalCalendar = Calendar.getInstance();


		Year = Integer.parseInt(DateTimeString.substring(0, 4));
		Month = Integer.parseInt(DateTimeString.substring(5, 7));
		Day = Integer.parseInt(DateTimeString.substring(8, 10));
		Hour = Integer.parseInt(DateTimeString.substring(11, 13));
		Minute = Integer.parseInt(DateTimeString.substring(14, 16));

		finalCalendar.set(Year, Month, Day, Hour, Minute, 0);

		return finalCalendar;

	}
	
	/**
	
	* @param calendar date 
	* @return Return a String of Time based on calendar in format HH:MM
	*/

	public static String getTimefmt(Calendar calendar) {
		
		//Retorna um string formatado contendo o tempo no formato HH:MM 
		
		String Timefmt = new String(); 
		
		Timefmt = String.valueOf(calendar.get(Calendar.HOUR_OF_DAY)) + ":" +
				String.valueOf(calendar.get(Calendar.MINUTE));
		
		return Timefmt;
		
	}


}

	

