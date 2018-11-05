import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TwoCityVisualizer extends JFrame{

	
	public TwoCityVisualizer(String primary, String secondary){
		setTitle("Routes: " + primary + " to " + secondary);
		
		setSize(400, 150);
		JPanel content = new JPanel();
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		//lots of these have placeholder data right now but it won't be too hard to add in
		//the actual data.
		JButton closeButton = new JButton("Search Again");
		JLabel title = new JLabel("Route from " + primary + " to " + secondary);
		JLabel distanceTitle = new JLabel("Shortest Distance: ");
		JLabel distanceRoute = new JLabel("City-City-City-City-City");
		JLabel timeTitle = new JLabel("Fastest drive: ");
		JLabel timeRoute = new JLabel("City-City-City-City-City");
		
		ActionListener close = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				JFrame v = new Visualizer();
				v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				v.setVisible(true);
				TwoCityVisualizer.super.dispose();
			}
		};
		closeButton.addActionListener(close);
		content.add(title);
		content.add(distanceTitle);
		content.add(distanceRoute);
		content.add(timeTitle);
		content.add(timeRoute);
		content.add(closeButton);

		add(content);
	}
}
