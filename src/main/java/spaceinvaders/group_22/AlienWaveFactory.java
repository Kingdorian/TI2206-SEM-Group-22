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
public class AlienWaveFactory implements AlienWaveFactoryInterface {
	
	/**
	 * ArrayList of the possible alienWaves.
	 */
	private ArrayList<AlienWave> patterns = new ArrayList<AlienWave>();
	/**
	 * Game object this factory belongs to.
	 */
	private Game game;
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
	/**
	 * Reader used to read the alienwaves from a file.
	 */
	private AlienWaveReader waveReader;
	
	/**
	 * Constructor of the alien wave factory.
	 * @param setgame game to set for this factory.
	 */
	public AlienWaveFactory(final Game setgame) {
		waveReader = new AlienWaveReader();

	}

	@Override
	public final ArrayList<AlienWave> createWaves() {
		String sep = System.getProperty("file.separator");
		ArrayList<AlienWave> waves = new ArrayList<AlienWave>();
		try {
			ArrayList<WavePattern> wavePatterns = 
					waveReader.read("src" + sep	+ "main" + sep + "resources" + sep
					+ "spaceinvaders" +  sep + "group_22" + sep	+ "waves" + sep);
			for(WavePattern w : wavePatterns) {
				waves.add(createWaveFromPattern(w));
			}
		} catch (IOException e) {
			Game.getLogger().log("IOException occured while reading alienwaves", e);
			waves.add(createDefaultWave());
		}
		return waves;
	}
	public final AlienWave createDefaultWave() {
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
        	 double interval = ((game.getCanvasWidth() - (2 * ALIENBORDERMARIGIN * game.getCanvasWidth()))
						- (pattern.getLength(i) * testAlien.getWidth())) / (pattern.getLength(i) + 1);  
            double x = ALIENBORDERMARIGIN * game.getCanvasWidth() + 0.5 * testAlien.getWidth();
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
        }
        return wave;
	}
}
