package ru.rkhaustov.trendreport;


import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * Created by rvkha_000 on 12.06.2017.
 */
public class DataReport  {
    /**
     * date.
     */
    private Calendar date;
    /**
     * dataReport.
     */
    private Map<State, Integer> dataReport;

    /**
     * @return date
     */
    public Calendar getDate() {
        return date;
    }


    /**
     * @param date  date
     */
    public DataReport(Calendar date) {
        this.date = date;
        this.dataReport = new LinkedHashMap<>();
        for (State state : State.values()) {
            dataReport.put(state, 0);
        }
    }


    /**
     * @return dataReport
     */
    public Map<State, Integer> getDataReport() {
        return dataReport;
    }
}
