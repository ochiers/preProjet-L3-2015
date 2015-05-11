package engine;

public class Engine {

	boolean gameInProgress;
	Game partieCourante;
	public Engine() {
		this.gameInProgress = false;
	}

	public void begin(){
		
		while(true) //On suppose que c'est l'IHM qui tue le thread
		{
			if
		}
	}
	
	
	public void nouvellePartie(Player p1, Player p2, int largeur, int hauteur)
	{
		this.partieCourante = new Game(largeur, hauteur, p1, p2);
	}
}
