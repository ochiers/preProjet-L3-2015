package preProjet;

import javax.swing.SwingUtilities;

import engine.*;
import IHM.*;
import AI.*;

public class JeuGaufreV2 {
	public static void main(String argv[]) throws InterruptedException{
		
		Engine e=new Engine();
		HardAI p1=new HardAI(e,true,"player1");
		MediumAI p2=new MediumAI(e,true,"player2");
	//	HumanPlayer p1=new HumanPlayer(e,false,"Player1");
	//	HumanPlayer p2=new HumanPlayer(e,false,"Player2");
		FenetreV2 f=new FenetreV2(e);
		e.setAffichage(f);
		
		e.nouvellePartie(p1, p2, 4, 6);
		SwingUtilities.invokeLater(f);
		Thread.sleep(200);
		e.begin();
	}
}
