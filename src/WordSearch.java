
public class WordSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private char[] inputRow;
	private String inputRowString;
	private String wordToFind;
	
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
	
	public boolean findWord() {
		if (inputRowString.contains(wordToFind)) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
