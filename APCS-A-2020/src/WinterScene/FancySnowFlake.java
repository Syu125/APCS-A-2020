package WinterScene;
//(c) A+ Computer Science

//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

//extend the AbstractShape class to make a FancySnowFlake class
public class FancySnowFlake extends AbstractShape {

	public FancySnowFlake(int x, int y, int wid, int ht) {
		super(x, y, wid, ht);
		// TODO Auto-generated constructor stub
	}

	public FancySnowFlake(int x, int y, int wid, int ht, Color col) {
		super(x, y, wid, ht, col);
	}

	public FancySnowFlake(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd) {
		super(x, y, wid, ht, col, xSpd, ySpd);
	}

	@Override
	public void draw(Graphics window) {
		// TODO Auto-generated method stub
		window.setColor(Color.WHITE);
		window.fillRect(getXPos() + getWidth() / 2, getYPos(), getWidth() / 10, getHeight());
		window.fillRect(getXPos(), getYPos() + getHeight() / 2, getWidth(), getHeight() / 10);
		window.drawLine((int) (Math.cos(45) * getWidth() / 2 - getWidth() / 5),
				(int) (Math.sin(45) * getHeight() / 2 - getHeight() / 5),
				(int) (Math.cos(225) * getWidth() / 2 - getWidth() / 5),
				(int) (Math.sin(225) * getHeight() / 2 - getHeight() / 5));
	}

	@Override
	public void moveAndDraw(Graphics window) {
		// TODO Auto-generated method stub
		if (getYPos() >= 500) {
			setYPos(15);
			setYSpeed((int) (Math.random() * 5 + 1));
		}
		setYPos(getYPos() + getYSpeed());
		window.setColor(Color.WHITE);
		window.fillRect(getXPos() + getWidth() / 2, getYPos(), getWidth() / 10, getHeight());
		window.fillRect(getXPos(), getYPos() + getHeight() / 2, getWidth(), getHeight() / 10);
		window.drawLine((int) (Math.cos(45) * getWidth() / 2 - getWidth() / 5),
				(int) (Math.sin(45) * getHeight() / 2 - getHeight() / 5),
				(int) (Math.cos(225) * getWidth() / 2 - getWidth() / 5),
				(int) (Math.sin(225) * getHeight() / 2 - getHeight() / 5));
	}

}
