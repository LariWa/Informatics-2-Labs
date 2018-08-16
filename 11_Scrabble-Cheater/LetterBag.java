import java.util.Arrays;
import java.util.HashSet;

//@author Florian Murzov-Pirkl and Larissa Wagnerberger
public class LetterBag {

	private HashSet<String> combination;

	public static void main(String[] args) {
		LetterBag lb = new LetterBag("java");
	}

	public LetterBag(String letters) {
		this.combination = new HashSet<String>();
		combination.add(letters);
		combination(letters);
		System.out.println(combination);
	}

	private void combination(String letters) {
		if (letters.length() < 3)
			return;
		for (int i = 0; i < letters.length(); i++) {
			String temp = letters.substring(0, i) + letters.substring(i + 1, letters.length());
			char[] sortingArray = temp.toCharArray();
			Arrays.sort(sortingArray);
			temp = String.valueOf(sortingArray);
			if (!combination.contains(temp)) {
				combination.add(temp);
				combination(temp);
			}
		}
	}

	public HashSet<String> getCombination() {
		return combination;
	}
}
