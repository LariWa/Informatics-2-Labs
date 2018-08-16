import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

//@author Florian Murzov-Pirkl and Larissa Wagnerberger
public class Dictionary {
	private LinkedList<String>[] hashedWords;

	private static int MODULO = 12809;
	private static String filename = "words.txt";
	private static String searchterm = "munster";
	int counter = 0;

	public Dictionary() throws IOException {
		hashedWords = new LinkedList[MODULO];
		int collisions = 0;
		int biggestSize = 0;
		for (int i = 0; i < MODULO; i++) {
			hashedWords[i] = new LinkedList<>();
		}
		readFile();

		for (int i = 0; i < hashedWords.length; i++) {
			int size = hashedWords[i].size();
			if (size > 1)
				collisions += size;
			if (size > biggestSize) {
				biggestSize = size;
			}
			System.out.println(i + ". " + hashedWords[i].toString());
		}
		System.out.println("Wordcount: " + counter);
		System.out.println("There are " + collisions + " collisions in the HashTable");
		System.out.println("The longest linked list has " + biggestSize + " chains");

	}

	public void readFile() throws IOException {
		String textLine;
		FileReader reader = new FileReader(filename);
		BufferedReader buffer = new BufferedReader(reader);

		while (buffer.ready()) {
			textLine = buffer.readLine().toLowerCase();
			/*
			 * if the words are longer than this, our calculation for the hashValue before
			 * modulo is too large
			 */
			if (textLine.length() <= 7) {

				counter++;
				/* long hashValue = calculatePos(textLine); */
				hashedWords[calculatePos(textLine)].add(textLine);
				/* System.out.println(textLine); */
			}
		}
		buffer.close();
	}

	public int calculatePos(String line) {
		long hashValue = 0;
		line = line.trim().toLowerCase();
		char[] ca = line.toCharArray();
		Arrays.sort(ca); /*
							 * sorts the char array by ascii values and therefore alphabetically as well.
							 */
		for (int i = 0; i < ca.length; i++) {
			double temp = Math.pow(26, (double) i); // cast necessary for math.pow
			hashValue = hashValue + (long) temp * ((long) ca[i] - 96);
		}
		return (int) (hashValue % MODULO);
	}

	public String[] lookup(String search) {
		/* char[] ca = search.toCharArray(); */
		int pos = calculatePos(search);
		int size = hashedWords[pos].size();
		String[] words = new String[size];
		for (int i = 0; i < size; i++) {
			words[i] = hashedWords[pos].get(i);
		}
		return words;
	}

	public boolean isPermutation(String original, String compare) {
		boolean bool = false;
		char[] originalA = original.toCharArray();
		Arrays.sort(originalA);
		char[] compareA = compare.toCharArray();
		Arrays.sort(compareA);

		for (int i = 0; i < originalA.length; i++) {
			if (originalA[i] != compareA[i])
				return bool;
		}
		bool = true;
		return bool;
	}

}
