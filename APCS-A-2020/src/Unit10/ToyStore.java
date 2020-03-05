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

	public ToyStore()
	{
		toyList = new ArrayList<Toy>();
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
  		t.setCount(t.getCount()-1);
  		
  		return t;
  	}
  
  	public String getMostFrequentToy()
  	{
  		
  		return "";
  	}  
  
  	public void sortToysByCount()
  	{
  	}  
  	  
	public String toString()
	{
	   return "";
	}
}