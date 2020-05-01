package BreakOut;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import javax.swing.JFrame;
import java.awt.Component;
import java.awt.Toolkit;
//BREAKOUT
public class TheGame extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public TheGame()
	{
		super("PONG");
		setSize(WIDTH,HEIGHT);

		BreakOut game = new BreakOut();
		
		((Component)game).setFocusable(true);
		getContentPane().add(game);
		
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main( String args[] )
	{
		TheGame run = new TheGame();
	}
	public TheGame(String s) {
		
	}
	public double getScreenWidth() {
		pack();
		return getWidth();
	}
	public double getScreenHeight() {
		return getSize().getHeight();
	}
}