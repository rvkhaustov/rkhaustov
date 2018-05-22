package ru.rvkhaustov.wordindex.dao;

import ru.rvkhaustov.wordindex.pojo.Position;
import ru.rvkhaustov.wordindex.pojo.TrieNode;

/**
 * Created by rvkha_000 on 14.05.2018.
 */
public interface DaoService {
    /**
     * @param word     word
     * @param position position line, column
     */
    void putWord(String word, Position position);

    /**
     * @param word word
     * @return position line, column
     */
    Position findWord(String word);

    /**
     * @return TrieNode
     */
    TrieNode getRootTrieNode();

}
