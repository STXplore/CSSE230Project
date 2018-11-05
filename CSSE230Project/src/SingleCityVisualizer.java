import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SingleCityVisualizer extends JFrame{

	
	public SingleCityVisualizer(String cityName){
		setTitle("City Info: " + cityName);
		setSize(400, 250);
		JPanel content = new JPanel();
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		
		JLabel mainTitle = new JLabel("Information for " + cityName);
		JLabel secondaryTitle = new JLabel("Popular Destinations");

		JLabel distanceTitle = new JLabel("Closest city: " + "yeehaw junction");
		JButton distanceSearch = new JButton("More Info");
		
		JLabel timeTitle = new JLabel("Fastest city to get to: " + "cowboy town");
		JButton timeSearch = new JButton("More Info");

		JTextField newCity = new JTextField("Find a route to any city");
		JButton searchButton = new JButton("Search");
		
		JButton closeButton = new JButton("Main Menu");
		
		content.add(mainTitle);
		content.add(secondaryTitle);
		content.add(distanceTitle);
		content.add(distanceSearch);
		content.add(timeTitle);
		content.add(timeSearch);
		content.add(newCity);
		content.add(searchButton);
		content.add(closeButton);
		
		ActionListener close = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				JFrame v = new Visualizer();
				v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				v.setVisible(true);
				SingleCityVisualizer.super.dispose();
			}
		};
		closeButton.addActionListener(close);
		
		ActionListener search = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(newCity.getText().isEmpty()){
					JFrame v = new ErrorVisualizer();
					v.setVisible(true);
				} else{
					JFrame v = new TwoCityVisualizer(cityName, newCity.getText());
					v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					v.setVisible(true);
					SingleCityVisualizer.super.dispose();
				}
			}
		};
		searchButton.addActionListener(search);

		ActionListener distSearch = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				JFrame v = new TwoCityVisualizer(cityName, "howdy");
				v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				v.setVisible(true);
				SingleCityVisualizer.super.dispose();
			}
		};
		distanceSearch.addActionListener(distSearch);
		
		ActionListener searchTime = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				JFrame v = new TwoCityVisualizer(cityName, "yeehaw");
				v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				v.setVisible(true);
				SingleCityVisualizer.super.dispose();
			}
		};
		timeSearch.addActionListener(searchTime);
		
		FocusListener newCityCheck = new FocusListener(){
			@Override
			public void focusGained(FocusEvent e){
				newCity.setText("");
			}

			@Override
			public void focusLost(FocusEvent arg0) {
			}
		};
		newCity.addFocusListener(newCityCheck);
		
		add(content);
	}
}
