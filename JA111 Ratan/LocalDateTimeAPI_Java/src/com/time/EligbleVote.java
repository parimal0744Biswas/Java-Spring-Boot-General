package com.time;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class EligbleVote
{
	public static void main(String[] args)
	{

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter Date DD-MM-YYYY format");

		String string = scanner.next();

		LocalDate date = LocalDate.parse(string, DateTimeFormatter.ofPattern("dd-MM-yyyy"));

		LocalDate today = LocalDate.now();

		Period period = Period.between(date, today);

		if (period.getYears() >= 18)
		{
			System.out.println("Eligble for Vote");
		}
		else
		{
			System.out.println("Not Eligible for vote");
		}

		scanner.close();

	}
}
