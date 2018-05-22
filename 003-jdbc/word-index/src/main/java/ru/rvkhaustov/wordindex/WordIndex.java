package ru.rvkhaustov.wordindex;

import ru.rvkhaustov.wordindex.dao.DaoService;
import ru.rvkhaustov.wordindex.pojo.Position;

import java.util.Set;

/**
 * Created by rvkha_000 on 13.05.2018.
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

    /**
     * @param searchWord search Word
     * @return list position line and column word in file. If this word not to return null.
     */
    Position getPositionIndexes4Word(String searchWord);

    /**
     * @return Daoservice.
     */
     DaoService getDaoService();
}
