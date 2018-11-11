import javax.swing.JFrame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ErrorVisualizer extends JFrame{

	public ErrorVisualizer(){
		
		//set the title of the window
		this.setTitle("Error");

		//create the content panel and set its layout
		JPanel content = new JPanel();
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		
		//set up a font
		Font f = new Font("Comic Sans MS", Font.BOLD, 30);
		
		//create each content element
		JLabel errorMessage = new JLabel("The city name you have entered is invalid.");
		errorMessage.setAlignmentX(CENTER_ALIGNMENT);
		errorMessage.setFont(f);
		
		JLabel errorMessage2 = new JLabel("Please enter a valid city name.");
		errorMessage2.setAlignmentX(CENTER_ALIGNMENT);
		errorMessage2.setFont(f);
		
		
		JButton closeButton = new JButton("OK");
		closeButton.setAlignmentX(CENTER_ALIGNMENT);
		closeButton.setFont(f);

		
		//create an action listener that closes the error window
		ActionListener close = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				ErrorVisualizer.super.dispose();
			}
		};
		
		//add the action listener to the error window
		closeButton.addActionListener(close);
		
		//add the elements to the content panel
		content.add(errorMessage);
		content.add(errorMessage2);
		content.add(closeButton);
		
		//add the content panel to the JFrame
		add(content);
		
		//pack the content into the window
		this.pack();
	}
}
