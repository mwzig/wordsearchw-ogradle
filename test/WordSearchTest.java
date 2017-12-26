import java.util.ArrayList;

import org.junit.Test;


class WordSearchTest {

	@Test
	void InitialTest() {
		ArrayList<String> wordsToFind = new ArrayList<String>();
		wordsToFind.add("abc");
		wordsToFind.add("hgf");
		
		Grid letterGrid = new Grid("asdf");
		WordSearch wordSearch = new WordSearch(letterGrid, wordsToFind);
		wordSearch.findWords();
	}

}