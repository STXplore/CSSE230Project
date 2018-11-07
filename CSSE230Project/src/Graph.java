import java.util.ArrayList;
import java.util.Hashtable;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

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
		
		if(key == null) {
			throw new IllegalArgumentException();
		}
		
		Place ret = places.get(key);
		
		if (ret == null) {
			throw new NoSuchElementException();
		}
		
		return ret;
	}
	
	public ArrayList<String> getKeys() {
		return keys;
	}
	
	
	// costType is 0 or 1, costType 0 uses the first cost (distance) and costType 1 uses the second cost (time)
	public ArrayList<String> Dijkstra(String start, String finish, int costType) {
		PriorityQueue<Vertex> vertices = new PriorityQueue<Vertex>();
		for(int i = 0; i < keys.size(); i++) {
			Vertex temp = new Vertex(places.get(keys.get(i)));
			if (temp.getPlace().getName().equals(start)) {
				temp.setCost(0); //So we start at the one with 0
			}
			vertices.offer(temp);
		}
		
		return null;
		
	}
	
}
