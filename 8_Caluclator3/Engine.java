import java.util.Iterator;

/**
 * UserInterface
 * 
 * @author Jan Schelhaas and Larissa Wagnerberger and Chantal Reiﬂner
 * @version 2018.06.08
 */
public class Engine {
	private String displayString = "";
	private boolean setMode = false;
	private boolean hexMode = false;
	private String error = "";
	private boolean open = false;
	private Set leftSet = new Set();
	private Set rightSet = new Set();
	private Set intersecSet = new Set();
	private boolean operator = false;
	private String operat = "";

	public Engine() {
		clear();
	}

	public void openp() {
		if (open)
			displayString = "Error: Too many open parenthensis!";
		else {
			open = true;
			displayString += "{";
		}

	}

	public void closep() {
		if (!open)
			displayString = "Error: Too many closing paranthensis!";
		else {
			open = false;
			displayString += "}";
		}

	}

	public void comma() {
		displayString += ", ";
	}

	public void getLength() {
		if (!open && leftSet != null) {
			displayString = "" + leftSet.getLength();
		}
	}

	public void numberPressed(int number) {
		displayString += number;
		if (setMode) {
			if (!operator) {
				if (leftSet.isMember(number))
					displayString = "Error: Number already in set";
				leftSet.add(number);
			} else {
				if (rightSet.isMember(number))
					displayString = "Error: Number already in set";
				rightSet.add(number);
			}

		}
	}

	public void equals() {

		try {
			Postfix p = new Postfix();

			if (hexMode) {
				int result = p.evaluate2(p.infixToPostfix(displayString), true);
				String sign = (Math.signum(result) < 0) ? "-" : "";
				displayString = sign + Integer.toHexString(Math.abs(result)).toUpperCase();
			}

			else if (setMode) {
				if (operat.equals("+")) {
					addSets();
					displayString = leftSet.toString();
				}
				if (operat.equals("-")) {
					subSets();
					displayString = leftSet.toString();
				}
				if (operat.equals("intersec")) {
					intersection();
				}
			} else
				displayString = String.valueOf(p.evaluate2(p.infixToPostfix(displayString), false));

			error = "";
		} catch (Exception e) {
			error = "Error while parsing expression: Illegal Character";
			clear();
		}

	}

	public boolean getSetMode() {
		return setMode;
	}

	public void setSetMode(boolean setMode) {
		this.setMode = setMode;
		clear();
	}

	public boolean getHexMode() {
		return hexMode;
	}

	public void setHexMode(boolean hexMode) {
		this.hexMode = hexMode;
		clear();
	}

	public void op(String op) {
		displayString += op;
		if (setMode && op.equals("+")) {
			operator = true;
			operat = "+";
		}
		if (setMode && op.equals("-")) {
			operator = true;
			operat = "-";
		}
		if (setMode && op.equals("intersec")) {
			operator = true;
			operat = "intersec";
		}
	}

	public String getDisplayString() {
		return displayString;
	}

	public void clear() {
		displayString = "";
		leftSet = new Set();
		rightSet = new Set();
		open = operator = false;
	}

	public void addSets() {
		Iterator it = rightSet.iterator();
		while (it.hasNext()) {
			leftSet.add((int) it.next());
		}
	}

	public void subSets() {
		Iterator it = rightSet.iterator();
		while (it.hasNext()) {
			leftSet.delete((int) it.next());
		}
	}

	public void intersection() {
		intersecSet.clear();
		Iterator it = rightSet.iterator();
		while (it.hasNext()) {
			if (leftSet.isMember((int) it.next())) {
				intersecSet.add((int) it.next());
			}
		}
		displayString = intersecSet.toString();
	}

	public String getStatus() {
		if (setMode)
			return "SET";

		else if (hexMode)
			return "HEX";
		else
			return "DEC";
	}

	public String getError() {
		return error;
	}
}
