package Unit9;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

import java.util.List;
import java.util.ArrayList;

public class ListDown
{
	//go() will return true if all numbers in numArray
	//are in decreasing order [31,12,6,2,1]
	public static boolean go(List<Integer> numArray)
	{
		int temp = numArray.get(0);
		if(numArray.size() > 1) {
			for(int i = 1; i < numArray.size(); i ++) {
			if(temp > numArray.get(i)) {
				temp = numArray.get(i);
			}else {
				return false;
			}
		}
		return true;
		}
		return false;
	}	
}