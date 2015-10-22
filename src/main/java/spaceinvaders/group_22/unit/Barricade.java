package spaceinvaders.group_22.unit;

import java.util.Arrays;
import java.util.Random;

import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.logger.Logger;
import spaceinvaders.group_22.ui.SpriteLoader;

/**
 * Class for the baricade units that protect the player.
 * @author dorian
 *
 */

@SuppressWarnings("checkstyle:magicnumber")
public class Barricade extends Unit implements Crumbling {
	/**
	 * Var that keeps track of damage taken by this barricade.
	 */
	private int health;
	/**
	 * 2d array with booleans for wich part of the barricade are already destroyed.
	 */
	private boolean[][] damage = new boolean[10][5];
	/**
	 * Creates new Barricade object.
	 * @param x X-coordinate of the barricade
	 * @param y Y-coordinate of the barricade
	 */
	public Barricade(final double x, final double y) {
		super(x, y);
		for (boolean[] array : damage) {
			Arrays.fill(array, true);
		}
		health = damage.length * damage[0].length;

	}
	/**
	 * When barricade is hit decrease health. 
	 * @param hittingBullet the bullet that hits the barricade.
	 */
	public final void hit(final Bullet hittingBullet) {
		Logger.getInstance().log("Calculating bullet impact location", LogEvent.Type.DEBUG);
		// Calculate hit location.
		double hitterDir = hittingBullet.getVelY() / Math.abs(hittingBullet.getVelY());
		double hitLocX = hittingBullet.getXCoor() - (getXCoor() - (0.5 * getWidth()));
		double hitLocY = hittingBullet.getYCoor() + (hittingBullet.getHeight() / 2) 
				- (hittingBullet.getHeight() * hitterDir) - getYCoor() + (0.5 *  getHeight());
		// If the tip of the bullet does not hit the barricade
		if (hitLocX < 0) {
			hitLocX = 0;
		} else if (hitLocX > getWidth()) {
			hitLocX = getWidth();
		}
		if (hitLocY < 0) { 
			hitLocY = 0;
		} else if (hitLocY > getHeight()) {
			hitLocY = getHeight();
		}
		if (health > (damage.length * damage[0].length) / 10)  {
			crumble(hitLocX, hitLocY);
		} else {
			health = 0;
		}
	}
	/**
	 * Return the amount of health the barricade has left.
	 * @return amount of health the barricade has left.
	 */
	public final int getHealth() {
		return health;
	}
	@Override
	public final boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Barricade other = (Barricade) obj;
		if (health != other.health) {
			return false;
		}
		return Arrays.deepEquals(damage, other.getDamage());
	}
	
	@Override
	public final int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + health;
		return result;
	}
	
	/**
	 * Sets the right sprite image.
	 */
	public final void setSpriteImage() {
		setSprite(SpriteLoader.getInstance().getBarrier());
	}
	/**
	 * Crumbles part of the barricade at the given x and y coordinate.
	 * @param x the x coordinate
	 * @param y the y coordinate
	 */
	@Override
	public final void crumble(final double x, final double y) {
		int totalParts = damage.length * damage[0].length;
		int brokenParts = 0;
		Logger.getInstance().log("Barricade hit at loc: (" + x + "," + y + ")", LogEvent.Type.DEBUG);
		Random randomizer = new Random();
		while (brokenParts < totalParts / 10) {
			double randX, randY;
			do {
				randX = randomizer.nextGaussian() * (getWidth() / 6) + x;
			} while(randX < 0 || randX > getWidth());
			do {
				randY = randomizer.nextGaussian() * (getHeight() / 6) + y;
			} while(randY < 0 || randY > getHeight());
			// Map the (x,y) to a part of the grid 
			randX = (randX * damage.length) / getWidth();
			randY = (randY * damage[0].length) / getHeight();
			if (damage[(int) randX][(int) randY]) {
				damage[(int) randX][(int) randY] = false;
				brokenParts++;
				health--;
			}
		}
	}
	/**
	 * Returns the damage to the barricade.
	 * @return boolean[][] with false for damaged parts
	 */
	public final boolean[][] getDamage() {
		return damage;
	}
	
}
