import java.io.*;

//@author Caroline Volante and Larissa Wagnerberger

public class FileR {

	public static void main(String[] args) {
		try {
			String fileName = "Z:\\Info 2\\HIstogram\\src\\TextFile1.txt";

			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);

			System.out.println("Copied from the file to the console:");

			while (br.ready()) {
				String line = br.readLine();
				for (int i = 0; i < line.length(); i++) {
					String first = line.substring(i, i + 1);

					System.out.print(first);
				}
				System.out.println("");
			}

		}

		catch (Exception e) {
			System.out.println(e);
		}
	}

}