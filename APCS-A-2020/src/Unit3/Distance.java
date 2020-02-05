//(c) A+ Computer Science 
//www.apluscompsci.com

//Name - Sophia Yu	
//Date - 2/4/20
//Class - APCS-A Period 2
//Lab  - Distance Formula
package Unit3;
import java.util.Scanner; 
import static java.lang.System.*;
import static java.lang.Math.*;

public class Distance
{
	private int xOne,yOne,xTwo,yTwo;
	private double distance;

	public Distance()
	{
		xOne = 0;
		yOne = 0;
		xTwo = 0;
		yTwo = 0;
	}

	public Distance(int x1, int y1, int x2, int y2)
	{
		xOne = x1;
		yOne = y1;
		xTwo = x2;
		yTwo = y2;
		
		calcDistance();
	}

	public void setCoordinates(int x1, int y1, int x2, int y2)
	{
		xOne = x1;
		yOne = y1;
		xTwo = x2;
		yTwo = y2;
	}

	public void calcDistance()
	{
		distance = Math.sqrt(Math.pow(xOne-xTwo, 2)+Math.pow(yOne-yTwo, 2));
	}
	
	public double getDistance()
	{
		return distance;
	}
	
	public void print()
	{
		System.out.println("distance == " + String.format("%.3f", distance));
	}
	
	//complete print or the toString

	public String toString()
	{
		return "Distance from (" + xOne + ", " + yOne + ") to (" + xTwo + ", " + yTwo + ") is " + String.format("%.3f",distance);
	}
}