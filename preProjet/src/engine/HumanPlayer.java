package engine;

import java.awt.Point;

public class HumanPlayer extends Player {

	boolean hasPlayed;
	Point caseJouee;

	public HumanPlayer(Gaufre gaufre, boolean isAI, String name) {
		super(gaufre, isAI, name);
		hasPlayed = false;
	}

	@Override
	public Point play() {
		hasPlayed = false;
		caseJouee = null;
		while (!hasPlayed) {
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return caseJouee;
	}

}
