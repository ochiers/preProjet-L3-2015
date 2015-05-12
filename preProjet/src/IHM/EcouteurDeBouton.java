package IHM;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import engine.HumanPlayer;

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
			fenetre.e.nouvellePartie( new HumanPlayer(fenetre.e,false,"player1"), new HumanPlayer(fenetre.e,false,"player2"), fenetre.e.partieCourante.map.largeur, fenetre.e.partieCourante.map.hauteur);

			String message="C'est au tour de  de jouer";
			System.out.println(message);
			fenetre.monDessin.repaint();
			break;
		case "Annuler":
			fenetre.e.partieCourante.annuler();
			fenetre.monDessin.repaint();
			break;
		case "Retablir":
			fenetre.e.partieCourante.refaire();
			fenetre.monDessin.repaint();
			break;
		default:
			break;
		}
	}

}
