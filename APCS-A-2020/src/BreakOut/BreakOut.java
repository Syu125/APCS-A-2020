package BreakOut;
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

import javax.swing.JLabel;

import java.awt.event.ActionListener;

public class BreakOut extends Canvas implements KeyListener, Runnable {
	private BlinkyBall ball;
	private Paddle leftPaddle;
	private boolean[] keys;
	private BufferedImage back;
	private int leftScore;
	private int rightScore;
	private boolean crossLeft;
	private boolean crossRight;
	private boolean leftWin;
	private Ball inviBall;
	private Timer t;
	private Block[][] blocks;
	private boolean[][] hit;
	private int totalLeft = 48;
	public BreakOut() {
		// set up all variables related to the game
		ball = new BlinkyBall();
		leftPaddle = new Paddle(20, 500, 70, 10, Color.YELLOW, 3);
		inviBall = new Ball();

		t = new Timer();
		keys = new boolean[4];
		leftWin = false;
		crossLeft = false;
		crossRight = false;

		blocks = new Block[6][8];
		hit = new boolean[6][8];

		for (int i = 0; i < blocks.length; i++) {
			for (int j = 0; j < blocks[i].length; j++) {
				blocks[i][j] = new Block();
				blocks[i][j].setColor(new Color((int) (Math.random() * 256), (int) (Math.random() * 256),
						(int) (Math.random() * 256)));
				hit[i][j] = false;
			}
		}

		setBackground(Color.WHITE);
		setVisible(true);

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
		if (back == null)
			back = (BufferedImage) (createImage(getWidth() + 100, getHeight()));

		// create a graphics reference to the back ground image
		// we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();

		graphToBack.setColor(Color.RED);
		graphToBack.drawString("Score: " + rightScore, 680, 500);

		ball.moveAndDraw(graphToBack);
		leftPaddle.draw(graphToBack);

		
		for (int i = 0; i < blocks.length; i++) {
			for (int j = 0; j < blocks[i].length; j++) {
				if (ball.collide(blocks[i][j])) {
					hit[i][j] = true;
					ball.setYSpeed(-ball.getYSpeed());
					blocks[i][j].draw(graphToBack, Color.WHITE);
					graphToBack.setColor(Color.WHITE);
					graphToBack.fillRect(715, 480, 30, 30);
					rightScore++;
					System.out.println("true");
					totalLeft--;
				}
				if (!hit[i][j]) {
					blocks[i][j].setX(j * 98);
					blocks[i][j].setY(i * 30);
					blocks[i][j].setWidth(97);
					blocks[i][j].setHeight(29);
					blocks[i][j].draw(graphToBack);
				} else {
					blocks[i][j] = new Block();
				}

			}
		}

		// see if ball hits bottom
		

		// see if the ball hits the left or right wall
		if (!(ball.getX() >= 10 && ball.getX() <= getWidth())) {
			ball.setXSpeed(-ball.getXSpeed());
			increaseSpeed();
			leftPaddle.setSpeed(leftPaddle.getSpeed() + 1);

		}

		// see if the ball hits the left paddle
		
		if (ball.getY() >= leftPaddle.getY()-10
				&& (ball.getX() >= leftPaddle.getX()-5 && ball.getX() <= leftPaddle.getX() + leftPaddle.getWidth())){
				ball.setYSpeed(-ball.getYSpeed());
			increaseSpeed();
			leftPaddle.setSpeed(leftPaddle.getSpeed() + 1);
		}else if (!(ball.getY() <= getHeight() + 50)) {
			System.out.println("hi");
			ball.draw(graphToBack, Color.WHITE);
			ball.setxPos(350);
			ball.setyPos(230);
			ball.setXSpeed(((int) (Math.random() * 2) + 1)*-1);
			ball.setYSpeed(((int) (Math.random() * 2) + 1));
			leftPaddle.setSpeed(3);

		
			
		}
		// see if the paddles need to be moved
		if (keys[0] == true) {
			// move left paddle up and draw it on the window
			leftPaddle.moveLeftAndDraw(graphToBack);

		}
		if (keys[1] == true) {
			// move left paddle down and draw it on the window
			leftPaddle.moveRightAndDraw(graphToBack);

		}

		twoDGraph.drawImage(back, null, 0, 0);
	}

	public void keyPressed(KeyEvent e) {
		switch (toUpperCase(e.getKeyChar())) {
		case 'A':
			keys[0] = true;
			break;
		case 'D':
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
		case 'A':
			keys[0] = false;
			break;
		case 'D':
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

	public void run() {
		try {
			while (true) {
				Thread.currentThread().sleep(8);
				repaint();
			}
		} catch (Exception e) {
		}
	}
}