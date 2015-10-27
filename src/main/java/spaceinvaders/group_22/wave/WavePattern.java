package spaceinvaders.group_22.wave;

import java.util.ArrayList;

/**
 * Class describes a pattern for an Alien wave.
 * @author Dorian
 *
 */
public interface WavePattern {
	/**
	 * Returns height in aliens of this pattern.
	 * @return amount of rows of aliens.
	 */
	int getHeight();
	/**
	 * Returns amount of aliens in the largest row.
	 * @return the width of the largest row.
	 */
	int getWidth();
	/**
	 * get length of specific row.
	 * @param index the index of the row to get the length from
	 * @return int the length of the row.
	 * @throws ArrayIndexOutOfBoundsException if the index is invalid.
	 */
	int getLength(final int index);
	
	/**
	 * Gets the amount of places in this pattern.
	 * @return amount of places (either occupied by an alien or empty) in this pattern.
	 */
	int size();
	/**
	 * Sets a row to the given row.
	 * @param index the index of the current row
	 * @param newRow the new row
	 * @throws IndexOutOfBoundsException when index is invalid.
	 */
	void setRow(final int index, ArrayList<Character> newRow);
	/**
	 * Sets a row to a given row.
	 * @param index the index of the current row
	 * @param newRow an array with chars for the new row
	 * @throws IndexOutOfBoundsException when index is invalid.
	 */
	void setRow(final int index, final char[] newRow);
	/**
	 * Sets a char in a given location.
	 * @param rowIndex of the char
	 * @param columnIndex of the char
	 * @param value the char to put
	 * @throws IndexOutOfBoundsException if the row or columIndex is invalid
	 */
	void setChar(final int rowIndex, final int columnIndex, final char value);
	/**
	 * Gets a char in a given location.
	 * @param rowIndex of the char
	 * @param columnIndex of the char
	 * @return the char at the given location
	 * @throws IndexOutOfBoundsException if the row or columIndex is invalid
	 */
	char getChar(final int rowIndex, final int columnIndex);
	/**
	 * Adds a new row to the pattern.
	 * @param row ArrayList the row to add
	 */
	void addRow(final ArrayList<Character> row);
	/**
	 * Adds a new row to the pattern.
	 * @param row Array the row to add
	 */
	void addRow(final char[] row);
	/**
	 * Gets row in a in the specified location.
	 * @param index of the row
	 * @return unmodifiable ArrayList containing the row
	 * @throws IndexOutOfBoundsException if the index is invalid
	 */
	ArrayList<Character> getRow(final int index);
	/**
	 * Compares object to this WavePattern.
	 * @param other the boject to compare this to.
	 * @return true if obj in param is equal to this otherwise false
	 */
	boolean equals(final Object other);
	/**
	 * Returns a string representation of this AlienWave.
	 * @return String representation of this alienWave.
	 */
	String toString();
	 
}
