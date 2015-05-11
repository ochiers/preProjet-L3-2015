package IHM;

import java.awt.*;
import javax.swing.*;

	 
public class Fenetre implements Runnable {
	
	//variables globales
	public static JFrame frame = new JFrame(" Gaufre Empoisonnée ");
	public int menu = 0;
	public int player = 1;
	public int level = 2;
	public int gaufre = 3;
	public int end = 4;
	
	public void run(){             

		frame.setSize(1000, 1000);      
		
		//panel d'accueil
		JPanel panelAccueil = new JPanel();
		panelAccueil.setLayout(null);
		
		//creation objets
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
		
		//ecouteur de souris
        newGame.addMouseListener(new EcSouris(0));
        quit.addMouseListener(new EcSouris(1));
        help.addMouseListener(new EcSouris(2));
		
		//ajout a panel
		panelAccueil.add(LaGE);
		panelAccueil.add(newGame);
		panelAccueil.add(quit);
		panelAccueil.add(help);
		
		//ajout a la frame
		panelAccueil.setBackground(Color.WHITE);        

 		frame.add(panelAccueil);
		frame.setVisible(true);
		
		

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

		
		
	}
}

