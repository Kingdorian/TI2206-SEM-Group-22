package spaceinvaders.group_22;

import java.util.ArrayList;

public class MultiPlayerGame extends Game {
	
	private ArrayList<Player> players;

	public MultiPlayerGame(final double width, final double height) {
		super(width, height);
		
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

}
