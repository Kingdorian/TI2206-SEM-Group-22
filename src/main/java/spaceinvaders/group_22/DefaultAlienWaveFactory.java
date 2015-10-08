package spaceinvaders.group_22;

import java.util.ArrayList;

import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.unit.Alien;

public class DefaultAlienWaveFactory implements AlienWaveFactoryInterface{
	/**
	 * Part of the screen (on left and right) that cannot be used when creating aliens. 
	 */
	static final double ALIENBORDERMARIGIN = 0.15;
	/**
	 * Amount of aliens per row.
	 */
	static final int ALIENS_PER_ROW = 10;
	/**
	 * Amount of rows of aliens.
	 */
	static final int AMOUNT_ALIEN_ROWS = 4;
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
        double interval = ((game.getCanvasWidth() - (2 * ALIENBORDERMARIGIN * game.getCanvasWidth()))
        						- (ALIENS_PER_ROW * testAlien.getWidth())) / (ALIENS_PER_ROW + 1);  

        // Drawing lines of Aliens.
        for (int i = 0; i < AMOUNT_ALIEN_ROWS; i++) {
            double startPosition = ALIENBORDERMARIGIN * game.getCanvasWidth() + 0.5 * testAlien.getWidth();
            for (int j = 0; j < ALIENS_PER_ROW; j++) {
            	Alien alien = new Alien(startPosition, distance, "invader.png");
            	Game.getLogger().log("Created Alien", LogEvent.Type.TRACE);
            	alien.setVelX(alienVelX);
            	aliens.add(alien);
            	startPosition += testAlien.getWidth() + interval;
            }
            distance += 1.1 * testAlien.getHeight();
        }
        return wave;
	}
}
