import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LocCoordinateTest {

	@Test
	void testLocCoordinate() {
		LocCoordinate locCoord = new LocCoordinate(0,5);
		assertNotNull(locCoord);
	}

	@Test
	void testToString() {
		String expectedOutput = new String("(0,5)");
		LocCoordinate locCoord = new LocCoordinate(0,5);
		String locCoordToString = locCoord.toString();
		assertEquals(expectedOutput, locCoordToString);
		
	}
	
	}
