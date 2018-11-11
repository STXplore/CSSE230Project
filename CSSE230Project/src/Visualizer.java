import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Visualizer extends JFrame{
		
	public Visualizer(Graph g){
		
		//set the title of the window
		setTitle("City Guide");
		
		//set up two fonts for titles and drop-down menus
		Font titleFont = new Font("Comic Sans MS", Font.BOLD, 40);
		Font labelFont = new Font("Comic Sans MS", Font.BOLD, 20);
				
		//create the panel that stores the content and set the layout for it
		JPanel content = new JPanel();
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));


		//add each part of the visualizer, set its font, set its alignment
		JLabel title = new JLabel("Get Route/City Info");
		title.setAlignmentX(CENTER_ALIGNMENT);
		title.setFont(titleFont);
		
		JButton searchButton = new JButton("Search");
		searchButton.setFont(titleFont);
		searchButton.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel primaryCityTitle = new JLabel("Current City");
		primaryCityTitle.setFont(titleFont);
		primaryCityTitle.setAlignmentX(CENTER_ALIGNMENT);

		JComboBox<String> primaryCity = new JComboBox<String>();
		primaryCity.setFont(labelFont);
		primaryCity.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel secondaryCityTitle = new JLabel("Destination (if necessary)");
		secondaryCityTitle.setFont(titleFont);
		secondaryCityTitle.setAlignmentX(CENTER_ALIGNMENT);

		JComboBox<String> secondaryCity = new JComboBox<String>();
		secondaryCity.setFont(labelFont);

		//populate the drop-down menus
		ArrayList<String> cityNames = g.getKeys();
		//since the second city can be blank, we add "none"
		secondaryCity.addItem("None");
		for(int i = 0; i < cityNames.size(); i++){
			primaryCity.addItem(cityNames.get(i));
			secondaryCity.addItem(cityNames.get(i));
		}

		//add each element to the content panel
		content.add(title);
		content.add(primaryCityTitle);
		content.add(primaryCity);
		content.add(secondaryCityTitle);
		content.add(secondaryCity);
		content.add(searchButton);
			
		//add action listener for the search button
		ActionListener search = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				//search for cities using data from the drop-down menu
				String primarySelection = primaryCity.getSelectedItem().toString();
				String secondarySelection = secondaryCity.getSelectedItem().toString();
					//if the second city is blank:
					if(secondarySelection.equals("None")){
						//open up the single city visualizer and close this window
						JFrame v = new SingleCityVisualizer(g, g.getPlace(primarySelection));
						v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						v.setVisible(true);
						Visualizer.super.dispose();
					}else{
						//open up the two city visualizer and close this window
						JFrame v = new TwoCityVisualizer(g, g.getPlace(primarySelection), g.getPlace(secondarySelection));
						v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						v.setVisible(true);
						Visualizer.super.dispose();
					}
				}
		};
		//add the listener to the search button
		searchButton.addActionListener(search);
		
		//add the content panel to the JFrame
		add(content);
		
		//pack the content in
		this.pack();
	}
	
}
