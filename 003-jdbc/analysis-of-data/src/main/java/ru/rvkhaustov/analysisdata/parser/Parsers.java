package ru.rvkhaustov.analysisdata.parser;

import org.jetbrains.annotations.Nullable;
import ru.rvkhaustov.analysisdata.dao.ParserDao;

/**
 * Created by rvkha_000 on 10.07.2018.
 */
public interface Parsers {
    /**
     * @param parsersDao impl dao.
     */
    void parseSite(@Nullable ParserDao parsersDao);
}
