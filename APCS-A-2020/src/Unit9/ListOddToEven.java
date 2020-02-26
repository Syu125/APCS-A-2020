package Unit9;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

import java.util.ArrayList;
import java.util.List;

public class ListOddToEven
{
	public static int go( List<Integer> ray )
	{
		int odd = 0;
		int even = 0;
		boolean found = false;
		for (int i = 0; i < ray.size(); i++) {
			if(ray.get(i)%2 == 1) {
				odd = i;
				found = true;
				break;
			}
		}
		if(!found)
			return -1;
		
		found = false;
		for (int i = ray.size()-1; i > odd; i--) {
			if(ray.get(i)%2 == 0) {
				even = i;
				found = true;
				break;
			}
		}
		if(!found)
			return -1;
		
		return even-odd;
	}
}