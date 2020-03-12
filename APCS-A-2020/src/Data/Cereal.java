package Data;

public class Cereal {
	String brand;
	int numCarbs;
	int numProteins;
	
	public Cereal(String name, int nc, int np) {
		brand = name; 
		numCarbs = nc;
		numProteins = np;
	}
	public void setName(String name) {
		brand = name;
	}
	public void setNumCarbs(int nc) {
		numCarbs = nc;
	}
	public void setNumProteins(int np) {
		numProteins = np;
	}
	public String getName() {
		return brand;
	}
	public int getCarbs() {
		return numCarbs;
	}
	public int getProteins() {
		return numProteins;
	}
	public String toString() {
		return brand + ": " + numCarbs + " per serving, " + numProteins + " per serving";
	}
	public static void main(String[] args) {
		Cereal c = new Cereal("100% Bran", 5, 4);
		System.out.println(c);
	}
}
