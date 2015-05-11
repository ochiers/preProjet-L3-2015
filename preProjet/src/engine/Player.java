package engine;

import java.awt.Point;

public abstract class Player {
	
	boolean aiPlayer;
	public String name;
	
	public Player(boolean isAI, String name)
	{
		this.aiPlayer = isAI;
		this.name = name;
	}

	public abstract Point play();
}
