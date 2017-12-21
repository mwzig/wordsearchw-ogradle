import java.util.ArrayList;

public class WordSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private char[] inputRow;
	private String inputRowString;
	private String wordToFind;
	private FoundWord foundWord;
	
	public WordSearch(char[] inputRow, String wordToFind) {
	
		this.inputRow = inputRow;
		this.wordToFind = wordToFind;
		// The input row has a comma between each character.
		// We need to parse out the commas.
		inputRowString = "";
		for (int i = 0; i < inputRow.length; i++) {
			if (inputRow[i] != ',') {
				inputRowString += inputRow[i];
			}
		}
	}
	
	public boolean findWordSimple() {
		if (inputRowString.contains(wordToFind)) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean findWord() {
		
		ArrayList<LocCoordinate> locCoordList = new ArrayList<LocCoordinate>();
		
		if (inputRowString.contains(wordToFind)) {
			int yCoord = inputRowString.indexOf(wordToFind);
			LocCoordinate locCoord = new LocCoordinate(0, yCoord);
			locCoordList.add(locCoord);
			// need to start at index 1 because we've already
			// got the first coordinate above
			for (int i = 1; i < wordToFind.length(); i++) {
				locCoord = new LocCoordinate(0, (yCoord + i));
				locCoordList.add(locCoord);
			}
			foundWord = new FoundWord(wordToFind, locCoordList);
			return true;
		}
		else {
			return false;
		}
	}

	public FoundWord getFoundWord() {
		return foundWord;
	}
	
}
