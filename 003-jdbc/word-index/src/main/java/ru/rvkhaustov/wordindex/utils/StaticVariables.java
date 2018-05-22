package ru.rvkhaustov.wordindex.utils;

import java.io.File;

/**
 * Created by rvkha_000 on 18.05.2018.
 */
public abstract class StaticVariables {

    /**
     * PATTERN_BETWEEN_WORD.
     */
    public static final String PATTERN_BETWEEN_WORD = "[ ,.!?;]";
    /**
     * ABSOLUTE_PATCH.
     */
    public static final String ABSOLUTE_PATCH = new File("").getAbsolutePath();

    /**
     * WORD_TXT.
     */
    public static final String WORD_TXT = "/src/main/java/ru/rvkhaustov/wordindex/utils/words.txt";
}
