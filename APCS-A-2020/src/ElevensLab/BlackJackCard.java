package ElevensLab;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

public class BlackJackCard extends Card
{
  	//constructors
  	public BlackJackCard( String s, int f)
  	{
  		super( );
  	}

  	//accessors
	public int getValue()
	{
		if( getValue() == 1 )
			return 11;
		if( getValue() >= 10 )
			return 10;
		return getValue();
	}

  	//toString
  	public String toString()
  	{
  		return super.toString() + " " + getValue();
  	}
 }