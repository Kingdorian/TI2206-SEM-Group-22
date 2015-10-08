package spaceinvaders.group_22;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Class describes a pattern for an Alien wave.
 * @author Dorian
 *
 */
public class WavePattern {
	/**
	 * 2D ArrayList containing chars to represent Aliens.
	 */
	ArrayList<ArrayList<Character>> pattern;
	/**
	 * Creates a new WavePattern Object.
	 */
	public WavePattern() {
		pattern = new ArrayList<ArrayList<Character>>();
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
	 * get length of specific row
	 * @param index the index of the row to get the length from
	 * @return int the length of the row.
	 * @throws ArrayIndexOutOfBoundsException if the index is invalid.
	 */
	public int getLength(int index) throws ArrayIndexOutOfBoundsException{
		return pattern.get(index).size();
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
		pattern.set(index, new ArrayList<Character>(newRow)); 
	}
	/**
	 * Sets a row to a given row.
	 * @param index the index of the current row
	 * @param Array<char> the new row
	 * @throws indexoutofboundsexception when index is invalid.
	 */
	public void setRow(int index, char[] newRow) throws IndexOutOfBoundsException {
		ArrayList<Character> rowList = new ArrayList<Character>();
		for(int i = 0; i < newRow.length; i++) {
			rowList.add(newRow[i]);
		}
		setRow(index, rowList);
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
	/**
	 * Gets a char in a given location.
	 * @param rowIndex of the char
	 * @param columnIndex of the char
	 * @return the char at the given location
	 * @throws IndexOutOfBoundsException if the row or columIndex is invalid
	 */
	public char getChar(int rowIndex, int columnIndex) throws IndexOutOfBoundsException {
		return pattern.get(rowIndex).get(columnIndex);
	}
	/**
	 * Adds a new row to the pattern.
	 * @param row the row to add
	 */
	public void addRow(final ArrayList<Character> row) {
		pattern.add(new ArrayList<Character>(row));
	}
	/**
	 * Gets row in a in the specified location.
	 * @param index of the row
	 * @return unmodifiable ArrayList containing the row
	 * @throws IndexOutOfBoundsException if the index is invalid
	 */
	public ArrayList<Character> getRow(int index) {
		// Create a copy of the old list to ensure it cannot be changed.
		return pattern.get(index);
	}
}
