import java.io.IOException;
import java.util.HashSet;
import java.util.Random;

//@author Florian Murzov-Pirkl and Larissa Wagnerberger
public class ScrabbleCheaterDeluxe {

	private static LetterBag lb;
	private static Dictionary dic;
	private static HashSet<String> possibilities;
	private static String word;

	public static void main(String[] args) throws IOException {
		dic = new Dictionary();
		word = getRandomWord();
		lb = new LetterBag(word);
		possibilities = new HashSet<String>();
		allCombos();
	}

	public static String getRandomWord() {
		Random random = new Random();

		String result = "";
		for (int i = 0; i < 7; i++) {
			result += Character.toString((char) (random.nextInt(26) + 97));
		}
		return result;
	}

	private static void allCombos() {
		HashSet<String> combination = lb.getCombination();
		for (String letters : combination) {
			String[] words = dic.lookup(letters);
			if (words.length > 1) {
				for (String word : words) {
					if (dic.isPermutation(word, letters)) {
						possibilities.add(word);
					}
				}
			}
		}
		System.out.println(word + " - Possible words: " + possibilities);
	}
}
