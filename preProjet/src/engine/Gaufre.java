package engine;

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
		
	}



}
