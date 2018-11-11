import javax.swing.JFrame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SingleCityVisualizer extends JFrame{

	
	public SingleCityVisualizer(Graph g, Place city){
		
		//set the title of the window
		setTitle("City Info: " + city.getName());
		
		//create the content panel and set its layout
		JPanel content = new JPanel();
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		
		//create fonts
		Font titleFont = new Font("Comic Sans MS", Font.BOLD, 40);
		Font subtitleFont = new Font("Comic Sans MS", Font.BOLD, 30);
		Font contentFont = new Font("Comic Sans MS", Font.BOLD, 20);
		
		//create each element for the visualizer
		JLabel mainTitle = new JLabel("Information for " + city.getName());
		mainTitle.setAlignmentX(CENTER_ALIGNMENT);
		mainTitle.setFont(titleFont);
		
		JLabel pointsTitle = new JLabel("Points of interest: ");
		pointsTitle.setAlignmentX(CENTER_ALIGNMENT);
		pointsTitle.setFont(subtitleFont);

		JLabel searchTitle = new JLabel("Find a route to any city");
		searchTitle.setAlignmentX(CENTER_ALIGNMENT);
		searchTitle.setFont(subtitleFont);
		
		//create and populate the drop-down menu
		JComboBox<String> newCity = new JComboBox<String>();
		newCity.setFont(contentFont);
		ArrayList<String> cityNames = g.getKeys();
		newCity.addItem("None");
		for(int i = 0; i < cityNames.size(); i++){
			newCity.addItem(cityNames.get(i));
		}
		
		JButton searchButton = new JButton("Search");
		searchButton.setAlignmentX(CENTER_ALIGNMENT);
		searchButton.setFont(subtitleFont);
		
		JButton closeButton = new JButton("Main Menu");
		closeButton.setAlignmentX(CENTER_ALIGNMENT);
		closeButton.setFont(subtitleFont);
		

		//add each element to the content panel
		content.add(mainTitle);
		content.add(pointsTitle);
		//create and add each point of interest
		ArrayList<String> points = city.getPoints();
		
		for(int i = 0; i < points.size(); i++){
			JLabel x = new JLabel(points.get(i));
			x.setAlignmentX(CENTER_ALIGNMENT);
			x.setFont(contentFont);
			content.add(x);
		}
		//continue adding elements
		content.add(searchTitle);
		content.add(newCity);
		content.add(searchButton);
		content.add(closeButton);
		
		
		//create an action listener that closes the window, sending it back to the home page
		ActionListener close = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				JFrame v = new Visualizer(g);
				v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				v.setVisible(true);
				SingleCityVisualizer.super.dispose();
			}
		};
		//add this action listener to the close button
		closeButton.addActionListener(close);
		
		//create an action listener that lets you search for directions to any city
		ActionListener search = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				//get the city name from the drop-down menu
				String entry = newCity.getSelectedItem().toString();
				//if the search button is clicked with no city selected:
				if(entry.equals("None")){
					//create an error frame
					JFrame v = new ErrorVisualizer();
					v.setVisible(true);
				} else{
					//create a two city visualizer with the route from this city to the inputted city
					JFrame v = new TwoCityVisualizer(g, city, g.getPlace(entry));
					v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					v.setVisible(true);
					SingleCityVisualizer.super.dispose();
				}
			}
		};
		//add the action listener to the search button
		searchButton.addActionListener(search);
		
		//add the content window
		add(content);
		
		//pack the content in
		this.pack();
	}
}
