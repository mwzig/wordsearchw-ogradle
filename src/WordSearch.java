
public class WordSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private char[] inputRow;
	
	private String wordToFind;
	
	public WordSearch(char[] inputRow, String wordToFind) {
	
		this.inputRow = inputRow;
		this.wordToFind = wordToFind;
	}
	
	public boolean findWord() {
		String row = new String(inputRow);
		if (row.contains(wordToFind)) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
