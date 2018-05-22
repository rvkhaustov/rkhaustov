package ru.rvkhaustov.wordindex.impl;

import org.junit.Before;
import org.junit.Test;
import ru.rvkhaustov.wordindex.WordIndex;
import ru.rvkhaustov.wordindex.pojo.Position;
import ru.rvkhaustov.wordindex.pojo.TrieNode;

import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static ru.rvkhaustov.wordindex.utils.StaticVariables.ABSOLUTE_PATCH;
import static ru.rvkhaustov.wordindex.utils.StaticVariables.WORD_TXT;

/**
 * Created by rvkha_000 on 22.05.2018.
 */
public class WordIndexImplTest {
    private WordIndex wordIndex;

    @Before
    public void setUp() {
        wordIndex = new WordIndexImpl();
        wordIndex.loadFile(ABSOLUTE_PATCH + WORD_TXT);
    }

    @Test
    public void loadFile() {
        Map<Character, TrieNode> result = wordIndex.getDaoService().getRootTrieNode().getChildren();
        assertEquals(23, result.size());
    }

    @Test
    public void getIndexes4Word() throws Exception {
        Set<Integer> result = wordIndex.getIndexes4Word("tags");
        assertTrue(result.contains(2));
        assertTrue(result.contains(3));
    }

    @Test
    public void getPositionIndexes4Word() throws Exception {
        Position result = wordIndex.getPositionIndexes4Word("tags");
        assertTrue(result.getLine().contains(2));
        assertTrue(result.getLine().contains(3));
        assertTrue(result.getColumn().contains(9));
        assertTrue(result.getColumn().contains(10));
    }

}