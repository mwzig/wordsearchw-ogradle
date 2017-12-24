
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

}
