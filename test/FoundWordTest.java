import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class FoundWordTest {

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
