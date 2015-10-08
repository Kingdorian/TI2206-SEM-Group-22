package spaceinvaders.group_22;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class WavePatternTest {

	@Test
	public void testGetHeightEmptyPattern() {
		WavePattern pattern = new WavePattern();
		Assert.assertEquals(0, pattern.getHeight());
	}

	@Test
	public void testGetHeightSingleRow() {
		WavePattern pattern = new WavePattern();
		pattern.addRow(new ArrayList<Character>());
		Assert.assertEquals(1, pattern.getHeight());
	}
	@Test
	public void testGetHeightMultiRow() {
		WavePattern pattern = new WavePattern();
		for(int i = 0; i < 3; i++) {
			pattern.addRow(new ArrayList<Character>());
		}
		Assert.assertEquals(3, pattern.getHeight());
	}
	@Test
	public void testGetWidthEmptyPattern() {
		WavePattern pattern = new WavePattern();
		Assert.assertEquals(0, pattern.getWidth());
	}
	@Test
	public void testGetWidthSingleEmptyRow() {
		WavePattern pattern = new WavePattern();
		pattern.addRow(new ArrayList<Character>());
		Assert.assertEquals(0, pattern.getWidth());
	}
	@Test
	public void testGetWidthSingleRowSingleChar() {
		WavePattern pattern = new WavePattern();
		ArrayList<Character> list = new ArrayList<Character>();
		list.add('c');
		pattern.addRow(list);
		Assert.assertEquals(1, pattern.getWidth());
	}
	@Test
	public void testGetWidthSingleRowMultiChar() {
		WavePattern pattern = new WavePattern();
		ArrayList<Character> list = new ArrayList<Character>();
		for(int i = 0; i < 5; i ++) {
			list.add('c');
		}
		pattern.addRow(list);
		Assert.assertEquals(5, pattern.getWidth());
	}
	@Test
	public void testGetWidthMultiRowEmpty() {
		WavePattern pattern = new WavePattern();
		ArrayList<Character> list = new ArrayList<Character>();
		for(int i = 0; i < 3; i++) {
			pattern.addRow(list);
		}
		Assert.assertEquals(0, pattern.getWidth());
	}
	@Test
	public void testGetWidthMultiRowFirstEmpty() {
		WavePattern pattern = new WavePattern();
		pattern.addRow(new ArrayList<Character>());
		ArrayList<Character> list = new ArrayList<Character>();
		for(int i = 0; i < 3; i++) {
			list.add('*');
		}
		pattern.addRow(list);
		Assert.assertEquals(3, pattern.getWidth());
	}
	@Test
	public void testGetWidthMultiRowFirstMax() {
		WavePattern pattern = new WavePattern();
		ArrayList<Character> list = new ArrayList<Character>();
		for(int i = 0; i < 5; i++) {
			list.add('*');
		}
		ArrayList<Character> otherlist = new ArrayList<Character>();
		for(int i = 0; i < 3; i++) {
			otherlist.add('b');
		}
		pattern.addRow(list);
		pattern.addRow(new ArrayList<Character>());
		Assert.assertEquals(5, pattern.getWidth());
	}
	@Test(expected = IndexOutOfBoundsException.class)  
	public void testGetLengthEmptyPattern() {
		WavePattern pattern = new WavePattern();
		pattern.getLength(2);
	}
	@Test(expected = IndexOutOfBoundsException.class)  
	public void testGetLengthInvalidRowIndex() {
		WavePattern pattern = new WavePattern();
		pattern.addRow(new ArrayList<Character>());
		pattern.getLength(2);
	}
	@Test
	public void testGetLengthEmptyRow() {
		WavePattern pattern = new WavePattern();
		pattern.addRow(new ArrayList<Character>());
		Assert.assertEquals(0, pattern.getLength(0));	
	}
	@Test
	public void testGetLengthSingleChar() {
		WavePattern pattern = new WavePattern();
		pattern.addRow(new ArrayList<Character>());
		ArrayList list = new ArrayList<Character>();
		list.add('a');
		pattern.addRow(list);
		Assert.assertEquals(1, pattern.getLength(1));	
	}
	@Test
	public void testGetLengthMultiChar() {
		WavePattern pattern = new WavePattern();
		pattern.addRow(new ArrayList<Character>());
		ArrayList list = new ArrayList<Character>();
		for(int i = 0; i < 20; i++) {
			list.add('a');
		}
		pattern.addRow(list);
		Assert.assertEquals(20, pattern.getLength(1));	
	}
	@Test
	public void testGetSizeEmptyPattern() { 
		WavePattern pattern = new WavePattern();
		Assert.assertEquals(0, pattern.size());
	}
	@Test
	public void testGetSizeSingleEmptyRowPattern() { 
		WavePattern pattern = new WavePattern();
		pattern.addRow(new ArrayList<Character>());
		Assert.assertEquals(0, pattern.size());
	}
	@Test
	public void testGetSizeMultiRow() { 
		WavePattern pattern = new WavePattern();
		ArrayList<Character> list = new ArrayList<Character>();
		for(int i = 0; i < 3; i++) {
			list.add('c');
		}
		pattern.addRow(list);
		Assert.assertEquals(3, pattern.size());
	}
	@Test
	public void testGetSizeMultiRowMultiChar() { 
		WavePattern pattern = new WavePattern();
		ArrayList<Character> list = new ArrayList<Character>();
		for(int i = 0; i < 3; i++) {
			list.add('c');
		}
		ArrayList<Character> otherlist = new ArrayList<Character>();
		for(int i = 0; i < 5; i++) {
			otherlist.add('b');
		}
		pattern.addRow(otherlist);
		pattern.addRow(list);
		Assert.assertEquals(8, pattern.size());
	}
	@Test
	public void testAddRowEmptyRow() {
		WavePattern pattern = new WavePattern();
		ArrayList<Character> list = new ArrayList<Character>();
		pattern.addRow(list);
		Assert.assertEquals(list, pattern.getRow(0));
	}
	@Test
	public void testAddRowWithChars() {
		WavePattern pattern = new WavePattern();
		ArrayList<Character> list = new ArrayList<Character>();
		list.add('a');
		list.add('b');
		pattern.addRow(list);
		Assert.assertEquals(list, pattern.getRow(0));
	}	
	@Test(expected = IndexOutOfBoundsException.class)  
	public void testSetRowEmptyPatternArrayList() {
		WavePattern pattern = new WavePattern();
		pattern.setRow(2, new ArrayList<Character>());
	}
	@Test(expected = IndexOutOfBoundsException.class)  
	public void testSetRowEmptyPatternArray() {
		WavePattern pattern = new WavePattern();
		pattern.setRow(2, new char[2]);
	}
	@Test 
	public void testSetRowWithCharsList() {
		WavePattern pattern = new WavePattern();
		pattern.addRow(new ArrayList<Character>());
		ArrayList<Character> list = new ArrayList<Character>();
		list.add('a'); list.add('b');
		pattern.setRow(0, list);
		Assert.assertEquals(list, pattern.getRow(0));
	}
	@Test
	public void testSetRowWithCharsArray() {
		WavePattern pattern = new WavePattern();
		pattern.addRow(new ArrayList<Character>());
		char[] chars = {'a', 'b', 'c'};
		pattern.setRow(0, chars);
		char[] charArray = new char[pattern.getRow(0).size()];
		for(int i = 0; i < pattern.getRow(0).size(); i++) {
			charArray[i] = pattern.getRow(0).get(i);
		}
		Assert.assertArrayEquals(chars, charArray);
	}
	@Test 
	public void testSetRowWithCharsEmptyList() {
		WavePattern pattern = new WavePattern();
		pattern.addRow(new ArrayList<Character>());
		ArrayList<Character> list = new ArrayList<Character>();
		pattern.setRow(0, list);
		Assert.assertEquals(list, pattern.getRow(0));
	}
	@Test
	public void testSetRowWithCharsEmptyArray() {
		WavePattern pattern = new WavePattern();
		pattern.addRow(new ArrayList<Character>());
		char[] chars = {};
		pattern.setRow(0, chars);
		char[] charArray = new char[pattern.getRow(0).size()];
		for(int i = 0; i < pattern.getRow(0).size(); i++) {
			charArray[i] = pattern.getRow(0).get(i);
		}
		Assert.assertArrayEquals(chars, charArray);
	}
	@Test(expected = IndexOutOfBoundsException.class)  
	public void testSetCharEmptyPattern() {
		WavePattern pattern = new WavePattern();
		pattern.getChar(0, 0);
	}
	@Test(expected = IndexOutOfBoundsException.class)  
	public void testSetCharInvalidRowIndex() {
		WavePattern pattern = new WavePattern();
		pattern.addRow(new ArrayList<Character>());
		pattern.getChar(1, 0);
	}
	@Test(expected = IndexOutOfBoundsException.class)  
	public void testSetCharEmptyPatternInvalidColumnIndex() {
		WavePattern pattern = new WavePattern();
		pattern.addRow(new ArrayList<Character>());
		pattern.getChar(0, 0);
	}
	@Test(expected = IndexOutOfBoundsException.class)  
	public void testSetCharInvalidColumnIndex() {
		WavePattern pattern = new WavePattern();
		ArrayList<Character> list = new ArrayList<Character>();
		list.add('a');
		pattern.addRow(new ArrayList<Character>());
		pattern.getChar(0, 1);
	}
	@Test(expected = IndexOutOfBoundsException.class)  
	public void testSetChar() {
		WavePattern pattern = new WavePattern();
		ArrayList<Character> list = new ArrayList<Character>();
		list.add('a');
		pattern.addRow(new ArrayList<Character>());
		Assert.assertEquals('a', pattern.getChar(0, 0));
	}
	@Test(expected = IndexOutOfBoundsException.class)  
	public void testSetCharSecondRow() {
		WavePattern pattern = new WavePattern();
		pattern.addRow(new ArrayList<Character>());
		ArrayList<Character> list = new ArrayList<Character>();
		list.add('a');
		list.add('b');
		pattern.addRow(new ArrayList<Character>());
		Assert.assertEquals('b', pattern.getChar(1, 1));
	}
}
