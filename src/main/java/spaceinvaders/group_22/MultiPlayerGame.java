package spaceinvaders.group_22;

import java.util.ArrayList;

public class MultiPlayerGame extends Game {
	
	private ArrayList<Player> players = new ArrayList<Player>();
	private MultiPlayerPowerUpController powerUpController;

	public MultiPlayerGame(final double width, final double height) {
		super(width, height);
		players.add(new Player(this, getCanvasWidth() / 3));
		players.add(new Player(this, 2 * getCanvasWidth() / 3));
		powerUpController = new MultiPlayerPowerUpController(this);
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	@Override
	public final MultiPlayerPowerUpController getPowerUpController() {
		return powerUpController;
	}

}
