package exercise4;

//@author Livia Konitzer and Larissa Wagnerberger

public class metricDate {
	public static void main(String[] args) {

		System.out.println(convertToMetric(1280));
		System.out.println(convertToJulian(80, 2, 1));
	}

	public static String convertToMetric(int jDate) {
		int year = jDate / 1000;
		int month = (jDate % 1000) / 100;
		int day = jDate - year * 1000 - month * 100;
		if (day == 0) {
			day = 100;
			month--;
		}

		return "day: " + day + " month: " + month + " year: " + year;

	}

	public static int convertToJulian(int mDay, int mMonth, int mYear) {

		return (mYear * 1000) + (mMonth * 100) + mDay;
	}
}
