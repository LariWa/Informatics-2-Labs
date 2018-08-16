import java.util.Scanner;

//@author David Panagiotopulos and Larissa Wagnerberger
public class Main {
	public static void main(String[] args) {
		Postfix p = new Postfix();
		consoleListener(args);
	}

	private static void consoleListener(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String s = scanner.next();
			if (s.equals("stop"))
				System.exit(0);
			try {
				System.out.println(Postfix.evaluatePfx(Postfix.infixToPostfix(s)));
			} catch (StackUnderflow stackUnderflow) {
				stackUnderflow.printStackTrace();
			} catch (PostfixException | InfixException e) {
				try {
					System.out.println("Postfix identified...\nResult: " + Postfix.evaluatePfx(s));
				} catch (StackUnderflow stackUnderflow) {
					stackUnderflow.printStackTrace();
				} catch (PostfixException e1) {
					System.err.println("Please use a valid input");
					main(args);
				}

			}

		}
	}

}