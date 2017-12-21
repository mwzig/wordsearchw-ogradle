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
		boolean valueToCheck = wordSearch.findWord(); 
		assertTrue(valueToCheck);
	}

	@Test
	public void findWordLtoRInOneRowFalse() {
		char rowChars[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' };
		
		WordSearch wordSearch = new WordSearch(rowChars, "bqd");
		boolean valueToCheck = wordSearch.findWord(); 
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
		boolean valueToCheck = wordSearch.findWord(); 
		assertTrue(valueToCheck);
	}

	@Test
	public void findWordLtoRInOneRowFalse() {
		char rowChars[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' };
		
		WordSearch wordSearch = new WordSearch(rowChars, "bqd");
		boolean valueToCheck = wordSearch.findWord(); 
		assertFalse(valueToCheck);
	}

}
