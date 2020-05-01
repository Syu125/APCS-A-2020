package BreakOut;
//(c) A+ Computer Science

//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Block implements Locatable {
	private int xPos;
	private int yPos;
	private int width;
	private int height;
	private Color color;

	public Block() {

	}

	// add other Block constructors - x , y , width, height, color

	public Block(int x, int y) {
		xPos = x;
		yPos = y;
		width = 10;
		height = 10;
		color = Color.BLACK;
		

	}
	public Block(int x, int y, int w, int h) {
		xPos =  x;
		yPos = y;
		width = w;
		height = h;
		color = Color.BLACK;
	}

	public Block(int x, int y, int w, int h, Color c) {
		xPos = x;
		yPos = y;
		width = w;
		height = h;
		color = c;
	}

	// add the other set methods

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color col) {
		color = col;
	}

	public void draw(Graphics window) {
		// uncomment after you write the set and get methods
		window.setColor(color);
		window.fillRect(getX(), getY(), getWidth(), getHeight());

	}

	public void draw(Graphics window, Color col) {
			window.setColor(col);
			window.fillRect(getX(), getY(), getWidth(), getHeight());
		
		

	}

	public boolean equals(Object obj) {
		if(super.equals(obj))
			return true;
		return false;
	}

	@Override
	public void setPos(int x, int y) {
		// TODO Auto-generated method stub
		this.xPos = x;
		this.yPos = y;
	}

	@Override
	public void setX(int x) {
		// TODO Auto-generated method stub
		this.xPos = x;
	}

	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub
		this.yPos = y;
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return xPos;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return yPos;
	}

	// add the other get methods

	// add a toString() method - x , y , width, height, color
	public String toString() {
		return xPos + " " + yPos + " " + width + " " + height + " " + color;
	}
}