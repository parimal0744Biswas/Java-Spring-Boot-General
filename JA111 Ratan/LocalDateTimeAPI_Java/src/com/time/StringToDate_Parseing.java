package com.time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// From String date to Day of Birth

public class StringToDate_Parseing
{

	public static void main(String[] args)
	{
		String dob1 = "12/07/1999";

		DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		LocalDate date = LocalDate.parse(dob1, dtf1);

		System.out.println(date.getDayOfWeek());

		String dayString = date.format(DateTimeFormatter.ofPattern("EEEE"));

		System.out.println(dayString);

	}
}
