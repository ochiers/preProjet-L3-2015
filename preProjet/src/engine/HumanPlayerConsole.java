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
		System.out.println("Saisir colonne :");
		int x  = s.nextInt();
		System.out.println("Saisir ligne :");
		int y = s.nextInt();
		
		return new Point(x,y);
	}

}
