package Q3LabAssess;

import java.util.ArrayList;
import java.util.Scanner;

public class Information {
	private String gender;
	private int age;
	private boolean testPos;
	private ArrayList<Double> temp; 
	
	
	public Information() {
		gender = "male";
		age = 1;
		testPos = false;
		temp = new ArrayList<Double>();
	}
	public Information(String g, int a, boolean t, double [] temp) {
		this.temp = new ArrayList<Double>();
		gender = g;
		age = a;
		testPos = t;
		for (double i : temp) {
			this.temp.add(i);
		}
	}
	public void changeStatus(boolean  b) {
		testPos = b;
	}
	public double getHighestTemp() {
		double t = temp.get(0);
		for (int i = 0; i < temp.size(); i++) {
			if(temp.get(i) > t) {
				t = temp.get(i);
			}
		}
		return t;
	}
	
	public double getAverageTemp() {
		double sum = 0;
		for (Double d : temp) {
			sum += d;
		}
		return sum/temp.size();
	}
	public double getLowestTemp() {
		double t = temp.get(0);
		for (int i = 0; i < temp.size(); i++) {
			if(temp.get(i) < t) {
				t = temp.get(i);
			}
		}
		return t;
	}
	public int feverDays() {
		int count = 0;
		for (Double d : temp) {
			if(d > 100.4) 
				count++;
		}
		return count;
			
		
	}
	public String getGender() {
		return gender;
	}
	public int getAge() {
		return age;
	}
	public boolean getTestPos() {
		return testPos;
	}
	public boolean testPos() {
		return testPos;
	}
	public ArrayList <Double> getTempList(){
		return temp;
	}
}
