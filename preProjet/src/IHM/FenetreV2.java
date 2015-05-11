package IHM;

import java.awt.*;
import javax.swing.*;

	 
public class FenetreV2 implements Runnable {
	public JFrame frame = new JFrame(" Gaufre Empoisonnée ");
	
	public void run(){             

		frame.setSize(500, 500);      
		
		//panel d'accueil
		JPanel panelAccueil = new JPanel();

		JMenuBar menuBar=new JMenuBar();
		JMenu menu1 = new JMenu("Fichier");
		JMenuItem menui1=new JMenuItem("New");
		menu1.add(menui1);
		
		menuBar.add(menu1);
		frame.setJMenuBar(menuBar);
 		AireDeDessin monDessin = new AireDeDessin();
 		panelAccueil.add(monDessin);
 		frame.add(panelAccueil);   
 		//frame.pack();
		frame.setVisible(true);
	}
}
