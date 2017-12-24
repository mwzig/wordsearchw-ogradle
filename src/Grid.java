
import java.util.ArrayList;
import java.util.Arrays;

public class Grid {

	private GridLetter[][] gridLetters;
	private ArrayList<GridLine> gridLines;

	public Grid(String inputFile) {
		// todo - read input file, for each letter, create a GridLetter
		// create the grid which is a 2-dim array of GridLetters
		// initialize the private member var wordsToFind from the file
		// Initialize the private member var gridLines by reading
		// each row L to R, R to L columns T to B, B to T,
		// diagonal TL to BR (L to R and R to L), and
		// diagonal BL to TR (L to R and R to L)

		// for now initialize each row with default data for testing
		LocCoordinate locCoordinate;
		GridLetter gridLetter;
		gridLetters = new GridLetter[8][8];
		gridLines = new ArrayList<GridLine>();
		for (int xCoordinate = 0; xCoordinate < 8; xCoordinate++) {
			locCoordinate = new LocCoordinate(xCoordinate, 0);
			gridLetter = new GridLetter('a', locCoordinate);
			gridLetters[xCoordinate][0] = gridLetter;

			locCoordinate = new LocCoordinate(xCoordinate, 1);
			gridLetter = new GridLetter('b', locCoordinate);
			gridLetters[xCoordinate][1] = gridLetter;

			locCoordinate = new LocCoordinate(xCoordinate, 2);
			gridLetter = new GridLetter('c', locCoordinate);
			gridLetters[xCoordinate][2] = gridLetter;

			locCoordinate = new LocCoordinate(xCoordinate, 3);
			gridLetter = new GridLetter('d', locCoordinate);
			gridLetters[xCoordinate][3] = gridLetter;

			locCoordinate = new LocCoordinate(xCoordinate, 4);
			gridLetter = new GridLetter('e', locCoordinate);
			gridLetters[xCoordinate][4] = gridLetter;

			locCoordinate = new LocCoordinate(xCoordinate, 5);
			gridLetter = new GridLetter('f', locCoordinate);
			gridLetters[xCoordinate][5] = gridLetter;

			locCoordinate = new LocCoordinate(xCoordinate, 6);
			gridLetter = new GridLetter('g', locCoordinate);
			gridLetters[xCoordinate][6] = gridLetter;

			locCoordinate = new LocCoordinate(xCoordinate, 7);
			gridLetter = new GridLetter('h', locCoordinate);
			gridLetters[xCoordinate][7] = gridLetter;

		}

		formatGridLines();
	}

	public Grid(GridLetter[][] gridLetters) {
		this.gridLetters = gridLetters;
		gridLines = new ArrayList<GridLine>();
		formatGridLines();
	}

	public Grid(GridLetter[][] gridLetters, String testType) {
		this.gridLetters = gridLetters;
		gridLines = new ArrayList<GridLine>();
		switch (testType) {
		case "DiagonalTopLeftToBottomRight":
			formatGridLinesFromDiagonalsTopLeftToBottomRightPart1();
			formatGridLinesFromDiagonalsTopLeftToBottomRightPart2();
			break;
		case "DiagonalBottomLeftToTopRight":
			formatGridLinesFromDiagonalsBottomLeftToTopRightPart1();
			formatGridLinesFromDiagonalsBottomLeftToTopRightPart2();
			break;
		case "Rows":
			formatGridLinesFromRows();
			break;

		case "Columns":
			formatGridLinesFromColumns();
			break;
		}
	}

	private void formatGridLines() {
		
		

		formatGridLinesFromRows();
		formatGridLinesFromColumns();
		formatGridLinesFromDiagonalsTopLeftToBottomRightPart1();
		formatGridLinesFromDiagonalsTopLeftToBottomRightPart2();
		formatGridLinesFromDiagonalsBottomLeftToTopRightPart1();
		formatGridLinesFromDiagonalsBottomLeftToTopRightPart2();
		
	}

	private void formatGridLinesFromRows() {
		// first, format rows L to R into GridLine objects and add them to the
		// GridLine ArrayList
		GridLine gridLine;
		ArrayList<LocCoordinate> gridLineCoordinateList;
		String lineString;
		for (int row = 0; row < gridLetters.length; row++) {
			lineString = "";
			gridLineCoordinateList = new ArrayList<LocCoordinate>();
			for (int column = 0; column < gridLetters.length; column++) {
				lineString += gridLetters[row][column].getLetter();
				gridLineCoordinateList.add(gridLetters[row][column].getLocCoordinate());

			}
			gridLine = new GridLine(lineString, gridLineCoordinateList);
			gridLines.add(gridLine);
		}
		// Second, format rows R to L into GridLine objects and add them to the
		// Gridline ArrayList

		for (int row = 0; row < gridLetters.length; row++) {
			lineString = "";
			gridLineCoordinateList = new ArrayList<LocCoordinate>();
			for (int column = gridLetters.length - 1; column >= 0; column--) {
				lineString += gridLetters[row][column].getLetter();
				gridLineCoordinateList.add(gridLetters[row][column].getLocCoordinate());

			}
			gridLine = new GridLine(lineString, gridLineCoordinateList);
			gridLines.add(gridLine);
		}
	}

	private void formatGridLinesFromColumns() {
		// first, format columns top to bottom into GridLine objects and add them to the
		// GridLine ArrayList
		GridLine gridLine;
		ArrayList<LocCoordinate> gridLineCoordinateList;
		String lineString;
		for (int column = 0; column < gridLetters.length; column++) {
			lineString = "";
			gridLineCoordinateList = new ArrayList<LocCoordinate>();
			for (int row = 0; row < gridLetters.length; row++) {
				lineString += gridLetters[row][column].getLetter();
				gridLineCoordinateList.add(gridLetters[row][column].getLocCoordinate());

			}
			gridLine = new GridLine(lineString, gridLineCoordinateList);
			gridLines.add(gridLine);
		}
	}

	private void formatGridLinesFromDiagonalsTopLeftToBottomRightPart1() {

		GridLine gridLine;
		ArrayList<LocCoordinate> gridLineCoordinateList;
		String lineString;
		int column = 0;
		int nextColumn = 0;
		int nextRowUp = 0;

		// Start at row 1, column 0
		// That will be the first letter in the GridLine
		// Then move right one, up one until we are out of the grid
		// Then move down to the next row, always starting at column 0
		for (int row = 1; row < gridLetters.length; row++) {
			// re-init vars as we move down each row because we
			// are creating a new GridLine
			column = 0;
			nextColumn = 0;
			nextRowUp = row;
			lineString = "";
			gridLineCoordinateList = new ArrayList<LocCoordinate>();
			// In a diagonal GridLine, we iterate through rows,
			// but we always start at column 0 as our first point
			lineString += gridLetters[row][column].getLetter();
			gridLineCoordinateList.add(gridLetters[row][column].getLocCoordinate());
			nextColumn++;
			nextRowUp--;

			do {
				lineString += gridLetters[nextRowUp][nextColumn].getLetter();
				gridLineCoordinateList.add(gridLetters[nextRowUp][nextColumn].getLocCoordinate());
				nextColumn++;
				nextRowUp--;

			} while (nextColumn < gridLetters.length && nextRowUp >= 0);
			gridLine = new GridLine(lineString, gridLineCoordinateList);
			gridLines.add(gridLine);
		}
	}

	// We reached the longest diagonal line, so now we need to switch axes and
	// process
	// the rest of the diagonals starting from the x-axis
	private void formatGridLinesFromDiagonalsTopLeftToBottomRightPart2() {

		GridLine gridLine;
		ArrayList<LocCoordinate> gridLineCoordinateList;
		String lineString;
		int row = gridLetters.length - 1;
		int nextColumn = 0;
		int nextRowUp = 0;

		// Start at last row, column 1
		// Then move right one, up one until we are out of the grid
		// Then move down to the next row, always starting at column 0
		for (int column = 1; column < gridLetters.length - 1; column++) {
			// re-init vars as we move across each column because we
			// are creating a new GridLine
			lineString = "";
			nextColumn = column;
			nextRowUp = row;
			gridLineCoordinateList = new ArrayList<LocCoordinate>();

			// we are always starting at the last row
			row = gridLetters.length - 1;
			lineString += gridLetters[row][column].getLetter();
			gridLineCoordinateList.add(gridLetters[row][column].getLocCoordinate());

			nextColumn++;
			nextRowUp--;

			do {
				lineString += gridLetters[nextRowUp][nextColumn].getLetter();
				gridLineCoordinateList.add(gridLetters[nextRowUp][nextColumn].getLocCoordinate());
				nextColumn++;
				nextRowUp--;

			} while (nextColumn < gridLetters.length && nextRowUp >= 0);
			gridLine = new GridLine(lineString, gridLineCoordinateList);
			gridLines.add(gridLine);
		}

	}

	private void formatGridLinesFromDiagonalsBottomLeftToTopRightPart1() {

		GridLine gridLine;
		ArrayList<LocCoordinate> gridLineCoordinateList;
		String lineString;
		int column = 0;
		int nextColumn = 0;
		int nextRowDown = 0;

		// Start at the next to the last row (which is grid size -2 because the index
		// starts at 0)
		// Start at column 0
		// Then move right one, down one until we are out of the grid
		// Then move up to the previous row, always starting at column 0
		for (int row = gridLetters.length - 2; row >= 0; row--) {
			// re-init vars as we move down each row because we
			// are creating a new GridLine
			column = 0;
			nextColumn = 0;
			nextRowDown = row;
			lineString = "";
			gridLineCoordinateList = new ArrayList<LocCoordinate>();
			// In a diagonal GridLine, we iterate through rows,
			// but we always start at column 0 as our first point
			lineString += gridLetters[row][column].getLetter();
			gridLineCoordinateList.add(gridLetters[row][column].getLocCoordinate());
			nextColumn++;
			nextRowDown++;

			do {
				lineString += gridLetters[nextRowDown][nextColumn].getLetter();
				gridLineCoordinateList.add(gridLetters[nextRowDown][nextColumn].getLocCoordinate());
				nextColumn++;
				nextRowDown++;
			} while (nextColumn < gridLetters.length && nextRowDown < gridLetters.length);
			gridLine = new GridLine(lineString, gridLineCoordinateList);
			gridLines.add(gridLine);
		}
	}

	private void formatGridLinesFromDiagonalsBottomLeftToTopRightPart2() {

		GridLine gridLine;
		ArrayList<LocCoordinate> gridLineCoordinateList;
		String lineString;
		int column = 0;
		int nextColumn = 0;
		int nextRowDown = 0;

		// Start at the next to the last row (which is grid size -2 because the index
		// starts at 0)
		// Start at column 0
		// Then move right one, down one until we are out of the grid
		// Then move up to the previous row, always starting at column 0
		for (int row = gridLetters.length - 2; row >= 0; row--) {
			// re-init vars as we move down each row because we
			// are creating a new GridLine
			column = 0;
			nextColumn = 0;
			nextRowDown = row;
			lineString = "";
			gridLineCoordinateList = new ArrayList<LocCoordinate>();
			// In a diagonal GridLine, we iterate through rows,
			// but we always start at column 0 as our first point
			lineString += gridLetters[row][column].getLetter();
			gridLineCoordinateList.add(gridLetters[row][column].getLocCoordinate());
			nextColumn++;
			nextRowDown++;

			do {
				lineString += gridLetters[nextRowDown][nextColumn].getLetter();
				gridLineCoordinateList.add(gridLetters[nextRowDown][nextColumn].getLocCoordinate());
				nextColumn++;
				nextRowDown++;
			} while (nextColumn < gridLetters.length && nextRowDown < gridLetters.length);
			gridLine = new GridLine(lineString, gridLineCoordinateList);
			gridLines.add(gridLine);
		}
	}
	
	public ArrayList<GridLine> getGridLines() {
		return gridLines;
	}

	public GridLetter[][] getGridLetters() {
		return gridLetters;
	}

	@Override
	public String toString() {

		for (int x = 0; x < gridLetters.length; x++) {
			for (int y = 0; y < gridLetters.length; y++) {
				System.out.println(gridLetters[x][y]);
			}
			System.out.println();
		}
		return "Grid [gridLetters=" + Arrays.toString(gridLetters) + ",  gridLines=" + gridLines + "]";
	}

}
