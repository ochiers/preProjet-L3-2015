package preProjet;

import javax.swing.SwingUtilities;

import engine.*;
import IHM.*;
import AI.*;

public class JeuGaufreV2 {
	public static void main(String argv[]){
		
		Engine e=new Engine();
		HumanPlayer p1=new HumanPlayer(e,false,"player1");
		HumanPlayer p2=new HumanPlayer(e,false,"player2");
		FenetreV2 f=new FenetreV2(e);
		e.nouvellePartie(f, p1, p2, 7, 5);
		SwingUtilities.invokeLater(f);
	}
}
