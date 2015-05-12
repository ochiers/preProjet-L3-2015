package preProjet;

import javax.swing.SwingUtilities;

import engine.*;
import IHM.*;
import AI.*;

public class JeuGaufreV2 {
	public static void main(String argv[]) throws InterruptedException{
		
		Engine e=new Engine();
		Player p1=new HumanPlayer(e,false,"player1");
		Player p2=new HumanPlayer(e,false,"player2");
		
		FenetreV2 f=new FenetreV2(e);
		e.setAffichage(f);
		
		e.nouvellePartie(p2, p1, 4, 6);
		SwingUtilities.invokeLater(f);
		Thread.sleep(200);
		e.begin();
	}
}
