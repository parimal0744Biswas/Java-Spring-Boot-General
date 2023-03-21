package com.time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateToString_Formatter
{
	public static void main(String[] args)
	{
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate);

		try
		{
//			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("DD/MM/YYYY");
//			String customeformat = localDate.format(formatter);
//			System.out.println(customeformat);

			String newPassten = localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			System.out.println(newPassten);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}

	}
}
