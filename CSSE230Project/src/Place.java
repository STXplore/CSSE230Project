import java.util.Hashtable;
import java.util.NoSuchElementException;
import java.util.ArrayList;

public class Place {
	
	private ArrayList<Link> links;
	
	private ArrayList<String> pointsKeys;
	private Hashtable<String, PointOfInterest> points;
	
	private String name;
	
	
	public Place() {
		name = "";
		links = new ArrayList<Link>();
		pointsKeys = new ArrayList<String>();
		points = new Hashtable<String, PointOfInterest>();
	}
	
	public Place(String name) {
		this.name = name;
		links = new ArrayList<Link>();
		pointsKeys = new ArrayList<String>();
		points = new Hashtable<String, PointOfInterest>();
	}
	
	//does what it says on the can
	public void addLink(Link l) {
		links.add(l);
	}
	
	//ensures that the point of interest is properly set into both lists and proper sets its parent
	public void addPoint(PointOfInterest p) {
		pointsKeys.add(p.getName());
		points.put(p.getName(), p);
		p.setParent(this);
	}
	
	//getter
	public ArrayList<Link> getLinks() {
		return links;
	}
	
	//originally used in Djikstra, but no longer used, does what it says on the can
	//costType 0 used distance cost and 1 used time cost
	public Link getLinkWithMinCost(int costType) {
		int minInd = 0;
		double minVal = links.get(0).getCost(costType);
		
		for(int i = 1; i < links.size(); i++) {
			double temp = links.get(i).getCost(costType);
			if (temp < minVal) {
				minInd = i;
				minVal = temp;
			}
		}
		return links.get(minInd);
	}
	
	//getter
	public ArrayList<String> getPointsKeys() {
		return pointsKeys;
	}
	
	//Hashtable lookup with nonexistent keys throwing errors instead of returning null
	public PointOfInterest getPoint(String key) {
		
		if(key == null) {
			throw new IllegalArgumentException();
		}
		
		PointOfInterest ret = points.get(key);
		
		if (ret == null) {
			throw new NoSuchElementException();
		}
		
		return ret;
	}
	
	//getter
	public String getName() {
		return name;
	}
	
	//setter
	public void setName(String name) {
		this.name = name;
	}


	//Returns an ArrayList of every point of interest as its name
	public ArrayList<String> getPoints(){

		if(pointsKeys.size() == 0){
			ArrayList<String> noneString = new ArrayList<String>();
			noneString.add("None");
			return noneString;
		} else{
			return this.pointsKeys;
		}
	}

}
