package StarFighter;
//(c) A+ Computer Science

//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OuterSpace extends Canvas implements KeyListener, Runnable {
	private Ship ship;
	private Alien alienOne;
	private Alien alienTwo;
	//private Ammo ammo;
	private ArrayList<Alien> horde;
	private ArrayList<Ammo> bullets;
	private ArrayList<Boolean> shoot;
	private int bNum;
	/*
	 * uncomment once you are ready for this part
	 *
	 * private AlienHorde horde; private Bullets shots;
	 */

	private boolean[] keys;
	private BufferedImage back;

	public OuterSpace() {
		setBackground(Color.black);

		bNum = 0;
		horde = new ArrayList<Alien>();
		bullets = new ArrayList<Ammo>();
		shoot = new ArrayList<Boolean>();

		keys = new boolean[5];

		// instantiate other instance variables
		// Ship, Alien
		for (int i = 0; i < 8; i++) {
			horde.add(new Alien(i * 100 + 50, -40, 40, 40, 1));
		}
		for (int i = 0; i < 20; i++) {
			bullets.add(new Ammo(-100, -100, 3));
			shoot.add(false);
		}
		ship = new Ship(100, 400, 50, 50, 2);
		// alienOne = new Alien(100,100,40,40,2);
		// alienTwo = new Alien(300,100,40,40,2);
		//ammo = new Ammo(100, 400, 2);
		this.addKeyListener(this);
		new Thread(this).start();

		setVisible(true);
		keys[4] = false;
	}

	public void update(Graphics window) {
		paint(window);
	}

	public void paint(Graphics window) {
		// set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D) window;

		// take a snap shop of the current screen and same it as an image
		// that is the exact same width and height as the current screen
		if (back == null)
			back = (BufferedImage) (createImage(getWidth(), getHeight()));

		// create a graphics reference to the back ground image
		// we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();

		graphToBack.setColor(Color.BLUE);
		graphToBack.drawString("StarFighter ", 25, 50);
		graphToBack.setColor(Color.BLACK);
		graphToBack.fillRect(0, 0, 800, 600);

		if (keys[0] == true) {
			ship.move("LEFT");
		}
		if (keys[1] == true) {
			ship.move("RIGHT");
		}
		if (keys[2] == true) {
			ship.move("UP");
		}
		if (keys[3] == true) {
			ship.move("DOWN");
		}
		for (Boolean b : shoot) {
			if (b) {
				bullets.get(shoot.indexOf(b)).draw(graphToBack);
				bullets.get(shoot.indexOf(b)).setX(ship.getX() + ship.getWidth() / 2);
				bullets.get(shoot.indexOf(b)).move("UP");

			}
		}

		// add code to move Ship, Alien, etc.
		ship.draw(graphToBack);
		// alienOne.draw(graphToBack);
		// alienTwo.draw(graphToBack);

		for (Alien alien : horde) {
			alien.draw(graphToBack);
			alien.move("UP");
			for (Ammo ammo : bullets) {
				if (ammo.getX() >= alien.getX() && ammo.getX() <= alien.getX() + alien.getWidth()
						&& ammo.getY() <= alien.getY() + alien.getHeight()) {
					shoot.set(bullets.indexOf(ammo), false);
					ammo.setPos(-100, -100);
					alien.setY(-40);
				}
			}
			if(alien.getY() > 640) {
				alien.setY(-40);
			}

		}
		for(Ammo ammo: bullets) {
			if(ammo.getY()<0) {
				shoot.set(bullets.indexOf(ammo), false);

			}
		}
		// add in collision detection to see if Bullets hit the Aliens and if Bullets
		// hit the Ship

		/*
		 * if(ammo.getX() >= alienOne.getX() && ammo.getX() <= alienOne.getX() +
		 * alienOne.getWidth() && ammo.getY() <= alienOne.getY()+alienOne.getHeight()) {
		 * keys[4] = false; alienOne.setY(-50); }
		 */
		twoDGraph.drawImage(back, null, 0, 0);
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			keys[0] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			keys[1] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			keys[2] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			keys[3] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			keys[4] = true;
			bullets.get(bNum).setY(ship.getY());

			shoot.set(bNum, true);
			if(bNum == bullets.size()-1)
				bNum = 0;
			else
				bNum ++;
			
		}
		repaint();
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			keys[0] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			keys[1] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			keys[2] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			keys[3] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
		}
		repaint();
	}

	public void keyTyped(KeyEvent e) {
		// no code needed here
	}

	public void run() {
		try {
			while (true) {
				Thread.currentThread().sleep(5);
				repaint();
			}
		} catch (Exception e) {
		}
	}
}
