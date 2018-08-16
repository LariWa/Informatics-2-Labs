
/**
 * Main class
 * 
 * @author Jan Schelhaas, Pascal Polchow, Larissa Wagnerberger
 * @version 2018.06.08
 */
public class Calculator {
	private Engine engine;
	private SetInterface gui;

	/**
	 * Create a new calculator and show it.
	 */
	public Calculator() {
		engine = new Engine();
		gui = new SetInterface(engine);
	}

	public static void main(String args[]) {
		new Calculator();
	}

	/**
	 * In case the window was closed, show it again.
	 */
	public void show() {
		gui.setVisible(true);
	}
}
