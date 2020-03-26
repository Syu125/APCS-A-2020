package Unit13;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.ArrayList;
import java.util.Arrays; 
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class NumberSorter
{
	//instance variables and other methods not shown

	private static int getNumDigits(int number)
	{
		int count = 0;
		while(number > 0) {
			number/=10;
			count ++;
		}
		return count;
	}

	public static int[] getSortedDigitArray(int number)
	{
		int[] sorted = new int [getNumDigits(number)];
		int count = 0;
		ArrayList <Integer> list = new ArrayList <Integer>();
		for (int i = 0; i < sorted.length; i++) {
			list.add(number%10);
			number /= 10;
		}
		while(list.size() > 0) {
			int i = list.get(0);
			for (Integer integer : list) {
				if(i > integer) {
					i = integer;
				}
			}
			sorted[count] = i;
			list.remove(list.indexOf(i));
			count++;
		}
		
		return sorted;
	}
}