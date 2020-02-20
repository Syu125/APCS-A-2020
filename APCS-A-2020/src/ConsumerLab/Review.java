package ConsumerLab;

import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;
import java.io.File;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;
import java.io.*;

/**
 * Class that contains helper methods for the Review Lab
 **/
public class Review {

	private static HashMap<String, Double> sentiment = new HashMap<String, Double>();
	private static ArrayList<String> posAdjectives = new ArrayList<String>();
	private static ArrayList<String> negAdjectives = new ArrayList<String>();

	private static final String SPACE = " ";

	static {
		try {
			Scanner input = new Scanner(new File("src/ConsumerLab/cleanSentiment.csv"));
			while (input.hasNextLine()) {
				String[] temp = input.nextLine().split(",");
				sentiment.put(temp[0], Double.parseDouble(temp[1]));
				// System.out.println("added "+ temp[0]+", "+temp[1]);
			}
			input.close();
		} catch (Exception e) {
			System.out.println("Error reading or parsing cleanSentiment.csv");
		}

		// read in the positive adjectives in postiveAdjectives.txt
		try {
			Scanner input = new Scanner(new File("src/ConsumerLab/positiveAdjectives.txt"));
			while (input.hasNextLine()) {
				String temp = input.nextLine().trim();
				//System.out.println(temp);
				posAdjectives.add(temp);
			}
			input.close();
		} catch (Exception e) {
			System.out.println("Error reading or parsing postitiveAdjectives.txt\n" + e);
		}

		// read in the negative adjectives in negativeAdjectives.txt
		try {
			Scanner input = new Scanner(new File("src/ConsumerLab/negativeAdjectives.txt"));
			while (input.hasNextLine()) {
				negAdjectives.add(input.nextLine().trim());
			}
			input.close();
		} catch (Exception e) {
			System.out.println("Error reading or parsing negativeAdjectives.txt");
		}
	}

	// fake review: writes a fake positive review based on another file
	public static String fakeReview(String fileName) {
		String review = textToString(fileName);
		String finalReview = "";
		String word = "";
		int index = 0;

		while (review.length() > 0) {
			index = review.indexOf(" ");
			if (index != -1) {

				word = review.substring(0, index);
			} else {
				finalReview += review;
				if (review.charAt(review.length() - 1) == '.') {
					finalReview = finalReview.substring(0, finalReview.length() - 1);
					finalReview += "!";
				}
				break;
			}

			if (word.charAt(0) == '*') {
				word = randomPositiveAdj() + " ";
			}

			finalReview += word + " ";
			review = review.substring(index + 1);
		}
		finalReview = finalReview.replaceAll("dis", "").replaceAll("not ", "");

		return finalReview;

	}

	/**
	 * returns a string containing all of the text in fileName (including
	 * punctuation), with words separated by a single space
	 */
	public static String textToString(String fileName) {
		String temp = "";
		try {
			Scanner input = new Scanner(new File(fileName));

			// add 'words' in the file to the string, separated by a single space
			while (input.hasNext()) {
				temp = temp + input.next() + " ";
			}
			input.close();

		} catch (Exception e) {
			System.out.println("Unable to locate " + fileName);
		}
		// make sure to remove any additional space that may have been added at the end
		// of the string.
		return temp.trim();
	}

	/**
	 * @returns the sentiment value of word as a number between -1 (very negative)
	 *          to 1 (very positive sentiment)
	 */
	public static double sentimentVal(String word) {
		try {
			return sentiment.get(word.toLowerCase());
		} catch (Exception e) {
			return 0;
		}
	}

	/**
	 * Returns the ending punctuation of a string, or the empty string if there is
	 * none
	 */
	public static String getPunctuation(String word) {
		String punc = "";
		for (int i = word.length() - 1; i >= 0; i--) {
			if (!Character.isLetterOrDigit(word.charAt(i))) {
				punc = punc + word.charAt(i);
			} else {
				return punc;
			}
		}
		return punc;
	}

	/**
	 * Randomly picks a positive adjective from the positiveAdjectives.txt file and
	 * returns it.
	 */
	public static String randomPositiveAdj() {
		int index = (int) (Math.random() * posAdjectives.size());
		return posAdjectives.get(index);
	}

	/**
	 * Randomly picks a negative adjective from the negativeAdjectives.txt file and
	 * returns it.
	 */
	public static String randomNegativeAdj() {
		int index = (int) (Math.random() * negAdjectives.size());
		return negAdjectives.get(index);

	}

	/**
	 * Randomly picks a positive or negative adjective and returns it.
	 */
	public static String randomAdjective() {
		boolean positive = Math.random() < .5;
		if (positive) {
			return randomPositiveAdj();
		} else {
			return randomNegativeAdj();
		}
	}

	/**
	 * Activity 2: totalSentiment() Write the code to total up the sentimentVals of
	 * each word in a review.
	 */
	public static double totalSentiment(String filename) {
		// read in the file contents into a string using the textToString method with
		// the filename
		String text = textToString(filename);
		String tempWord = "";
		// set up a sentimentTotal variable
		double sentimentTotal = 0;

		// loop through the file contents
		while (text.length() >= 0) {
			// find each word
			if (text.indexOf(" ") != -1) {
				tempWord = text.substring(0, text.indexOf(" "));

				// add in its sentimentVal
				sentimentTotal += sentimentVal(tempWord);
			} else {
				tempWord = text.substring(0, text.length());
				sentimentTotal += sentimentVal(tempWord);
				break;
			}
			// set the file contents to start after this word
			text = text.substring(text.indexOf(" ") + 1);
		}
		return sentimentTotal;
	}

	/**
	 * Activity 2 starRating method Write the starRating method here which returns
	 * the number of stars for the review based on its totalSentiment.
	 */
	public static int starRating(String filename) {
		// call the totalSentiment method with the fileName
		double val = totalSentiment(filename);

		// determine number of stars between 0 and 4 based on totalSentiment value
		int stars = 0;
		// write if statements here=
		if (val >= 15)
			stars = 4;
		else if (val >= 10)
			stars = 3;
		else if (val >= 5)
			stars = 2;
		else if (val >= 0)
			stars = 1;
		else
			stars = 0;

		// return number of stars
		return stars;
	}
}