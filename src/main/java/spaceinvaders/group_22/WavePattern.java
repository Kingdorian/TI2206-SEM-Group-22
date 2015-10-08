package spaceinvaders.group_22;

import java.util.ArrayList;

/**
 * Class describes a pattern for an Alien wave.
 * @author Dorian
 *
 */
public class WavePattern {
	/**
	 * 2D ArrayList containing chars to represent Aliens.
	 */
	ArrayList<ArrayList<Character>> pattern = new ArrayList<ArrayList<Character>>();
	/**
	 * Creates a new WavePattern Object.
	 */
	public WavePattern() {
		
	}
	/**
	 * Returns height in aliens of this pattern.
	 * @return amount of rows of aliens.
	 */
	public int getHeight() {
		return pattern.size();
	}
	/**
	 * Returns amount of aliens in the largest row.
	 * @return the width of the largest row.
	 */
	public int getWidth() {
		int width = 0;
		for(ArrayList<Character> row : pattern) {
			width = Math.max(width, row.size());
		}
		return width;
	}
}
