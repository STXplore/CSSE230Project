import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.NoSuchElementException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
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
		JTextField primaryCity = new JTextField();
		JLabel secondaryCityTitle = new JLabel(defaultText2);
		JTextField secondaryCity = new JTextField();
		JLabel title = new JLabel("Get Route/City Info");
		content.add(title);
		content.add(primaryCityTitle);
		content.add(primaryCity);
		content.add(secondaryCityTitle);
		content.add(secondaryCity);
		content.add(searchButton);
		
		FocusListener primaryCheck = new FocusListener(){
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
		
		
		ActionListener search = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				//search for cities
				if(primaryCity.getText().isEmpty() || primaryCity.getText().equals(defaultText1)){
					JFrame v = new ErrorVisualizer();
					v.setVisible(true);
				} else{
					if(secondaryCity.getText().isEmpty() || secondaryCity.getText().equals(defaultText2)){
						try{
						JFrame v = new SingleCityVisualizer(g, g.getPlace(primaryCity.getText()));
						v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						v.setVisible(true);
						Visualizer.super.dispose();
						} catch (NoSuchElementException ex){
							JFrame v = new ErrorVisualizer();
							v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							v.setVisible(true);
						}
					}else{
						try{
						JFrame v = new TwoCityVisualizer(g, g.getPlace(primaryCity.getText()), g.getPlace(secondaryCity.getText()));
						v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						v.setVisible(true);
						Visualizer.super.dispose();
						} catch (NoSuchElementException exc){
							JFrame v = new ErrorVisualizer();
							v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							v.setVisible(true);
						}
					}
				}
			}
		};
		searchButton.addActionListener(search);
		add(content);
//		pack();
	}
	
}
