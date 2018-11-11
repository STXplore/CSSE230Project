import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Visualizer extends JFrame{
	
	private final String defaultText1 = "Current City";
	private final String defaultText2 = "Destination (if necessary)";
	
	public Visualizer(Graph g){
		setTitle("City Guide");
		
		this.setSize(400, 200);
		JPanel content = new JPanel();
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		JButton searchButton = new JButton("Search");
		JLabel primaryCityTitle = new JLabel(defaultText1);
		//JTextField primaryCity = new JTextField();
		JComboBox<String> primaryCity = new JComboBox<String>();
		JLabel secondaryCityTitle = new JLabel(defaultText2);
		//JTextField secondaryCity = new JTextField();
		JComboBox<String> secondaryCity = new JComboBox<String>();
		ArrayList<String> cityNames = g.getKeys();
		secondaryCity.addItem("None");
		for(int i = 0; i < cityNames.size(); i++){
			primaryCity.addItem(cityNames.get(i));
			secondaryCity.addItem(cityNames.get(i));
		}
		JLabel title = new JLabel("Get Route/City Info");
		content.add(title);
		content.add(primaryCityTitle);
		content.add(primaryCity);
		content.add(secondaryCityTitle);
		content.add(secondaryCity);
		content.add(searchButton);
		
/*		FocusListener primaryCheck = new FocusListener(){
			@Override
			public void focusGained(FocusEvent e){
				primaryCity.setText("");
			}

			@Override
			public void focusLost(FocusEvent arg0) {
			}
		};
		primaryCity.addFocusListener(primaryCheck);

		FocusListener secondaryCheck = new FocusListener(){
			@Override
			public void focusGained(FocusEvent e){
				secondaryCity.setText("");
			}

			@Override
			public void focusLost(FocusEvent arg0) {
			}
		};
		secondaryCity.addFocusListener(secondaryCheck);
		
*/		
		ActionListener search = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				//search for cities
				String primarySelection = primaryCity.getSelectedItem().toString();
				String secondarySelection = secondaryCity.getSelectedItem().toString();
					if(secondarySelection.equals("None")){
						JFrame v = new SingleCityVisualizer(g, g.getPlace(primarySelection));
						v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						v.setVisible(true);
						Visualizer.super.dispose();
					}else{
						JFrame v = new TwoCityVisualizer(g, g.getPlace(primarySelection), g.getPlace(secondarySelection));
						v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						v.setVisible(true);
						Visualizer.super.dispose();
					}
				}
		};
		searchButton.addActionListener(search);
		add(content);
//		pack();
	}
	
}
