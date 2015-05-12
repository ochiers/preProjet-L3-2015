package engine;

import java.awt.Point;

import IHM.Fenetre;

public class Game {

	public boolean finish;
	public Player J1, J2, joueurCourant,winner;
	public Gaufre map;
	public int numberTurn;
	public Fenetre display;

	public Game(Fenetre f, int largeur, int hauteur, Player j1, Player j2) {
		this.finish = false;
		this.J1 = j1;
		this.J2 = j2;
		this.map = new Gaufre(largeur, hauteur);
		this.numberTurn = 0;
		display = f;
	}

	public void jouer() {

		while (!finish) {
			Point caseJouee = null;
			while (isCaseInvalide(caseJouee)) {

				if (numberTurn % 2 == 0) {
					joueurCourant = J1;
					caseJouee = J1.play();
				} else {
					joueurCourant = J2;
					caseJouee = J2.play();
				}
			}
			System.out.println(caseJouee);
			mangerGaufre(caseJouee);
			//display.repaint();
			numberTurn++;
			finish = isTerminated();

		}
		//display.frame.repaint();
		System.out.print(joueurCourant.toString());
		
		if (numberTurn % 2 == 0)
			winner = J1;
		else
			winner = J2;
	}

	private void mangerGaufre(Point caseJouee) {

		for (int i = caseJouee.x; i < this.map.largeur; i++)
			for (int j = caseJouee.y; j < this.map.hauteur; j++)
					this.map.setCase(new Point(i, j), Gaufre.MANGEE);

	}

	private boolean isTerminated() {

		return (map.grille[0][1] == Gaufre.MANGEE && map.grille[1][0] == Gaufre.MANGEE && map.grille[1][1] == Gaufre.MANGEE);
	}
	
	private boolean isCaseInvalide(Point c){
		
		return c == null || c.x <  0 || c.y < 0 || c.x >= this.map.largeur || c.y >= this.map.hauteur || map.grille[c.x][c.y] == Gaufre.EMPOISONNEE || map.grille[c.x][c.y] == Gaufre.MANGEE;
	}
}
