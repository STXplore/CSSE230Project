
public class Vertex implements Comparable<Vertex> {

	private Place vert;
	private Place last;
	
	private double cost;
	
	public Vertex(Place place) {
		vert = place;
		last = null;
		cost = Double.POSITIVE_INFINITY;
	}
	
	public Vertex(Place place, Place previous, double cost) {
		vert = place;
		last = previous;
		this.cost = cost;
	}
	
	public Place getPlace() {
		return vert;
	}
	
	public Place getLast() {
		return last;
	}
	
	public void setLast(Place previous) {
		last = previous;
	}
	
	public double getCost() {
		return cost;
	}
	
	public void setCost(double cost) {
		this.cost = cost;
	}

	public int compareTo(Vertex arg0) {
		// TODO Auto-generated method stub
		return new Double(cost).compareTo(new Double(arg0.getCost()));
	}
}
