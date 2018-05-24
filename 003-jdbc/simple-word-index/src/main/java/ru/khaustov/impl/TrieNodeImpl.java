package ru.khaustov.impl;

import ru.khaustov.TrieNode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by rvkha_000 on 23.05.2018.
 */
public class TrieNodeImpl implements TrieNode {

    /**
     * Position.
     */
    private Set<Integer> position;

    /**
     * trie.
     */
    private Map<Character, Set<Integer>> trie;

    /**
     * Constructor.
     */
    public TrieNodeImpl() {
        this.trie = new TreeMap<>();
        this.position = new HashSet<>();
    }

    /**
     * @param value    char.
     * @param position position.
     */
    public void put(char value, int position) {
        Set<Integer> positions = trie.get(value) == null ? new HashSet<>() : trie.get(value);
        positions.add(position);
        trie.put(value, positions);
    }

    /**
     * @param searchWord word
     * @return set positions
     */
    public Set<Integer> find(String searchWord) {
        Set<Integer> positions = trie.get(searchWord.charAt(0));
        if (positions == null) {
            return null;
        }

        Set<Integer> resultPositions = new HashSet<>();
        boolean findWord;
        for (Integer startCh : positions) {
            Integer positionSearchWord = 1;
            findWord = true;
            int length = startCh + searchWord.length();
            for (Character characterSearchWord : searchWord.toCharArray()) {
                if (!trie.get(characterSearchWord).contains(startCh++)) {
                    findWord = false;
                    continue;
                }
            }

            if (findWord) {
                resultPositions.add(startCh - searchWord.length());
            }
        }
        return resultPositions.isEmpty() ? null : resultPositions;
    }
}
