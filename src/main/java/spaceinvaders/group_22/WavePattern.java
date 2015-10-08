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
	/**
	 * Gets the amount of places in this pattern.
	 * @return amount of places (either occupied by an alien or empty) in this pattern.
	 */
	public int size() {
		int places = 0;
		for(ArrayList<Character> row : pattern) {
			places+=row.size();
		}
		return places;
	}
	/**
	 * Sets a row to the given row.
	 * @param index the index of the current row
	 * @param ArrayList<Character> the new row
	 * @throws indexoutofboundsexception when index is invalid.
	 */
	public void setRow(int index, ArrayList<Character> newRow) throws IndexOutOfBoundsException {
		pattern.set(index, newRow); 
	}
	/**
	 * Sets a row to a given row.
	 * @param index the index of the current row
	 * @param Array<char> the new row
	 * @throws indexoutofboundsexception when index is invalid.
	 */
	public void setRow(int index, char[] newRow) throws IndexOutOfBoundsException {
		for(int i = 0; i < newRow.length; i++) {
			pattern.get(index).set(i, newRow[i]);
		}
	}
	/**
	 * Sets a char in a given location.
	 * @param rowIndex of the char
	 * @param columnIndex of the char
	 * @param value the char to put
	 * @throws IndexOutOfBoundsException if the row or columIndex is invalid
	 */
	public void setChar(int rowIndex, int columnIndex, char value) throws IndexOutOfBoundsException {
		pattern.get(rowIndex).set(columnIndex, value);
	}
}
