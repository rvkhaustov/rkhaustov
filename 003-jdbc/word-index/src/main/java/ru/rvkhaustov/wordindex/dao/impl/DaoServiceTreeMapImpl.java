package ru.rvkhaustov.wordindex.dao.impl;

import ru.rvkhaustov.wordindex.dao.DaoService;
import ru.rvkhaustov.wordindex.pojo.Position;
import ru.rvkhaustov.wordindex.pojo.TrieNode;

/**
 * Created by rvkha_000 on 14.05.2018.
 */
public class DaoServiceTreeMapImpl implements DaoService {
    /**
     * Root tree node.
     */
    private TrieNode rootTrieNode;

    /**
     * Constructor.
     */
    public DaoServiceTreeMapImpl() {
        rootTrieNode = new TrieNode();
    }

    /**
     * @return TrieNode
     */
    public TrieNode getRootTrieNode() {
        return rootTrieNode;
    }

    /**
     * @param word     word
     * @param position position line, column
     */
    @Override
    public void putWord(String word, Position position) {
        if (word == null) {
            System.out.println("Error, word must not = null");
            return;
        }
        TrieNode trieNode = rootTrieNode;
        for (char key : word.toLowerCase().toCharArray()) {
            if (!trieNode.getChildren().containsKey(key)) {
                trieNode.getChildren().put(key, new TrieNode());
            }
            trieNode = trieNode.getChildren().get(key);
        }
        trieNode.setPosition(position);
    }

    /**
     * @param word word
     * @return position line, column
     */
    @Override
    public Position findWord(String word) {
        if (word == null) {
            System.out.println("Error, word must not = null");
            return null;
        }
        TrieNode trieNode = rootTrieNode;
        for (char key : word.toLowerCase().toCharArray()) {
            if (!trieNode.getChildren().containsKey(key)) {
                return null;
            } else {
                trieNode = trieNode.getChildren().get(key);
            }
        }
        if (trieNode.isLeaf()) {
            return trieNode.getPosition();
        }
        return null;
    }

}
