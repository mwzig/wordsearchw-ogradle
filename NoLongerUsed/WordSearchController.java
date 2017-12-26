import java.util.ArrayList;

import main.FoundWord;
import main.LocCoordinate;

public class WordSearchController {
	private WordSearchV1 wordSearch;
	private FoundWord foundWord;

	public WordSearchController(WordSearchV1 wordSearch) {
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
