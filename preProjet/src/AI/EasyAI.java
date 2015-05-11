package AI;

import java.awt.Point;
import java.util.Random;

import engine.Engine;
import engine.Gaufre;
import engine.Player;

public class EasyAI extends Player {
	
	public EasyAI(Engine engine, boolean isAI, String name) {
		super(engine, isAI, name);
	}

	@Override
	public Point play(){
		Random r = new Random();
		int x = 0;
		int y = 0;
		Gaufre g = leMoteur.partieCourante.map;
		while(g.grille[x][y] != Gaufre.LIBRE){
			x = r.nextInt(g.largeur);
			y = r.nextInt(g.hauteur);
		}
		
		return new Point(x,y);
	}
}
