import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class FoundWordTest {

	// Test the FoundWord toString method here because the FoundWord class 
	// really just stores the word found and its list of coordinates,
	// and the toString method on it is what will be used eventually to print out
	// the list of found words and their coordinates.
	@Test
	void testToStringOneCoordinate() {
		String expectedOutput = "abc: (0,1)";
		LocCoordinate locCoord = new LocCoordinate(0,1);
		ArrayList<LocCoordinate> locList = new ArrayList<LocCoordinate>();
		locList.add(locCoord);
		FoundWord foundWord = new FoundWord("abc", locList);
		String outputToCheck = foundWord.toString(); 
		assertEquals(expectedOutput, outputToCheck);
		
	}

	@Test
	void testToStringTwoCoordinates() {
		String expectedOutput = "abc: (0,1),(0,2)";
		LocCoordinate locCoord1 = new LocCoordinate(0,1);
		LocCoordinate locCoord2 = new LocCoordinate(0,2);
		ArrayList<LocCoordinate> locList = new ArrayList<LocCoordinate>();
		locList.add(locCoord1);
		locList.add(locCoord2);
		FoundWord foundWord = new FoundWord("abc", locList);
		String outputToCheck = foundWord.toString(); 
		assertEquals(expectedOutput, outputToCheck);
				
	}

}
