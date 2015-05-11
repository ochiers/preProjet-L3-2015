package engine;

import java.awt.Point;

public abstract class Player {
	
	boolean aiPlayer;
	public String name;
	public Gaufre laGaufre;
	public Player(Gaufre gaufre, boolean isAI, String name)
	{
		this.aiPlayer = isAI;
		this.name = name;
		this.laGaufre = gaufre;
	}

	public abstract Point play();
}
