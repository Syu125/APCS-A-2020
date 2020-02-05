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

public class DistanceRunner
{
	public static void main( String[] args )
	{
		Scanner s = new Scanner(in);
		int x1 = 0;
		int x2 = 0;
		int y1 = 0;
		int y2 = 0;
		
		//test first sample data: (1,1), (2,1)
		out.print("Enter x1:: ");
		x1 = s.nextInt();
		out.print("Enter y1 :: ");
		x2 = s.nextInt();
		out.print("Enter x2 :: ");
		y1 = s.nextInt();
		out.print("Enter y2 :: ");
		y2 = s.nextInt();
		
		Distance distanceInputTest = new Distance(x1, y1, x2, y2);
		distanceInputTest.print();
		System.out.println("\n");
		
		
		//add test cases	
		Distance d2 = new Distance(1,1,-2,2);
		Distance d3 = new Distance(1,1,0,0);

		System.out.println(d2);
		System.out.println(d3);
	}
}