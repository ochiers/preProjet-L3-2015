package AI;

import java.awt.Point;
import java.util.Random;

import engine.Gaufre;
import engine.Player;

public class EasyAI extends Player {
	
	public EasyAI(Gaufre gaufre, boolean isAI, String name) {
		super(gaufre, isAI, name);
	}

	@Override
	public Point play(){
		Random r = new Random();
		int x = 0;
		int y = 0;
		while(laGaufre.grille[x][y] != Gaufre.LIBRE){
			x = r.nextInt(laGaufre.largeur);
			y = r.nextInt(laGaufre.hauteur);
		}
		
		return new Point(x,y);
	}
}
