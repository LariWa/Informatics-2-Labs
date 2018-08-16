package exercise4;

//@author Livia Konitzer and Larissa Wagnerberger

public class test {

	public static void main(String[] args) {
		System.out.println("Test Julian Date: ");

		System.out.println("Checking for mistakes in leap-year calculation");
		System.out.println("The 4.3.1900 should be 63 as Julian Date:");
		System.out.println(julianDate.convertGregorian(4, 3, 1900));

		System.out.println("63 should be 4.3.1900 as Gregorian Date:");
		System.out.println(julianDate.convertJulian(63));

		System.out.println("The 28.2.1901 should be 424 as Julian Date:");
		System.out.println(julianDate.convertGregorian(28, 2, 1901));

		System.out.println("424 should be 28.2.1901 as Gregorian Date:");
		System.out.println(julianDate.convertJulian(424));

		System.out.println("The 1.3.1916 should be 5904 as Julian Date:");
		System.out.println(julianDate.convertGregorian(1, 3, 1916));

		System.out.println("5904 should be 1.3.1916 as Gregorian Date:");
		System.out.println(julianDate.convertJulian(5904));

		System.out.println("\n1.1.1900 should be 1 as JulianDate");
		System.out.println(julianDate.convertGregorian(1, 1, 1900));
		System.out.println("1 should be 1.1.1900 as Gregorian Date:");
		System.out.println(julianDate.convertJulian(1));

	}

}
