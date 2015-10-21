package spaceinvaders.group_22.unit;

import java.util.Arrays;
import java.util.Random;

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
	private int health  = 10;
	/**
	 * 2d array with booleans for wich part of the barricade are already destroyed.
	 */
	boolean[][] damage = new boolean[15][5];
	/**
	 * Creates new Barricade object.
	 * @param x X-coordinate of the barricade
	 * @param y Y-coordinate of the barricade
	 */
	public Barricade(final double x, final double y) {
		super(x, y);
		for(boolean[] array : damage) {
			Arrays.fill(array, true);
		}
		System.out.println(Arrays.toString(damage[1]));
	}
	/**
	 * When barricade is hit decrease health. 
	 */
	public final void hit() {
		health--;
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
		return true;
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
	public void crumble(double x, double y) {
		int partWidthIndex = (int)(x/getWidth()/damage.length);
		int partHeightIndex = (int)(y/getHeight()/damage[0].length);
		int totalParts = damage.length*damage[0].length;
		int brokenParts = 0;
		Random randomizer = new Random();
		while(brokenParts < totalParts/10) {
			double randX, randY;
			do {
				randX = randomizer.nextGaussian();
				randX = damage.length*(randX/6);
			} while((int)randX < 0 || (int)randX >= damage.length);
			do {
				randY = randomizer.nextGaussian();
				randY = damage[0].length*(randY/6);
			} while((int)randY < 0 || (int)randY >= damage[0].length);
			if(damage[(int)randX][(int)randY]) {
				damage[(int)randX][(int)randY] = false;
				brokenParts++;
			}
		}
	}
	/**
	 * Returns the damage to the barricade.
	 * @return boolean[][] with false for damaged parts
	 */
	public boolean[][] getDamage() {
		return damage;
	}
	
}
