package spaceinvaders.group_22.ui;

import java.util.HashMap;

import javafx.scene.image.Image;
import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.logger.Logger;

/**
 * Class which handles distributing sprites.
 * @author Jochem
 *
 */
public final class SpriteLoader {
	
	/**
	 * The singleton unique instance of Logger.
	 */
	private static volatile SpriteLoader uniqueInstance;

	/**
	 * Hashmap containing the sprites.
	 */
	private HashMap<String, Image> sprites;
	
	/**
	 * The maximum health for which there is an alien sprite.
	 */
	public static final int ALIEN_MAXHEALTH = 5;
	
	/**
	 * The maximum frame for which there is an explosion sprite.
	 */
	public static final int EXPLOSION_FRAMES = 5;
	
	/**
	 * Constructor for the SpriteLoader.
	 * It contains all sprites, and if a new sprite is added it should be added to this list.
	 */
	private SpriteLoader() {
    	sprites = new HashMap<String, Image>();
		
		addSprite("alienbullet.png");
		addSprite("spaceshipbullet.png");
		addSprite("alien_shooter.png");
		addSprite("alien_health1.png");
		addSprite("alien_health2.png");
		addSprite("alien_health3.png");
		addSprite("alien_health4.png");
		addSprite("alien_health5.png");
		addSprite("alien_large.png");
		addSprite("spaceship.png");
		addSprite("spaceship2.png");
		addSprite("heart.png");
		addSprite("barrier.png");
		addSprite("explosion1.png");
		addSprite("explosion2.png");
		addSprite("explosion3.png");
		addSprite("explosion4.png");
		addSprite("explosion5.png");
		addSprite("powerup_orange.png");
		addSprite("powerup_blue.png");
		addSprite("powerup_red.png");
		addSprite("glow_blue.png");
		addSprite("glow_orange.png");
		addSprite("bossspaceship.png");

		
    	Logger.getInstance().log("Initialized " + getClass().getName(), LogEvent.Type.INFO);

	}
	
	/**
	 * Returns the singleton instance of Logger.
	 * @return the Loggers unique instance.
	 */
	public static SpriteLoader getInstance() {
		if (uniqueInstance == null) {
			synchronized (SpriteLoader.class) {
				if (uniqueInstance == null) {
					uniqueInstance = new SpriteLoader();
		       }
			}	
		}
		return uniqueInstance; 
	}
    
    /**
     * Adds a sprite to the sprite Hasmap.
     * @param filename The filename of the sprite to add.
     */
    public void addSprite(final String filename) {
		sprites.put(filename, 
				new Image(getClass().getClassLoader()
						.getResource("spaceinvaders/group_22/images/" + filename).toString()));
		Logger.getInstance().log("Loaded " + filename, LogEvent.Type.DEBUG);
    }
    
    /**
     * Getter method for the alien bullet sprite.
     * @return The alien bullet sprite Image.
     */
    public Image getBulletAlien() {
    	return sprites.get("alienbullet.png");
    }
    
    /**
     * Getter method for the spaceship bullet sprite.
     * @return The spaceship bullet sprite Image.
     */
    public Image getBulletSpaceShip() {
    	return sprites.get("spaceshipbullet.png");
    }
    
    /**
     * Getter method for the large alien sprite.
     * @return The large alien sprite Image.
     */
    public Image getAlienLarge() {
    	return sprites.get("alien_large.png");
    }
    
    /**
     * Getter method for the shooter alien sprite.
     * @return The shooter alien sprite Image.
     */
    public Image getAlienShooter() {
    	return sprites.get("alien_shooter.png");
    }

    /**
     * Getter method for the alien sprite with a certain health value.
     * @param health The health of the alien to get the sprite for.
     * @return The alien sprite Image with correct health.
     */
    public Image getAlienWithHealth(final int health) {
    	if (health > 0 && health <= ALIEN_MAXHEALTH) {
    		return sprites.get("alien_health" + Integer.toString(health) + ".png");
    	} else {
    		return sprites.get("alien_health1.png");
    	}
    }
    
    /**
     * Getter method for the spaceShip sprite.
     * @return The alien sprite Image.
     * @param playerNr number of player to get the spaceShip for.
     */
    public Image getSpaceShip(final int playerNr) {
    	if (playerNr > 1) {
    		return sprites.get("spaceship" + Integer.toString(playerNr) + ".png");
    	} else {
    		return sprites.get("spaceship.png");
    	}
    }
    
    /**
     * Getter method for the heart sprite.
     * @return The heart sprite Image.
     */
    public Image getHeart() {
    	return sprites.get("heart.png");
    }

    /**
     * Getter method for the heart sprite.
     * @return The heart sprite Image.
     */
    public Image getBarrier() {
    	return sprites.get("barrier.png");
    }
    
    /**
     * Getter method for the explosion with a certain frame.
     * @param frame The frame of the explosion animation to get the sprite for.
     * @return The explosion sprite Image.
     */
    public Image getExplosionWithFrame(final int frame) {
    	if (frame > 0 && frame <= EXPLOSION_FRAMES) {
    		return sprites.get("explosion" + Integer.toString(frame) + ".png");
    	} else {
    		return sprites.get("explosion1.png");
    	}
    }
    
    /**
     * Getter method for the speed powerup sprite.
     * @return The speed powerup sprite Image.
     */
    public Image getSpeedPowerUp() {
    	return sprites.get("powerup_blue.png");
    }
    
    /**
     * Getter method for the speed powerup glow sprite.
     * @return The speed powerup glow sprite Image.
     */
    public Image getSpeedPowerUpGlow() {
    	return sprites.get("glow_blue.png");
    }
    
    
    /**
     * Getter method for the shoot powerup sprite.
     * @return The shoot powerup sprite Image.
     */
    public Image getShootPowerUp() {
    	return sprites.get("powerup_orange.png");
    }
    
    /**
     * Getter method for the shoot powerup glow sprite.
     * @return The shoot powerup glow sprite Image.
     */
    public Image getShootPowerUpGlow() {
    	return sprites.get("glow_orange.png");
    }
    
    /**
     * Getter method for the life powerup sprite.
     * @return The life powerup sprite Image.
     */
    public Image getLifePowerUp() {
    	return sprites.get("powerup_red.png");
    }
    
    /**
     * Getter method for the boss spaceship sprite.
     * @return The boss spaceship sprite Image.
     */
    public Image getBossSpaceShip() {
    	return sprites.get("bossspaceship.png");
    }
}
