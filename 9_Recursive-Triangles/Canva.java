import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.Random;

import javax.swing.JFrame;
//@author Florian Murzov-Pirkl and Larissa Wagnerberger

public class Canva extends JFrame {
	// Lab PC:
	// private int canvasw = 1920;
	// private int canvash=1000;

	private int canvasw = 1300;
	private int canvash = 700;
	private int i = 0;
	private Random rand = new Random();
	private Graphics g;

	public Canva() {
		super();
		setSize(canvasw, canvash);
		setVisible(true);
	}

	public void paint(Graphics g) {
		g.clearRect(0, 0, canvasw + 100, canvash + 100);
		canvasw = getWidth() - 100;
		canvash = getHeight() - 100;

		int space = 50;
		int height = canvash - space;
		if (canvash > canvasw)
			height = canvasw - space;
		int width = (int) (height * 2 / Math.sqrt(3));
		this.g = g;

		sierpinski(space, canvash, width, height, getColor());

	}

	public void sierpinski(double x, double y, double width, double height, Color col) {
		if (width < 5)
			return;

		drawTriangle((int) x, (int) y, (int) width, (int) height, col);
		i++;

		col = getColor();

		sierpinski(x, y, width / 2, height / 2, col);
		sierpinski(x + width / 2, y, width / 2, height / 2, col);
		sierpinski(x + width / 4, y - height / 2, width / 2, height / 2, col);
	}

	public void drawTriangle(int x, int y, int width, int height, Color col) {

		g.setColor(col);

		g.drawLine(x, y, x + width, y);
		g.drawLine(x + width, y, x + width / 2, y - height);
		g.drawLine(x + width / 2, y - height, x, y);

		int xpoints[] = { x + width / 4, x + width / 4 * 3, x + width / 2 };
		int ypoints[] = { y - height / 2, y - height / 2, y };
		int npoints = 3;

		Polygon p = new Polygon(xpoints, ypoints, npoints);
		g.fillPolygon(p);
	}

	public Color getColor() {
		float r = rand.nextFloat();
		float g = rand.nextFloat();
		float b = rand.nextFloat();
		Color col = new Color(r, g, b);
		return col;
	}

	public Graphics getG() {
		return g;
	}
}