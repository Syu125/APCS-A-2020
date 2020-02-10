package Unit4;
//(c) A+ Computer Science
//www.apluscompsci.com

//Name - 
//Date -
//Class -
//Lab  -

import static java.lang.System.*;
import java.util.Scanner;
import Unit4.Discount;

public class DiscountRunner
{
	public static void main( String args[] )
	{
		//user input
		Scanner keyboard = new Scanner(System.in);
		
		out.print("Enter the original bill amount :: ");
		double amt = keyboard.nextDouble();
		System.out.println("Bill after discount :: " + String.format("%.2f", Discount.getDiscountedBill(amt))+ "\n");

		//more test cases
		/*500
		2500
		4000
		333.33
		95874.2154*/
		System.out.println("More test cases...\n");
		System.out.println("Bill after discount of " + 500 + " :: " + String.format("%.2f", Discount.getDiscountedBill(500)));
		System.out.println("Bill after discount of " + 2500 + " :: " + String.format("%.2f", Discount.getDiscountedBill(2500)));
		System.out.println("Bill after discount of " + 4000 + " :: " + String.format("%.2f", Discount.getDiscountedBill(4000)));
		System.out.println("Bill after discount of " + 333.333 + " :: " + String.format("%.2f", Discount.getDiscountedBill(333.333)));
		System.out.println("Bill after discount of " + 95874.2154 + " :: " + String.format("%.2f", Discount.getDiscountedBill(95874.2154)));

	}
}