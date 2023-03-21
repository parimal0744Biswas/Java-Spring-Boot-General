package com.time;

import java.time.LocalDate;
import java.time.Period;

public class TimeDifference
{
	public static void main(String[] args)
	{
		LocalDate localDate = LocalDate.now();

		LocalDate dob1 = LocalDate.of(1999, 02, 12);

		Period period = Period.between(dob1, localDate);

		System.out.println(period);
		System.out.println(period.getDays());
	}
}
