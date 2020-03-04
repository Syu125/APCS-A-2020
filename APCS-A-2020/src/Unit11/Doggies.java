//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
package Unit11;

import java.util.Arrays;

public class Doggies
{
	private Dog[] pups;

	public Doggies(int size)
	{
		//point pups at a new array of Dog
		pups = new Dog[size];
		
	}
	
	public void set(int spot, int age, String name)
	{
		//put a new Dog in the array at spot 
		//make sure spot is in bounds	
		pups[spot] = new Dog (age, name);
	}

	public String getNameOfOldest()
	{
		int oldest = pups[0].getAge();
		String old = pups[0].getName();
		for (int i = 1; i < pups.length; i++) {
			if(pups[i].getAge() > oldest) {
				oldest = pups[i].getAge();
				old = pups[i].getName();
			}
		}
		return old;
	}

	public String getNameOfYoungest()
	{
		int youngest = pups[0].getAge();
		String young = pups[0].getName();
		for (int i = 1; i < pups.length; i++) {
			if(pups[i].getAge() < youngest) {
				youngest = pups[i].getAge();
				young = pups[i].getName();
			}
		}
		return young;	}

	public String toString()
	{
		return ""+Arrays.toString(pups);
	}
}