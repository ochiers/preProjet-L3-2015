package AI;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import engine.*;

public class HardAI extends Player {
	ArrayList<Point> coupsPossibles;
	
	public HardAI(Engine engine, boolean isAI, String name) {
		super(engine, isAI, name);
		this.coupsPossibles = new ArrayList<Point>();
	}

	public boolean aucuneCaseLibre(Gaufre g){
		for(int i  = 0; i < g.largeur; i++)
			for (int j = 0; j < g.hauteur; j++)
				if(g.grille[i][j] == Gaufre.LIBRE) return false;
		return true;
	}
	
	private void mangerGaufre(Gaufre g, Point caseJouee) {
		for (int i = caseJouee.x; i < g.largeur; i++)
			for (int j = caseJouee.y; j < g.hauteur; j++)
					g.setCase(new Point(i, j), Gaufre.MANGEE);
	}
	
	public boolean evaluation(Gaufre g, boolean typeNoeud){
		boolean b = !typeNoeud;
		if (aucuneCaseLibre(g)) return b;
		else if (typeNoeud) { /* tour de l'IA */
			for(int i  = 0; i < g.largeur; i++){
				for (int j = 0; j < g.hauteur; j++){
					if(g.grille[i][j] == Gaufre.LIBRE){
						Gaufre g2 = new Gaufre(g);
						mangerGaufre(g2, new Point(i,j));
						b = b || evaluation(g2, false);
					}
				}
			}
		}
		else { /* tour de l'adversaire */
			for(int i  = 0; i < g.largeur; i++){
				for (int j = 0; j < g.hauteur; j++){
					if(g.grille[i][j] == Gaufre.LIBRE){
						Gaufre g2 = new Gaufre(g);
						mangerGaufre(g2, new Point(i,j));
						b = b && evaluation(g2, true);
					}
				}
			}
		}
		return b;
	}
	
	@Override
	public Point play() {
		try { /* Sleep pour pouvoir visualiser les coups lors d'une partie entre deux IA */
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Gaufre g = leMoteur.partieCourante.map;
		for(int i = 0; i < g.largeur; i++){
			for (int j = 0; j < g.hauteur; j++){
				//System.out.println("case : " + i + " " + j + " valeur : " + g.grille[i][j]);
				if(g.grille[i][j] == Gaufre.LIBRE){
					Gaufre g2 = new Gaufre(g);
					Point p = new Point(i,j);
					mangerGaufre(g2, p);
					if(evaluation(g2, false)) return p;
				}
			}
		}
		/*Si aucun coup ne nous permet de gagner, on joue au hasard en attendant une éventuelle erreur de l'adversaire */
		Random r = new Random();
		int x = 0;
		int y = 0;
		while(g.grille[x][y] != Gaufre.LIBRE){
			x = r.nextInt(g.largeur);
			y = r.nextInt(g.hauteur);
		}
		return new Point(x,y);
	}
}
