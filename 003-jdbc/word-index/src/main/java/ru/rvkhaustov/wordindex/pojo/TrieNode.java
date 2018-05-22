package ru.rvkhaustov.wordindex.pojo;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by rvkha_000 on 14.05.2018.
 */
public class TrieNode {
    /**
     * children Tree.
     */
    private Map<Character, TrieNode> children = new TreeMap<>();
    /**
     * end word.
     */
    private boolean leaf;
    /**
     * Position word.
     */
    private Position positions;

    /**
     * @param position position
     */
    public void setPosition(Position position) {
        this.positions.setPosition(position);
        this.leaf = true;
    }

    /**
     * @return Position
     */
    public Position getPosition() {
        return this.positions;
    }

    /**
     * Constructor.
     */
    public TrieNode() {
        this.children = new TreeMap<>();
        this.positions = new Position();
    }

    /**
     * @return children tree.
     */
    public Map<Character, TrieNode> getChildren() {
        return children;
    }

    /**
     * @return true if en word? else false.
     */
    public boolean isLeaf() {
        return leaf;
    }



}
