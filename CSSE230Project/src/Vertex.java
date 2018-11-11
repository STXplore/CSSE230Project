
public class Vertex implements Comparable<Vertex> {

	/*
	 * This class is exclusively used in the Djikstra search method implemented in Graph.java
	 * It functions as a wrapper for places that stores the minimum cost to reach them as well as the place before it in the path
	 * 
	 */
	
	private Place vert; //place being held in wrapper
	private Place last; //place before this one
	
	private double cost;
	
	public Vertex(Place place) {
		vert = place;
		last = null;
		//All nodes except the start have a distance positive infinity for the purposes of the algorithm
		cost = Double.POSITIVE_INFINITY;
	}
	
	public Vertex(Place place, Place previous, double cost) {
		vert = place;
		last = previous;
		this.cost = cost;
	}
	
	//getter
	public Place getPlace() {
		return vert;
	}
	
	//getter
	public Place getLast() {
		return last;
	}
	
	//setter
	public void setLast(Place previous) {
		last = previous;
	}
	
	//getter
	public double getCost() {
		return cost;
	}
	
	//getter
	public String getName() {
		return vert.getName();
	}
	
	//setter
	public void setCost(double cost) {
		this.cost = cost;
	}

	//Compares vertices by cost, using compareTo functionality of Double for comparisons in Djikstra method
	public int compareTo(Vertex arg0) {
		return new Double(cost).compareTo(new Double(arg0.getCost()));
	}
}
