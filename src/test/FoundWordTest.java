package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import main.FoundWord;
import main.LocCoordinate;

public class FoundWordTest {

	@Test
	public void testToStringOneCoordinate() {
		String expectedOutput = "abc: (0,1)";
		LocCoordinate locCoord = new LocCoordinate(0,1);
		ArrayList<LocCoordinate> locList = new ArrayList<LocCoordinate>();
		locList.add(locCoord);
		FoundWord foundWord = new FoundWord("abc", locList);
		String outputToCheck = foundWord.toString(); 
		assertEquals(expectedOutput, outputToCheck);
		
	}

	@Test
	public void testToStringTwoCoordinates() {
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
