import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileParser {

	private String fileName = "src/Cities.txt";
	private Graph graph;
	
	public FileParser(){
		try{
			//attempt to parse the file.
			this.graph = parseFile();
		} catch(IOException e){
			//the file isn't working for some reason, close the program.
			System.out.println("Error parsing file. Closing.");
			System.exit(-1);
		}
	}
	
	public Graph parseFile() throws IOException{
		
		//create an empty graph to populate
		Graph g = new Graph();
		
		//set up a scanner to read the file
		Scanner s = new Scanner(new File(fileName));

		while(s.hasNext()){
			//if the next line matches the code for a place (which it should), start adding places
			String line = s.nextLine();
			if(line.equals("Place")){
				addPlace(s, g);
			}
		}
		//close the scanner and return the newly created graph
		s.close();
		return g;
	}
	
	public void addPlace(Scanner s, Graph g){
		Place p = new Place();
		//set the name (which will always be the next line)
		p.setName(s.nextLine());
		
		while(s.hasNext()){
			//check the next line
			String line = s.nextLine();
			//if it's a link...
			if(line.equals("Link")){
				//add the link
				addLink(s, p);
				
				//if it's a point...
			} else if(line.equals("Point")){
				//add the point
				addPoint(s, p);
				
				//if it's a place...
			} else if(line.equals("Place")){
				//it's a new place, start this method again
				addPlace(s, g);
			}
		}
		//add the newly created place to the graph
		g.addPlace(p);
	}
	
	public void addLink(Scanner s, Place p){
		//get the name, which should be next
		String linkName = s.nextLine();
		
		//create a new array of 2 doubles for the distance and time cost
		double[] costs = new double[2];
		costs[0] = s.nextDouble();
		costs[1] = s.nextDouble();	
		
		//create the new link
		Link l = new Link(linkName, costs);
		
		//add the link to the place
		p.addLink(l);
	}
	
	public void addPoint(Scanner s, Place p){
		PointOfInterest point = new PointOfInterest();
		String pointName = s.nextLine();
		point.setName(pointName);
		p.addPoint(point);
	}
}
