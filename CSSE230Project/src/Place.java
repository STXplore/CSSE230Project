import java.util.Hashtable;
import java.util.ArrayList;

public class Place {
	
	private ArrayList<Link> links;
	
	private ArrayList<String> pointsKeys;
	private Hashtable<String, PointOfInterest> points;
	
	private String name;
	
	
	public Place() {
		name = "";
		links = new ArrayList<Link>();
	}
	
	public Place(String name) {
		this.name = name;
		links = new ArrayList<Link>();
	}
	
	public void addLink(Link l) {
		links.add(l);
	}
	
	public void addPoint(PointOfInterest p) {
		pointsKeys.add(p.getName());
		points.put(p.getName(), p);
		p.setParent(this);
	}
	
	public ArrayList<Link> getLinks() {
		return links;
	}
	
	public ArrayList<String> getPointsKeys() {
		return pointsKeys;
	}
	
	public PointOfInterest getPoint(String key) {
		return points.get(key);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	

}
