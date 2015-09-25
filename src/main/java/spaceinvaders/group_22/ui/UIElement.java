package spaceinvaders.group_22.ui;

import java.util.HashMap;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import spaceinvaders.group_22.Game;
import spaceinvaders.group_22.logger.LogEvent;

/**
 * The drawing of all the elements.
 * @author Ege
 *
 */
public abstract class UIElement {
	
	/**
	 * All sprites that can be used in a UIElement.
	 */
	private HashMap<String, Image> sprites;
	
	/**
	 * The Game.
	 */
	private Game game;
	
	/**
	 * The UI controller.
	 */
	private GraphicsContext graphicsContext;
	
	/**
	 * The constructor for a UIElement object.
	 * @param newGame The game to obtain the data from.
	 * @param gc The GraphicsContext to draw on.
	 */
	public UIElement(final Game newGame, final GraphicsContext gc) { 
		getSpriteMap();
		setGame(newGame);
		graphicsContext = gc;
	}
	
	/**
	 * Drawing the elements.
	 */
	public abstract void draw();
	
	
    /**
     * Creates a hashmap of all available sprite images.
     */
    public final void getSpriteMap() {
    	sprites = new HashMap<String, Image>();
    		
    		addSprite(sprites, "alienbullet.png");
    		addSprite(sprites, "spaceshipbullet.png");
    		addSprite(sprites, "invader.png");
    		addSprite(sprites, "spaceship.png");
    		addSprite(sprites, "heart.png");
    		addSprite(sprites, "barrier.png");
    		addSprite(sprites, "explosion1.png");
    		addSprite(sprites, "explosion2.png");
    		addSprite(sprites, "explosion3.png");
    		addSprite(sprites, "explosion4.png");
    		addSprite(sprites, "explosion5.png");
    }
    
    /**
     * Getter method for the sprites hashmap.
     * @return the hashmap containing the sprites.
     */
    public final HashMap<String, Image> getSprites() {
    	return sprites;
    }
    
    /**
     * Adds a sprite to the sprite Hasmap.
     * @param spriteMap The hashmap of sprites to add to.
     * @param filename The filename of the sprite to add.
     */
    public final void addSprite(final HashMap<String, Image> spriteMap, final String filename) {
		spriteMap.put(filename, 
				new Image(getClass().getClassLoader()
						.getResource("spaceinvaders/group_22/images/" + filename).toString()));
		Game.getLogger().log("Loaded " + filename, LogEvent.Type.DEBUG);
    }

	/**
	 * @return Returns the game to obtain data from.
	 */
	public final Game getGame() {
		return game;
	}

	/**
	 * @param newGame The newGame to set.
	 */
	public final void setGame(final Game newGame) {
		this.game = newGame;
	}
	
	/**
	 * @return Returns the game to obtain data from.
	 */
	public final GraphicsContext getGC() {
		return graphicsContext;
	}

	/**
	 * @param newGC The new GraphicsContext to draw on.
	 */
	public final void setGC(final GraphicsContext newGC) {
		this.graphicsContext = newGC;
	}
   
}
