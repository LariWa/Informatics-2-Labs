//@ author Benedict Belz and Larissa Wagnerberger
public class ExecutionTimes {

	public static void main(String[] args) {
		int x = 10;
		System.out.println("Fragment 1 with 10: " + frag1(10));
		System.out.println("Fragment 1 with 100: " + frag1(100));
		System.out.println("Fragment 1 with 1000: " + frag1(1000));
		System.out.println("Fragment 1 with 10000: " + frag1(10000));
		System.out.println("Fragment 1 with 100000: " + frag1(100000));

		System.out.println("Fragment 2 with 10: " + frag2(10));
		System.out.println("Fragment 2 with 100: " + frag2(100));
		System.out.println("Fragment 2 with 1000: " + frag2(1000));
		System.out.println("Fragment 2 with 10000: " + frag2(10000));
		System.out.println("Fragment 2 with 100000: " + frag2(100000));

		System.out.println("Fragment 3 with 10: " + frag3(10));
		System.out.println("Fragment 3 with 100: " + frag3(100));
		System.out.println("Fragment 3 with 1000: " + frag3(1000));
		System.out.println("Fragment 3 with 10000: " + frag3(10000));
		System.out.println("Fragment 3 with 100000: " + frag3(100000));

		System.out.println("Fragment 4 with 10: " + frag4(10));
		System.out.println("Fragment 4 with 100: " + frag4(100));
		System.out.println("Fragment 4 with 1000: " + frag4(1000));
		System.out.println("Fragment 4 with 10000: " + frag4(10000));
		System.out.println("Fragment 4 with 100000: " + frag4(100000));

		System.out.println("Fragment 5 with 10: " + frag5(10));
		System.out.println("Fragment 5 with 100: " + frag5(100));
		System.out.println("Fragment 5 with 1000: " + frag5(1000));
		System.out.println("Fragment 5 with 10000: " + frag5(10000));
		System.out.println("Fragment 5 with 100000: " + frag5(100000));

		System.out.println("Fragment 6 with 10: " + frag6(10));
		System.out.println("Fragment 6 with 100: " + frag6(100));
		System.out.println("Fragment 6 with 1000: " + frag6(1000));
		System.out.println("Fragment 6 with 10000: " + frag6(10000));
		System.out.println("Fragment 6 with 100000: " + frag6(100000));

		System.out.println("Fragment 7 with 10: " + frag7(10));
		System.out.println("Fragment 7 with 100: " + frag7(100));
		System.out.println("Fragment 7 with 1000: " + frag7(1000));
		System.out.println("Fragment 7 with 10000: " + frag7(10000));
		System.out.println("Fragment 7 with 100000: " + frag7(100000));

		System.out.println("Fragment 8 with 10: " + frag8(10));
		System.out.println("Fragment 8 with 100: " + frag8(100));
		System.out.println("Fragment 8 with 1000: " + frag8(1000));
		System.out.println("Fragment 8 with 10000: " + frag8(10000));
		System.out.println("Fragment 8 with 100000: " + frag8(100000));

	}

	public static int frag1(int n) {
		// Fragment #1
		int sum = 0;
		for (int i = 0; i < n; i++)
			sum++;
		return sum;
	}

	public static int frag2(int n) {
		// Fragment #2
		int sum = 0;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				sum++;
		return sum;
	}

	public static long frag3(int n) {
		// Fragment #3
		long sum = 0;
		for (int i = 0; i < n; i++)
			for (int j = i; j < n; j++)
				sum++;
		return sum;
	}

	public static int frag4(int n) {
		// Fragment #4
		int sum = 0;
		for (int i = 0; i < n; i++)
			sum++;
		for (int j = 0; j < n; j++)
			sum++;
		return sum;
	}

	public static int frag5(int n) {
		// Fragment #5
		int sum = 0;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n * n; j++)
				sum++;
		return sum;
	}

	public static long frag6(int n) {
		// Fragment #6
		long sum = 0;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < i; j++)
				sum++;
		return sum;
	}

	public static long frag7(int n) {
		// Fragment #7
		long sum = 0;
		for (int i = 1; i < n; i++)
			for (int j = 0; j < n * n; j++)
				if (j % i == 0)
					for (int k = 0; k < j; k++)
						sum++;
		return sum;
	}

	public static int frag8(int n) {
		// Fragment #8
		int sum = 0;
		int i = n;
		while (i > 1) {
			i = i / 2;
			sum++;
		}
		return sum;
	}

	public boolean isPrime(int x) {
		if (x < 2)
			return false;
		for (int i = 2; i < x; i++)
			if (x % i == 0)
				return false;
		return true;

	}
}
