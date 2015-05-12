package engine;

import java.awt.Point;
import java.util.Scanner;

public class HumanPlayerConsole extends Player {

	public HumanPlayerConsole(Engine gaufre, boolean isAI, String name) {
		super(gaufre, isAI, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Point play() {

		Scanner s = new Scanner(System.in);
		System.out.println("A " + name + " de jouer");
		System.out.println("\tAnnuler : 0");
		System.out.println("\tRefaire : 1");
		System.out.println("\tMANGER ! : 2");
		System.out.println("\tQuitter : 10");
		int a = s.nextInt();
		switch (a) {
		case 0:
			leMoteur.partieCourante.annuler();break;

		case 1:
			leMoteur.partieCourante.refaire();break;

		case 2:break;
		case 10:
			System.exit(0);
		}
		System.out.println("Saisir colonne :");
		int x = s.nextInt();
		System.out.println("Saisir ligne :");
		int y = s.nextInt();
		

		return new Point(x, y);
	}

}
