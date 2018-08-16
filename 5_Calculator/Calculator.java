package exercise5;

/**
 * The main class of a simple calculator. Create one of these and you'll get the
 * calculator on screen.
 * 
 * @author David J. Barnes, Michael Kolling, Caroline Volante and Larissa
 *         Wagnerberger
 */
public class Calculator {
	protected CalcEngine engine;
	protected UserInterface gui;

	public static void main(String args[]) {
		new Calculator();
	}

	/**
	 * Create a new calculator and show it.
	 */
	public Calculator() {
		engine = new CalcEngine();
		gui = new UserInterface(engine);
	}

	/**
	 * In case the window was closed, show it again.
	 */
	public void show() {
		gui.setVisible(true);
	}
}
