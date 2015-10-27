package spaceinvaders.group_22;

import java.util.ArrayList;

import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.logger.Logger;
import spaceinvaders.group_22.unit.Alien;
import spaceinvaders.group_22.unit.NormalAlien;
/**
 * Default alien wave factory to create a default alien wave.
 * @author Bryan and Dorian
 *
 */
public class DefaultAlienWaveFactory implements AlienWaveFactoryInterface {
	/**
	 * Game object to which this factory belongs.
	 */
	private Game game;
	
	/**
	 * Alien wave factory to create a default alien wave.
	 * @param setGame the game to set the game of this factory to
	 */
	public DefaultAlienWaveFactory(final Game setGame) {
		game = setGame;
	}
	/**
	 * Creates an alienwave.
	 * @return the created alienwave object
	 */
	@SuppressWarnings("checkstyle:magicnumber")
	public final AlienWave createWave() {
		ConcreteAlienWave wave = new ConcreteAlienWave();
		
		
		 // Distance to top of the screen.
        double distance = 125;
        // Create alien object to make sure we can get the width and height of aliens
        Alien testAlien = new NormalAlien(0.0, 0.0); 
        double interval = 
    		game.getCanvasWidth() - 2 * AlienController.ALIENBORDERMARGIN * game.getCanvasWidth()
				- AlienController.ALIENS_PER_ROW * testAlien.getWidth() / AlienController.ALIENS_PER_ROW + 1;  

        // Drawing lines of Aliens.
        for (int i = 0; i < AlienController.AMOUNT_ALIEN_ROWS; i++) {
        	ArrayList<Alien> aliens = new ArrayList<Alien>();
            double startPosition = AlienController.ALIENBORDERMARGIN * game.getCanvasWidth() 
            		+ 0.5 * testAlien.getWidth();
            for (int j = 0; j < AlienController.ALIENS_PER_ROW; j++) {
            	Alien alien = new NormalAlien(startPosition, distance);
            	Logger.getInstance().log("Created Alien", LogEvent.Type.TRACE);
            	alien.setVelX(game.getAlienController().getAlienVelX());
            	aliens.add(alien);
            	startPosition += testAlien.getWidth() + interval;
            }
            distance += 1.1 * testAlien.getHeight();
            wave.addAlienRow(aliens);
        }
        
        return wave;
	}
	
	@Override
	public final AlienWave createBossWave() {
		return createWave();
	}
}
