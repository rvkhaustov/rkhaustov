package ru.khaustov.impl;

import org.junit.Before;
import org.junit.Test;
import ru.khaustov.WordIndex;

import java.io.File;
import java.util.Set;

import static org.junit.Assert.assertTrue;

/**
 * Created by rvkha_000 on 24.05.2018.
 */
public class WordIndexImplTest {
    /**
     * WordIndex.
     */
    private WordIndex wordIndex;

    /**
     * ABSOLUTE_PATCH.
     */
    public static final String ABSOLUTE_PATCH = new File("").getAbsolutePath();

    /**
     * WORD_TXT.
     */
    public static final String WORD_TXT = "/src/main/java/ru/khaustov/words.txt";

    /**
     * Load file.
     */
    @Before
    public void setUp() {
        wordIndex = new WordIndexImpl();
        wordIndex.loadFile(ABSOLUTE_PATCH + WORD_TXT);
    }

    /**
     * Test search word.
     */
    @Test
    public void getIndexes4Word() {
        Set<Integer> result = wordIndex.getIndexes4Word("tags");
        assertTrue(result.size() == 2);
        assertTrue(result.contains(167));
        assertTrue(result.contains(222));
    }
}