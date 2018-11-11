import javax.swing.JFrame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TwoCityVisualizer extends JFrame{

	
	public TwoCityVisualizer(Graph g, Place primary, Place secondary){
		//set the window title
		setTitle("Routes: " + primary.getName() + " to " + secondary.getName());
		
		//create the content panel and set its layout
		JPanel content = new JPanel();
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

		//create the font for the labels and the titles
		Font bigFont = new Font("Comic Sans MS", Font.BOLD, 40);
		Font smallFont = new Font("Comic Sans MS", Font.BOLD, 30);
		
		//create each element of the visualizer
		JButton closeButton = new JButton("Search Again");
		closeButton.setAlignmentX(CENTER_ALIGNMENT);
		closeButton.setFont(bigFont);
		
		JLabel title = new JLabel("Route from " + primary.getName() + " to " + secondary.getName());
		title.setAlignmentX(CENTER_ALIGNMENT);
		title.setFont(bigFont);

		JLabel distanceTitle = new JLabel("Shortest Distance: ");
		distanceTitle.setAlignmentX(CENTER_ALIGNMENT);
		distanceTitle.setFont(smallFont);

		JLabel distanceRoute = new JLabel(g.Dijkstra(secondary.getName(), primary.getName(), 0).toString());
		distanceRoute.setAlignmentX(CENTER_ALIGNMENT);
		distanceRoute.setFont(smallFont);
		
		JLabel timeTitle = new JLabel("Fastest drive: ");
		timeTitle.setAlignmentX(CENTER_ALIGNMENT);
		timeTitle.setFont(smallFont);

		JLabel timeRoute = new JLabel(g.Dijkstra(secondary.getName(), primary.getName(), 1).toString());
		timeRoute.setAlignmentX(CENTER_ALIGNMENT);
		timeRoute.setFont(smallFont);
		
		//add an action listener that closes the two city visual when clicked on, opening a home page visualizer
		ActionListener close = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				JFrame v = new Visualizer(g);
				v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				v.setVisible(true);
				TwoCityVisualizer.super.dispose();
			}
		};
		//add the action listener to the close button
		closeButton.addActionListener(close);
		
		//add the items to the content panel
		content.add(title);
		content.add(distanceTitle);
		content.add(distanceRoute);
		content.add(timeTitle);
		content.add(timeRoute);
		content.add(closeButton);

		//add the content panel to the JFrame
		add(content);
		
		//pack the content in
		this.pack();
	}
}
