package AI;

import java.awt.Point;
import java.util.Random;
import engine.*;

public class MediumAI extends Player {
	
	public MediumAI(Engine engine, boolean isAI, String name) {
		super(engine, isAI, name);
	}

	/* Si il existe un coup gagnant, renvoie le point sur lequel jouer pour gagner */
	public Point coupGagnant(){
		Gaufre laGaufre = leMoteur.partieCourante.map;
		if(laGaufre.grille[0][1] == Gaufre.LIBRE && laGaufre.grille[1][0] == Gaufre.MANGEE){
			return new Point(0,1);
		}
		if(laGaufre.grille[1][0] == Gaufre.LIBRE && laGaufre.grille[0][1] == Gaufre.MANGEE){
			return new Point(1,0);
		}
		return null;
	}
	
	/* Teste si il existe un "meilleur" coup que jouer sur le point (x,y) */
	public boolean existeMeilleurCoup(int x, int y){
		Gaufre laGaufre = leMoteur.partieCourante.map;
		if(((x == 1 && y == 0) || (x == 0 && y == 1)) && laGaufre.grille[y][x] == Gaufre.LIBRE){
			/* On cherche une case libre autre que les 2 cases adjacentes au poison. Si on la trouve, c'est qu'il reste un coup non perdant donc on ne joue pas le coup qu'on teste */
			for(int i = 0; i < laGaufre.largeur; i++){
				for(int j = 0; j < laGaufre.hauteur; j++){
					if(i >= 1 && j >= 1 && laGaufre.grille[i][j] == Gaufre.LIBRE)
						return true;
				}
			}			
		}
		return false;
	}
	
	@Override
	public Point play(){
		Gaufre laGaufre = leMoteur.partieCourante.map;
		Random r = new Random();
		int x = 0;
		int y = 0;
		Point res = coupGagnant();
		if(res != null) return res;
		while(laGaufre.grille[x][y] != Gaufre.LIBRE || existeMeilleurCoup(x,y)){
			x = r.nextInt(laGaufre.largeur);
			y = r.nextInt(laGaufre.hauteur);
		}
		
		return new Point(x,y);
	}
}
