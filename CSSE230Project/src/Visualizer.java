import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Visualizer extends JFrame{
	
	private final String defaultText1 = "Current City";
	private final String defaultText2 = "Destination (if necessary)";
	
	public Visualizer(){
		setTitle("City Guide");
		
		this.setSize(400, 150);
		JPanel content = new JPanel();
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		JButton searchButton = new JButton("Search");
		JTextField primaryCity = new JTextField(defaultText1);
		JTextField secondaryCity = new JTextField(defaultText2);
		JLabel title = new JLabel("Get Route/City Info");
		content.add(title);
		content.add(searchButton);
		content.add(primaryCity);
		content.add(secondaryCity);

		
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
						JFrame v = new SingleCityVisualizer(primaryCity.getText());
						v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						v.setVisible(true);
						Visualizer.super.dispose();
					}else{
						JFrame v = new TwoCityVisualizer(primaryCity.getText(), secondaryCity.getText());
						v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						v.setVisible(true);
						Visualizer.super.dispose();
					}
				}
			}
		};
		searchButton.addActionListener(search);
		add(content);
//		pack();
	}
	
}
