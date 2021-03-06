package Pong;
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
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

import java.awt.event.ActionListener;

public class Pong extends Canvas implements KeyListener, Runnable {
	private BlinkyBall ball;
	private Paddle leftPaddle;
	private Paddle rightPaddle;
	private boolean[] keys;
	private BufferedImage back;
	private int leftScore;
	private int rightScore;
	private boolean crossLeft;
	private boolean crossRight;
	private boolean leftWin;
	private Ball inviBall;
	private Timer t;
	private Wall left, right, top, bottom;
	private int frameWidth;
	private int frameHeight;
	private boolean hide = false;

	public Pong() {
		// set up all variables related to the game
		ball = new BlinkyBall();
		leftPaddle = new Paddle(20, 250, 10, 40, Color.YELLOW, 3);
		rightPaddle = new Paddle(745, 200, 10, 40, Color.YELLOW, 3);
		inviBall = new Ball();

		left = new Wall(5, 0, 5, getHeight());
		right = new Wall(getWidth(), 0, 5, getHeight());
		top = new Wall(0, 0, getWidth(), 5);
		bottom = new Wall(0, getHeight(), getWidth(), 5);

		frameWidth = 800;
		frameHeight = 600;
		t = new Timer();
		keys = new boolean[4];
		leftWin = false;
		crossLeft = false;
		crossRight = false;

		setBackground(Color.WHITE);
		setVisible(true);

		t.schedule(new updateTask(), 7000,10000);
		
		new Thread(this).start();
		addKeyListener(this); // starts the key thread to log key strokes
	}

	public void update(Graphics window) {
		paint(window);

	}

	public void paint(Graphics window) {
		// set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D) window;

		// take a snap shop of the current screen and same it as an image
		// that is the exact same width and height as the current screen
			back = (BufferedImage) (createImage(frameWidth, frameHeight));

		// create a graphics reference to the back ground image
		// we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();

		graphToBack.setColor(Color.RED);
		graphToBack.drawString("leftScore: " + leftScore, getWidth()-80, getHeight()-40);
		graphToBack.drawString("rightScore: " + rightScore, getWidth()-80, getHeight()-20);
		
		leftPaddle.setHeight(frameHeight/10);
		rightPaddle.setHeight(frameHeight/10);
		
		leftPaddle.setWidth(leftPaddle.getHeight()/7);
		rightPaddle.setWidth(rightPaddle.getHeight()/7);
		
		ball.setWidth(frameWidth/70);
		ball.setHeight(frameWidth/70);
		
		rightPaddle.erase(graphToBack);
		rightPaddle.setX(frameWidth - 50);
		ball.moveAndDraw(graphToBack);
		leftPaddle.draw(graphToBack);
		rightPaddle.draw(graphToBack);
		 
		

		left.setHeight(getHeight());
		right.setHeight(getHeight());
		top.setWidth(getWidth());
		bottom.setWidth(getWidth());

		if (left.wallCollide(ball) || right.wallCollide(ball)) {

			ball.setXSpeed(-ball.getXSpeed());
			increaseSpeed();
		}
		if (top.wallCollide(ball) || bottom.wallCollide(ball)) {

			ball.setYSpeed(-ball.getYSpeed());
			increaseSpeed();
		}

		// see if ball hits left wall or right wall
		if (!(ball.getX() >= 10 && ball.getX() <= frameWidth - 20)) {
			if (ball.getX() <= 10) {
				rightScore++;
				leftWin = false;
				graphToBack.setColor(Color.WHITE);
				graphToBack.fillRect(740, 480, 30, 30);
			}
			if (ball.getX() > frameWidth-20) {
				leftScore++;
				leftWin = true;
				graphToBack.setColor(Color.WHITE);
				graphToBack.fillRect(730, 460, 30, 30);
			}
			ball.draw(graphToBack, Color.WHITE);
			ball.setxPos(350);
			ball.setyPos(170);
			if (leftWin) {
				ball.setXSpeed(((int) (Math.random() * 2) + 1));
				ball.setYSpeed(((int) (Math.random() * 2) + 1));
			} else {
				ball.setXSpeed(((int) (Math.random() * 2) + 1) * -1);
				ball.setYSpeed(((int) (Math.random() * 2) + 1));
			}

		}

		// see if the ball hits the top or bottom wall
		if (!(ball.getY() >= 0 && ball.getY() <= frameHeight-70)) {
			ball.setYSpeed(-ball.getYSpeed());
			increaseSpeed();

		}

		if (ball.didCollideLeft(leftPaddle) || ball.didCollideRight(leftPaddle) || ball.didCollideTop(leftPaddle)
				|| ball.didCollideBottom(leftPaddle)) {

		}

		// see if the ball hits the left paddle
		if (ball.getX() <= leftPaddle.getX() + leftPaddle.getWidth() + Math.abs(ball.getXSpeed())
				&& (ball.getY() >= leftPaddle.getY() && ball.getY() <= leftPaddle.getY() + leftPaddle.getHeight()
						|| ball.getY() + ball.getHeight() >= leftPaddle.getY()
								&& ball.getY() + ball.getHeight() < leftPaddle.getY() + leftPaddle.getHeight())) {
			if (ball.getX() <= leftPaddle.getX() + leftPaddle.getWidth() - Math.abs(ball.getXSpeed()))
				ball.setYSpeed(-ball.getYSpeed());
			else
				ball.setXSpeed(-ball.getXSpeed());
			increaseSpeed();
		}

		// see if the ball hits the right paddle
		if (ball.getX() >= rightPaddle.getX() - rightPaddle.getWidth() - Math.abs(ball.getXSpeed())
				&& (ball.getY() >= rightPaddle.getY() && ball.getY() <= rightPaddle.getY() + rightPaddle.getHeight()
						|| ball.getY() + ball.getHeight() >= rightPaddle.getY()
								&& ball.getY() + ball.getHeight() < rightPaddle.getY() + rightPaddle.getHeight())) {
			if (ball.getX() >= rightPaddle.getX() + rightPaddle.getWidth() + Math.abs(ball.getXSpeed()))
				ball.setYSpeed(-ball.getYSpeed());
			else
				ball.setXSpeed(-ball.getXSpeed());
			increaseSpeed();
		}

		// see if the paddles need to be moved
		if (keys[0] == true) {
			// move left paddle up and draw it on the window
			leftPaddle.moveUpAndDraw(graphToBack);

		}
		if (keys[1] == true) {
			// move left paddle down and draw it on the window
			leftPaddle.moveDownAndDraw(graphToBack);

		}
		if (keys[2] == true) {
			rightPaddle.moveUpAndDraw(graphToBack);
		}
		if (keys[3] == true) {
			rightPaddle.moveDownAndDraw(graphToBack);
		}

		twoDGraph.drawImage(back, null, 0, 0);
		
	}

	public void keyPressed(KeyEvent e) {
		switch (toUpperCase(e.getKeyChar())) {
		case 'W':
			keys[0] = true;
			break;
		case 'Z':
			keys[1] = true;
			break;
		case 'I':
			keys[2] = true;
			break;
		case 'M':
			keys[3] = true;
			break;
		}
	}

	public void keyReleased(KeyEvent e) {
		switch (toUpperCase(e.getKeyChar())) {
		case 'W':
			keys[0] = false;
			break;
		case 'Z':
			keys[1] = false;
			break;
		case 'I':
			keys[2] = false;
			break;
		case 'M':
			keys[3] = false;
			break;
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	public void increaseSpeed() {
		if (ball.getXSpeed() < 0) {
			if (ball.getYSpeed() < 0) {
				ball.setXSpeed(ball.getXSpeed() - 1);
				ball.setYSpeed(ball.getYSpeed() - 1);
			} else {
				ball.setXSpeed(ball.getXSpeed() - 1);
				ball.setYSpeed(ball.getYSpeed() + 1);
			}
		} else {
			if (ball.getYSpeed() < 0) {
				ball.setXSpeed(ball.getXSpeed() + 1);
				ball.setYSpeed(ball.getYSpeed() - 1);
			} else {
				ball.setXSpeed(ball.getXSpeed() + 1);
				ball.setYSpeed(ball.getYSpeed() + 1);
			}
		}
	}

	public void changeFrameWidth(int w) {
		frameWidth = w;
	}

	public void changeFrameHeight(int h) {
		frameHeight = h;
	}

	public void run() {
		try {
			while (true) {
				Thread.currentThread().sleep(8);
				repaint();
				if(!hide) {
					ball.setColor(ball.randomColor());
				}
			}
		} catch (Exception e) {
		}
	}
	class updateTask extends TimerTask{
		
		@Override
		public void run() {
			long t = System.currentTimeMillis();
			long end = t + 3000;
			while(System.currentTimeMillis() < end) {
		
				ball.setColor(Color.WHITE);
				hide  = true;
				try {
					Thread.sleep(8);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			hide = false;
			ball.setColor(ball.randomColor());
			
			
			
		}
		
	}
	
}