package Unit13;
//(c) A+ Computer Science

//www.apluscompsci.com
//Name -

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class NumberShifterRunner {
	public static void main(String args[]) throws IOException {
		int[] list = NumberShifter.makeLucky7Array(20);
		for (int j = 0; j < 5; j++) {
			System.out.println("\n");
			for (int i : list) {

				System.out.print(i + ", ");
			}
			NumberShifter.shiftEm(list);
			System.out.println();
			for (int i : list) {
				System.out.print(i + ", ");
			}
			list = NumberShifter.makeLucky7Array(20);
		}

	}
}
