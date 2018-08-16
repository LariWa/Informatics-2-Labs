package exercise5;

import java.util.*;

//@author Caroline Volante and Larissa Wagnerberger

public class HexCalcEngine extends CalcEngine {
	private String hexValue = "";
	protected boolean isHexadecimal = true;

	public void numberPressed(int number) {

		if (!isHexadecimal) {
			super.numberPressed(number);
		} else {
			if (buildingDisplayValue) {
				// Incorporate this digit.
				displayValue = displayValue * 16 + number;
			} else {
				// Start building a new number.
				displayValue = number;
				buildingDisplayValue = true;
			}
			hexValue = Integer.toHexString(displayValue);
		}

	}

	/*
	 * public String getDisplayValue() { return hexValue; }
	 */

	public void clear() {

		super.clear();
		if (isHexadecimal)
			hexValue = "";
	}

	public void applyOperator(char operator) {
		super.applyOperator(operator);
		if (isHexadecimal)
			hexValue = "";

	}

	public void calculateResult() {
		super.calculateResult();
		if (isHexadecimal)
			hexValue = Integer.toHexString(displayValue);
	}

	public String getHexValue() {
		return hexValue;
	}

}
