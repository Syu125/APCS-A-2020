package BreakOut;
//(c) A+ Computer Science

//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block implements Collidable{
	private int xSpeed;
	private int ySpeed;

	public Ball() {
		super(400, 300);
		xSpeed = -2;
		ySpeed = 1;
	}

	// add the other Ball constructors
	public Ball(int x, int y) {
		super(x, y);
		xSpeed = -2;
		ySpeed = 1;
	}
	public Ball(int x, int y, int xs, int ys) {
		super(x, y);
		xSpeed = xs;
		ySpeed = ys;
	}
	

	public Ball(int x, int y, int wid, int ht, int xSpd, int ySpd) {
		super(x, y,wid,ht);
		xSpeed = xSpd;
		ySpeed = ySpd;
	}
	public Ball(int x, int y, int wid, int ht, Color c, int xSpd, int ySpd) {
		super(x, y,wid,ht,c);
		xSpeed = xSpd;
		ySpeed = ySpd;
	}

	public void moveAndDraw(Graphics window) {
		// draw a white ball at old ball location
		window.setColor(Color.WHITE);
		window.fillRect(getX(), getY(), 10, 10);
		setX(getX() + xSpeed);
		// setY
		setY(getY() + ySpeed);
		// draw the ball at its new location
		window.setColor(Color.blue);
		window.fillRect(getX(), getY(), 10, 10);
	}
	
	// add the set methods
	public void setXSpeed(int xSpeed) {
		this.xSpeed = xSpeed;
	}

	public void setYSpeed(int ySpeed) {
		this.ySpeed = ySpeed;
	}

	public int getXSpeed() {
		return xSpeed;
	}
	
	public int getYSpeed() {
		return ySpeed;
	}
	
	public boolean equals(Object obj) {

		return false;
	}

	public boolean collide (Block b) {
		if(b.getY()+2 >= getY() && b.getX() <= getX() && b.getX() + b.getWidth()+1 >= getX()) {
			return true;
		}
		return false;
	}
	@Override
	public boolean didCollideLeft(Object obj) {
		// TODO Auto-generated method stub
		Paddle p = (Paddle) obj;
		if(p.getxPos() +p.getWidth() >=  getxPos() && 
				(p.getY()+p.getHeight() >= getyPos() && p.getY() <= getyPos())) {
			return  true;
		}
		return false;
	}

	@Override
	public boolean didCollideRight(Object obj) {
		// TODO Auto-generated method stub
		Paddle p = (Paddle) obj;
		if(p.getxPos() <= getxPos()+10 && 
				(p.getY()+p.getHeight() >= getyPos() && p.getY() <= getyPos())) {
			return  true;
		}
		return false;
	}

	@Override
	public boolean didCollideTop(Object obj) {
		// TODO Auto-generated method stub
		Paddle p = (Paddle) obj;
		if(p.getyPos() <= getyPos()+10 && 
				(p.getX()+p.getWidth() >= getxPos() && p.getX() <= getxPos())) {
			return  true;
		}
		return false;
	}

	@Override
	public boolean didCollideBottom(Object obj) {
		// TODO Auto-generated method stub
		Paddle p = (Paddle) obj;
		if(p.getyPos()+p.getHeight() >= getyPos() && 
				(p.getX()+p.getWidth() >= getxPos() && p.getX() <= getxPos())) {
			return  true;
		}
		return false;
	}

	
}