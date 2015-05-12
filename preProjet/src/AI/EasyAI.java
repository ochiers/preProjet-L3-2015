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
		try { /* Sleep pour pouvoir visualiser les coups lors d'une partie entre deux IA */
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new Point(x,y);
	}
}
