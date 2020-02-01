//(c) A+ Computer Science
//www.apluscompsci.com

//Name - Sophia Yu
//Date - 1/30/20
//Class - APCS-A Period 2
//Lab  - AsciiBox
package Unit0;
public class AsciiBox
{
	public static void main(String[] args)
	{
		AsciiBox a = new AsciiBox();
		System.out.println("Sophia \t  1/30/20 \n\n" );
		boolean plus = true;
		for (int i = 0; i < 7; i++) {
			if(plus) {
				a.addPlus();
				plus = false;
			}else {
				a.addA();
				plus = true;
			}
		}
	}
	void addPlus() {
		for (int i = 0; i < 3; i++) {
			System.out.println("+++++++++++++++++++++++++ " );
	}
		}
		
	void addA() {
		for (int i = 0; i < 2; i++) {
			System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAA " );
		}
		
	}
}