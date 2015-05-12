package engine;

import java.awt.Point;

public class HumanPlayer extends Player {

	private boolean hasPlayed;
	private Point caseJouee;

	public HumanPlayer(Engine moteur, boolean isAI, String name) {
		super(moteur, isAI, name);
		hasPlayed = false;
	}

	@Override
	public Point play() {
		hasPlayed = false;
		caseJouee = null;
		while (!hasPlayed && caseJouee == null) {
			try {
				//System.out.println(name + " attend");
				Thread.sleep(50);
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
