package Unit13;
//(c) A+ Computer Science

//www.apluscompsci.com
//Name -

import java.util.*;
import java.io.*;

public class WordSearch {
	private String[][] m;

	public WordSearch(int size, String str) {
		int count = 0;
		m = new String[8][str.length() / 8];
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				m[i][j] = "";
				m[i][j] += str.charAt(count);
				count++;
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}

	}

	public boolean isFound(String word) {
		int row = m.length;
		int column = m[0].length;
		if (checkRight(word, row, column) || checkLeft(word, row, column) || checkUp(word, row, column)
				|| checkDown(word, row, column) || checkDiagUpRight(word, row, column)
				|| checkDiagUpLeft(word, row, column) || checkDiagDownRight(word, row, column)
				|| checkDiagDownLeft(word, row, column))
			return true;
		return false;
	}

	public boolean checkRight(String w, int r, int c) {
		for (int i = 0; i < r; i++) {
			String word = "";
			for (int j = 0; j < c; j++) {
				word += m[i][j];
			}
			if (word.contains(w))
				return true;
		}
		return false;
	}

	public boolean checkLeft(String w, int r, int c) {
		for (int i = 0; i < r; i++) {
			String word = "";
			for (int j = c - 1; j >= 0; j--) {
				word += m[i][j];
			}
			if (word.contains(w))
				return true;
		}
		return false;
	}

	public boolean checkUp(String w, int r, int c) {
		for (int i = 0; i < c; i++) {
			String word = "";
			for (int j = r - 1; j >= 0; j--) {
				word += m[j][i];
			}
			if (word.contains(w))
				return true;
		}
		return false;
	}

	public boolean checkDown(String w, int r, int c) {

		for (int i = 0; i < c; i++) {
			String word = "";
			for (int j = 0; j < r; j++) {
				word += m[j][i];
			}
			if (word.contains(w))
				return true;
		}
		return false;
	}

	public boolean checkDiagUpRight(String w, int r, int c) {
		for (int i = 0; i < r; i++) {
			String word = "";
			int count = i;
			for (int j = 0; j < i + 1; j++) {
				word += m[count][j];
				count--;
			}
			if (word.contains(w))
				return true;
		}
		int colcount = 0;
		int store = colcount;
		for (int i = r - 1; i >= 0; i--) {
			colcount = store;
			String word = "";
			int count = r - 1;
			for (int j = r - i - 1; j < c; j++) {
				word += m[count][colcount];
				colcount++;
				count--;
			}
			store++;

			if (word.contains(w))
				return true;
		}
		return false;
	}

	public boolean checkDiagUpLeft(String w, int r, int c) {
		for (int i = 0; i < r; i++) {
			int check = c-1;
			String word = "";
			int count = i;
			for (int j = i; j >= 0; j--) {
				word += m[count][check];
				count--;
				check--;
			}
			if (word.contains(w))
				return true;
		}
		int colcount = 7;
		int store = colcount;
		for (int i = r - 1; i >= 0; i--) {
			colcount = store;
			String word = "";
			int count = r - 1;
			for (int j = r - i - 1; j < c; j++) {
				word += m[count][colcount];
				colcount--;
				count--;
			}
			store--;
			if (word.contains(w))
				return true;
		}
		return false;
	}

	public boolean checkDiagDownLeft(String w, int r, int c) {
			for (int i = 0; i < r; i++) {
				int check = c-1;
				String word = "";
				int count = r-i-1;
				for (int j = i; j >= 0; j--) {
					word += m[count][check]; 
					count++;
					check--;
				}
				if (word.contains(w))
					return true;
			}
			for (int i = 0; i < r; i++) {
				String word = "";
				int count = 0;
				for (int j = r-1-i; j >= 0; j--) {
					word += m[count][j];
					count++;
				}
				if (word.contains(w))
					return true;
			}
			return false;
	}

	public boolean checkDiagDownRight(String w, int r, int c) {
		for (int i = 0; i < r; i++) {
			String word = "";
			int count = r-i-1;
			for (int j = 0; j < i + 1; j++) {
				word += m[count][j];
				count++;
			}
			if (word.contains(w))
				return true;
		}
		for (int i = 0; i < r; i++) {
			int check = r-1-i;
			String word = "";
			int count = 0;
			for (int j = 0; j < i+1; j++) {
				word += m[count][check];
				count++;
				check++;
			}
			if (word.contains(w))
				return true;
		}
		return false;
		
	}

	public String toString() {
		return "";
	}
}
