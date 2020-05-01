package BreakOut;
//(c) A+ Computer Science
//BREAKOUT
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block {
	// instance variables
	private int speed;
	private TheGame tg =  new TheGame("get");

	public Paddle() {
		super(10, 10);
		speed = 5;
	}

	// add the other Paddle constructors
	public Paddle(int speed) {
		super();
		this.speed = speed;
	}

	public Paddle(int x, int y) {
		super(x, y);
		speed = 5;
	}

	public Paddle(int x, int y, int speed) {
		super(x, y);
		this.speed = speed;
	}

	public Paddle(int x, int y, int width, int height, int speed) {
		super(x, y, width, height);
		this.speed = speed;
	}

	public Paddle(int x, int y, int width, int height, Color col, int speed) {
		super(x, y, width, height, col);
		this.speed = speed;
	}

	// add get methods
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void moveLeftAndDraw(Graphics window) {
		draw(window, Color.WHITE);
		setxPos(getxPos() - speed);
		draw(window);
		
	}

	public void moveRightAndDraw(Graphics window) {
			draw(window, Color.WHITE);
			setxPos(getxPos() + speed);
			draw(window);
	}

	// add a toString() method
	@Override
	public String toString() {
		return getxPos() + " " + getyPos() + " " + getWidth() + " " + getHeight() + " " + getColor() + " " + speed;
	}
}