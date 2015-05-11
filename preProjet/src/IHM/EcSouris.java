package IHM;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EcSouris implements MouseListener{
	    
	    public EcSouris(int n) {
	    	//...
	    	System.out.println("ok Ec");
	    }

	    public void mouseClicked(MouseEvent e) {
	    	//...
	    	System.out.println("ok cliqué");
	    }

	    // Il faut aussi une implementation pour les autres methodes de l'interface
	    public void mouseEntered(MouseEvent e) {}
	    public void mouseExited(MouseEvent e) {}
	    public void mousePressed(MouseEvent e) {}
	    public void mouseReleased(MouseEvent e) {}	
}
