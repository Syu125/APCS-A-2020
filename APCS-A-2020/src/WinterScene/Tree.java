package WinterScene;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Tree extends AbstractShape
{
   public Tree(int x, int y, int w, int h )
   {
		super(x, y, w, h, Color.WHITE, 0, 0);
   }

   public void draw(Graphics window)
   {
	   
	   int center = getXPos() + getWidth()/2;
	   int base = getWidth();
	   int height = getHeight();
	   int [] x =  {getXPos(),  center,  getXPos() + getWidth()};
	   int [] y = {getYPos(),height, getYPos()};
	   window.setColor(Color.lightGray);
	   window.fillRect(center-15, 490, 30, 20);
	   window.setColor(Color.GREEN);
	   window.fillPolygon(x,y,3);
	   for(int i  = 0; i < 3;  i++) {
		   x[0] += getWidth()/(10-i);
		   x[2] -= getWidth()/(10-i);
		   y[0] -= y[0]/7;
		   y[2] -= y[2]/7;
		   window.fillPolygon(x,y,3);
	   }
	   
	   
	   }

   public void moveAndDraw(Graphics window)
   {
      draw(window);   
   }
}