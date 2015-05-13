package IHM;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

import engine.*;
import AI.*;

public class EcouteurDeBouton implements ActionListener{
	String label;
	FenetreV2 fenetre;
	
	public EcouteurDeBouton(FenetreV2 f,String lab){
		label=lab;
		fenetre=f;
	}
	
	public void actionPerformed(ActionEvent e) {
		switch (label){
		case "Nouvelle Partie":
			fenetre.e.nouvellePartie( fenetre.e.partieCourante.J1, fenetre.e.partieCourante.J2, fenetre.e.partieCourante.map.largeur, fenetre.e.partieCourante.map.hauteur);
			fenetre.monDessin.repaint();
			break;
		case "Sauvegarder":
			JFileChooser save = new JFileChooser();
			save.showSaveDialog(fenetre.frame);
			fenetre.e.sauvegarderPartie(save.getSelectedFile().getAbsolutePath());
			break;
		case "Charger":
			JFileChooser load = new JFileChooser();
			load.showOpenDialog(fenetre.frame);
			fenetre.e.chargerPartie(load.getSelectedFile().getAbsolutePath());
			break;
		case "Quitter":
			System.exit(0);
			break;
		case "Annuler":
			fenetre.e.partieCourante.annuler();
			fenetre.monDessin.repaint();
			break;
		case "Retablir":
			fenetre.e.partieCourante.refaire();
			fenetre.monDessin.repaint();
			break;
		case "J1 vs J2":
			fenetre.e.nouvellePartie( new HumanPlayer(fenetre.e,false,"Player1"), new HumanPlayer(fenetre.e,false,"Player2"), fenetre.e.partieCourante.map.largeur, fenetre.e.partieCourante.map.hauteur);
			fenetre.monDessin.repaint();
			break;
		case "J1 vs PC1":
			if(fenetre.pc1==1)
				fenetre.e.nouvellePartie( new HumanPlayer(fenetre.e,false,"Player1"), new EasyAI(fenetre.e,true,"Player2"), fenetre.e.partieCourante.map.largeur, fenetre.e.partieCourante.map.hauteur);
			else if(fenetre.pc1==2)
				fenetre.e.nouvellePartie( new HumanPlayer(fenetre.e,false,"Player1"), new MediumAI(fenetre.e,true,"Player2"), fenetre.e.partieCourante.map.largeur, fenetre.e.partieCourante.map.hauteur);
			else if(fenetre.pc1==3)
				fenetre.e.nouvellePartie( new HumanPlayer(fenetre.e,false,"Player1"), new HardAI(fenetre.e,true,"Player2"), fenetre.e.partieCourante.map.largeur, fenetre.e.partieCourante.map.hauteur);
			fenetre.monDessin.repaint();
			break;
		case "PC1 vs PC2":
			System.out.println("pc1 = " +fenetre.pc1+ " et pc2 = " + fenetre.pc2);
			if(fenetre.pc1==1 && fenetre.pc2==1)
				fenetre.e.nouvellePartie( new EasyAI(fenetre.e,true,"Player1"), new EasyAI(fenetre.e,true,"Player2"), fenetre.e.partieCourante.map.largeur, fenetre.e.partieCourante.map.hauteur);
			else if(fenetre.pc1==2 && fenetre.pc2==1)
				fenetre.e.nouvellePartie( new MediumAI(fenetre.e,true,"Player1"), new EasyAI(fenetre.e,true,"Player2"), fenetre.e.partieCourante.map.largeur, fenetre.e.partieCourante.map.hauteur);
			else if(fenetre.pc1==3 && fenetre.pc2==1)
				fenetre.e.nouvellePartie( new HardAI(fenetre.e,true,"Player1"), new EasyAI(fenetre.e,true,"Player2"), fenetre.e.partieCourante.map.largeur, fenetre.e.partieCourante.map.hauteur);
			if(fenetre.pc1==1 && fenetre.pc2==2)
				fenetre.e.nouvellePartie( new EasyAI(fenetre.e,true,"Player1"), new MediumAI(fenetre.e,true,"Player2"), fenetre.e.partieCourante.map.largeur, fenetre.e.partieCourante.map.hauteur);
			else if(fenetre.pc1==2 && fenetre.pc2==2)
				fenetre.e.nouvellePartie( new MediumAI(fenetre.e,true,"Player1"), new MediumAI(fenetre.e,true,"Player2"), fenetre.e.partieCourante.map.largeur, fenetre.e.partieCourante.map.hauteur);
			else if(fenetre.pc1==3 && fenetre.pc2==2)
				fenetre.e.nouvellePartie( new HardAI(fenetre.e,true,"Player1"), new MediumAI(fenetre.e,true,"Player2"), fenetre.e.partieCourante.map.largeur, fenetre.e.partieCourante.map.hauteur);
			if(fenetre.pc1==1 && fenetre.pc2==3)
				fenetre.e.nouvellePartie( new EasyAI(fenetre.e,true,"Player1"), new HardAI(fenetre.e,true,"Player2"), fenetre.e.partieCourante.map.largeur, fenetre.e.partieCourante.map.hauteur);
			else if(fenetre.pc1==2 && fenetre.pc2==3)
				fenetre.e.nouvellePartie( new MediumAI(fenetre.e,true,"Player1"), new HardAI(fenetre.e,true,"Player2"), fenetre.e.partieCourante.map.largeur, fenetre.e.partieCourante.map.hauteur);
			else if(fenetre.pc1==3 && fenetre.pc2==3)
				fenetre.e.nouvellePartie( new HardAI(fenetre.e,true,"Player1"), new HardAI(fenetre.e,true,"Player2"), fenetre.e.partieCourante.map.largeur, fenetre.e.partieCourante.map.hauteur);
			fenetre.monDessin.repaint();
			break;

		case "PC1: Facile":
			fenetre.pc1=1;
			break;
		case "PC1: Moyen":
			fenetre.pc1=2;
			break;
		case "PC1: Difficile":
			fenetre.pc1=3;
			break;
		case "PC2: Facile":
			fenetre.pc2=1;
			break;
		case "PC2: Moyen":
			fenetre.pc2=2;
			break;
		case "PC2: Difficile":
			fenetre.pc2=3;
			break;

		default:
			break;
		}
	}

}
