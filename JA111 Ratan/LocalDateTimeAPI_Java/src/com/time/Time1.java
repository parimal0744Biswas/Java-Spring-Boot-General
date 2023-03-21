package com.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;

public class Time1
{
	public static void main(String[] args)
	{
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate);

		LocalTime localTime = LocalTime.now();
		System.out.println(localTime);

		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime);

		ZonedDateTime zdt = ZonedDateTime.now();
		System.out.println(zdt);

		LocalDate dob1 = LocalDate.of(1996, 07, 12);
		System.out.println(dob1);

		dob1.atTime(1, 50, 30);

		System.out.println(dob1);

	}
}
