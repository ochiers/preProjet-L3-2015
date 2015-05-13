package engine;

import java.awt.Point;

import IHM.Affichage;

public class Game {

	public boolean finish;
	public boolean stopped;
	public Player J1, J2, joueurCourant, winner;
	public Gaufre map;
	public int numberTurn;
	public Affichage display;
	private UndoRedo<Gaufre> annuler_refaire;

	public Game(Affichage f, int largeur, int hauteur, Player j1, Player j2) {
		this.finish = false;
		this.J1 = j1;
		this.J2 = j2;
		this.joueurCourant = j1;
		this.map = new Gaufre(largeur, hauteur);
		this.numberTurn = 0;
		display = f;
		annuler_refaire = new UndoRedo<Gaufre>();
	}

	public void jouer() {

		while (!finish && !stopped) {
			Point caseJouee = null;
			annuler_refaire.addItem(new Gaufre(map));
			while (!stopped && isCaseInvalide(caseJouee)) {

				if (numberTurn % 2 == 0) {
					joueurCourant = J1;
					caseJouee = J1.play();
				} else {
					joueurCourant = J2;
					caseJouee = J2.play();
				}
			}
			mangerGaufre(caseJouee);
			display.afficherJeu();
			numberTurn++;
			finish = isTerminated();

		}
		if (!stopped) {
			System.out.print(joueurCourant.toString() + "a gagné");

			if (numberTurn % 2 == 0)
				winner = J1;
			else
				winner = J2;
		}
	}

	private void mangerGaufre(Point caseJouee) {

		for (int i = caseJouee.x; i < this.map.largeur; i++)
			for (int j = caseJouee.y; j < this.map.hauteur; j++)
				this.map.setCase(new Point(i, j), Gaufre.MANGEE);

	}

	private boolean isTerminated() {

		return (map.grille[0][1] == Gaufre.MANGEE && map.grille[1][0] == Gaufre.MANGEE && map.grille[1][1] == Gaufre.MANGEE);
	}

	private boolean isCaseInvalide(Point c) {

		return c == null || c.x < 0 || c.y < 0 || c.x >= this.map.largeur || c.y >= this.map.hauteur || map.grille[c.x][c.y] == Gaufre.EMPOISONNEE || map.grille[c.x][c.y] == Gaufre.MANGEE;
	}

	public void annuler() {

		this.map = annuler_refaire.undo();
		if (joueurCourant instanceof HumanPlayer)
			((HumanPlayer) joueurCourant).setCaseJouee(new Point(0, 0));
		if (joueurCourant == J2)
			joueurCourant = J1;
		else
			joueurCourant = J2;
		numberTurn--;
		display.afficherJeu();
	}

	public void refaire() {
		this.map = annuler_refaire.redo();
		if (joueurCourant instanceof HumanPlayer)
			((HumanPlayer) joueurCourant).setCaseJouee(new Point(0, 0));
		if (joueurCourant == J2)
			joueurCourant = J1;
		else
			joueurCourant = J2;
		numberTurn++;
		display.afficherJeu();
	}

	public boolean peutRefaire() {
		return annuler_refaire.canRedo();
	}

	public boolean peutAnnuler() {
		return annuler_refaire.canUndo();
	}

}
