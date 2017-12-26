import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import main.FoundWord;

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
		
		boolean bForwardSearch = true;
		WordSearchV1 wordSearch = new WordSearchV1(lineChars, "bcd");
		WordSearchController wsController = new WordSearchController(wordSearch);
		boolean valueToCheck = wsController.checkVerticalLine(0, bForwardSearch); 
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
		
		boolean bForwardSearch = true;
			WordSearchV1 wordSearch = new WordSearchV1(lineChars, "bcd");
		WordSearchController wsController = new WordSearchController(wordSearch);
		boolean bFound = wsController.checkVerticalLine(0, bForwardSearch); 
		FoundWord foundWord = wsController.getFoundWord();
		String checkFoundWordToString = foundWord.toString();
		String expectedToString = "bcd: (1,0),(2,0),(3,0)";
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
		boolean bForwardSearch = true;
		WordSearchV1 wordSearch = new WordSearchV1(lineChars, "bqd");
		WordSearchController wsController = new WordSearchController(wordSearch);
		boolean valueToCheck = wsController.checkVerticalLine(0, bForwardSearch); 
		assertFalse(valueToCheck);
	}
	
	// Iteration 6:  Test searching backwards vertically.
	// These are copied from Iteration 4 in in the WordSearchTest class.
	// Get the location of a found word and also test not finding it.

	public void findWordRtoLInOneColumnReturnLocTrue() {
		char lineChars[] = {'a', ',', 
				           'b', ',',
				           'c', ',',
				           'd', ',',
				           'e', ',',
				           'f', ',',
				           'g', ',',
				           'h' };
		
		boolean bForwardSearchFalse = false;
		WordSearchV1 wordSearch = new WordSearchV1(lineChars, "hgf");
		WordSearchController wsController = new WordSearchController(wordSearch);
		boolean valueToCheck = wsController.checkVerticalLine(0, bForwardSearchFalse); 
		assertTrue(valueToCheck);
	}

		@Test
	public void findWordRtoLInOneColumnReturnValidLocCoords() {
		char lineChars[] = {'a', ',', 
				           'b', ',',
				           'c', ',',
				           'd', ',',
				           'e', ',',
				           'f', ',',
				           'g', ',',
				           'h' };
		
		boolean bForwardSearchFalse = false;
		WordSearchV1 wordSearch = new WordSearchV1(lineChars, "hgf");
		WordSearchController wsController = new WordSearchController(wordSearch);
		boolean bFound = wsController.checkVerticalLine(0, bForwardSearchFalse); 
		FoundWord foundWord = wsController.getFoundWord();
		String checkFoundWordToString = foundWord.toString();
		String expectedToString = "hgf: (7,0),(6,0),(5,0)";
		assertEquals(expectedToString, checkFoundWordToString);
	}

	@Test
	public void findWordRtoLInOneColumnReturnLocFalse() {
		char lineChars[] = {'a', ',', 
		           'b', ',',
		           'c', ',',
		           'd', ',',
		           'e', ',',
		           'f', ',',
		           'g', ',',
		           'h' };
		
		boolean bForwardSearchFalse = false;
		WordSearchV1 wordSearch = new WordSearchV1(lineChars, "hgr");
		WordSearchController wsController = new WordSearchController(wordSearch);
		boolean valueToCheck = wsController.checkVerticalLine(0, bForwardSearchFalse); 
		assertFalse(valueToCheck);
	}
	
	
}
