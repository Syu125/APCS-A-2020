package Unit10;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import static java.lang.System.*;

public class ToyStoreRunner
{
	public static void main( String args[] )
	{
		//test cases
	/*
	 * sorry bat sorry sorry sorry train train teddy teddy ball ball
	 */
		ArrayList <Toy> toys;
		ToyStore tStore = new ToyStore();
		
		Toy [] t = {new Toy("sorry"), new Toy("bat"), new Toy("sorry"), new Toy("sorry"), new Toy("sorry"), new Toy("train"),  new Toy("train"), new Toy("teddy"), new Toy("teddy"), new Toy("ball"), new Toy("ball")};
		toys = new ArrayList <Toy>( Arrays.asList(t));
		tStore = new ToyStore(toys);
		System.out.println(tStore.getThatToy("sorry"));
	} 
}