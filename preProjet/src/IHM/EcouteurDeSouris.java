package IHM;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import engine.HumanPlayer;

public class EcouteurDeSouris implements MouseListener{
	AireDeDessin aire;
	
	public EcouteurDeSouris(AireDeDessin a){
		aire=a;
	}
	
	
	
	public void mouseClicked(MouseEvent e) {
		
		Point p=new Point();
		p=aire.conversionGrille(e.getX(),e.getY());	
			if(aire.fenetre.e.partieCourante.joueurCourant.aiPlayer == false){
				((HumanPlayer)aire.fenetre.e.partieCourante.joueurCourant).setCaseJouee(p);
			}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}

}
