package ru.khaustov;

import java.util.Set;

/**
 * Created by rvkha_000 on 24.05.2018.
 */
public interface WordIndex {
    /**
     * Load data from file and build index.
     *
     * @param filename path + name file
     */
    void loadFile(String filename);

    /**
     * @param  searchWord search Word
     * @return set pisition line  word in file. If this word not to return null.
     */
    Set<Integer> getIndexes4Word(String searchWord);


}
