package ru.khaustov;

import java.util.Set;

/**
 * Created by rvkha_000 on 24.05.2018.
 */
public interface TrieNode {
    /**
     * @param value    char.
     * @param position position.
     */
    void put(char value, int position);

    /**
     * @param searchWord searc word
     * @return set positions
     */
    Set<Integer> find(String searchWord);
}
