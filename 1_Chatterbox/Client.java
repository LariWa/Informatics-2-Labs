
import java.io.*;
import java.net.*;
import java.util.Scanner;

//@author Jodie Preuß and Larissa Wagnerberger

public class Client {

	private static Scanner reader;
	private static DataOutputStream dout;
	private static DataInputStream dis;

	public static void main(String[] args) {
		reader = new Scanner(System.in);
		boolean finished = false;
		try {
			Socket s = new Socket("141.45.215.53", 8000);
			dis = new DataInputStream(s.getInputStream());
			while (!finished) {
				dout = new DataOutputStream(s.getOutputStream());
				String input = getInput();
				if (input.equals("bye")) {
					finished = true;
					dout.writeUTF("Tschüs");
					dout.close();
					s.close();
				} else {
					dout.writeUTF(input);
					dout.flush();
					System.out.println("Server says: " + dis.readUTF());
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Read a line of text from standard input (the text terminal), and return it as
	 * a String.
	 *
	 * @return A String typed by the user.
	 */
	public static String getInput() {
		System.out.print("> "); // print prompt
		String inputLine = reader.nextLine();

		return inputLine;
	}
}
