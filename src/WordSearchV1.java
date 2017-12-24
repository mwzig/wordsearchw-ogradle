import java.util.ArrayList;

public class WordSearchV1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private char[] inputRow;
	private String inputRowString;
	private String wordToFind;
	private FoundWord foundWord;

	public WordSearchV1(char[] inputRow, String wordToFind) {

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
		} else {
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
		} else {
			return false;
		}
	}

	public boolean findWordReverse() {

		String wordToLookFor = "";
		for (int i = wordToFind.length() - 1; i >= 0; i--) {
			wordToLookFor += wordToFind.charAt(i);
		}

		ArrayList<LocCoordinate> locCoordList = new ArrayList<LocCoordinate>();

		if (inputRowString.contains(wordToLookFor)) {
			int yCoord = inputRowString.indexOf(wordToLookFor) + wordToLookFor.length() - 1;
			LocCoordinate locCoord = new LocCoordinate(0, yCoord);
			locCoordList.add(locCoord);
			// need to start at index at end of word since we are working in reverse
			for (int i = 1; i < wordToLookFor.length(); i++) {
				locCoord = new LocCoordinate(0, (yCoord - i));
				locCoordList.add(locCoord);
			}
			foundWord = new FoundWord(wordToFind, locCoordList);
			return true;
		} else {
			return false;
		}
	}

	public ArrayList<Integer> findWordNew() {

		ArrayList<Integer> locList = new ArrayList<Integer>();

		if (inputRowString.contains(wordToFind)) {
			int coord = inputRowString.indexOf(wordToFind);
			locList.add(coord);
			// need to start at index 1 because we've already
			// got the first coordinate above
			for (int i = 1; i < wordToFind.length(); i++) {
				locList.add(coord + i);
			}
		}
		return locList;
	}

	public ArrayList<Integer> findWordReverseNew() {

		String wordToLookFor = "";
		for (int i = wordToFind.length() - 1; i >= 0; i--) {
			wordToLookFor += wordToFind.charAt(i);
		}

		ArrayList<Integer> locList = new ArrayList<Integer>();

		if (inputRowString.contains(wordToLookFor)) {
			int coord = inputRowString.indexOf(wordToLookFor) + wordToLookFor.length() - 1;
			locList.add(coord);
			// need to start at index at end of word since we are working in reverse
			for (int i = 1; i < wordToLookFor.length(); i++) {
				locList.add(coord - i);
			}
		}
		return locList;
	}

	public FoundWord getFoundWord() {
		return foundWord;
	}

	public char[] getInputRow() {
		return inputRow;
	}

	public String getInputRowString() {
		return inputRowString;
	}

	public String getWordToFind() {
		return wordToFind;
	}

}
