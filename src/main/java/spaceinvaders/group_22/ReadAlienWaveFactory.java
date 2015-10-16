package spaceinvaders.group_22;

import java.util.ArrayList;

import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.logger.Logger;
import spaceinvaders.group_22.unit.Alien;
import spaceinvaders.group_22.unit.HealthAlien;
import spaceinvaders.group_22.unit.LargeAlien;
import spaceinvaders.group_22.unit.NormalAlien;
import spaceinvaders.group_22.unit.ShootAlien;

/**
 * Class for creating an alienwave.
 * @author Dorian and Bryan
 *
 */
public class ReadAlienWaveFactory implements AlienWaveFactoryInterface {

	/**
	 * Game object this factory belongs to.
	 */
	private Game game;
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
	 * @throws Exception if file can't be read.
	 */
	public ReadAlienWaveFactory(final Game setgame) throws Exception {
		waveReader = new AlienWaveReader();
		game = setgame;
		String sep = System.getProperty("file.separator");
		patternList = waveReader.read("src" + sep	+ "main" + sep + "resources" + sep
				+ "spaceinvaders" +  sep + "group_22" + sep	+ "waves" + sep);
	}
	@Override
	public final AlienWave createWave() {
		return createWaveFromPattern(patternList.get((int) (Math.random() * patternList.size())));
	}
	/**
	 * Creates a new alienwave according to the supplied pattern.
	 * @return pattern to create a alienwave from
	 * @param wavePattern the pattern to create an wave from.
	 */
	@SuppressWarnings("checkstyle:magicnumber")
	public final AlienWave createWaveFromPattern(final WavePattern wavePattern) {
		ConcreteAlienWave wave = new ConcreteAlienWave();
		
		
		 // Distance to top of the screen.
        double y = 125;
        // Create alien object to make sure we can get the width and height of aliens
        Alien testAlien = new NormalAlien(0.0, 0.0); 
        // Drawing lines of Aliens.
        for (int i = 0; i < wavePattern.getHeight(); i++) {
        	ArrayList<Alien> aliens = new ArrayList<Alien>();
        	 double interval = ((game.getCanvasWidth() 
        			 - (2 * AlienController.ALIENBORDERMARGIN
        					 * game.getCanvasWidth()))
						- (wavePattern.getLength(i) * testAlien.getWidth())) / (wavePattern.getLength(i) + 1);  
            double x = AlienController.ALIENBORDERMARGIN * game.getCanvasWidth() + 0.5 * testAlien.getWidth();
            for (int j = 0; j < wavePattern.getLength(i); j++) {
            	switch (wavePattern.getChar(i, j)) {
            		case '*':
            			Alien alien = new NormalAlien(x, y);
                    	alien.setVelX(AlienController.getAlienVelX());
                    	aliens.add(alien);
                    	Logger.getInstance().log("Created Alien at location:(" + x + "," + y + ")", 
                    			LogEvent.Type.TRACE);
                      	break;
            		case '#': 
            			Alien bigAlien = new LargeAlien(x + (testAlien.getWidth() / 2), 
            					y + (testAlien.getWidth() / 2));
            			bigAlien.setVelX(AlienController.getAlienVelX());
            			aliens.add(bigAlien);
            			Logger.getInstance().log("Created 2x2 Alien at location:"
            					+ "(" + x + "," + y + ")", LogEvent.Type.TRACE);
            			break;
            		case '%':
            			Alien redAlien = new HealthAlien(x, y);
            			redAlien.setVelX(AlienController.getAlienVelX());
                    	aliens.add(redAlien);
                    	Logger.getInstance().log("Created red alien Alien at location:"
                    			+ "(" + x + "," + y + ")", LogEvent.Type.TRACE);
                      	break;
            		case 'S':
            			Alien shooterAlien = new ShootAlien(x, y);
            			shooterAlien.setVelX(AlienController.getAlienVelX());
            			shooterAlien.increaseShooting();
            			aliens.add(shooterAlien);
            			Logger.getInstance().log("Created fast shooting alien Alien at location:"
            					+ "(" + x + "," + y + ")", LogEvent.Type.TRACE);
            			break;
            		default:
            			
            			break;
            	}
            	x += testAlien.getWidth() + interval;
            }
            y += 1.1 * testAlien.getHeight();
            wave.addAlienRow(aliens);
        }

        return wave;
	}
}
