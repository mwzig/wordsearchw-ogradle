package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import main.Grid;
import main.WordSearch;

public class WordSearchTest {

	@Test
	public void testWordSearch() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindWords() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindWord() {
		fail("Not yet implemented");
	}
	
	@Test
	public void InitialTest() {
		ArrayList<String> wordsToFind = new ArrayList<String>();
		wordsToFind.add("abc");
		wordsToFind.add("hgf");
		
		Grid letterGrid = new Grid("asdf");
		WordSearch wordSearch = new WordSearch(letterGrid, wordsToFind);
		wordSearch.findWords();
	}
}
