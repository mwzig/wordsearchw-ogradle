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
			gridLetter = new GridLetter('a', locCoordinate);
			inputGrid[xCoordinate][0] = gridLetter;

			locCoordinate = new LocCoordinate(xCoordinate, 1);
			gridLetter = new GridLetter('b', locCoordinate);
			inputGrid[xCoordinate][1] = gridLetter;

			locCoordinate = new LocCoordinate(xCoordinate, 2);
			gridLetter = new GridLetter('c', locCoordinate);
			inputGrid[xCoordinate][2] = gridLetter;

			locCoordinate = new LocCoordinate(xCoordinate, 3);
			gridLetter = new GridLetter('d', locCoordinate);
			inputGrid[xCoordinate][3] = gridLetter;
		
			xCoordinate = 1;
			locCoordinate = new LocCoordinate(xCoordinate, 0);
			gridLetter = new GridLetter('e', locCoordinate);
			inputGrid[xCoordinate][0] = gridLetter;

			locCoordinate = new LocCoordinate(xCoordinate, 1);
			gridLetter = new GridLetter('f', locCoordinate);
			inputGrid[xCoordinate][1] = gridLetter;

			locCoordinate = new LocCoordinate(xCoordinate, 2);
			gridLetter = new GridLetter('g', locCoordinate);
			inputGrid[xCoordinate][2] = gridLetter;

			locCoordinate = new LocCoordinate(xCoordinate, 3);
			gridLetter = new GridLetter('h', locCoordinate);
			inputGrid[xCoordinate][3] = gridLetter;
		
			xCoordinate = 2;
			locCoordinate = new LocCoordinate(xCoordinate, 0);
			gridLetter = new GridLetter('i', locCoordinate);
			inputGrid[xCoordinate][0] = gridLetter;

			locCoordinate = new LocCoordinate(xCoordinate, 1);
			gridLetter = new GridLetter('j', locCoordinate);
			inputGrid[xCoordinate][1] = gridLetter;

			locCoordinate = new LocCoordinate(xCoordinate, 2);
			gridLetter = new GridLetter('k', locCoordinate);
			inputGrid[xCoordinate][2] = gridLetter;

			locCoordinate = new LocCoordinate(xCoordinate, 3);
			gridLetter = new GridLetter('l', locCoordinate);
			inputGrid[xCoordinate][3] = gridLetter;
		
			xCoordinate = 3;
			locCoordinate = new LocCoordinate(xCoordinate, 0);
			gridLetter = new GridLetter('m', locCoordinate);
			inputGrid[xCoordinate][0] = gridLetter;

			locCoordinate = new LocCoordinate(xCoordinate, 1);
			gridLetter = new GridLetter('n', locCoordinate);
			inputGrid[xCoordinate][1] = gridLetter;

			locCoordinate = new LocCoordinate(xCoordinate, 2);
			gridLetter = new GridLetter('o', locCoordinate);
			inputGrid[xCoordinate][2] = gridLetter;

			locCoordinate = new LocCoordinate(xCoordinate, 3);
			gridLetter = new GridLetter('p', locCoordinate);
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
		wordsToFind.add("abcd");
		wordsToFind.add("fgh");
		wordsToFind.add("ijk");
		wordsToFind.add("no");
		
		Grid letterGrid = new Grid(inputGrid);
		WordSearch wordSearch = new WordSearch(letterGrid, wordsToFind);
		boolean bAllWordsFound = wordSearch.findWords();
		assertTrue(bAllWordsFound);
	}

	@Test
	public void FindWordsAcrossReverse() {
		ArrayList<String> wordsToFind = new ArrayList<String>();
		wordsToFind.add("dcba");
		wordsToFind.add("hgf");
		wordsToFind.add("kji");
		wordsToFind.add("on");
		
		Grid letterGrid = new Grid(inputGrid);
		WordSearch wordSearch = new WordSearch(letterGrid, wordsToFind);
		boolean bAllWordsFound = wordSearch.findWords();
		assertTrue(bAllWordsFound);
	}
	
	@Test
	public void FindWordsDown() {
		ArrayList<String> wordsToFind = new ArrayList<String>();
		wordsToFind.add("aeim");
		wordsToFind.add("fjn");
		wordsToFind.add("gk");
		wordsToFind.add("dh");
		
		Grid letterGrid = new Grid(inputGrid);
		WordSearch wordSearch = new WordSearch(letterGrid, wordsToFind);
		boolean bAllWordsFound = wordSearch.findWords();
		assertTrue(bAllWordsFound);
	}
	
	@Test
	public void FindWordsDownReverse() {
		ArrayList<String> wordsToFind = new ArrayList<String>();
		wordsToFind.add("miea");
		wordsToFind.add("njf");
		wordsToFind.add("kg");
		wordsToFind.add("hd");
		
		Grid letterGrid = new Grid(inputGrid);
		WordSearch wordSearch = new WordSearch(letterGrid, wordsToFind);
		boolean bAllWordsFound = wordSearch.findWords();
		assertTrue(bAllWordsFound);
	}
	
	@Test
	public void FindWordsDiagonalTopLeftBottomRight() {
		ArrayList<String> wordsToFind = new ArrayList<String>();
		wordsToFind.add("eb");
		wordsToFind.add("ifc");
		wordsToFind.add("mjgd");
		wordsToFind.add("nkh");
		wordsToFind.add("ol");
			
		Grid letterGrid = new Grid(inputGrid);
		WordSearch wordSearch = new WordSearch(letterGrid, wordsToFind);
		boolean bAllWordsFound = wordSearch.findWords();
		assertTrue(bAllWordsFound);
	}

	@Test
	public void FindWordsDiagonalTopLeftBottomRightReverse() {
		ArrayList<String> wordsToFind = new ArrayList<String>();
		wordsToFind.add("be");
		wordsToFind.add("cfi");
		wordsToFind.add("dgjm");
		wordsToFind.add("hkn");
		wordsToFind.add("lo");
			
		Grid letterGrid = new Grid(inputGrid);
		WordSearch wordSearch = new WordSearch(letterGrid, wordsToFind);
		boolean bAllWordsFound = wordSearch.findWords();
		for (FoundWord foundWord: wordSearch.getFoundWords()) {
			System.out.println("diag revers");
			System.out.println(foundWord.toString());
		}
		assertTrue(bAllWordsFound);
	}

	@Test
	public void FindWordsDiagonalBottomLeftTopRight() {
		ArrayList<String> wordsToFind = new ArrayList<String>();
		wordsToFind.add("in");
		wordsToFind.add("ejo");
		wordsToFind.add("afkp");
		wordsToFind.add("bgl");
		wordsToFind.add("ch");
			
		Grid letterGrid = new Grid(inputGrid);
		WordSearch wordSearch = new WordSearch(letterGrid, wordsToFind);
		boolean bAllWordsFound = wordSearch.findWords();
		assertTrue(bAllWordsFound);
	}

	@Test
	public void FindWordsDiagonalBottomLeftTopRightReverse() {
		ArrayList<String> wordsToFind = new ArrayList<String>();
		wordsToFind.add("ni");
		wordsToFind.add("oje");
		wordsToFind.add("pkfa");
		wordsToFind.add("lgb");
		wordsToFind.add("hc");
			
		Grid letterGrid = new Grid(inputGrid);
		WordSearch wordSearch = new WordSearch(letterGrid, wordsToFind);
		boolean bAllWordsFound = wordSearch.findWords();
		assertTrue(bAllWordsFound);
	}
}
