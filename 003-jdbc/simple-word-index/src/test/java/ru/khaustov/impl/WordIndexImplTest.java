package ru.khaustov.impl;

import org.junit.Before;
import org.junit.Test;
import ru.khaustov.WordIndex;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.core.Is.is;

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

    /**
     * Compare Indexes4Word with String.index.Of .
     */
    @Test
    public void compareIndexes4WordWithIndexOf() {
        List<Integer> integers = new ArrayList<>(wordIndex.getIndexes4Word("a"));
        String str = "The parser will make every attempt parser to create a clean parse from the HTML you provide, regardless of whether the HTML is well-formed or not. It handles:";
        Integer expected = str.indexOf('a');
        assertThat(expected, is(integers.get(0)));
    }
}