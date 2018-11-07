import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ErrorVisualizer extends JFrame{

	public ErrorVisualizer(){
		this.setTitle("Error");
		setSize(350, 100);
		JPanel content = new JPanel();
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		JLabel errorMessage = new JLabel("The city name you have entered is invalid.");
		JLabel errorMessage2 = new JLabel("Please enter a valid city name.");
		JButton closeButton = new JButton("Sorry about that...");
		
		ActionListener close = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				ErrorVisualizer.super.dispose();
			}
		};
		closeButton.addActionListener(close);
		content.add(errorMessage);
		content.add(errorMessage2);
		content.add(closeButton);
		add(content);
	}
}
