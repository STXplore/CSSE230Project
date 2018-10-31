
public class PointOfInterest {
	
	private String name;
	private Place parent;
	
	public PointOfInterest() {
		name = "";
	}
	
	public PointOfInterest(String name) {
		this.name = name;
		this.parent = null;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Place getParent() {
		return parent;
	}
	
	public void setParent(Place parent) {
		this.parent = parent;
	}
	
}
