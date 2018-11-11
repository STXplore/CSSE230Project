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
	
	
	//handles adding new places so that they are properly represented in both data structures
	public void addPlace(Place p) {
		places.put(p.getName(), p);
		keys.add(p.getName());
	}
	
	//Hashtable lookup with nonexistent keys throwing errors instead of returning null
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
	
	//just a getter
	public ArrayList<String> getKeys() {
		return keys;
	}

	/*
	 * Returns an ArrayList of keys, in reverse order, of the shortest path from the Place with key start to Place with key finish
	 * using the cost provided by costType
	 * 
	 * costType 0 means the type is distance
	 * costType 1 means the type is time
	 * 
	 */
	public ArrayList<String> Dijkstra(String start, String finish, int costType) {
		PriorityQueue<Vertex> vertices = new PriorityQueue<Vertex>();
		Hashtable<String, Vertex> verticesList = new Hashtable<String, Vertex>();
		
		//constructing a list of all of the vertices in the graph as well as a priorityQueue
		for(int i = 0; i < keys.size(); i++) {
			Vertex temp = new Vertex(places.get(keys.get(i)));
			verticesList.put(temp.getPlace().getName(), temp);
			
			//If the vertex we are looking at is the start, sets its cost to 0 so we go there first
			if (temp.getPlace().getName().equals(start)) {
				temp.setCost(0);
			}
			vertices.offer(temp);
		}
		
		
		//Starting the actual algorithm
		Vertex cur = vertices.poll();
		while(!vertices.isEmpty() && !cur.getName().equals(finish)) {
			for(int i = 0; i < cur.getPlace().getLinks().size(); i++) {
				Link l = cur.getPlace().getLinks().get(i);
				Vertex temp =  verticesList.get(l.getKey());
				if(vertices.contains(temp) && temp.getCost() > cur.getCost() + l.getCost(costType) ) {
					
					//We have to remove from the PriorityQueue before we mess with the vertex and then re add it otherwise we get
					//interesting issues
					vertices.remove(temp);
					temp.setCost(cur.getCost() + l.getCost(costType));
					temp.setLast(cur.getPlace());
					vertices.add(temp);
				}
			}
			
			cur = vertices.poll();
			
		}
		

		//Building the path backwards using the parent field of vertices
		Vertex temp = verticesList.get(finish);
		ArrayList<String> path = new ArrayList<String>();
		path.add(temp.getPlace().getName());
		
		
		while(temp != null && temp.getLast() != null) {
			temp = verticesList.get(temp.getLast().getName());
			if(temp != null) {
				path.add(temp.getName());
			}
		}
		//System.out.println(path);
		return path;
		
	}
		

	/**
	 * This code is unspeakably bad, but it's only for testing purposes.
	 */
	public void printGraph(){
		for(int i = 0; i < places.size(); i++){
			System.out.println("city: " + keys.get(i));
			ArrayList<Link> listOfLinks =  places.get(keys.get(i)).getLinks();
			for(int j = 0; j < listOfLinks.size(); j++){
				System.out.println("	link: " + listOfLinks.get(j).getKey());
				System.out.println("		cost1: " + listOfLinks.get(j).getCost(0));
				System.out.println("		cost2: " + listOfLinks.get(j).getCost(1));				
			}
			System.out.println("Points of interest:");
			if(places.get(keys.get(i)).getPointsKeys().size() != 0){
				for(int k = 0; k < places.get(keys.get(i)).getPointsKeys().size(); k++){
					System.out.println(places.get(keys.get(i)).getPointsKeys().get(k));
				}
			} else{
				System.out.println("none");
			}
		}

	}
	
}
