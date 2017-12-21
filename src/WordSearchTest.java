import static org.junit.Assert.*;

import org.junit.Test;

public class WordSearchTest {

	// Iteration 1 - started with a WordSearch constructor that 
	// just took in chars like this 
	/*
	@Test
	public void findWordLtoRInOneRowTrue() {
		char rowChars[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' };
		
		WordSearch wordSearch = new WordSearch(rowChars, "bcd");
		boolean valueToCheck = wordSearch.findWordSimple(); 
		assertTrue(valueToCheck);
	}

	@Test
	public void findWordLtoRInOneRowFalse() {
		char rowChars[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' };
		
		WordSearch wordSearch = new WordSearch(rowChars, "bqd");
		boolean valueToCheck = wordSearch.findWordSimple(); 
		assertFalse(valueToCheck);
	}
	*/
	
	
	// Iteration 2 - started with a WordSearch constructor that 
	// just took in chars with a comma in between each 
	
	@Test
	public void findWordLtoRInOneRowTrue() {
		char rowChars[] = {'a', ',', 
				           'b', ',',
				           'c', ',',
				           'd', ',',
				           'e', ',',
				           'f', ',',
				           'g', ',',
				           'h' };
		
		WordSearch wordSearch = new WordSearch(rowChars, "bcd");
		boolean valueToCheck = wordSearch.findWordSimple(); 
		assertTrue(valueToCheck);
	}

	@Test
	public void findWordLtoRInOneRowFalse() {
		char rowChars[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' };
		
		WordSearch wordSearch = new WordSearch(rowChars, "bqd");
		boolean valueToCheck = wordSearch.findWordSimple(); 
		assertFalse(valueToCheck);
	}

	// Iteration 3 - now lets get the location of a found word
	// and also test not finding it
	@Test
	public void findWordLtoRInOneRowReturnLocTrue() {
		char rowChars[] = {'a', ',', 
				           'b', ',',
				           'c', ',',
				           'd', ',',
				           'e', ',',
				           'f', ',',
				           'g', ',',
				           'h' };
		
		WordSearch wordSearch = new WordSearch(rowChars, "bcd");
		boolean bLeftToRight = true;
		boolean valueToCheck = wordSearch.findWord(bLeftToRight); 
		assertTrue(valueToCheck);
	}

	@Test
	public void findWordLtoRInOneRowReturnValidLocCoords() {
		char rowChars[] = {'a', ',', 
				           'b', ',',
				           'c', ',',
				           'd', ',',
				           'e', ',',
				           'f', ',',
				           'g', ',',
				           'h' };
		
		WordSearch wordSearch = new WordSearch(rowChars, "bcd");
		boolean bLeftToRight = true;
		boolean bFound = wordSearch.findWord(bLeftToRight);
		FoundWord foundWord = wordSearch.getFoundWord();
		String expectedToString = "bcd: (0,1),(0,2),(0,3)";
		String checkFoundWordToString = foundWord.toString();
		assertEquals(expectedToString, checkFoundWordToString);
	}

	@Test
	public void findWordLtoRInOneRowReturnLocFalse() {
		char rowChars[] = {'a', ',', 
		           'b', ',',
		           'c', ',',
		           'd', ',',
		           'e', ',',
		           'f', ',',
		           'g', ',',
		           'h' };
		
		WordSearch wordSearch = new WordSearch(rowChars, "bqd");
		boolean bLeftToRight = true;
		boolean valueToCheck = wordSearch.findWord(bLeftToRight); 
		assertFalse(valueToCheck);
	}

// Iteration 4: find a word from R to L (reverse direction) in one row
	@Test
	public void findWordRtoLInOneRowReturnLocTrue() {
		char rowChars[] = {'a', ',', 
				           'b', ',',
				           'c', ',',
				           'd', ',',
				           'e', ',',
				           'f', ',',
				           'g', ',',
				           'h' };
		
		WordSearch wordSearch = new WordSearch(rowChars, "hgf");
		boolean bLeftToRightFalse = false;
		boolean valueToCheck = wordSearch.findWord(bLeftToRightFalse); 
		assertTrue(valueToCheck);
	}

	@Test
	public void findWordRtoLInOneRowReturnValidLocCoords() {
		char rowChars[] = {'a', ',', 
				           'b', ',',
				           'c', ',',
				           'd', ',',
				           'e', ',',
				           'f', ',',
				           'g', ',',
				           'h' };
		
		WordSearch wordSearch = new WordSearch(rowChars, "hgf");
		boolean bLeftToRightFalse = false;
		boolean bFound = wordSearch.findWord(bLeftToRightFalse);
		FoundWord foundWord = wordSearch.getFoundWord();
		String expectedToString = "hgf: (0,7),(0,6),(0,5)";
		String checkFoundWordToString = foundWord.toString();
		assertEquals(expectedToString, checkFoundWordToString);
	}

	@Test
	public void findWordRtoLInOneRowReturnLocFalse() {
		char rowChars[] = {'a', ',', 
		           'b', ',',
		           'c', ',',
		           'd', ',',
		           'e', ',',
		           'f', ',',
		           'g', ',',
		           'h' };
		
		WordSearch wordSearch = new WordSearch(rowChars, "hgr");
		boolean bLeftToRightFalse = false;
		boolean valueToCheck = wordSearch.findWord(bLeftToRightFalse); 
		assertFalse(valueToCheck);
	}
	
}