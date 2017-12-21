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
		boolean valueToCheck = wordSearch.findWord(); 
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
		boolean bFound = wordSearch.findWord();
		FoundWord foundWord = wordSearch.getFoundWord();
		String expectedToString = "bcd: (0,1),(0,2),(0,3)";
		String checkFoundWordToString = foundWord.toString();
		assertEquals(expectedToString, checkFoundWordToString);
	}

	@Test
	public void findWordLtoRInOneRowReturnLocFalse() {
		char rowChars[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' };
		
		WordSearch wordSearch = new WordSearch(rowChars, "bqd");
		boolean valueToCheck = wordSearch.findWord(); 
		assertFalse(valueToCheck);
	}


}
