package IHM;

import java.awt.*;
import javax.swing.*;

	 
public class Fenetre implements Runnable {
	public void run(){             
		JFrame frame = new JFrame(" Gaufre Empoisonnée ");
		frame.setSize(500, 500);      
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);        
 		frame.setContentPane(panel);               
		frame.setVisible(true);
	}
}
