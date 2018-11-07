import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.NoSuchElementException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SingleCityVisualizer extends JFrame{

	
	public SingleCityVisualizer(Graph g, Place city){
		setTitle("City Info: " + city.getName());
		setSize(400, 250);
		JPanel content = new JPanel();
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		
		JLabel mainTitle = new JLabel("Information for " + city.getName());
		
		JLabel timeTitle = new JLabel("Most Popular Point of Interest: " + city.getSinglePointOfInterest());

		JLabel searchTitle = new JLabel("Find a route to any city");
		JTextField newCity = new JTextField();
		JButton searchButton = new JButton("Search");
		
		JButton closeButton = new JButton("Main Menu");
		
		content.add(mainTitle);
		content.add(timeTitle);
		content.add(searchTitle);
		content.add(newCity);
		content.add(searchButton);
		content.add(closeButton);
		
		ActionListener close = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				JFrame v = new Visualizer(g);
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
					try{
					JFrame v = new TwoCityVisualizer(g, city, g.getPlace(newCity.getText()));
					v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					v.setVisible(true);
					SingleCityVisualizer.super.dispose();
					}catch(NoSuchElementException ex){
						JFrame v = new ErrorVisualizer();
						v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						v.setVisible(true);
					}
				}
			}
		};
		searchButton.addActionListener(search);

				
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
