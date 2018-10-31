import java.util.Hashtable;
import java.util.ArrayList;

public class Place {
	
	private ArrayList<Link> links;
	
	private String name;
	
	
	public Place() {
		name = "";
		links = new ArrayList<Link>();
	}
	
	public Place(String name) {
		this.name = name;
		links = new ArrayList<Link>();
	}
	
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	

}
