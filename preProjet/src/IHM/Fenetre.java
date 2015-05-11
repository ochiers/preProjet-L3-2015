package IHM;

import java.awt.*;
import javax.swing.*;

	 
public class Fenetre implements Runnable {
	public void run(){             
		JFrame frame = new JFrame(" Gaufre Empoisonnée ");
 
		AireDeDessin aire = new AireDeDessin();
		
		frame.add(aire);   
		frame.setSize(500, 500);  
		frame.setVisible(true);
	}
}
