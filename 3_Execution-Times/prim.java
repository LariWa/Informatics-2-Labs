import java.math.BigInteger;
import java.util.Random;

//@ author Benedict Belz and Larissa Wagnerberger
public class prim {

	public static void main(String[] args) {
		Random r = new Random();
		long average1 = 0;

		for (int i = 0; i < 100; i++) {
			BigInteger rand = new BigInteger(20, r);
			long rand1 = rand.longValue();
			long start = System.nanoTime();
			long result = isPrime(rand1);
			long end = System.nanoTime();
			System.out.print(result + "         ");
			System.out.println((end - start));
			average1 += end - start;
		}

		System.out.println("Total: " + average1);
		average1 = average1 / 100;
		System.out.println("Average: " + average1);

		long average2 = 0;

		for (int i = 0; i < 100; i++) {
			BigInteger rand = new BigInteger(40, r);
			long rand1 = rand.longValue();
			long start = System.nanoTime();
			long result = isPrime(rand1);
			long end = System.nanoTime();
			System.out.print(result + "   ");
			System.out.println((end - start));
			average2 += end - start;
		}

		System.out.println("Total time: " + average2);
		average2 = average2 / 100;
		System.out.println("Average: " + average2);

	}

	public static long isPrime(long x) {
		long steps = 1;

		if (x < 2)
			return steps;
		for (int i = 2; i < x; i++) {
			steps++;
			if (x % i == 0)
				return steps;
		}
		return steps;

	}
}
