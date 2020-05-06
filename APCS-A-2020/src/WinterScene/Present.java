package WinterScene;
//(c) A+ Computer Science

//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Present extends AbstractShape {
	public Present(int x, int y, int w, int h) {
		super(x, y, w, h, Color.WHITE, 0, 0);
	}

	public void draw(Graphics window) {
		window.setColor(getColor());
		window.fillRect(getXPos(), getYPos(), getWidth(), getHeight());
		window.setColor(Color.BLACK);
		window.drawRect(getXPos(), getYPos(), getWidth(), getHeight());

	}

	public void moveAndDraw(Graphics window) {
		draw(window);
	}
}