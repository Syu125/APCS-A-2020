//(c) A+ Computer Science
//www.apluscompsci.com

//Name - Sophia Yu	
//Date - 2/4/20
//Class - APCS-A Period 2
//Lab  - Miles Per Hour
package Unit3;
import java.util.Scanner; 
import static java.lang.System.*;
import static java.lang.Math.*;

public class MPHRunner
{
	public static void main( String[] args )
	{
		Scanner keyboard = new Scanner(in);
		
		/*out.print("Enter the distance :: ");
		int dist = keyboard.nextInt();

		out.print("Enter the hours :: ");
		int hrs = keyboard.nextInt();

		out.print("Enter the minutes :: ");
		int mins = keyboard.nextInt();

		MilesPerHour test = new MilesPerHour(dist, hrs, mins);
		test.calcMPH();
		test.print();*/
		
		//add more test cases
		MilesPerHour test1 = new MilesPerHour(45,0,32);
		MilesPerHour test2 = new MilesPerHour(96,1,43);
		MilesPerHour test3 = new MilesPerHour(100,2,25);
		MilesPerHour test4 = new MilesPerHour(50,2,25);
		System.out.println(test1);
		System.out.println(test2);
		System.out.println(test3);
		System.out.println(test4);
		
	}
}