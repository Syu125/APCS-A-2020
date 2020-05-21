package StarFighterTwo;
//(c) A+ Computer Science

//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;

public class Ammo extends MovingThing {
	private int speed;
	private String direction;

	public Ammo() {
		this(0, 0, 0);
		direction = "UP";
	}

	public Ammo(int x, int y) {
		super(x, y);
		direction = "UP";
	}

	public Ammo(int x, int y, int s) {
		super(x, y);
		speed = s;
		direction = "UP";
	}

	public void setSpeed(int s) {
		speed = s;
	}

	public int getSpeed() {
		return speed;
	}

	public void setDirection(String s) {
		direction = s;
	}
	public String getDirection() {
		return direction;
	}

	public void draw(Graphics window) {
		window.setColor(Color.YELLOW);
		window.fillRect(getX(), getY(), 10, 10);
	}

	public void move() {
		switch (direction.toUpperCase()) {
		case ("UP"):
			setY(getY() - 3);
			break;
		case ("DOWN"):
			setY(getY() + 3);
			break;

		case ("LEFT"):
			setX(getX() - 3);
			break;

		case ("RIGHT"):
			setX(getX() + 3);
			break;
		}
		
	}

	public String toString() {
		return "";
	}

	@Override
	public void move(String direction) {
		// TODO Auto-generated method stub
		
	}
}
