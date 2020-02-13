package Unit6;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class Perfect
{
   private int number;
   private int sum;

	//add constructors

   public Perfect() {
	   number = 0;
	   sum = 0;
   }
   public Perfect(int number) {
	   this.number = number;
	   sum = 0;
   }
   
	//add a set method
   public void setNumber(int number) {
	   this.number = number;
   }
	public boolean isPerfect()
	{
		for (int i = 1; i < number; i++) {
			if(number%i == 0) {
				sum+=i;
			}
		}
		if(sum == number)
			return true;
		return false;
	}

	//add a toString	
	public String toString() {
		if(isPerfect())
			return number + " is perfect" + "\n";
		else
			return number + " is not perfect" + "\n";
	}
}