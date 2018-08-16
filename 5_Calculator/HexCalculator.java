package exercise5;

//@author Caroline Volante and Larissa Wagnerberger

public class HexCalculator extends Calculator {
	protected HexCalcEngine engine;
	protected HexUserface gui;

	public static void main(String args[]) {
		new HexCalculator();
	}

	public HexCalculator() {
		engine = new HexCalcEngine();
		gui = new HexUserface(engine);
	}

}
