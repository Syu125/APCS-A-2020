package GraphicsUnit2;
//(c) A+ Computer Science

//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;

public class Shape {
	// instance variables
	private int xPos;
	private int yPos;
	private int width;
	private int height;
	private Color color;
	private int xSpeed;
	private int ySpeed;
	private boolean run = true;

	/*
	 * The constructor is used to initialize all instance variables. The constructor
	 * makes the object.
	 */
	public Shape(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd) {
		xPos = x;
		// finish this constructor
		yPos = y;
		width = wid;
		height = ht;
		color = col;
		xSpeed = xSpd;
		ySpeed = ySpd;
	}

	/*
	 * The draw method draws the shape on the screen.
	 */
	public void draw(Graphics window) {
		window.setColor(color);
		window.fillRect(xPos, yPos, width, height);
		window.setColor(Color.white);
		window.fillOval(xPos + (int) (width * 0.15), yPos + (int) (height * 0.3), (int) (width * 0.2),
				(int) (width * 0.2));
		window.fillOval(xPos + (int) (width * 0.65), yPos + (int) (height * 0.3), (int) (width * 0.2),
				(int) (width * 0.2));
		// window.drawRect(xPos + (int)(width *0.15), yPos + (int)(height * 0.3),
		// height, height);
		// draw whatever you want
		// ^
		// [ :: ]
		// ()

	}

	/*
	 * This draw method will be used to erase the shape.
	 */
	public void draw(Graphics window, Color col) {
		window.setColor(col);
		window.fillRect(xPos, yPos, width, height);
	}

	public void moveAndDraw(Graphics window) {
		// not needed yet
			xPos += xSpeed;
			yPos += ySpeed;
			draw(window);
		
	}

	// add in set and get methods for xPos, yPos, xSpeed, and ySpeed
	public int getX() {
		return xPos;
	}

	public void setX(int x) {
		// add code here
		xPos = x;
	}

	public int getY() {
		return yPos;
	}

	public void setY(int y) {
		yPos = y;
	}

	public int getXSpeed() {
		return xSpeed;
	}

	public void setXSpeed(int xSpd) {
		xSpeed = xSpd;
	}

	public int getYSpeed() {
		return ySpeed;
	}

	public void setYSpeed(int ySpd) {
		ySpeed = ySpd;
	}

	public String toString() {
		return xPos + " " + yPos + " " + width + " " + height + " " + color + " " + xSpeed + " " + ySpeed;
	}
}