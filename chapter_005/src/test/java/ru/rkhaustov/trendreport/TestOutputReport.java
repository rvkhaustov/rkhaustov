package ru.rkhaustov.trendreport;

import java.text.SimpleDateFormat;

/**
 * Created by rvkha_000 on 12.06.2017.
 */
public class TestOutputReport implements OutputReport {

    /**
     * stringBuilder.
     */
    private StringBuilder stringBuilder = new StringBuilder();

    /**
     * @param dataReport datareport.
     */
    @Override
    public void putReportTrend(DataReport dataReport) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
        stringBuilder.append(sdf.format(dataReport.getDate().getTime()) + " ; ");
        for (Integer integer : dataReport.getDataReport().values()) {
            stringBuilder.append(String.format("%4s;", integer));
        }
    }

    /**
     * @return stringBuilder.
     */
    public StringBuilder getStringBuilder() {
        return stringBuilder;
    }
}
