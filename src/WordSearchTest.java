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
		char rowChars[] = {'a', ',', 
		           'b', ',',
		           'c', ',',
		           'd', ',',
		           'e', ',',
		           'f', ',',
		           'g', ',',
		           'h' };
		
		WordSearch wordSearch = new WordSearch(rowChars, "bqd");
		boolean valueToCheck = wordSearch.findWord(); 
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
		boolean valueToCheck = wordSearch.findWordReverse(); 
		assertTrue(valueToCheck);
	}

	// I coded expected coordinates from the end when I was thinking
	// of having a findWordReverse method, and I changed my mind on the
	// logic.  I forgot and ran this test and realized the method was
	// actually returning the right value and my expected value was
	// incorrect.  It's good to have these negative tests... so, I left
	// it, but made it pass by changing the assert to check notequals.
	@Test
	public void findWordRtoLInOneRowReturnValidLocCoordsNegTest() {
		char rowChars[] = {'a', ',', 
				           'b', ',',
				           'c', ',',
				           'd', ',',
				           'e', ',',
				           'f', ',',
				           'g', ',',
				           'h' };
		
		WordSearch wordSearch = new WordSearch(rowChars, "hgf");
		boolean bFound = wordSearch.findWordReverse();
		FoundWord foundWord = wordSearch.getFoundWord();
		String expectedToString = "hgf: (0,7),(0,6),(0,5)";
		String checkFoundWordToString = foundWord.toString();
		assertEquals(expectedToString, checkFoundWordToString);
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
		boolean bFound = wordSearch.findWordReverse();
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
		boolean valueToCheck = wordSearch.findWordReverse(); 
		assertFalse(valueToCheck);
	}
	
}