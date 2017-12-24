
import java.util.ArrayList;
import java.util.Arrays;

public class Grid {

	private GridLetter[][] gridLetters;
	private ArrayList<String> wordsToFind;
	private ArrayList<GridLine> gridLines;
	private ArrayList<FoundWord> foundWords;

	public Grid(String inputFile) {
		// todo - read input file, for each letter, create a GridLetter
		// create the 2-dim array of letters gridLetters
		// initialize the private member var wordsToFind
		// initialize the private member var gridLines by reading
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
		String wordToFind1 = "bcd";
		String wordToFind2 = "hgf";
		wordsToFind = new ArrayList<String>();
		wordsToFind.add(wordToFind1);
		wordsToFind.add(wordToFind2);

		formatGridLines();
	}

	private void formatGridLines() {
		formatGridLinesFromRows();
		//formatGridLinesFromColumns();
		formatGridLinesFromDiagonals();
	}

	private void formatGridLinesFromColumns() {

		// first, format rows L to R into GridLine objects and add them to the
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

	private void formatGridLinesFromDiagonals() {
	
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
			//re-init vars as we move down each row because we 
			//are creating a new GridLine
			column = 0;
			nextColumn = 0;
			nextRowUp = row;
			lineString = "";
			gridLineCoordinateList = new ArrayList<LocCoordinate>();
			//In a diagonal GridLine, we iterate through rows, 
			//but we always start at column 0 as our first point
			lineString += gridLetters[row][column].getLetter();
			gridLineCoordinateList.add(gridLetters[row][column].getLocCoordinate());
			nextColumn++;
			nextRowUp--;
			
			do {
				System.out.println("nextColumn is " + nextColumn);
				System.out.println("nextRowUp is " + nextRowUp);
				lineString += gridLetters[nextRowUp][nextColumn].getLetter();
				gridLineCoordinateList.add(gridLetters[nextRowUp][nextColumn].getLocCoordinate());
				nextColumn++;
				nextRowUp--;
					
			} while (nextColumn < gridLetters.length  && nextRowUp >= 0); 
			gridLine = new GridLine(lineString, gridLineCoordinateList);
			gridLines.add(gridLine);
			System.out.println(gridLine);
		}
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

	@Override
	public String toString() {

		for (int x = 0; x < gridLetters.length; x++) {
			for (int y = 0; y < gridLetters.length; y++) {
				System.out.println(gridLetters[x][y]);
			}
			System.out.println();
		}
		return "Grid [gridLetters=" + Arrays.toString(gridLetters) + ", wordsToFind=" + wordsToFind + ", gridLines="
				+ gridLines + ", foundWords=" + foundWords + "]";
	}

	public GridLetter[][] getGridLetters() {
		return gridLetters;
	}

	public ArrayList<String> getWordsToFind() {
		return wordsToFind;
	}

	public ArrayList<GridLine> getGridLines() {
		return gridLines;
	}

	public ArrayList<FoundWord> getFoundWords() {
		return foundWords;
	}

}
