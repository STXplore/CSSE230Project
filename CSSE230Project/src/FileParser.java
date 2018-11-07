import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileParser {

	private String fileName = "src/Cities.txt";
	private Graph graph;
	
	public FileParser(){
		try{
			this.graph = parseFile();
		} catch(IOException e){
			System.out.println("sup");
		}
	}
	
	public Graph parseFile() throws IOException{
		Graph g = new Graph();
		Scanner s = new Scanner(new File(fileName));
		while(s.hasNext()){
			String line = s.nextLine();
			if(line.equals("PLACE")){
				addPlace(s, g);
			}
		}
		s.close();
//		g.printGraph();
		return g;
	}
	
	public void addPlace(Scanner s, Graph g){
		Place p = new Place();
		p.setName(s.nextLine());
		while(s.hasNext()){
			String line = s.nextLine();
			if(line.equals("LINK")){
				String linkName = s.nextLine();
				double[] costs = new double[2];
				costs[0] = s.nextDouble();
				costs[1] = s.nextDouble();	
				Link l = new Link(linkName, costs);
				p.addLink(l);
			} else if(line.equals("POINT")){
				addPoint(s, p);
			} else if(line.equals("PLACE")){
				addPlace(s, g);
			}
		}
		g.addPlace(p);
	}
	
	public void addPoint(Scanner s, Place p){
		PointOfInterest point = new PointOfInterest();
		String pointName = s.nextLine();
		point.setName(pointName);
		p.addPoint(point);
	}
}
