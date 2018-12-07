package ru.rvkhaustov.analysisdata;

import ru.rvkhaustov.analysisdata.init.LoadParams;

/**
 * Created by rvkha_000 on 16.07.2018.
 */
public class SqlRuParser {
    /**
     * @param args path to properties.
     */
    public static void main(String[] args) {
        new LoadParams(args);
    }
}
