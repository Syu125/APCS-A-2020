package Unit7;
//(c) A+ Computer Science
// www.apluscompsci.com
//Name -  

import static java.lang.System.*;

public class BiggestDouble
{
	private double one,two,three,four;

	public BiggestDouble()
	{
		this(0,0,0,0);
	}

	public BiggestDouble(double a, double b, double c, double d)
	{
		one = a;
		two = b;
		three = c;
		four = d;
	}

	public void setDoubles(double a, double b, double c, double d)
	{
		one = a;
		two = b;
		three = c;
		four = d;
	}

	public double getBiggest()
	{
		double temp = one;
		if(two > temp) {
			temp = two;
		}
		if(three > temp) {
			temp = three;
		}
		if(four > temp) {
			temp = four;
		}
		return temp;
	}

	public String toString()
	{
	   return one + " " + two + " " + three + " " + four + " "
	   		+ "" + "\n biggest = " + getBiggest() ;
	}

}