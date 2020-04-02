package Q3LabAssess;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s;
		try {
			s = new Scanner(new File("src/Q3LabAssess/status.dat"));
			String name = s.nextLine();
			int num = Integer.parseInt(s.nextLine());
			Hospital h = new Hospital(name, num);
			System.out.print(name + ": " + num + " patients\n");
			for (int i = 0; i < num; i++) {
				String pName =  s.nextLine();
				String [] info = s.nextLine().split(" ");
				String [] temp  = s.nextLine().split(" ");
				double [] tempAlt = new double [7];
				for (int j = 0; j < tempAlt.length; j++) {
					tempAlt[j] = Double.parseDouble(temp[j]);
				}
				h.addPatient(new Patient(pName, info[0], Integer.parseInt(info[1]), info[2].equals("pos"), tempAlt) );
				
				System.out.print("\n"+pName);
				System.out.println("\n	Gender: " + info[0]
						+ "\n	Age: " + Integer.parseInt(info[1])
						+ "\n	testPos: " + info[2]);
				System.out.print("	Week Temperature Records: ");
				Arrays.stream(tempAlt).forEach(t -> System.out.print(t + " "));
			}
			
			System.out.println("\n\n\n\nPatients by first name");
			h.sort();
			ArrayList <Patient> list = h.getList();
			for (Patient patient : list) {
				System.out.println(patient.toString());
			}
			System.out.println("\n\n\nPatients who tested positive: ");
			for (int j = 0; j < h.getNumPatients(); j++) {
				if(h.getPatient(j).testPos()) {
					System.out.println(h.getPatient(j).toString());
				}
			}
			
			System.out.println("\n\n\nAnalysis of temperature of each patient over a week: ");
			for (int i = 0; i < h.getNumPatients(); i++) {
				System.out.println(h.getPatient(i).tempAna());
			}
			
			System.out.println("\n\n\nList based on average temp: ");
			h.listTemp();
			
			System.out.println("\n\n\nAnalysis for Alva Anderson");
			System.out.println(h.getPatient("Alva Anderson").toString());
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
