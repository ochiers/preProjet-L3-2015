package engine;

import java.awt.Point;

public class HumanPlayer extends Player {

	private boolean hasPlayed;
	private Point caseJouee;

	public HumanPlayer(Gaufre gaufre, boolean isAI, String name) {
		super(gaufre, isAI, name);
		hasPlayed = false;
	}

	@Override
	public Point play() {
		hasPlayed = false;
		caseJouee = null;
		while (!hasPlayed && caseJouee == null) {
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return caseJouee;
	}
	public void setCaseJouee(Point p){
		this.caseJouee = p;
		this.hasPlayed = true;
	}
}
