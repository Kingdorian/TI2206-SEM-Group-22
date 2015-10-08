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
}
