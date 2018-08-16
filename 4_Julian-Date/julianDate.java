package exercise4;

//@author Livia Konitzer and Larissa Wagnerberger

public class julianDate extends metricDate {
	public static void main(String[] args) {
		System.out.println("Larissa's Birthday:");
		System.out.println("as Julian Date: " + convertGregorian(15, 11, 1997));
		System.out.println("as Metric Date" + convertToMetric(35748));
		System.out.println("Livia's Birthday \nas Julian Date: " + convertGregorian(15, 9, 1994));
		System.out.println("as Metric Date: " + convertToMetric(34591));
	}

	public static String convertJulian(int julian) {
		int year = 1900;
		int day = 0;
		int month = 1;
		int monate[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		while (julian != 0) {
			for (int i = 1; i <= 12; i++) {
				for (int j = 1; j <= monate[i - 1]; j++) {

					if (julian != 0) {
						julian--;
						day++;
					} else
						return "" + day + "." + month + "." + year;

				}
				if (julian != 0 && i == 2 && year % 4 == 0 && year != 1900) {
					julian--;
					day++;
				}
				if (julian == 0)
					return "" + day + "." + month + "." + year;
				day = 0;
				month++;

			}

			month = 1;

			year++;
		}
		return "Couldn't calculate gregorian date";
	}

	public static double convertGregorian(int day, int month, int year) {

		if (year < 1900)
			return -1;
		int date = 0;
		int monate[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		for (int i = 1900; i <= year - 1; i++) {
			if (i % 4 == 0 && (i != 1900))
				date = date + 366;
			else
				date = date + 365;
		}
		for (int j = 1; j < month; j++) {
			for (int k = 1; k <= monate[j - 1]; k++) {
				date++;
			}

		}
		if (month > 2 && year % 4 == 0 && year != 1900)
			date++;
		date = date + day;
		return date;

	}

}
