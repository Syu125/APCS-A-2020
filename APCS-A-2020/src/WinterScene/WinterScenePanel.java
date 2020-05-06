package WinterScene;
//(c) A+ Computer Science

//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

public class WinterScenePanel extends JPanel implements Runnable {
	private List<AbstractShape> shapes;
	private AbstractShape sMan;
	private AbstractShape cTree;
	private List<AbstractShape> gifts;
	public WinterScenePanel()
	{
		setVisible(true);
		//refer shapes to a new ArrayList of AbstractShape
		shapes = new ArrayList<AbstractShape>();
		
		//populate the list with 50 unique snowflakes
		for(int i = 0; i < 50; i++) {
			int side = (int)(Math.random()*20+10);
			shapes.add(new FancySnowFlake((int)(Math.random()*720+15),15, side, side));
			shapes.get(i).setYSpeed((int)(Math.random()*5+1));
		}
		
		gifts =  new ArrayList<AbstractShape>();
		
		for(int i  = 0; i < 5; i++) {
			gifts.add(new Present((int)(Math.random() *100 + 600),550,(int)(Math.random()*50+10), (int)(Math.random()*30+10)));
			gifts.get(i).setYPos(510-gifts.get(i).getHeight());
			gifts.get(i).setColor(new Color((int)(Math.random()*200+56), (int)(Math.random()*200+56), (int)(Math.random()*200+56)));
		}
		//instantiate a snowman
		sMan = new SnowMan(150,500, 100,100);
		
		
		cTree = new Tree(600,500,150,300);
		
		new Thread(this).start();
	}

	public void update(Graphics window) {
		paint(window);
	}

	public void paint(Graphics window) {
		window.setColor(Color.BLUE);
		window.fillRect(0, 0, getWidth(), getHeight());
		window.setColor(Color.WHITE);
		window.drawRect(20, 20, getWidth() - 40, getHeight() - 40);
		window.setFont(new Font("TAHOMA", Font.BOLD, 18));
		window.drawString("MAKE A WINTER SCENE!", 40, 40);

		window.setColor(Color.WHITE);
		window.fillRect(20,510,getWidth()-40,30);
		// make the snowman appear
		sMan.draw(window);
		cTree.draw(window);
		// make the snowflakes appear and move down the screen
		for (AbstractShape abstractShape : shapes) {
			abstractShape.moveAndDraw(window);
		}
		for (AbstractShape abstractShape : gifts) {
			abstractShape.moveAndDraw(window);
		}
		// check to see if any of the snowflakes need to be reset to the top of the
		// screen
		
		
	}

	public void run() {
		try {
			while (true) {
				Thread.currentThread().sleep(35);
				repaint();
			}
		} catch (Exception e) {
		}
	}
}