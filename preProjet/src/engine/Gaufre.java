package engine;

import java.awt.Point;

public class Gaufre {
	
	public static final int EMPOISONNEE = 0;
	public static final int LIBRE = 1;
	public static final int MANGEE = 2;
	public final int hauteur;
	public final int largeur;
	public final int[][] grille;
	
	public Gaufre(int tailleLargeur, int tailleHauteur){	
		this.grille = new int[tailleLargeur][tailleHauteur];
		this.hauteur = tailleHauteur;
		this.largeur = tailleLargeur;
		initialisation();
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

}
