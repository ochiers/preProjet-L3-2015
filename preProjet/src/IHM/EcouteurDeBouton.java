package IHM;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
			//fenetre.e.nouvellePartie(fenetre, p1, p2, fenetre.e.partieCourante.map.largeur, fenetre.e.partieCourante.map.hauteur);
			break;
		default:
			break;
		}
	}

}
