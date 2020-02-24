package Unit8;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

public class RayOddToEven
{
	public static int go(int[] ray)
	{
		int odd = 0;
		int even = 0;
		boolean found = false;
		for (int i = 0; i < ray.length; i++) {
			if(ray[i]%2 == 1) {
				odd = i;
				found = true;
				break;
			}
		}
		if(!found)
			return -1;
		
		found = false;
		for (int i = odd; i < ray.length; i++) {
			if(ray[i]%2 == 0) {
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