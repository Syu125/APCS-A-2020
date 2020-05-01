package Pong;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import javax.swing.JFrame;
import java.awt.Component;
import java.awt.Toolkit;

public class TheGame extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int WIDTH = 800;
	private static int HEIGHT = 600;
	private static Pong game;
	private boolean first = true;

	public TheGame()
	{
		super("PONG");
		setSize(WIDTH,HEIGHT);

		game = new Pong();
		
		((Component)game).setFocusable(true);
		getContentPane().add(game);
		
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main( String args[] )
	{
		TheGame run = new TheGame();
		run.update();
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
	public void setFrameSize(int w, int h) {
		this.setSize(w,h);
	}
	public void update()
	   {
	   	try
	   	{
	   		while(true)
	   		{
	   		if(first) {
		   		   this.setSize(800,600);
		   		   first = false;
	   		}else {
	   			Thread.currentThread().sleep(8);
	   		   game.changeFrameWidth(this.getWidth());
	   		   game.changeFrameHeight(this.getHeight());
	   		   this.setSize(this.getWidth(),this.getHeight());
	   		   setVisible(true);
	   		}
	   		   
	   		}
	      }catch(Exception e)
	      {
	      }
	  	}	
}