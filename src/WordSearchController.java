import java.util.ArrayList;

public class WordSearchController {
	private WordSearch wordSearch;
	private FoundWord foundWord;

	public WordSearchController(WordSearch wordSearch) {
		this.wordSearch = wordSearch;
	}

	// now we have to build the coordinate list based on a vertical search
	public boolean checkVerticalLine(int yCoordinate, boolean forwardSearch) {

		boolean bWordFound = false;
		ArrayList<LocCoordinate> coordList = new ArrayList<LocCoordinate>();
		ArrayList<Integer> locList;
		
		if (forwardSearch) {
			locList = wordSearch.findWordNew();
				
		} else {
			locList = wordSearch.findWordReverseNew();
		}
		if (!locList.isEmpty()) {
			bWordFound = true;
			for (int xCoordinate : locList) {
				LocCoordinate locCoordinate = new LocCoordinate(xCoordinate, yCoordinate);
				coordList.add(locCoordinate);
			}
			foundWord = new FoundWord(wordSearch.getWordToFind(), coordList);
		}
		return bWordFound;
	}

	public FoundWord getFoundWord() {
		return foundWord;
	}

}
