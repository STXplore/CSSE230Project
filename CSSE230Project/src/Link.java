
public class Link {

	private String key;
	private double[] costs;
	private final int numCosts = 2;
	
	public Link(String name) {
		this.key = name;
		costs = new double[numCosts];
	}
	
	public Link(String name, double[] costs) {
		this.key = name;
		this.costs = costs;
	}
	
	//just a getter
	public String getKey() {
		return key;
	}
	
	//gets cost at index i
	//i = 0 is distance
	//i = 1 is time
	public double getCost(int i) {
		return costs[i];
	}
	
	//sets cost at index i
	//i = 0 is distance
	//i = 1 is time
	public void setCost(int index, int value) {
		costs[index] = value;
	}
	
	public String toString() {
		return "Link to " + key;
	}
	
}
