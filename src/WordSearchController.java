import java.util.ArrayList;

public class WordSearchController {
	private WordSearch wordSearch;
	private FoundWord foundWord;
	
	public WordSearchController(WordSearch wordSearch) {
		this.wordSearch = wordSearch;
	}

	// now we have to make up the coordinate list based on if we are 
	// searching vertically
	public boolean checkVerticalLine(int yCoordinate) {
		
		boolean bWordFound = false;
		ArrayList<LocCoordinate> coordList = new ArrayList<LocCoordinate>();
		ArrayList<Integer> locList = wordSearch.findWordNew();
		if (!locList.isEmpty()) {
			bWordFound = true;
			for (int xCoordinate:locList) {
				LocCoordinate locCoordinate = new LocCoordinate(xCoordinate, yCoordinate);
				coordList.add(locCoordinate);
			}
			foundWord = new FoundWord(wordSearch.getWordToFind(), coordList);
		}
		return bWordFound;
	}

	public WordSearch getWordSearch() {
		return wordSearch;
	}

	public FoundWord getFoundWord() {
		return foundWord;
	}
	
}
