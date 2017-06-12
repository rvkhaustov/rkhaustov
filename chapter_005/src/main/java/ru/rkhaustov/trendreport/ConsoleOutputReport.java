package ru.rkhaustov.trendreport;

import java.text.SimpleDateFormat;


/**
 * Created by rvkha_000 on 12.06.2017.
 */
public class ConsoleOutputReport implements OutputReport {
    /**
     * reportHeader.
     */
    private boolean reportHeader;

    /**
     * Constructor.
     */
    public ConsoleOutputReport() {
        this.reportHeader = true;
    }

    /**
     * @param dataReport data report.
     */
    @Override
    public void putReportTrend(DataReport dataReport) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
        StringBuilder stringBuilder = new StringBuilder();

        if (reportHeader) {
            for (State state : dataReport.getDataReport().keySet()) {
                stringBuilder.append(String.format("%4s;", state));
            }
            System.out.println(String.format("       DATA          ;%s", stringBuilder.toString()));
            reportHeader = false;
        }
        stringBuilder = new StringBuilder();
        for (Integer integer : dataReport.getDataReport().values()) {
            stringBuilder.append(String.format("%4s;", integer));
        }
        System.out.println(String.format("%s ; %s", sdf.format(dataReport.getDate().getTime()),
                stringBuilder.toString()));
    }
}
