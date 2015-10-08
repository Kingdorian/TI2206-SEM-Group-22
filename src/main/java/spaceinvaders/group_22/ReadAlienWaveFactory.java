package spaceinvaders.group_22;

import java.io.IOException;
import java.util.ArrayList;

import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.unit.Alien;

/**
 * Class for creating an alienwave.
 * @author Dorian and Bryan
 *
 */
public class ReadAlienWaveFactory implements AlienWaveFactoryInterface {
	/**
	 * ArrayList of the possible alienWaves.
	 */
	private ArrayList<AlienWave> patterns = new ArrayList<AlienWave>();
	/**
	 * Game object this factory belongs to.
	 */
	private Game game;
	/**
	 * Speed of the aliens in the X direction in pixels per second.
	 */
	private double alienVelX = 40;
	/**
	 * Reader used to read the alienwaves from a file.
	 */
	private AlienWaveReader waveReader;
	/**
	 * List of all patterns that are read from files.
	 */
	private ArrayList<WavePattern> patternList;
	/**
	 * WaveP
	 */
	/**
	 * Constructor of the alien wave factory.
	 * @param setgame game to set for this factory.
	 */
	public ReadAlienWaveFactory(final Game setgame) throws Exception {
		waveReader = new AlienWaveReader();
		game = setgame;
		String sep = System.getProperty("file.separator");
		patternList = waveReader.read("src" + sep	+ "main" + sep + "resources" + sep
				+ "spaceinvaders" +  sep + "group_22" + sep	+ "waves" + sep);
	}

	public final AlienWave createWave() {
		ArrayList<AlienWave> waves = new ArrayList<AlienWave>();
		System.out.println(patternList.get(0).toString());
        alienVelX+= AlienController.ALIENVELXINCREASE;
		return createWaveFromPattern(patternList.get(0));
	}
	/**
	 * Creates a new alienwave according to the supplied pattern
	 * @return pattern to create a alienwave from
	 */
	public final AlienWave createWaveFromPattern(WavePattern pattern) {
		ConcreteAlienWave wave = new ConcreteAlienWave();
		ArrayList<Alien> aliens = new ArrayList<Alien>();
		
		 // Distance to top of the screen.
        double y = 125;
        // Create alien object to make sure we can get the width and height of aliens
        Alien testAlien = new Alien(0.0, 0.0, Alien.SPRITE); 
        // Drawing lines of Aliens.
        for (int i = 0; i < pattern.getHeight(); i++) {
        	 double interval = ((game.getCanvasWidth() -
        			 (2 * AlienController.ALIENBORDERMARIGIN
        					 * game.getCanvasWidth()))
						- (pattern.getLength(i) * testAlien.getWidth())) / (pattern.getLength(i) + 1);  
            double x = AlienController.ALIENBORDERMARIGIN * game.getCanvasWidth() + 0.5 * testAlien.getWidth();
            for (int j = 0; j < pattern.getLength(i); j++) {
            	switch (pattern.getChar(i, j)) {
            		case '*':
            			Alien alien = new Alien(x, y, "invader.png");
                    	alien.setVelX(alienVelX);
                    	aliens.add(alien);
                      	Game.getLogger().log("Created Alien at location:(" + x + "," + y + ")", LogEvent.Type.TRACE);
            	}
            	x += testAlien.getWidth() + interval;
            }
            y += 1.1 * testAlien.getHeight();
            wave.addAlienRow(aliens);
        }
        return wave;
	}
}
