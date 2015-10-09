package spaceinvaders.group_22;

import java.util.ArrayList;

/**
 * Class describes a pattern for an Alien wave.
 * @author Dorian
 *
 */
public class ArrayListWavePattern implements WavePattern {
	/**
	 * 2D ArrayList containing chars to represent Aliens.
	 */
	private ArrayList<ArrayList<Character>> pattern;
	/**
	 * Creates a new WavePattern Object.
	 */
	public ArrayListWavePattern() {
		pattern = new ArrayList<ArrayList<Character>>();
	}
	/**
	 * Returns height in aliens of this pattern.
	 * @return amount of rows of aliens.
	 */
	public final int getHeight() {
		return pattern.size();
	}
	/**
	 * Returns amount of aliens in the largest row.
	 * @return the width of the largest row.
	 */
	public final int getWidth() {
		int width = 0;
		for (ArrayList<Character> row : pattern) {
			width = Math.max(width, row.size());
		}
		return width;
	}
	/**
	 * get length of specific row.
	 * @param index the index of the row to get the length from
	 * @return int the length of the row.
	 * @throws ArrayIndexOutOfBoundsException if the index is invalid.
	 */
	public final int getLength(final int index) throws ArrayIndexOutOfBoundsException {
		return pattern.get(index).size();
	}
	
	/**
	 * Gets the amount of places in this pattern.
	 * @return amount of places (either occupied by an alien or empty) in this pattern.
	 */
	public final int size() {
		int places = 0;
		for (ArrayList<Character> row : pattern) {
			places += row.size();
		}
		return places;
	}
	/**
	 * Sets a row to the given row.
	 * @param index the index of the current row
	 * @param newRow the new row
	 * @throws IndexOutOfBoundsException when index is invalid.
	 */
	public final void setRow(final int index, final ArrayList<Character> newRow) throws IndexOutOfBoundsException {
		pattern.set(index, new ArrayList<Character>(newRow)); 
	}
	/**
	 * Sets a row to a given row.
	 * @param index the index of the current row
	 * @param newRow an array with chars for the new row
	 * @throws IndexOutOfBoundsException when index is invalid.
	 */
	public final void setRow(final int index, final char[] newRow) throws IndexOutOfBoundsException {
		ArrayList<Character> rowList = new ArrayList<Character>();
		for (int i = 0; i < newRow.length; i++) {
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
	public final void setChar(final int rowIndex, 
			final int columnIndex, final char value) throws IndexOutOfBoundsException {
		pattern.get(rowIndex).set(columnIndex, value);
	}
	/**
	 * Gets a char in a given location.
	 * @param rowIndex of the char
	 * @param columnIndex of the char
	 * @return the char at the given location
	 * @throws IndexOutOfBoundsException if the row or columIndex is invalid
	 */
	public final char getChar(final int rowIndex, final int columnIndex) throws IndexOutOfBoundsException {
		return pattern.get(rowIndex).get(columnIndex);
	}
	/**
	 * Adds a new row to the pattern.
	 * @param row ArrayList the row to add
	 */
	public final void addRow(final ArrayList<Character> row) {
		pattern.add(new ArrayList<Character>(row));
	}
	/**
	 * Adds a new row to the pattern.
	 * @param row Array the row to add
	 */
	public final void addRow(final char[] row) {
		ArrayList<Character> rowList = new ArrayList<Character>();
		for (int i = 0; i < row.length; i++) {
			rowList.add(row[i]);
		}
		addRow(rowList);
	}
	/**
	 * Gets row in a in the specified location.
	 * @param index of the row
	 * @return unmodifiable ArrayList containing the row
	 * @throws IndexOutOfBoundsException if the index is invalid
	 */
	public final ArrayList<Character> getRow(final int index) throws IndexOutOfBoundsException {
		// Create a copy of the old list to ensure it cannot be changed.
		return pattern.get(index);
	}
	/**
	 * Compares object to this WavePattern.
	 * @param other the boject to compare this to.
	 * @return true if obj in param is equal to this otherwise false
	 */
	public final boolean equals(final Object other) {
		if (other != null && other instanceof ArrayListWavePattern) {
			ArrayListWavePattern otherPattern = (ArrayListWavePattern) other;
			if (this.getHeight() != otherPattern.getHeight()) {
				return false;
			}
			for (int i = 0; i < pattern.size(); i++) {
				if (!this.getRow(i).equals(otherPattern.getRow(i))) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
	/**
	 * Returns a string representation of this AlienWave.
	 * @return String representation of this alienWave.
	 */
	public final String toString() {
		return pattern.toString();
	}
	 
}
