package Unit11;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*; 

class Rational implements Comparable<Rational>
{
	//add two instance variables
	private int num1;
	private int den1;
	//write two constructors

	public Rational() {
		num1 = 1;
		den1 = 1;
	}
	public Rational(int num, int den) {
		num1 = num;
		den1 = den;
	}
	
	//write a setRational method
	public void setRational(int num, int den) {
		num1 = num; 
		den1 = den;
	}

	//write  a set method for numerator and denominator
	public void setNum(int num) {
		num1 = num;
	}
	public void setDen(int den) {
		den1 = den;
	}
	
	
	public void add(Rational  other)
	{
		/*num1/den1 + num2/den2 
		new numerator = (num1 * den2 + num2 * den1)
		new denominator = (den1 * den2)
		*/
		int tempNum = den1 * other.getNum() ;
		num1 *= other.getDen();
		other.setNum(tempNum);
		
		den1 *= other.getDen();
		
		num1 += other.getNum();
		

		reduce();
	}

	private void reduce()
	{
		for(int i = num1; i > 0; i--) {
			if(den1%i == 0 && num1%i == 0) {
				num1 /=i;
				den1 /= i;
			}
		}



	}

	private int gcd(int numOne, int numTwo)
	{

		int factor = 0;
		for(int i = 0; i < numOne; i++) {
			if(numOne%i == 0 && numTwo%i == 0) {
				factor = i;
			}
		}

		return factor;
	}

	public Object clone ()
	{
		Rational clone = this;
		return clone;
	}


	//ACCESSORS

	//write get methods for numerator and denominator
	public int getNum() {
		return num1;
	}
	public int getDen() {
		return den1;
	}
	
	public boolean equals( Object obj)
	{
		Rational other = (Rational)obj;
		this.reduce();
		other.reduce();
		if(num1 == other.getNum() && den1 == other.getDen())
			return true;
		return false;
	}

	public int compareTo(Rational other)
	{
		if((double) num1/den1 > (double) other.getNum()/other.getDen())
			return 1;
		else if((double) num1/den1 < (double) other.getNum()/other.getDen())
			return -1;
		return 0;
	}



	
	//write  toString() method
	public String toString() {
		return num1 + "/" + den1;
		
	}
	
}