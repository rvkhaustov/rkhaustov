package ru.rvkhaustov.analysisdata.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import ru.rvkhaustov.analysisdata.dao.ParserDao;
import ru.rvkhaustov.analysisdata.parser.Parsers;

/**
 * Created by rvkha_000 on 05.08.2018.
 */
public class ParserJob implements Job {

    /**
     * ParserDao.
     */
    private ParserDao parserDao;
    /**
     * parsers.
     */
    private Parsers parsers;

    /**
     * @param jobExecutionContext jobExecutionContext
     * @throws JobExecutionException JobExecutionException
     */
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        parsers.parseSite(parserDao);
    }

    /**
     * @param parserDao parserDao
     */
    public void setParserDao(ParserDao parserDao) {
        this.parserDao = parserDao;
    }

    /**
     * @param parsers parsers
     */
    public void setParsers(Parsers parsers) {
        this.parsers = parsers;
    }
}
