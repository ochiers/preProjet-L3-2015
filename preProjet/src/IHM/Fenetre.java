package IHM;

import java.awt.*;
import javax.swing.*;
	 
public class Fenetre implements Runnable {
	public void run(){             
		JFrame frame = new JFrame(" Gauffre Empoisonnée ");
		frame.setSize(500, 500);      
		JPanel panel = new JPanel();
		//Définition de sa couleur de fond
		panel.setBackground(Color.WHITE);        
		//On prévient notre JFrame que notre JPanel sera son content pane
		frame.setContentPane(panel);               
		frame.setVisible(true);
	}
}
