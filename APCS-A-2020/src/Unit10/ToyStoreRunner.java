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
		Toy [] t = {new Toy("sorry"), new Toy( "bat"), new Toy("sorry"), new Toy("sorry"), new Toy(" sorry"), new Toy(" train"),  new Toy("train"), new Toy(" teddy"), new Toy(" teddy"), new Toy(" ball"), new Toy(" ball")};
		toys = new ArrayList <Toy>( Arrays.asList(t));
		
		ToyStore26 tStore = new ToyStore26();
		tStore = new ToyStore26(toys);
		System.out.println(tStore.getThatToy("train"));
		
		System.out.println("max: " + tStore.getMostFrequentToy());
		tStore.sortToysByCount();
		System.out.println(tStore);
		System.out.println(myName);
	
	} 
}