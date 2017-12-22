import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WordSearchControllerTest {


	// Iteration 5.  Test searching vertically rather than horizontally to find words.
	// See if we can treat a vertical line just like a horizontal line, but instead of
	// always having x = 0, now we always have y = 0.  The logic is moving toward 
	// just treating the search as searching a line of characters, returning the non-x or non-y
	// indicated coordinate, and having the controlling calling function determine whether 
	// to put in a fixed x or y coordinate.
	// (It is basically treating any direction as a row, but then determining the 
	// coordinates based on what direction we are searching - horizontal, vertical, or 
	// diagonal.

	// 
	// These are copied from Iteration 3 in in the WordSearchTest class.
	// Get the location of a found word and also test not finding it.
	@Test
	public void findWordLtoRInOneRowReturnLocTrue() {
		char lineChars[] = {'a', ',', 
				           'b', ',',
				           'c', ',',
				           'd', ',',
				           'e', ',',
				           'f', ',',
				           'g', ',',
				           'h' };
		
		WordSearch wordSearch = new WordSearch(lineChars, "bcd");
		WordSearchController wsController = new WordSearchController(wordSearch);
		boolean valueToCheck = wsController.checkVerticalLine(0); 
		assertTrue(valueToCheck);
	}

	@Test
	public void findWordLtoRInOneRowReturnValidLocCoords() {
		char lineChars[] = {'a', ',', 
				           'b', ',',
				           'c', ',',
				           'd', ',',
				           'e', ',',
				           'f', ',',
				           'g', ',',
				           'h' };
		
		WordSearch wordSearch = new WordSearch(lineChars, "bcd");
		WordSearchController wsController = new WordSearchController(wordSearch);
		boolean bFound = wsController.checkVerticalLine(0); 
		FoundWord foundWord = wsController.getFoundWord();
		String expectedToString = "bcd: (1,0),(2,0),(3,0)";
		String checkFoundWordToString = foundWord.toString();
		assertEquals(expectedToString, checkFoundWordToString);
	}

	@Test
	public void findWordLtoRInOneRowReturnLocFalse() {
		char lineChars[] = {'a', ',', 
		           'b', ',',
		           'c', ',',
		           'd', ',',
		           'e', ',',
		           'f', ',',
		           'g', ',',
		           'h' };
		
		WordSearch wordSearch = new WordSearch(lineChars, "bqd");
		WordSearchController wsController = new WordSearchController(wordSearch);
		boolean valueToCheck = wsController.checkVerticalLine(0); 
		assertFalse(valueToCheck);
	}
	
	

}
