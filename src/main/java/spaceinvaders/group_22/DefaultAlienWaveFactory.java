package spaceinvaders.group_22;

import java.util.ArrayList;

import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.unit.Alien;

public class DefaultAlienWaveFactory implements AlienWaveFactoryInterface{
	/**
	 * Speed of the aliens in the X direction in pixels per second.
	 */
	private double alienVelX = 40;
	Game game;
	
	
	public DefaultAlienWaveFactory (final Game setGame) {
		game = setGame;
	}
	public final AlienWave createWave() {
		ConcreteAlienWave wave = new ConcreteAlienWave();
		ArrayList<Alien> aliens = new ArrayList<Alien>();
		
		 // Distance to top of the screen.
        double distance = 125;
        // Create alien object to make sure we can get the width and height of aliens
        Alien testAlien = new Alien(0.0, 0.0, Alien.SPRITE); 
        double interval = ((game.getCanvasWidth() - (2 * AlienController.ALIENBORDERMARIGIN * game.getCanvasWidth()))
        						- (AlienController.ALIENS_PER_ROW * testAlien.getWidth())) / (AlienController.ALIENS_PER_ROW + 1);  

        // Drawing lines of Aliens.
        for (int i = 0; i < AlienController.AMOUNT_ALIEN_ROWS; i++) {
            double startPosition = AlienController.ALIENBORDERMARIGIN * game.getCanvasWidth() + 0.5 * testAlien.getWidth();
            for (int j = 0; j < AlienController.ALIENS_PER_ROW; j++) {
            	Alien alien = new Alien(startPosition, distance, "invader.png");
            	Game.getLogger().log("Created Alien", LogEvent.Type.TRACE);
            	alien.setVelX(alienVelX);
            	aliens.add(alien);
            	startPosition += testAlien.getWidth() + interval;
            }
            distance += 1.1 * testAlien.getHeight();
        }
        alienVelX+= AlienController.ALIENVELXINCREASE;
        return wave;
	}
}
