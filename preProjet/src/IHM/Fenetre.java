package IHM;

import java.awt.*;
import javax.swing.*;

	 
public class Fenetre implements Runnable {
	public JFrame frame = new JFrame(" Gaufre Empoisonnée ");
	
	public void run(){             

		frame.setSize(500, 500);      
		
		//panel d'accueil
		JPanel panelAccueil = new JPanel();
	/*	panelAccueil.setLayout(null);
		JLabel LaGE = new JLabel(" La Gaufre Empoisonnée. ");
		LaGE.setSize(300, 40);
		LaGE.setLocation(400, 80);
		JButton newGame = new JButton(" Nouvelle Partie ");
		newGame.setSize(200, 50);
		newGame.setLocation(400, 400);
		JButton quit = new JButton(" Quitter ");
		quit.setSize(100, 50);
		quit.setLocation(450, 600);
		JButton help = new JButton(" Aide ");
		help.setSize(100, 100);
		help.setLocation(850, 850);
		

		panelAccueil.add(LaGE);
		panelAccueil.add(newGame);
		panelAccueil.add(quit);
		panelAccueil.add(help);

		
		panelAccueil.setBackground(Color.WHITE);        
 		*/
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
