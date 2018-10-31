
public class Link {

	public String key;
	public double[] costs;
	
	public Link(String name) {
		this.key = name;
	}
	
	public String getKey() {
		return key;
	}
	
	public double getCost(int i) {
		return costs[i];
	}
	
}
