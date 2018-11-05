import java.util.ArrayList;
import java.util.Hashtable;
import java.util.NoSuchElementException;

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
	
}
