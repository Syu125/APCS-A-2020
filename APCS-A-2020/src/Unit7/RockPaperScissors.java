package Unit7;
//(c) A+ Computer Science
// www.apluscompsci.com
//Name -  

import java.util.Scanner;
import static java.lang.System.*;

public class RockPaperScissors
{
	private String playChoice;
	private String compChoice;

	public RockPaperScissors()
	{
		playChoice = "R";
		compChoice = "R";
	}

	public RockPaperScissors(String player)
	{
		playChoice = player;
		int num = (int)(Math.random()*3);
		switch(num) {
		case 0:
			compChoice = "R";
			break;
		case 1:
			compChoice = "P";
			break;
		case 2:
			compChoice = "S";
			break;
		}
	}

	public void setPlayers(String player)
	{
		
	}

	public String determineWinner()
	{

		
		if(compChoice.equals("R")) {
			if(playChoice.equals("R")) {
				return "!Draw Game!";
			}
			else if(playChoice.equals("P")) {
				return "Player wins <<Paper Breaks Rock>>!";
			}
			else {
				return "Computer wins <<Rock Breaks Scissors>>!";
			}
		}else if(compChoice.equals("P")) {
			if(playChoice.equals("R")) {
				return "Computer wins <<Paper Breaks Rock>>!";
			}
			else if(playChoice.equals("P")) {
				return "!Draw Game!";
			}
			else {
				return "Player wins <<Scissors Breaks Paper>>!";
			}
			
		}else {
			if(playChoice.equals("R")) {
				return "Player wins <<Rock Breaks Scissors>>!";
			}
			else if(playChoice.equals("P")) {
				return "Computer wins <<Scissors Breaks Paper>>!";
			}
			else {
				return "Draw Game!";
			}

		}
	}

	public String toString()
	{
		String output="player had " + playChoice + "\ncomputer had " + compChoice;
		return output;
	}
}