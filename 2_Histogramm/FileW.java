import java.io.*;

//@author Caroline Volante and Larissa Wagnerberger

public class FileW {
	public static void main(String[] args) {
		try {
			FileWriter fw = new FileWriter("Z:\\Info 2\\HIstogram\\src\\TextFile1.txt");
			fw.write("we write...");
			fw.flush();
			int c = 42;

			fw.write(Integer.toString(c));
			fw.flush();

			Integer i = 42;
			fw.write(Integer.toString(i));
			fw.flush();

			// create File
			File file = new File("Z:\\Info 2\\HIstogram\\src\\TextFile2.txt");
			file.createNewFile();
		}

		catch (Exception e) {
			System.out.println(e);
		}

	}
}
