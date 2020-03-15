package Data;

public class Restaurant {

	private String name, neighborhood;
	private int zipcode;
	
	public Restaurant(String name, String neighborhood, int zipcode) {
		this.name =  name;
		this.neighborhood =  neighborhood;
		this.zipcode =  zipcode;
	}
	public String getName() {
		return name;
	}
	public String getNeighborhood() {
		return neighborhood;
	}
	public int getZipcode() {
		return zipcode;
	}
	public boolean isLocatedInNeighborhood(String loc) {
		return this.neighborhood.equals(loc);
	}
}
