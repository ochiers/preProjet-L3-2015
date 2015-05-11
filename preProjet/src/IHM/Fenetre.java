package IHM;

import java.awt.*;
import javax.swing.*;

	 
public class Fenetre implements Runnable {
	public JFrame frame = new JFrame(" Gaufre Empoisonnée ");
	
	public void run(){             
		this.frame.setSize(1000, 1000);      
		//panel d'accueil
		JPanel panelAccueil = new JPanel();
		JLabel LaGE = new JLabel(" La Gaufre Empoisonnée. ");
		JButton newGame = new JButton(" Nouvelle Partie ");
		JButton quit = new JButton(" Quitter ");
		ImageIcon pointInterro = new ImageIcon("http://cdns2.freepik.com/photos-libre/question-bulle_318-77793.jpg");
		JButton help = new JButton(" Aide ", pointInterro);
		
		panelAccueil.add(LaGE, BorderLayout.NORTH);
		panelAccueil.add(newGame, BorderLayout.CENTER);
		panelAccueil.add(quit, BorderLayout.CENTER);
		panelAccueil.add(help, BorderLayout.SOUTH);
		
		//
		panelAccueil.setBackground(Color.WHITE);        
 		frame.add(panelAccueil);               
		frame.setVisible(true);
	}
}


/*
		//panel choix des joueurs
		JPanel panelJoueurs = new JPanel();
		
		//panel choix des difficultés
		JPanel panelNiveaux = new JPanel();
		
		//panel de jeu contenant la gaufre
		JPanel panelJeu = new JPanel();
		
		//panel fin de partie
		JPanel panelFin = new JPanel();
*/