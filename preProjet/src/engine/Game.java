package engine;

import java.awt.Point;

import IHM.Fenetre;

public class Game {

	boolean finish;
	Player J1, J2, joueurCourant,winner;
	Gaufre map;
	int numberTurn;
	Fenetre display;

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
			while (caseJouee == null || map.grille[caseJouee.x][caseJouee.y] == Gaufre.EMPOISONNEE || map.grille[caseJouee.x][caseJouee.y] == Gaufre.MANGEE) {
				if (numberTurn % 2 == 0) {
					joueurCourant = J1;
					caseJouee = J1.play();
				} else {
					joueurCourant = J2;
					caseJouee = J2.play();
				}
			}
			mangerGaufre(caseJouee);
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
				if (i != 0 && j != 0)
					this.map.setCase(new Point(i, j), Gaufre.MANGEE);

	}

	private boolean isTerminated() {

		return (map.grille[0][1] == Gaufre.MANGEE && map.grille[1][0] == Gaufre.MANGEE && map.grille[1][1] == Gaufre.MANGEE);
	}

}
