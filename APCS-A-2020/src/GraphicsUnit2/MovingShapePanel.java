package GraphicsUnit2;
//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import java.awt.Font; 
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MovingShapePanel extends JPanel implements Runnable
{
	private Shape sh;
	private Shape sh2;
	private Shape sh3;
	private ArrayList <Shape> shapes;

	public MovingShapePanel()
	{
		setBackground(Color.WHITE);
		setVisible(true);

		//refer sh to a new Shape
		sh = new Shape(100,100,100,100,Color.blue, 1,2);
		sh2 = new Shape(200,350,200,530,Color.pink, 30,10);
		sh3 = new Shape(20,100,100,100,Color.cyan, 2,6);
		
		shapes = new ArrayList <Shape>();
		shapes.add(sh);
		shapes.add(sh2);
		shapes.add(sh3);
		
		new Thread(this).start();
	}

	public void update(Graphics window)
	{
		paint(window);
	}

	public void paint(Graphics window)
	{
		window.setColor(Color.WHITE);
		window.fillRect(0,0,getWidth(), getHeight());
		window.setColor(Color.BLUE);
		window.drawRect(20,20,getWidth()-40,getHeight()-40);
		window.setFont(new Font("TAHOMA",Font.BOLD,18));
		window.drawString("CREATE YOUR OWN SHAPE!",40,40);

		//tell sh to move and draw
		//sh.moveAndDraw(window);
		for(Shape s : shapes) {
			s.moveAndDraw(window);
			//this code handles the left and right walls
			if(!(s.getX()>=10 && s.getX()<=500))
			{
				System.out.println("hi");
				s.setXSpeed(-s.getXSpeed());
			}
			

			//add code to handle the top and bottom walls
			if(!(s.getY()>=10 && s.getY()<=440))
			{
				s.setYSpeed(-s.getYSpeed());
			}
		}
		
	}

   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(10);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}
}