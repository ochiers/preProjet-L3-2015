package preProjet;

import javax.swing.SwingUtilities;

import engine.*;
import IHM.*;
import AI.*;

public class JeuGaufreV2 {
	public static void main(String argv[]){
		
		Engine e=new Engine();
		HardAI p1=new HardAI(e,true,"player1");
		HumanPlayer p2=new HumanPlayer(e,false,"player2");
		
		FenetreV2 f=new FenetreV2(e);
		e.setAffichage(f);
		
		e.nouvellePartie(p2, p1, 4, 6);
		SwingUtilities.invokeLater(f);
		e.begin();
	}
}
