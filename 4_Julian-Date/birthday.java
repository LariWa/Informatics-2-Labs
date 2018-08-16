package exercise4;

//@ author Livia Konitzer and Larissa Wagnerberger

import java.util.*;

public class birthday {
	public static void main(String[] args) {
		System.out.println("Birthday calulation:");
		System.out.println("Please enter your birthday (dd.mm.yyyy)");
		Scanner reader = new Scanner(System.in);
		String input = reader.nextLine();
		String[] split = input.split("\\.");
		int bday = Integer.parseInt(split[0]);
		int bmonth = Integer.parseInt(split[1]);
		int byear = Integer.parseInt(split[2]);

		if (isBday(bday, bmonth))
			System.out.println("Happy birthday!!");
		int bdays = birthdayDays(bday, bmonth, byear);
		if (bdays % 100 == 0)
			System.out.println("Today is your lucky day!");
		System.out.println("You are " + bdays + " days old.");
		String weekday = weekday(bday, bmonth, byear);
		System.out.println("You were born on: " + weekday);

	}

	public static int[] currentDate() {
		Calendar c = Calendar.getInstance();
		int cday = c.get(Calendar.DATE);
		int cmonth = (c.get(Calendar.MONTH) + 1);
		int cyear = c.get(Calendar.YEAR);
		int[] date = { cday, cmonth, cyear };
		return date;

	}

	public static int birthdayDays(int bday, int bmonth, int byear) {

		int[] date = currentDate();

		int cdays = (int) julianDate.convertGregorian(date[0], date[1], date[2]);
		int bdays = (int) julianDate.convertGregorian(bday, bmonth, byear);

		return cdays - bdays;
	}

	public static String weekday(int bday, int bmonth, int byear) {
		int bdays = (int) julianDate.convertGregorian(bday, bmonth, byear);
		int weekday = (bdays) % 7;
		String[] weekdays = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
		return weekdays[weekday];

	}

	public static boolean isBday(int bday, int bmonth) {
		int[] date = currentDate();
		if (date[0] == bday && date[1] == bmonth)
			return true;
		return false;

	}
}
