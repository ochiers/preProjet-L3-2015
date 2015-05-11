package engine;

import IHM.Fenetre;

public class Engine {

	boolean gameInProgress;
	Game partieCourante;
	public Engine() {
		this.gameInProgress = false;
	}

	public void begin(){
		
		while(true) //On suppose que c'est l'IHM qui tue le thread
		{
			while(!gameInProgress)
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			partieCourante.jouer();
			//
			//AFFICHER LA VICTOIRE ICI 
			//
			gameInProgress = false;
		}
	}
	
	
	public void nouvellePartie(Fenetre f, Player p1, Player p2, int largeur, int hauteur)
	{
		this.gameInProgress = true;
		this.partieCourante = new Game(f,largeur, hauteur, p1, p2);
	}
}
