package ConsumerLab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		// test reading from files
		Scanner s;
		try {
			s = new Scanner(new File("src/ConsumerLab/positiveAdjectives.txt"));
			System.out.println("First word from positiveAdjectives.txt: " + s.next());
				
			Scanner s2 = new Scanner(new File("src/ConsumerLab/negativeAdjectives.txt"));
			System.out.println("First word from negativeAdjectives.txt: " + s2.next());
			
			Scanner s3 = new Scanner(new File("src/ConsumerLab/simpleReview.txt"));
			System.out.println("First word from simpleReview.txt: " + s3.next());
			
			Scanner s4 = new Scanner(new File("src/ConsumerLab/26WestReview.txt"));
			System.out.println("First word from 26WestReview.txt: " + s4.next());
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//Checking total sentiment and fake review
		double i = Review.totalSentiment("src/ConsumerLab/26WestReview.txt");
		System.out.println("Fake Review: " + Review.fakeReview("src/ConsumerLab/simpleReview.txt"));
		System.out.println("value of 26WestReview " + (int)i);
		System.out.println("stars for 26WestReview: " + Review.starRating("src/ConsumerLab/26WestReview.txt"));
		
		// read in the positive adjectives in postiveAdjectives.txt
		try {
			Scanner input = new Scanner(new File("src/ConsumerLab/positiveAdjectives.txt"));
			while (input.hasNextLine()) {
				String temp = input.nextLine().trim();
				System.out.println(temp);

			}
			input.close();
		} catch (Exception e) {
			System.out.println("Error reading or parsing postitiveAdjectives.txt\n" + e);
		}
	}
}