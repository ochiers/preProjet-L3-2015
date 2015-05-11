package AI;

import java.awt.Point;
import java.util.Random;

import engine.Gaufre;
import engine.Player;

public class MediumAI extends Player {
	
	public MediumAI(Gaufre gaufre, boolean isAI, String name) {
		super(gaufre, isAI, name);
	}

	/* Si il existe un coup gagnant, renvoie le point sur lequel jouer pour gagner */
	public Point coupGagnant(){
		if(laGaufre.grille[0][1] == Gaufre.LIBRE && laGaufre.grille[1][0] == Gaufre.MANGEE){
			return new Point(0,1);
		}
		if(laGaufre.grille[1][0] == Gaufre.LIBRE && laGaufre.grille[0][1] == Gaufre.MANGEE){
			return new Point(1,0);
		}
		return null;
	}
	
	/* Teste si jouer sur le point (x,y) est le "meilleur" coup possible*/
	public boolean existeMeilleurCoup(int x, int y){
		if(x > 1 || y > 1)
			return false;
		else {
			if(x == 1 && y == 0 && laGaufre.grille[0][1] == Gaufre.LIBRE){
				return true;
			}	
			if(x == 0 && y == 1 && laGaufre.grille[1][0] == Gaufre.LIBRE){
				return true;
			}
			/* On cherche une case libre autre que les 2 cases adjacentes au poison. Si on la trouve, c'est qu'il reste un coup non perdant donc on ne joue pas le coup qu'on teste */
			for(int i = 0; i< laGaufre.largeur; i++){
				for(int j = 0; j<laGaufre.hauteur; j++){
					if((i != 0 && j != 1) || (i != 1 && j != 0))
						return true;
				}
			}
			return false;
		}
	}
	
	@Override
	public Point play(){
		Random r = new Random();
		int x = 0;
		int y = 0;
		Point res = coupGagnant();
		if(res != null) return res;
		while(laGaufre.grille[x][y] != 0 && existeMeilleurCoup(x,y)){
			x = r.nextInt(laGaufre.largeur);
			y = r.nextInt(laGaufre.hauteur);
		}
		
		return new Point(x,y);
	}
}
