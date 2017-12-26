package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import main.FoundWord;
import main.Grid;
import main.GridLetter;
import main.LocCoordinate;
import main.WordSearch;

public class WordSearchTest {

	private GridLetter[][] inputGrid;

	@Before
	public void setUp() throws Exception {
			
		LocCoordinate locCoordinate;
		GridLetter gridLetter;
		inputGrid = new GridLetter[4][4];

			int xCoordinate = 0; 
			locCoordinate = new LocCoordinate(xCoordinate, 0);
			gridLetter = new GridLetter('c', locCoordinate);
			inputGrid[xCoordinate][0] = gridLetter;

			locCoordinate = new LocCoordinate(xCoordinate, 1);
			gridLetter = new GridLetter('a', locCoordinate);
			inputGrid[xCoordinate][1] = gridLetter;

			locCoordinate = new LocCoordinate(xCoordinate, 2);
			gridLetter = new GridLetter('t', locCoordinate);
			inputGrid[xCoordinate][2] = gridLetter;

			locCoordinate = new LocCoordinate(xCoordinate, 3);
			gridLetter = new GridLetter('s', locCoordinate);
			inputGrid[xCoordinate][3] = gridLetter;
		
			xCoordinate = 1;
			locCoordinate = new LocCoordinate(xCoordinate, 0);
			gridLetter = new GridLetter('o', locCoordinate);
			inputGrid[xCoordinate][0] = gridLetter;

			locCoordinate = new LocCoordinate(xCoordinate, 1);
			gridLetter = new GridLetter('o', locCoordinate);
			inputGrid[xCoordinate][1] = gridLetter;

			locCoordinate = new LocCoordinate(xCoordinate, 2);
			gridLetter = new GridLetter('k', locCoordinate);
			inputGrid[xCoordinate][2] = gridLetter;

			locCoordinate = new LocCoordinate(xCoordinate, 3);
			gridLetter = new GridLetter('g', locCoordinate);
			inputGrid[xCoordinate][3] = gridLetter;
		
			xCoordinate = 2;
			locCoordinate = new LocCoordinate(xCoordinate, 0);
			gridLetter = new GridLetter('d', locCoordinate);
			inputGrid[xCoordinate][0] = gridLetter;

			locCoordinate = new LocCoordinate(xCoordinate, 1);
			gridLetter = new GridLetter('a', locCoordinate);
			inputGrid[xCoordinate][1] = gridLetter;

			locCoordinate = new LocCoordinate(xCoordinate, 2);
			gridLetter = new GridLetter('a', locCoordinate);
			inputGrid[xCoordinate][2] = gridLetter;

			locCoordinate = new LocCoordinate(xCoordinate, 3);
			gridLetter = new GridLetter('o', locCoordinate);
			inputGrid[xCoordinate][3] = gridLetter;
		
			xCoordinate = 3;
			locCoordinate = new LocCoordinate(xCoordinate, 0);
			gridLetter = new GridLetter('y', locCoordinate);
			inputGrid[xCoordinate][0] = gridLetter;

			locCoordinate = new LocCoordinate(xCoordinate, 1);
			gridLetter = new GridLetter('p', locCoordinate);
			inputGrid[xCoordinate][1] = gridLetter;

			locCoordinate = new LocCoordinate(xCoordinate, 2);
			gridLetter = new GridLetter('i', locCoordinate);
			inputGrid[xCoordinate][2] = gridLetter;

			locCoordinate = new LocCoordinate(xCoordinate, 3);
			gridLetter = new GridLetter('d', locCoordinate);
			inputGrid[xCoordinate][3] = gridLetter;
		

	}

	@Test
	public void InitialTest() {
		ArrayList<String> wordsToFind = new ArrayList<String>();
		wordsToFind.add("abc");
		wordsToFind.add("hgf");
		
		Grid letterGrid = new Grid("asdf");
		WordSearch wordSearch = new WordSearch(letterGrid, wordsToFind);
		boolean bAllWordsFound = wordSearch.findWords();
		assertFalse(bAllWordsFound);
	}

	@Test
	public void FindWordsAcross() {
		ArrayList<String> wordsToFind = new ArrayList<String>();
		wordsToFind.add("cats");
		wordsToFind.add("okg");
		wordsToFind.add("daa");
		wordsToFind.add("pi");
		
		Grid letterGrid = new Grid(inputGrid);
		WordSearch wordSearch = new WordSearch(letterGrid, wordsToFind);
		boolean bAllWordsFound = wordSearch.findWords();
		for (FoundWord foundWord: wordSearch.getFoundWords()) {
			System.out.println(foundWord.toString());
		}
		assertTrue(bAllWordsFound);
	}
	@Test
	public void FindWordsDown() {
		ArrayList<String> wordsToFind = new ArrayList<String>();
		wordsToFind.add("ody");
		wordsToFind.add("oap");
		wordsToFind.add("tk");
		wordsToFind.add("sgod");
		
		Grid letterGrid = new Grid(inputGrid);
		WordSearch wordSearch = new WordSearch(letterGrid, wordsToFind);
		boolean bAllWordsFound = wordSearch.findWords();
		for (FoundWord foundWord: wordSearch.getFoundWords()) {
			System.out.println(foundWord.toString());
		}
		assertTrue(bAllWordsFound);
	}
}
