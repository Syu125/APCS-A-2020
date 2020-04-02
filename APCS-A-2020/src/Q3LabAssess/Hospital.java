package Q3LabAssess;

import java.util.ArrayList;
import java.util.Scanner;

public class Hospital {
	private String name;
	private int numPatients;
	private ArrayList<Patient> patientList;

	public Hospital() {
		name = "Scripps";
		numPatients = 0;
		patientList = new ArrayList<Patient>();
	}

	public Hospital(String n, int np) {
		name = n;
		numPatients = np;
		patientList = new ArrayList<Patient>();
	}

	public void addPatient(Patient p) {
		patientList.add(p);
	}

	public void addPatient(Patient p, int spot) {
		patientList.add(spot, p);
	}

	public void sort() {
		for (int i = 0; i < patientList.size(); i++) {
			String n = patientList.get(i).getName();
			for (int j = 0; j < patientList.size(); j++) {
				if (n.charAt(0) < patientList.get(j).getName().charAt(0)) {
					Patient temp = patientList.get(i);
					patientList.set(i, patientList.get(j));
					patientList.set(j, temp);
				} else if (n.charAt(1) < patientList.get(j).getName().charAt(1)
						&& n.charAt(0) == patientList.get(j).getName().charAt(0)) {
					Patient temp = patientList.get(i);
					patientList.set(i, patientList.get(j));
					patientList.set(j, temp);
				}
			}
		}
	}
	public Patient getPatient(String pName) {
		sort();
		ArrayList<Patient> sort = patientList;
		int first = 0;
		int last = sort.size() - 1;
		int mid = 0;
		while (first <= last) {
			mid = (first + last) / 2;
			if (sort.get(mid).getName().equals(pName) ) {
				return sort.get(mid);
			} else if (sort.get(mid).getName().charAt(0) < pName.charAt(0)) {
				first = mid + 1;
			} else if(sort.get(mid).getName().charAt(1) < pName.charAt(1) && sort.get(mid).getName().charAt(0) == pName.charAt(0)) {
				first = mid + 1;
			}
				else {
				last = mid - 1;
			}

		}
		return sort.get(mid);
	}
	public ArrayList<Patient> getList(){
		return patientList;
	}
	public Patient getPatient(int i ) {
		return patientList.get(i);
	}
	public void listTemp() {
		ArrayList <Patient> forTemp = patientList;
		for (int i = 0; i < getNumPatients(); i++) {
			double t = patientList.get(i).getInfo().getAverageTemp();
			for (int j = 0; j < getNumPatients(); j++) {
				if(t > patientList.get(j).getInfo().getAverageTemp()) {
					Patient tempVar = forTemp.get(i);
					forTemp.set(i, patientList.get(j));
					forTemp.set(j, tempVar);
				}
			}
		}
		for (Patient patient : forTemp) {
			System.out.println(patient.tempAna());
		}
	}
	public String getHostpitalName() {
		return name;
	}

	public int getNumPatients() {
		return numPatients;
	}

}
