package WinterScene;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class SnowMan extends AbstractShape
{
   public SnowMan(int x, int y, int w, int h )
   {
		super(x, y, w, h, Color.WHITE, 0, 0);
   }

   public void draw(Graphics window)
   {
      //add code here to make a snowman 
	   window.setColor(getColor());
	   window.fillOval(getXPos(), 555-getHeight(), getWidth(), (int)(getHeight()*0.7));
	   window.fillOval(getXPos()+(int)(getWidth()*0.165), 555-(int)(getHeight()*1.3), (int)(getWidth()*0.7), (int)(getHeight()*0.5));
	   window.fillOval(getXPos()+(int)(getWidth()*0.27), 555-(int)(getHeight()*1.6), (int)(getWidth()*0.5), (int)(getHeight()*0.4));
	   window.setColor(Color.BLACK);
	   window.fillOval(getXPos()+(int)(getWidth()*0.165), 555-(int)(getHeight()*1.65), (int)(getWidth()*0.7), (int)(getHeight()*0.15));
	   window.fillRect(getXPos()+(int)(getWidth()*0.3), 555-(int)(getHeight()*1.85), (int)(getWidth()*0.45), (int)(getHeight()*0.25));
   }

   public void moveAndDraw(Graphics window)
   {
      draw(window);   
   }
}