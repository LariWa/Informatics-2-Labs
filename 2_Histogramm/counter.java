import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

//@author Caroline Volante and Larissa Wagnerberger
public class counter {

	public static void main(String[] args) {
		try {
			String fileName = "TextFile1.txt";

			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			File file = new File("frequency.txt");
			file.createNewFile();
			FileWriter fw = new FileWriter("frequency.txt");

			int[] count = new int[26];
			while (br.ready()) {
				String line = br.readLine().toUpperCase();
				char[] c = line.toCharArray();
				for (int i = 0; i < c.length; i++) {
					int letter = ((int) c[i]) - 65;
					if (0 <= letter && letter < 26)
						count[letter]++;
				}
			}
			fw.write("Frequency of letters in TextFile1: \r\n");

			for (int i = 0; i < count.length; i++) {
				fw.write((char) (i + 65) + ": " + count[i] + "\r\n");
			}
			fw.flush();

		}

		catch (Exception e) {
			System.out.println(e);
		}

	}

}
