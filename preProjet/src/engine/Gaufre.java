package engine;

import java.awt.Point;

public class Gaufre {
	
	public static final int EMPOISONNEE = 0;
	public static final int LIBRE = 1;
	public static final int MANGEE = 2;
	public final int hauteur;
	public final int largeur;
	public int[][] grille;
	
	public Gaufre(int tailleLargeur, int tailleHauteur){	
		this.grille = new int[tailleLargeur][tailleHauteur];
		this.hauteur = tailleHauteur;
		this.largeur = tailleLargeur;
		initialisation();
	}
	
	public Gaufre(Gaufre g)
	{
		this.hauteur = g.hauteur;
		this.largeur = g.largeur;
		this.grille = new int[largeur][hauteur];
		for(int i  = 0; i < this.largeur; i++)
			for (int j = 0; j < this.hauteur; j++)
				this.grille[i][j] = g.grille[i][j];
	}
	
	public void initialisation() {
		for(int i  = 0; i < this.largeur; i++)
			for (int j = 0; j < this.hauteur; j++)
				this.grille[i][j] = Gaufre.LIBRE;
		this.grille[0][0] = Gaufre.EMPOISONNEE; // Mise en place de la case empoisonnée en position (0,0)	
	}
	
	public void setCase(Point laCase, int etat)
	{
		if(laCase.x < 0 || laCase.x >= largeur || laCase.y < 0 || laCase.y >= hauteur || etat > 2 || etat < 0)
			System.err.println("Case " + laCase + " invalide, ou etat " + etat + " invalide");
		else
			this.grille[laCase.x][laCase.y] = etat;
	}
	
	public String toString(){
		
		String res = "Gaufre :";
		for(int i = 0; i<hauteur;i++){
			res = res +"\n";
			for(int j = 0 ; j<largeur;j++)
				res = res + " " + grille[j][i] + " |";
		}
		return res;
	}

}
