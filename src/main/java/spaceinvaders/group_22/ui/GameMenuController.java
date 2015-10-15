package spaceinvaders.group_22.ui;

import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.logger.Logger;

public class GameMenuController {
	
	public void startSinglePlayer() {
		Logger.getInstance().log("Starting a singleplayer game", LogEvent.Type.DEBUG);
	}
	public void startMultiPlayer() {
		Logger.getInstance().log("Starting a multiplayer game", LogEvent.Type.DEBUG);
	}
	public void quit() {
		Logger.getInstance().log("Quitting game", LogEvent.Type.DEBUG);
	}
}
