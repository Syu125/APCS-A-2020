package Data;

import java.util.ArrayList;
import java.util.Scanner;

import core.data.DataSource;

public class RestaurantData {
	public static void main(String[] args) {
		DataSource ds = DataSource.connect("https://data.baltimorecity.gov/api/views/k5ry-ef3g/rows.xml").load();
		ArrayList<Restaurant> allrsts = ds.fetchList(Restaurant.class, "row/row/name", "row/row/neighborhood",
				"row/row/zipcode");
		System.out.println(allrsts.size() + " restaurants in Baltimore City");

		ArrayList<Integer> zips = new ArrayList<Integer>();
		System.out.println("\nList of restaurants based on zipcode");
		for (int j = 0; j < allrsts.size(); j++) {
			int zip = allrsts.get(j).getZipcode();

			int count = 0;
			for (int z : zips) {
				if (zip == z) {
					count++;
				}
				// allrsts.remove(allrsts.get(j));
			}
			if (count == 0) {
				System.out.println("  " + zip);
				for (int i = 0; i < allrsts.size(); i++) {
					if (zip == allrsts.get(i).getZipcode()) {
						System.out.println("	" + allrsts.get(i).getName());
					}
				}
			}

			zips.add(zip);

		}
		Scanner s = new Scanner(System.in);
		System.out.print("\nEnter a neighborhood in Baltimore City: ");
		String neighborhood = s.next();
		System.out.println("\nRestaurants in " + neighborhood + ": ");
		for (Restaurant r : allrsts) {
			if (r.isLocatedInNeighborhood(neighborhood)) {
				System.out.println("  " + r.getName());
			}
		}
	}
}
