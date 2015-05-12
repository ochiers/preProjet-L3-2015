package engine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import AI.EasyAI;
import AI.HardAI;
import AI.MediumAI;
import IHM.Fenetre;

public class Engine {

	public boolean gameInProgress;
	public Game partieCourante;
	public Fenetre f;
	public Engine(Fenetre f) {
		this.gameInProgress = false;
		this.f=f;
	}

	public void begin() {

		while (true) // On suppose que c'est l'IHM qui tue le thread
		{
			while (!gameInProgress)
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			partieCourante.jouer();
			//
			// AFFICHER LA VICTOIRE ICI
			//
			gameInProgress = false;
		}
	}

	public void nouvellePartie(Fenetre f, Player p1, Player p2, int largeur, int hauteur) {
		this.gameInProgress = true;
		this.partieCourante = new Game(f, largeur, hauteur, p1, p2);
	}

	public static void main(String args[]) {
		Engine e = new Engine(new Fenetre());
		e.nouvellePartie(e.f, new EasyAI(e, true, "J1"), new MediumAI(e, true, "J2"), 10, 6);
		e.sauvegarderPartie("./partie.txt");
		e.begin();

	}

	public void sauvegarderPartie(String path) {

		File fichier = new File(path);
		try {
			FileWriter w = new FileWriter(fichier);
			String str = partieCourante.J1.toString() + "#" + partieCourante.J1.getClass().getSimpleName() + "\n";
			str += partieCourante.J2.toString() + "#" + partieCourante.J2.getClass().getSimpleName() + "\n";

			if (partieCourante.joueurCourant == partieCourante.J1)
				str += 1 + "\n";
			else
				str += 2 + "\n";

			str += partieCourante.numberTurn + "\n";
			str += partieCourante.map.largeur + "\n" + partieCourante.map.hauteur;
			for (int i = 0; i < partieCourante.map.hauteur; i++) {
				str += "\n";
				for (int j = 0; j < partieCourante.map.largeur; j++)
					str += partieCourante.map.grille[j][i] + " ";
			}
			w.write(str);
			w.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void chargerPartie(String path) {

		File fichier = new File(path);
		try {
			Scanner s = new Scanner(fichier);
			String j1 = s.nextLine();
			String j2 = s.nextLine();
			int jcour = Integer.parseInt(s.nextLine());
			int largeur = Integer.parseInt(s.nextLine());
			int hauteur = Integer.parseInt(s.nextLine());
			int map[][] = new int[largeur][hauteur];
			for (int i = 0; i < hauteur; i++) {
				String[] str = s.nextLine().split(" ");
				for (int j = 0; j < largeur; j++) {
					map[j][i] = Integer.parseInt(str[j]);
				}
			}
			Player p1 = parsePlayer(j1);
			Player p2 = parsePlayer(j2);
			Game g = new Game(f, largeur, hauteur, p1, p2);
			g.joueurCourant = (jcour == 1) ? p1 : p2;  
			g.map.grille = map;
			
		} catch (Exception e) {
			System.err.println("Fichier corrompu");
			e.printStackTrace();
		}

	}

	public Player parsePlayer(String str) {
		Player res = null;
		String[] a = str.split("#");
		if (a[2].equals("EasyAI"))
			res = new EasyAI(this, true, a[1]);
		else if (a[2].equals("MediumAI"))
			res = new MediumAI(this, true, a[1]);
		/*
		 * else if (a[2].equals("HardAI")) res = new HardAI(this, true, a[1]);
		 */
		else if (a[2].equals("HumanPlayer"))
			res = new HumanPlayer(this, false, a[1]);
		else if (a[2].equals("HumanPlayerConsole"))
			res = new HumanPlayerConsole(this, false, a[1]);

		return res;

	}
}
