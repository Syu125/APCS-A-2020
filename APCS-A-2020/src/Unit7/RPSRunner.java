package Unit7;
//(c) A+ Computer Science
// www.apluscompsci.com
//Name -  

import java.util.Scanner;
import static java.lang.System.*;

public class RPSRunner
{
	public static void main(String args[])
	{
		Scanner keyboard = new Scanner(System.in);
		char response;
		
		//add in a do while loop after you get the basics up and running
		
			while(true) {
				String player = "";
				
				out.print("Rock-Paper-Scissors - pick your weapon[R,P,S]:: ");
				
				//read in the player value
				player = keyboard.next();
			
				RockPaperScissors game = new RockPaperScissors(player);		
				System.out.println(game);
				System.out.println(game.determineWinner() + "\n");
		
				out.print("Do you want to play again? y/n :: ");
				String an = keyboard.next();
				if(an.equals("n")) {
					break;
				}
			}
	}
}



