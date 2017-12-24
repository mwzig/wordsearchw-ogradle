import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GridTest {

	@Test
	void testGrid() {
		Grid testGrid = new Grid("someFileName");
		System.out.println(testGrid.toString());
	}


}
