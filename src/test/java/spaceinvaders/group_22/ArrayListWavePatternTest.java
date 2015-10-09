package spaceinvaders.group_22;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class ArrayListWavePatternTest {

	@Test
	public void testGetHeightEmptyPattern() {
		ArrayListWavePattern pattern = new ArrayListWavePattern();
		Assert.assertEquals(0, pattern.getHeight());
	}

	@Test
	public void testGetHeightSingleRow() {
		ArrayListWavePattern pattern = new ArrayListWavePattern();
		pattern.addRow(new ArrayList<Character>());
		Assert.assertEquals(1, pattern.getHeight());
	}
	@Test
	public void testGetHeightMultiRow() {
		ArrayListWavePattern pattern = new ArrayListWavePattern();
		for(int i = 0; i < 3; i++) {
			pattern.addRow(new ArrayList<Character>());
		}
		Assert.assertEquals(3, pattern.getHeight());
	}
	@Test
	public void testGetWidthEmptyPattern() {
		ArrayListWavePattern pattern = new ArrayListWavePattern();
		Assert.assertEquals(0, pattern.getWidth());
	}
	@Test
	public void testGetWidthSingleEmptyRow() {
		ArrayListWavePattern pattern = new ArrayListWavePattern();
		pattern.addRow(new ArrayList<Character>());
		Assert.assertEquals(0, pattern.getWidth());
	}
	@Test
	public void testGetWidthSingleRowSingleChar() {
		ArrayListWavePattern pattern = new ArrayListWavePattern();
		ArrayList<Character> list = new ArrayList<Character>();
		list.add('c');
		pattern.addRow(list);
		Assert.assertEquals(1, pattern.getWidth());
	}
	@Test
	public void testGetWidthSingleRowMultiChar() {
		ArrayListWavePattern pattern = new ArrayListWavePattern();
		ArrayList<Character> list = new ArrayList<Character>();
		for(int i = 0; i < 5; i ++) {
			list.add('c');
		}
		pattern.addRow(list);
		Assert.assertEquals(5, pattern.getWidth());
	}
	@Test
	public void testGetWidthMultiRowEmpty() {
		ArrayListWavePattern pattern = new ArrayListWavePattern();
		ArrayList<Character> list = new ArrayList<Character>();
		for(int i = 0; i < 3; i++) {
			pattern.addRow(list);
		}
		Assert.assertEquals(0, pattern.getWidth());
	}
	@Test
	public void testGetWidthMultiRowFirstEmpty() {
		ArrayListWavePattern pattern = new ArrayListWavePattern();
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
		ArrayListWavePattern pattern = new ArrayListWavePattern();
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
		ArrayListWavePattern pattern = new ArrayListWavePattern();
		pattern.getLength(2);
	}
	@Test(expected = IndexOutOfBoundsException.class)  
	public void testGetLengthInvalidRowIndex() {
		ArrayListWavePattern pattern = new ArrayListWavePattern();
		pattern.addRow(new ArrayList<Character>());
		pattern.getLength(2);
	}
	@Test
	public void testGetLengthEmptyRow() {
		ArrayListWavePattern pattern = new ArrayListWavePattern();
		pattern.addRow(new ArrayList<Character>());
		Assert.assertEquals(0, pattern.getLength(0));	
	}
	@Test
	public void testGetLengthSingleChar() {
		ArrayListWavePattern pattern = new ArrayListWavePattern();
		pattern.addRow(new ArrayList<Character>());
		ArrayList list = new ArrayList<Character>();
		list.add('a');
		pattern.addRow(list);
		Assert.assertEquals(1, pattern.getLength(1));	
	}
	@Test
	public void testGetLengthMultiChar() {
		ArrayListWavePattern pattern = new ArrayListWavePattern();
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
		ArrayListWavePattern pattern = new ArrayListWavePattern();
		Assert.assertEquals(0, pattern.size());
	}
	@Test
	public void testGetSizeSingleEmptyRowPattern() { 
		ArrayListWavePattern pattern = new ArrayListWavePattern();
		pattern.addRow(new ArrayList<Character>());
		Assert.assertEquals(0, pattern.size());
	}
	@Test
	public void testGetSizeMultiRow() { 
		ArrayListWavePattern pattern = new ArrayListWavePattern();
		ArrayList<Character> list = new ArrayList<Character>();
		for(int i = 0; i < 3; i++) {
			list.add('c');
		}
		pattern.addRow(list);
		Assert.assertEquals(3, pattern.size());
	}
	@Test
	public void testGetSizeMultiRowMultiChar() { 
		ArrayListWavePattern pattern = new ArrayListWavePattern();
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
		ArrayListWavePattern pattern = new ArrayListWavePattern();
		ArrayList<Character> list = new ArrayList<Character>();
		pattern.addRow(list);
		Assert.assertEquals(list, pattern.getRow(0));
	}
	@Test
	public void testAddRowWithChars() {
		ArrayListWavePattern pattern = new ArrayListWavePattern();
		ArrayList<Character> list = new ArrayList<Character>();
		list.add('a');
		list.add('b');
		pattern.addRow(list);
		Assert.assertEquals(list, pattern.getRow(0));
	}	
	@Test(expected = IndexOutOfBoundsException.class)  
	public void testSetRowEmptyPatternArrayList() {
		ArrayListWavePattern pattern = new ArrayListWavePattern();
		pattern.setRow(2, new ArrayList<Character>());
	}
	@Test(expected = IndexOutOfBoundsException.class)  
	public void testSetRowEmptyPatternArray() {
		ArrayListWavePattern pattern = new ArrayListWavePattern();
		pattern.setRow(2, new char[2]);
	}
	@Test 
	public void testSetRowWithCharsList() {
		ArrayListWavePattern pattern = new ArrayListWavePattern();
		pattern.addRow(new ArrayList<Character>());
		ArrayList<Character> list = new ArrayList<Character>();
		list.add('a'); list.add('b');
		pattern.setRow(0, list);
		Assert.assertEquals(list, pattern.getRow(0));
	}
	@Test
	public void testSetRowWithCharsArray() {
		ArrayListWavePattern pattern = new ArrayListWavePattern();
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
		ArrayListWavePattern pattern = new ArrayListWavePattern();
		pattern.addRow(new ArrayList<Character>());
		ArrayList<Character> list = new ArrayList<Character>();
		pattern.setRow(0, list);
		Assert.assertEquals(list, pattern.getRow(0));
	}
	@Test
	public void testSetRowWithCharsEmptyArray() {
		ArrayListWavePattern pattern = new ArrayListWavePattern();
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
	public void testGetCharEmptyPattern() {
		ArrayListWavePattern pattern = new ArrayListWavePattern();
		pattern.getChar(0, 0);
	}
	@Test(expected = IndexOutOfBoundsException.class)  
	public void testGetCharInvalidRowIndex() {
		ArrayListWavePattern pattern = new ArrayListWavePattern();
		pattern.addRow(new ArrayList<Character>());
		pattern.getChar(1, 0);
	}
	@Test(expected = IndexOutOfBoundsException.class)  
	public void testGetCharEmptyPatternInvalidColumnIndex() {
		ArrayListWavePattern pattern = new ArrayListWavePattern();
		pattern.addRow(new ArrayList<Character>());
		pattern.getChar(0, 0);
	}
	@Test(expected = IndexOutOfBoundsException.class)  
	public void testGetCharInvalidColumnIndex() {
		ArrayListWavePattern pattern = new ArrayListWavePattern();
		ArrayList<Character> list = new ArrayList<Character>();
		list.add('a');
		pattern.addRow(new ArrayList<Character>());
		pattern.getChar(0, 1);
	}
	@Test 
	public void testGetChar() {
		ArrayListWavePattern pattern = new ArrayListWavePattern();
		ArrayList<Character> list = new ArrayList<Character>();
		list.add('a');
		pattern.addRow(list);
		Assert.assertEquals('a', pattern.getChar(0, 0));
	}
	@Test 
	public void testGetCharSecondRow() {
		ArrayListWavePattern pattern = new ArrayListWavePattern();
		pattern.addRow(new ArrayList<Character>());
		ArrayList<Character> list = new ArrayList<Character>();
		list.add('a');
		list.add('b');
		pattern.addRow(list);
		Assert.assertEquals('b', pattern.getChar(1, 1));
	}
	@Test(expected = IndexOutOfBoundsException.class)  
	public void testSetCharEmptyPattern() {
		ArrayListWavePattern pattern = new ArrayListWavePattern();
		pattern.setChar(0, 0, 'a');
	}
	@Test(expected = IndexOutOfBoundsException.class)  
	public void testSetCharInvalidRowIndex() {
		ArrayListWavePattern pattern = new ArrayListWavePattern();
		pattern.addRow(new ArrayList<Character>());
		pattern.setChar(1, 0, 'a');
	}
	@Test(expected = IndexOutOfBoundsException.class)  
	public void testSetCharEmptyPatternInvalidColumnIndex() {
		ArrayListWavePattern pattern = new ArrayListWavePattern();
		pattern.addRow(new ArrayList<Character>());
		pattern.setChar(0, 0, 'a');
	}
	@Test(expected = IndexOutOfBoundsException.class)  
	public void testSetCharInvalidColumnIndex() {
		ArrayListWavePattern pattern = new ArrayListWavePattern();
		ArrayList<Character> list = new ArrayList<Character>();
		list.add('a');
		pattern.addRow(new ArrayList<Character>());
		pattern.setChar(0, 1, 'a');
	}
	@Test 
	public void testSetChar() {
		ArrayListWavePattern pattern = new ArrayListWavePattern();
		ArrayList<Character> list = new ArrayList<Character>();
		list.add('a');
		pattern.addRow(list);
		pattern.setChar(0, 0, 'b');
		Assert.assertEquals('b', pattern.getChar(0, 0));
	}
	@Test 
	public void testSetCharSecondRow() {
		ArrayListWavePattern pattern = new ArrayListWavePattern();
		pattern.addRow(new ArrayList<Character>());
		ArrayList<Character> list = new ArrayList<Character>();
		list.add('a');
		list.add('b');
		pattern.addRow(list);
		pattern.setChar(1, 1,  'c');
		Assert.assertEquals('c', pattern.getChar(1, 1));
	}
	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetRowEmptyPattern() {
		ArrayListWavePattern pattern = new ArrayListWavePattern();
		pattern.getRow(0);
	}
	@Test
	public void testAddRowArray() {
		ArrayListWavePattern pattern = new ArrayListWavePattern();
		char[] chars = {'a', 'b', 'c'};
		pattern.addRow(chars);
		ArrayList<Character> charList = new ArrayList<Character>();
		charList.add('a');
		charList.add('b');
		charList.add('c');
		Assert.assertEquals(charList, pattern.getRow(0));
	}
	@Test
	public void testAddRowEmptyArrayRow() {
		ArrayListWavePattern pattern = new ArrayListWavePattern();
		ArrayList<Character> list = new ArrayList<Character>();
		char[] chars = {};
		pattern.addRow(chars);
		Assert.assertEquals(list, pattern.getRow(0));
	}

	@Test
	public void testEqualsOtherNull() {
		ArrayListWavePattern pattern = new ArrayListWavePattern();
		Assert.assertFalse(pattern.equals(null));
	}
	@Test
	public void testEqualsNoPattern() {
		ArrayListWavePattern pattern = new ArrayListWavePattern();
		Assert.assertFalse(pattern.equals(12));
	}
	@Test
	public void testEqualsThisLarger() {
		ArrayListWavePattern pattern = new ArrayListWavePattern();
		pattern.addRow(new ArrayList<Character>());
		ArrayListWavePattern otherPattern = new ArrayListWavePattern();
		Assert.assertNotEquals(pattern,otherPattern);
	}
	@Test
	public void testEqualsOtherLarger() {
		ArrayListWavePattern pattern = new ArrayListWavePattern();
		ArrayListWavePattern otherPattern = new ArrayListWavePattern();
		otherPattern.addRow(new ArrayList<Character>());
		Assert.assertNotEquals(pattern,otherPattern);
	}
	@Test
	public void testEqualsNotEqualFirstRow() {
		ArrayListWavePattern pattern = new ArrayListWavePattern();
		ArrayListWavePattern otherPattern = new ArrayListWavePattern();
		char[] chars = {'a', 'b'};
		pattern.addRow(chars);
		otherPattern.addRow(new ArrayList<Character>());
		Assert.assertNotEquals(pattern,otherPattern);
	}
	@Test
	public void testEqualsEqualOneRow() {
		ArrayListWavePattern pattern = new ArrayListWavePattern();
		ArrayListWavePattern otherPattern = new ArrayListWavePattern();
		char[] chars = {'a', 'b'};
		pattern.addRow(chars);
		otherPattern.addRow(chars);
		Assert.assertEquals(pattern,otherPattern);
	}
	@Test
	public void testEqualsNotEqualsSecondRow() {
		ArrayListWavePattern pattern = new ArrayListWavePattern();
		ArrayListWavePattern otherPattern = new ArrayListWavePattern();
		char[] chars = {'a', 'b'};
		pattern.addRow(chars);
		otherPattern.addRow(chars);
		otherPattern.addRow(chars);
		chars[1] = 'c';
		pattern.addRow(chars);	
		Assert.assertNotEquals(pattern,otherPattern);
	}
	@Test
	public void testEqualsNotEqualsMultiRow() {
		ArrayListWavePattern pattern = new ArrayListWavePattern();
		ArrayListWavePattern otherPattern = new ArrayListWavePattern();
		char[] chars = {'a', 'b'};
		pattern.addRow(chars);
		otherPattern.addRow(chars);
		chars[0] = 'c';
		otherPattern.addRow(chars);
		pattern.addRow(chars);	
		Assert.assertEquals(pattern,otherPattern);
	}
}
