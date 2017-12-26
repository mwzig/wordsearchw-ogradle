package main;
import java.util.ArrayList;

public class WordSearch {

	private Grid letterGrid;
	private ArrayList<String> wordsToFind;
	private ArrayList<FoundWord> foundWords;

	public WordSearch(Grid letterGrid, ArrayList<String> wordsToFind) {
		this.letterGrid = letterGrid;
		this.wordsToFind = wordsToFind;
		foundWords = new ArrayList<FoundWord>();
	}

	// If all words found, return true
	public boolean findWords() {

		for (String wordToFind : wordsToFind) {
			findWord(wordToFind);
			
		}
		if (wordsToFind.size() == foundWords.size()) {
			return true; 
		} else {
			return false;
		}
		
	}

	public void findWord(String wordToFind) {

		ArrayList<LocCoordinate> locCoordList = new ArrayList<LocCoordinate>();
		GridLine gridLine;
		for (int i = 0; i < letterGrid.getGridLines().size(); i++) {
			gridLine = letterGrid.getGridLines().get(i);
			if (gridLine.getLineString().contains(wordToFind)) {
				ArrayList<LocCoordinate> locList = gridLine.getGridLocCoordinateList();
				int foundAtIndex = gridLine.getLineString().indexOf(wordToFind);
				locCoordList.add(locList.get(foundAtIndex));
				// need to start at index 1 because we've already
				// got the first coordinate above
				for (int j = 1; j < wordToFind.length(); j++) {
					locCoordList.add(locList.get(foundAtIndex + j));
				}
				foundWords.add(new FoundWord(wordToFind, locCoordList));
			}
		}
	}
	 
}
