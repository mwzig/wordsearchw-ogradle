package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import main.Grid;
import main.WordSearch;

public class WordSearchTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void InitialTest() {
		ArrayList<String> wordsToFind = new ArrayList<String>();
		wordsToFind.add("abc");
		wordsToFind.add("hgf");
		
		Grid letterGrid = new Grid("asdf");
		WordSearch wordSearch = new WordSearch(letterGrid, wordsToFind);
		wordSearch.findWords();
		boolean bAllWordsFound = wordSearch.findWords();
		assertFalse(bAllWordsFound);
	}

}
