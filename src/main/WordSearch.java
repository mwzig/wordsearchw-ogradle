package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.platform.commons.util.StringUtils;

public class WordSearch {

	private String inputFileName;
	private Grid letterGrid;
	private ArrayList<String> wordsToFind;
	private ArrayList<FoundWord> foundWords;

	public WordSearch(Grid letterGrid, ArrayList<String> wordsToFind) {
		this.letterGrid = letterGrid;
		this.wordsToFind = wordsToFind;
		this.foundWords = new ArrayList<FoundWord>();
	}
	
	public WordSearch(String inputFileName) {
		this.inputFileName = inputFileName;
		this.foundWords = new ArrayList<FoundWord>();
		this.wordsToFind = new ArrayList<String>();
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

	public ArrayList<FoundWord> getFoundWords() {
		return foundWords;
	}

	public void readInputFile() {
		String basePath = new File("").getAbsolutePath();
		String inputBasePath = basePath + "/resources";
		System.out.println(basePath);
		int rowNbr = 0;

		// Now read in the input csv file. We will read the data on
		// each line into an arraylist and parse thru it later
		String inputFileName = inputBasePath + this.inputFileName;
		ArrayList<String> gridData = new ArrayList<String>();

		try {
			FileReader fr = new FileReader(inputFileName);
			BufferedReader br = new BufferedReader(fr);
			String gridInputString, gridInputStringNoCommas, inputWordsToFind;
			inputWordsToFind = br.readLine();
			System.out.println(inputWordsToFind);
			String[] words = inputWordsToFind.split(",");
			
			System.out.println("words.length is " + words.length);
			for (int i = 0; i < words.length; i++) {
				System.out.println((words[i]));
			}
			
			for (int i = 0; i < words.length; i++) {
				wordsToFind.add((words[i]));
			}
			
			while ((gridInputString = br.readLine()) != null) {
				gridInputStringNoCommas = gridInputString.replaceAll(",",   "");
				gridInputStringNoCommas = gridInputStringNoCommas.replaceAll(" ", "");
			    gridData.add(gridInputStringNoCommas);
				System.out.println(gridInputStringNoCommas);
			}
			fr.close();
			
			letterGrid = new Grid(gridData);
		} catch (IOException e) {
			e.printStackTrace();
		}

	
		for (String gridRow : gridData) {
			//int firstCommaLoc = tagProductIdPrice.indexOf(',');
			//int secondCommaLoc = tagProductIdPrice.indexOf(',', firstCommaLoc + 1);
			//String tag = tagProductIdPrice.substring(0, firstCommaLoc);
			//String productId = tagProductIdPrice.substring(firstCommaLoc + 1, secondCommaLoc);
			//String price = tagProductIdPrice.substring(secondCommaLoc + 1);
			//String urlWithProductId = urlPartA + productId + urlPartB;
			//Thread.sleep(2000); // if you make too many calls/sec, the API errors for this license
		}
	}

}
