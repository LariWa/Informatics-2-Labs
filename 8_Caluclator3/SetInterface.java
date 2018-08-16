import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * SetInterface
 * 
 * @author Chantal Reiﬂner and Larissa Wagnerberger
 * @version 2018.06.08
 */
public class SetInterface extends HexInterface implements ActionListener {

	protected JPanel setpanel;
	protected JButton switchbutton;
	protected JButton openpbutton;
	protected JButton closepbutton;
	protected JButton commabutton;
	protected JButton lengthbutton;
	protected JButton intersecbutton;
	private JPanel hexButtons;
	private Component[] buttons;

	public SetInterface(Engine engine) {
		super(engine);

		makebuttonsSET();

		frame.setVisible(true);

		// make the program exit if we close the window
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				frame.dispose();
			}
		});
	}

	protected void makebuttonsSET() {

		openpbutton = new JButton("{");
		openpbutton.addActionListener(this);
		closepbutton = new JButton("}");
		closepbutton.addActionListener(this);
		commabutton = new JButton(", ");
		commabutton.addActionListener(this);
		lengthbutton = new JButton("length");
		lengthbutton.addActionListener(this);
		intersecbutton = new JButton("intersec");
		intersecbutton.addActionListener(this);

		activatebuttons(false);

		assembleSET();
	}

	protected void assembleSET() {

		JPanel contentPane = (JPanel) frame.getContentPane();

		setpanel = new JPanel(new GridLayout(7, 1));

		setpanel.add(openpbutton);
		setpanel.add(closepbutton);
		setpanel.add(commabutton);
		setpanel.add(lengthbutton);
		setpanel.add(intersecbutton);
		BorderLayout layout = (BorderLayout) contentPane.getLayout();
		hexButtons = (JPanel) layout.getLayoutComponent(BorderLayout.EAST);
		buttons = hexButtons.getComponents();
		JPanel Buttons = new JPanel(new GridLayout(1, 2));
		Buttons.add(hexButtons);
		Buttons.add(setpanel);
		contentPane.add(Buttons, BorderLayout.EAST);
		switchbutton = (JButton) buttons[0];

		frame.pack();
	}

	public void activateHexButtons(boolean b) {

		for (int i = 1; i < buttons.length; i++) {
			buttons[i].setEnabled(b);
		}
	}

	public void actionPerformed(ActionEvent event) {

		super.actionPerformed(event);

		String command = event.getActionCommand();

		if (command.equals("{"))
			calc.openp();
		if (command.equals("}"))
			calc.closep();
		if (command.equals(", "))
			calc.comma();
		if (command.equals("length"))
			calc.getLength();
		if (command.equals("intersec"))
			calc.op(command);

		else if (command.equals("SET")) {
			calc.setSetMode(true);
			calc.setHexMode(false);
			activatebuttons(true);
			activateHexButtons(false);
			switchbutton.setText("DEC");
			showInfo();
		}

		else if (command.equals("DEC")) {
			calc.setSetMode(false);
			calc.setHexMode(false);
			activatebuttons(false);
			activateHexButtons(false);
			switchbutton.setText("HEX");
			showInfo();
		}

		else if (command.equals("HEX")) {
			calc.setSetMode(false);
			calc.setHexMode(true);
			activatebuttons(false);
			activateHexButtons(true);
			switchbutton.setText("SET");
			showInfo();
		}

		redisplay();
	}

	private void activatebuttons(boolean b) {
		openpbutton.setEnabled(b);
		closepbutton.setEnabled(b);
		commabutton.setEnabled(b);
		lengthbutton.setEnabled(b);
		intersecbutton.setEnabled(b);

	}

	protected void redisplay() {

		if (calc.getSetMode()) {
			showInfo();
			display.setText("" + calc.getDisplayString());
		} else
			super.redisplay();
	}

}
