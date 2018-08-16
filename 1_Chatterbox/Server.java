
import java.io.*;
import java.net.*;

//@author Jodie Preuﬂ and Larissa Wagnerberger

public class Server {
	private static DataOutputStream dout;

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			ServerSocket ss = new ServerSocket(8001);
			Socket s = ss.accept();// establishes connection
			boolean finished = false;
			while (!finished) {
				dout = new DataOutputStream(s.getOutputStream());
				DataInputStream dis = new DataInputStream(s.getInputStream());
				String str = (String) dis.readUTF();
				System.out.println("message= " + str);
				String str2 = br.readLine();
				dout.writeUTF(str2);
				dout.flush();

				if (str.equals("bye")) {
					finished = true;
					ss.close();
				}
			}
		} catch (Exception e) {
			System.out.println("You got an Errormessage: " + e);
		}
	}
}