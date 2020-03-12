package Unit10;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

public class ToyStore
{
	private ArrayList<Toy> toyList;
	private ArrayList <Toy> sortedList;

	public ToyStore()
	{
		toyList = new ArrayList<Toy>();
		sortedList = new ArrayList<Toy>();
		
	}
	public ToyStore(ArrayList <Toy> list) {
		toyList = list;
	}

	public void loadToys( String toys )
	{
		toyList = new ArrayList<Toy>();
		toyList.add(new Toy(toys));
	}
  
  	public Toy getThatToy( String nm )
  	{
  		Toy t = new Toy("");
  		for(Toy toy: toyList) {
  			if(toy.getName().equals(nm)) {
  				t =  toy;
  				toy.setCount(toy.getCount()+1);
  			}
  		}
  		t.setCount(t.getCount());
  		
  		return t;
  	}
  
  	public String getMostFrequentToy()
  	{
  		Toy most = toyList.get(0);
  		for(Toy t: toyList) {
  			if(t.getCount() > most.getCount()){
  				most = t;
  			}
  		}
  		return most.getName();
  	}  
  
  	public void sortToysByCount()
	{
  		for(Toy t: toyList) {
  			if()
  		}
  		/*
		 * sortedList = toyList; for(Toy t: toyList) {
		 * t.setCount(getThatToy(t.getName()).getCount()); } for(Toy t: toyList) { int
		 * count = 1; for(Toy toy: toyList){ if(toy.getName().equals(t.getName())) {
		 * count++; } } if(count > 1) { sortedList.add(t); } } toyList = sortedList;
		 */
  	}  
  	  
	public String toString()
	{
	   return toyList.toString();
	}
}