import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Visualizer extends JFrame{
	
	public Visualizer(){
		setTitle("City Guide");
		
		this.setSize(1920, 1080);
		JPanel content = new JPanel();
//		content.setLayout(mgr);
		JButton searchButton = new JButton("Search");
		
		JTextField primaryCity = new JTextField("Current City");
		JTextField secondaryCity = new JTextField("Destination (if necessary)");
		content.add(searchButton);
		content.add(primaryCity);
		content.add(secondaryCity);
		ActionListener search = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				//search for cities
				System.out.println("searching for cities");
				if(primaryCity.getText().isEmpty()){
					System.out.println("Please enter a primary city.");
				} else{
					if(secondaryCity.getText().isEmpty()){
						System.out.println("going to single-city window");
					}else{
						System.out.println("going to route window");
					}
				}
			}
		};
		searchButton.addActionListener(search);
		add(content);
		pack();
	}
	
}
