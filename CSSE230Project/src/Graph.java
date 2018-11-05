import java.util.ArrayList;
import java.util.Hashtable;

public class Graph {

	private Hashtable<String, Place> places;
	private ArrayList<String> keys;
	
	public Graph() {
		places = new Hashtable<String, Place>();
		keys = new ArrayList<String>();
	}
	
	public void addPlace(Place p) {
		places.put(p.getName(), p);
		keys.add(p.getName());
	}
	
	public Place getPlace(String key) {
		return places.get(key);
	}
	
	public ArrayList<String> getKeys() {
		return keys;
	}
	
	public void string(){
		for(int i = 0; i < places.size(); i++){
			System.out.println("city: " + keys.get(i));
			ArrayList<Link> listOfLinks =  places.get(keys.get(i)).getLinks();
			for(int j = 0; j < listOfLinks.size(); j++){
				System.out.println("	link: " + listOfLinks.get(j).getKey());
				System.out.println("		cost1: " + listOfLinks.get(j).getCost(0));
				System.out.println("		cost2: " + listOfLinks.get(j).getCost(1));				
			}
		}
	}
	
}
