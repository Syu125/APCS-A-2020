package Q3LabAssess;

import java.util.Scanner;


public class Patient {
	private String name;
	private Information info;
	
	public Patient() {
		name =  "";
		info =  new Information();
	}
	public Patient(String n, String g, int a, boolean t, double [] temp) {
		name = n;
		info = new Information(g, a, t, temp);
	}
	
	public String getName() {
		return name;
	}
	public void changeStatus(boolean b){
		info.changeStatus(b);
	}
	
	public boolean testPos() {
		return info.testPos();
	}
	public double highTemp() {
		return info.getHighestTemp();
	}
	public double lowTemp() {
		return info.getLowestTemp();
	}
	public int feverDays() {
		return info.feverDays();
	}
	public Information getInfo() {
		return info;
	}
	public String tempAna() {
		return name + "\n	Low: " + info.getLowestTemp()
		+ "\n	High: " + info.getHighestTemp()
		+ "\n	Average: " + String.format("%.1f", info.getAverageTemp());
	}
	public String toString() {
		String tString =  "";
		for (double d : info.getTempList()) {
			tString += d  + " ";
		}
		return name + "\n	Gender: " + info.getGender()
				+ "\n	Age: " + info.getAge()
				+ "\n	TestPos: " + info.getTestPos()
				+ "\n	Week Temperature Records: " + tString;
	}
}
