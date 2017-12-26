import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import main.Grid;
import main.GridLetter;
import main.GridLine;
import main.LocCoordinate;

class GridTest2 {

	private GridLetter[][] inputGrid;
	private ArrayList<String> testList;
	
	@Before
    public void executedBeforeEach() {
        testList = new ArrayList();
        System.out.println("@Before: executedBeforeEach");
    }

	@Before
//	public GridLetter[][] formatTestGrid() {
	public void formatTestGrid() {
		LocCoordinate locCoordinate;
		GridLetter gridLetter;
		inputGrid = new GridLetter[8][8];

		for (int xCoordinate = 0; xCoordinate < 8; xCoordinate++) {
			locCoordinate = new LocCoordinate(xCoordinate, 0);
			gridLetter = new GridLetter('a', locCoordinate);
			inputGrid[xCoordinate][0] = gridLetter;

			locCoordinate = new LocCoordinate(xCoordinate, 1);
			gridLetter = new GridLetter('b', locCoordinate);
			inputGrid[xCoordinate][1] = gridLetter;

			locCoordinate = new LocCoordinate(xCoordinate, 2);
			gridLetter = new GridLetter('c', locCoordinate);
			inputGrid[xCoordinate][2] = gridLetter;

			locCoordinate = new LocCoordinate(xCoordinate, 3);
			gridLetter = new GridLetter('d', locCoordinate);
			inputGrid[xCoordinate][3] = gridLetter;

			locCoordinate = new LocCoordinate(xCoordinate, 4);
			gridLetter = new GridLetter('e', locCoordinate);
			inputGrid[xCoordinate][4] = gridLetter;

			locCoordinate = new LocCoordinate(xCoordinate, 5);
			gridLetter = new GridLetter('f', locCoordinate);
			inputGrid[xCoordinate][5] = gridLetter;

			locCoordinate = new LocCoordinate(xCoordinate, 6);
			gridLetter = new GridLetter('g', locCoordinate);
			inputGrid[xCoordinate][6] = gridLetter;

			locCoordinate = new LocCoordinate(xCoordinate, 7);
			gridLetter = new GridLetter('h', locCoordinate);
			inputGrid[xCoordinate][7] = gridLetter;

		}
		//return inputGrid;
		
	}

	@Test
	void testGetGridLinesFromFormatRows() {

		//GridLetter[][] inputGrid = formatTestGrid();
		
		String testType = "Rows";
		Grid testGrid = new Grid(inputGrid, testType);
		ArrayList<GridLine> gridLines = testGrid.getGridLines();
		String checkConcatGridLineStrings = "";
		for (GridLine gridLine: gridLines) {
			checkConcatGridLineStrings += gridLine.getLineString();
			System.out.println(gridLine.toString());
		}

		String expectedConcatGridLineStrings = 
		"abcdefgh" +
		"abcdefgh" +
		"abcdefgh" +
		"abcdefgh" +
		"abcdefgh" +
		"abcdefgh" +
		"abcdefgh" +
		"abcdefgh";
					
		System.out.println("grid row string is " + checkConcatGridLineStrings);
		
		assertEquals(expectedConcatGridLineStrings, checkConcatGridLineStrings);
	}

	// If the reverse logic works for rows, then it will also work for 
	// columns and diagonals...
	@Test
	void testGridLineGetReverse() {

		//GridLetter[][] inputGrid = formatTestGrid();
		
		String testType = "Rows";
		Grid testGrid = new Grid(inputGrid, testType);
		ArrayList<GridLine> gridLines = testGrid.getGridLines();
		String checkConcatGridLineStrings = "";
		for (GridLine gridLine: gridLines) {
			checkConcatGridLineStrings += gridLine.getReverseLine().getLineString();
			System.out.println(gridLine.toString());
		}

		String expectedReverseGridLineString = 
		"hgfedcba" + 
		"hgfedcba" + 
		"hgfedcba" + 
		"hgfedcba" + 
		"hgfedcba" + 
		"hgfedcba" + 
		"hgfedcba" + 
		"hgfedcba";
					
		System.out.println("grid row string is " + checkConcatGridLineStrings);
		
		assertEquals(expectedReverseGridLineString, checkConcatGridLineStrings);
	}

	@Test
	void testGetGridLinesFromFormatColumns() {

		//GridLetter[][] inputGrid = formatTestGrid();
		
		String testType = "Columns";
		Grid testGrid = new Grid(inputGrid, testType);
		ArrayList<GridLine> gridLines = testGrid.getGridLines();
		String checkConcatGridLineStrings = "";
		for (GridLine gridLine: gridLines) {
			checkConcatGridLineStrings += gridLine.getLineString();
			System.out.println(gridLine.toString());
		}

		String expectedConcatGridLineStrings = 
		"aaaaaaaa" +
		"bbbbbbbb" +
		"cccccccc" +
		"dddddddd" +
		"eeeeeeee" +
		"ffffffff" +
		"gggggggg" +
		"hhhhhhhh";
		
		assertEquals(expectedConcatGridLineStrings, checkConcatGridLineStrings);
	}

	@Test
	void testGetGridLinesFromFormatDiagonalsTopLeftToBottomRight() {

		//GridLetter[][] inputGrid = formatTestGrid();
		
		String testType = "DiagonalTopLeftToBottomRight";
		Grid testGrid = new Grid(inputGrid, testType);
		ArrayList<GridLine> gridLines = testGrid.getGridLines();
		String checkConcatGridLineStrings = "";
		for (GridLine gridLine: gridLines) {
			checkConcatGridLineStrings += gridLine.getLineString();
			System.out.println(gridLine.toString());
		}

		String expectedConcatGridLineStrings = "ab" +
		"abc" +
		"abcd" +
		"abcde" +
		"abcdef" +
		"abcdefg" +
		"abcdefgh" +
		"bcdefgh" +
		"cdefgh" +
		"defgh" +
		"efgh" +
		"fgh" +
		"gh";
					
		assertEquals(expectedConcatGridLineStrings, checkConcatGridLineStrings);
	}

	@Test
	void testGetGridLinesFromFormatDiagonalsBottomLeftToTopRight() {

		//GridLetter[][] inputGrid = formatTestGrid();
	
		String testType = "DiagonalBottomLeftToTopRight";
		Grid testGrid = new Grid(inputGrid, testType);
		ArrayList<GridLine> gridLines = testGrid.getGridLines();
		String checkConcatGridLineStrings = "";
		for (GridLine gridLine: gridLines) {
			checkConcatGridLineStrings += gridLine.getLineString();
			System.out.println(gridLine.toString());
		}

		String expectedConcatGridLineStrings = "ab" +
		"abc" +
		"abcd" +
		"abcde" +
		"abcdef" +
		"abcdefg" +
		"abcdefgh" +
		"bcdefgh" +
		"cdefgh" +
		"defgh" +
		"efgh" +
		"fgh" +
		"gh";
		System.out.println("checkConcatString is" + checkConcatGridLineStrings);
					
		assertEquals(expectedConcatGridLineStrings, checkConcatGridLineStrings);
	
	}

}





