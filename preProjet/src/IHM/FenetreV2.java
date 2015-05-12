package IHM;

import java.awt.*;
import java.awt.event.KeyEvent;

import javax.swing.*;

import engine.*;

	 
public class FenetreV2 extends Fenetre implements Runnable,Affichage {
	public JFrame frame = new JFrame(" Gaufre Empoisonnée ");
	Engine e;
	AireDeDessin monDessin;
	
	public FenetreV2(Engine engine){
		e=engine;
	}
	
	public void run(){             

		frame.setSize(500, 500);      
		
		//panel d'accueil
		JPanel panelAccueil = new JPanel();
		
			//Ajout grille
		monDessin = new AireDeDessin(this,e.partieCourante.map.largeur,e.partieCourante.map.hauteur);
		monDessin.addMouseListener(new EcouteurDeSouris(monDessin));
 		panelAccueil.add(monDessin);
 		
 			//Barre de Menu
		JMenuBar menuBar=new JMenuBar();
		
		JMenu menu1 = new JMenu("Fichier");
		JMenuItem mi1=new JMenuItem("Nouvelle Partie");
			mi1.addActionListener(new EcouteurDeBouton(this,mi1.getText()));
		JMenuItem mi2=new JMenuItem("Sauvegarder");
		JMenuItem mi3=new JMenuItem("Charger");
		JMenuItem mi4=new JMenuItem("Quitter");	
		menu1.add(mi1);
		menu1.add(mi2);
		menu1.add(mi3);
		menu1.add(mi4);
		
		JMenu menu2 = new JMenu("Edition");
		JMenuItem mi5=new JMenuItem("Annuler");
			mi5.addActionListener(new EcouteurDeBouton(this,mi5.getText()));
		JMenuItem mi6=new JMenuItem("Retablir");
			mi6.addActionListener(new EcouteurDeBouton(this,mi6.getText()));
		menu2.add(mi5);
		menu2.add(mi6);
		
		JMenu menu3 = new JMenu("Option");
		JRadioButtonMenuItem jrb1 = new JRadioButtonMenuItem("J vs J");
		JRadioButtonMenuItem jrb2 = new JRadioButtonMenuItem("J vs PC1");
		JRadioButtonMenuItem jrb3 = new JRadioButtonMenuItem("PC1 vs PC2");
		if(e.partieCourante.J1.aiPlayer && e.partieCourante.J2.aiPlayer)
			jrb3.setSelected(true);
		else if(!e.partieCourante.J1.aiPlayer && !e.partieCourante.J2.aiPlayer)
			jrb1.setSelected(true);
		else 
			jrb2.setSelected(true);
		ButtonGroup bg = new ButtonGroup();
		bg.add(jrb1);
		bg.add(jrb2);
		bg.add(jrb3);
		menu3.add(jrb1);
		menu3.add(jrb2);
		menu3.add(jrb3);
		
		JMenu menu4 = new JMenu("Difficulté");
		JRadioButtonMenuItem jrb4 = new JRadioButtonMenuItem("PC1: Facile");
		JRadioButtonMenuItem jrb5 = new JRadioButtonMenuItem("PC1: Moyen");
		JRadioButtonMenuItem jrb6 = new JRadioButtonMenuItem("PC1:Difficile");
		jrb5.setSelected(true);
		ButtonGroup bg2 = new ButtonGroup();
		bg2.add(jrb4);
		bg2.add(jrb5);
		bg2.add(jrb6);	
		JRadioButtonMenuItem jrb7 = new JRadioButtonMenuItem("PC2: Facile");
		JRadioButtonMenuItem jrb8 = new JRadioButtonMenuItem("PC2: Moyen");
		JRadioButtonMenuItem jrb9 = new JRadioButtonMenuItem("PC2:Difficile");
		jrb8.setSelected(true);
		ButtonGroup bg3 = new ButtonGroup();
		bg3.add(jrb7);
		bg3.add(jrb8);
		bg3.add(jrb9);
		
		menu4.add(jrb4);
		menu4.add(jrb5);
		menu4.add(jrb6);
		menu4.add(jrb7);
		menu4.add(jrb8);
		menu4.add(jrb9);
		
		
		
		menuBar.add(menu1);
		menuBar.add(menu2);
		menuBar.add(menu3);
		menuBar.add(menu4);
		
		frame.setJMenuBar(menuBar);
 		frame.add(panelAccueil);  
 		frame.pack();
		frame.setVisible(true);
	}

	public void afficherJeu() {
		monDessin.repaint();
		
	}

	public void afficherVictoire() {
		
	}
}
