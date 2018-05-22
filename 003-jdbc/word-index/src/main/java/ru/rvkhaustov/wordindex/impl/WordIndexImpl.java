package ru.rvkhaustov.wordindex.impl;

import ru.rvkhaustov.wordindex.WordIndex;
import ru.rvkhaustov.wordindex.dao.DaoService;
import ru.rvkhaustov.wordindex.dao.impl.DaoServiceTreeMapImpl;
import ru.rvkhaustov.wordindex.pojo.Position;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.regex.Pattern;

import static ru.rvkhaustov.wordindex.utils.StaticVariables.PATTERN_BETWEEN_WORD;

/**
 * Created by rvkha_000 on 13.05.2018.
 */
public class WordIndexImpl implements WordIndex {

    /**
     * Load data from file and build index.
     *
     * @param filename path + name file
     */
    private DaoService daoService = new DaoServiceTreeMapImpl();

    /**
     * @return DaoService.
     */
    public DaoService getDaoService() {
        return daoService;
    }

    @Override
    public void loadFile(String filename) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(filename), StandardCharsets.UTF_8))) {
            String lineWorlds = reader.readLine();
            int line = 0;
            Pattern pattern = Pattern.compile(PATTERN_BETWEEN_WORD);
            while (lineWorlds != null) {
                String[] words = pattern.split(lineWorlds);
                int column = -1;
                for (String word : words) {
                    column = lineWorlds.indexOf(word, column + 1);
                    daoService.putWord(word, new Position(line, column));
                }
                lineWorlds = reader.readLine();
                line++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param searchWord
     * @return list line word in file. If this word not to return null.
     */
    @Override
    public Set<Integer> getIndexes4Word(String searchWord) {
        Position position = daoService.findWord(searchWord);
        if (position != null && !position.getLine().isEmpty()) {
            return position.getLine();
        }
        return null;
    }

    /**
     * @param searchWord
     * @return list position line and column word in file. If this word not to return null.
     */
    @Override
    public Position getPositionIndexes4Word(String searchWord) {
        Position position = daoService.findWord(searchWord);
        if (position != null && !position.getLine().isEmpty()) {
            return position;
        }
        return null;
    }


}
