package ru.khaustov.impl;

import ru.khaustov.TrieNode;
import ru.khaustov.WordIndex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Set;

/**
 * Created by rvkha_000 on 24.05.2018.
 */
public class WordIndexImpl implements WordIndex {

    /**
     * Trie node.
     */
    private TrieNode trieNode;

    /**
     * Constructor.
     */
    public WordIndexImpl() {
        this.trieNode = new TrieNodeImpl();
    }

    /**
     * Load data from file and build index.
     *
     * @param filename path + name file
     */
    @Override
    public void loadFile(String filename) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(filename), StandardCharsets.UTF_8))) {
            String lineWorlds = reader.readLine();
            Integer position = 0;

            while (lineWorlds != null) {
                for (Character ch : lineWorlds.toCharArray()) {
                    this.trieNode.put(ch, position++);
                }
                lineWorlds = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param searchWord search Word
     * @return set pisition line  word in file. If this word not to return null.
     */
    @Override
    public Set<Integer> getIndexes4Word(String searchWord) {
        return this.trieNode.find(searchWord);
    }
}
