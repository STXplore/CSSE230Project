import java.io.IOException;

import javax.swing.JFrame;

public class Main{
	
	/**
	 * Starts the application.
	 * @param args ignored
	 */
	public static void main(String[] args) {
		FileParser p = new FileParser();
		Graph g = null;
		try {
			g = p.parseFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(g != null){
			JFrame v = new Visualizer(g);
			v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			v.setVisible(true);
		}
	}
}