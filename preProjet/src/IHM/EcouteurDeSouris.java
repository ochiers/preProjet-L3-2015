package IHM;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import engine.HumanPlayer;

public class EcouteurDeSouris implements MouseListener{
	AireDeDessin aire;
	
	public EcouteurDeSouris(AireDeDessin a){
		aire=a;
	}
	
	public boolean estJouable(){
		
		return true;
	}
	
	public void mouseClicked(MouseEvent e) {
		//if(estJouable()){
			Point p=new Point();
			p.x=1;
			p.y=1;
			if(aire.fenetre.e.partieCourante.joueurCourant.aiPlayer == false){
				((HumanPlayer)aire.fenetre.e.partieCourante.joueurCourant).setCaseJouee(p);
				System.out.println("bonjour");
			}
			else{
				System.out.println("test");
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
