package ru.rkhaustov.trendreport;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by rvkha_000 on 11.06.2017.
 */
public class Report {

    /**
     * outputReport.
     */
    private OutputReport outputReport;

    /**
     * @param outputReport outputReport
     */
    public Report(OutputReport outputReport) {
        this.outputReport = outputReport;
    }

    /**
     * @param taskList taskList
     * @param startDate startDate
     * @param finishDate finishDate
     * @param period period
     */
    public void reportTrend(List<Task> taskList, Calendar startDate, Calendar finishDate, int period) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
        Calendar fromDate = new GregorianCalendar();
        Calendar toDate = new GregorianCalendar();
        fromDate.setTime(startDate.getTime());
        do {
            toDate.setTime(fromDate.getTime());
            toDate.add(period, 1);
            toDate = toDate.after(finishDate) ? finishDate : toDate;
            DataReport dataReport = new DataReport(fromDate);
            for (Task task : taskList) {
                if (task.getState() == State.CLOSED && task.getModificationDate().before(fromDate)) {
                    dataReport.getDataReport().put(State.CLOSED,
                            dataReport.getDataReport().get(State.CLOSED) + 1);
                } else if (task.getCreateDate().before(toDate)) {
                    for (Operation operation : task.getOperations()) {
                        if (between(operation.getExecutedDate(), fromDate, toDate)) {
                            dataReport.getDataReport().put(operation.getEndState(),
                                   dataReport.getDataReport().get(operation.getEndState()) + 1);
                        }

                    }
                }
            }
            fromDate.setTime(toDate.getTime());
            outputReport.putReportTrend(dataReport);

        } while (fromDate.before(finishDate) || fromDate.compareTo(finishDate) != 0);
    }


    /**
     * @param calendar calendar
     * @param from from
     * @param to to
     * @return false if calendar not between  from to, to if calendar between from to
     */
    public boolean between(Calendar calendar, Calendar from, Calendar to) {
        return  (calendar.compareTo(from) == 0 || calendar.after(from))
                && (calendar.before(to) || calendar.compareTo(to) == 0) ? true : false;
    }
}
