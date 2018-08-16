import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

//@author Caroline Volante and Larissa Wagnerberger

public class histogram {

	public static void main(String[] args) {
		try {

			String fileName = "TextFile1.txt";
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			File file = new File("frequency.txt");
			file.createNewFile();
			FileWriter fw = new FileWriter("frequency.txt");

			File file2 = new File("Graph.txt");
			file2.createNewFile();
			FileWriter fw2 = new FileWriter("Graph.txt");

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
			fw2.write("Graphic visualization \r\n");

			for (int i = 0; i < count.length; i++) {
				String output = "";
				fw.write((char) (i + 65) + ": " + count[i] + "\r\n");
				output += "\r\n" + (char) (i + 65) + ": ";
				double y = ((double) count[i]) / 80 * 100;
				for (int stars = 0; stars < y; stars++) {
					output += "*";

				}
				fw2.write(output);
			}
			fw.flush();
			fw2.flush();

		}

		catch (Exception e) {
			System.out.println(e);
		}

	}

}