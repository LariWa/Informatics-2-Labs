package exercise5;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

//@author Caroline Volante and Larissa Wagnerberger

public class HexUserface extends UserInterface {

	private HexCalcEngine calc;
	private JCheckBox decimalBox;
	private JCheckBox hexadecimalBox;
	protected JPanel buttonPanel;

	public HexUserface(HexCalcEngine engine) {

		super(engine);
		this.calc = engine;
		frame.setContentPane(makeButtons());
		addCheckbox("Decimal", "Hexadecimal");
		frame.pack();
	}

	public JPanel makeButtons() {
		JPanel contentPanel = (JPanel) frame.getContentPane();
		buttonPanel = new JPanel(new GridLayout(2, 3));
		addButton(buttonPanel, "A");
		addButton(buttonPanel, "B");
		addButton(buttonPanel, "c");
		addButton(buttonPanel, "D");
		addButton(buttonPanel, "E");
		addButton(buttonPanel, "F");

		BorderLayout layout = (BorderLayout) contentPanel.getLayout();
		JPanel calcButtons = (JPanel) layout.getLayoutComponent(BorderLayout.CENTER);
		JPanel Buttons = new JPanel(new GridLayout(2, 1));
		Buttons.add(calcButtons);
		Buttons.add(buttonPanel);
		contentPanel.add(Buttons, BorderLayout.CENTER);
		return contentPanel;

	}

	/**
	 * Add a checkbox to the frame
	 * 
	 * @param checkboxText1
	 *            is the text for the first checkbox
	 * @param checkboxText
	 *            is the text for the second checkbox
	 */
	protected void addCheckbox(String checkboxText1, String checkboxText2) {

		JPanel cboxPanel = new JPanel();
		decimalBox = new JCheckBox(checkboxText1, false);
		hexadecimalBox = new JCheckBox(checkboxText2, true);

		cboxPanel.add(decimalBox, BorderLayout.EAST);
		cboxPanel.add(hexadecimalBox, BorderLayout.WEST);

		frame.getContentPane().add(cboxPanel, BorderLayout.AFTER_LAST_LINE);

		decimalBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent ie) {
				if (decimalBox.isSelected()) {
					calc.isHexadecimal = false;
					hexadecimalBox.setSelected(false);
					buttonPanel.setVisible(false);
				}

				if (hexadecimalBox.isSelected()) {

					calc.isHexadecimal = true;
					;
					decimalBox.setSelected(false);
					buttonPanel.setVisible(true);
				}
			}
		});

	}

	public void actionPerformed(ActionEvent event) {
		super.actionPerformed(event);

		if (calc.isHexadecimal) {
			String command = event.getActionCommand();

			if (command.equals("A") || command.equals("B") || command.equals("c") || command.equals("D")
					|| command.equals("E") || command.equals("F")) {
				int number = Integer.parseInt(command, 16);
				calc.numberPressed(number);
			}
			// else unknown command.

			redisplay();
		}

	}

	protected void redisplay() {
		if (!calc.isHexadecimal)
			super.redisplay();
		else
			display.setText("" + calc.getHexValue());
	}

	public HexCalcEngine getCalc() {
		return calc;
	}

	public void setCalc(HexCalcEngine calc) {
		this.calc = calc;
	}

}
