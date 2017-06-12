package ru.rkhaustov.trendreport;

/**
 * Created by rvkha_000 on 12.06.2017.
 */
public interface OutputReport {

    /**
     * Intarface for implements: console, csv,  jdbc, xml, collection.
     * @param dataReport datareport.
     */
void putReportTrend(DataReport dataReport);
}
