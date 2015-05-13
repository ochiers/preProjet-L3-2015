package IHM;

import java.awt.*;
import java.awt.event.KeyEvent;

import javax.swing.*;

import AI.*;
import engine.*;

	 
public class FenetreV2 extends Fenetre implements Runnable,Affichage {
	public JFrame frame = new JFrame(" Gaufre Empoisonnée ");
	Engine e;
	AireDeDessin monDessin;
	int pc1;
	int pc2;
	JMenuItem mi5;
	JMenuItem mi6;
	
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
			mi2.addActionListener(new EcouteurDeBouton(this,mi2.getText()));
		JMenuItem mi3=new JMenuItem("Charger");
			mi3.addActionListener(new EcouteurDeBouton(this,mi3.getText()));
		JMenuItem mi4=new JMenuItem("Quitter");	
			mi4.addActionListener(new EcouteurDeBouton(this,mi4.getText()));
		menu1.add(mi1);
		menu1.add(mi2);
		menu1.add(mi3);
		menu1.add(mi4);
		
		JMenu menu2 = new JMenu("Edition");
		mi5=new JMenuItem("Annuler");
			mi5.addActionListener(new EcouteurDeBouton(this,mi5.getText()));
			mi5.setEnabled(false);
		mi6=new JMenuItem("Retablir");
			mi6.addActionListener(new EcouteurDeBouton(this,mi6.getText()));
			mi6.setEnabled(false);
		menu2.add(mi5);
		menu2.add(mi6);
		
		JMenu menu3 = new JMenu("Option");
		JRadioButtonMenuItem jrb1 = new JRadioButtonMenuItem("J1 vs J2");
			jrb1.addActionListener(new EcouteurDeBouton(this,jrb1.getText()));
		JRadioButtonMenuItem jrb2 = new JRadioButtonMenuItem("J1 vs PC1");
			jrb2.addActionListener(new EcouteurDeBouton(this,jrb2.getText()));
		JRadioButtonMenuItem jrb3 = new JRadioButtonMenuItem("PC1 vs PC2");
			jrb3.addActionListener(new EcouteurDeBouton(this,jrb3.getText()));
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
			jrb4.addActionListener(new EcouteurDeBouton(this,jrb4.getText()));
		JRadioButtonMenuItem jrb5 = new JRadioButtonMenuItem("PC1: Moyen");
			jrb5.addActionListener(new EcouteurDeBouton(this,jrb5.getText()));
		JRadioButtonMenuItem jrb6 = new JRadioButtonMenuItem("PC1: Difficile");
			jrb6.addActionListener(new EcouteurDeBouton(this,jrb6.getText()));
		if(jrb2.isSelected()){
			if(e.partieCourante.J1 instanceof EasyAI || e.partieCourante.J2 instanceof EasyAI){
				jrb4.setSelected(true);
				pc1=1;//facile
			}
			else if(e.partieCourante.J1 instanceof MediumAI || e.partieCourante.J2 instanceof MediumAI){
				jrb5.setSelected(true);
				pc1=2;//moyen
			}
			else if(e.partieCourante.J1 instanceof HardAI || e.partieCourante.J2 instanceof HardAI){
				jrb6.setSelected(true);
				pc1=3;//difficile
			}
		}
		else{
			jrb5.setSelected(true); // Moyen Par Defaut
			pc1=2;
		}
		ButtonGroup bg2 = new ButtonGroup();
		bg2.add(jrb4);
		bg2.add(jrb5);
		bg2.add(jrb6);	
		JRadioButtonMenuItem jrb7 = new JRadioButtonMenuItem("PC2: Facile");
			jrb7.addActionListener(new EcouteurDeBouton(this,jrb7.getText()));
		JRadioButtonMenuItem jrb8 = new JRadioButtonMenuItem("PC2: Moyen");
			jrb8.addActionListener(new EcouteurDeBouton(this,jrb8.getText()));
		JRadioButtonMenuItem jrb9 = new JRadioButtonMenuItem("PC2: Difficile");
			jrb9.addActionListener(new EcouteurDeBouton(this,jrb9.getText()));
		if(jrb3.isSelected()){
			if(e.partieCourante.J1 instanceof EasyAI){
				jrb4.setSelected(true);
				pc1=1;
			}
			else if(e.partieCourante.J1 instanceof MediumAI){
				jrb5.setSelected(true);
				pc1=2;
			}
			else if(e.partieCourante.J1 instanceof HardAI){
				jrb6.setSelected(true);
				pc1=3;
			}
			if(e.partieCourante.J2 instanceof EasyAI){
				jrb7.setSelected(true);
				pc2=1;
			}
			else if(e.partieCourante.J2 instanceof MediumAI){
				jrb8.setSelected(true);
				pc2=2;
			}
			else if(e.partieCourante.J2 instanceof HardAI){
				jrb9.setSelected(true);
				pc2=3;
			}
		}
		else{
			jrb8.setSelected(true); //Moyen par defaut
			pc2=2;
		}
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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void afficherJeu() {
		if(e.partieCourante.peutAnnuler())
			mi5.setEnabled(true);
		else
			mi5.setEnabled(false);
		if(e.partieCourante.peutRefaire())
			mi6.setEnabled(true);
		else
			mi6.setEnabled(false);
		
		monDessin.repaint();
		
	}

	public void afficherVictoire() {
		monDessin.fini=true;
	}
}
