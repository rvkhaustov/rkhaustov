package ru.rkhaustov.trendreport;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by rvkha_000 on 11.06.2017.
 */
public class ReportTest {
    /**
     * Test method reportTrend.
     */
    @Test
    public void whenPutDataThanReport() {
        TestOutputReport outputReport = new TestOutputReport();
        Report report = new Report(outputReport);
        List<Task> tasks = new ArrayList<>();

        Task taskFirst = new Task(State.NEW, new GregorianCalendar(2017, 06, 01));
        taskFirst.addOperation(new Operation(State.NEW, State.PROSSESING, new GregorianCalendar(2017, 06, 01)));
        taskFirst.addOperation(new Operation(State.PROSSESING, State.RESOLVED, new GregorianCalendar(2017, 06, 02)));
        taskFirst.addOperation(new Operation(State.RESOLVED, State.CLOSED, new GregorianCalendar(2017, 06, 03)));
        tasks.add(taskFirst);
        taskFirst.closeTask(new GregorianCalendar(2017, 6, 03));

        Task taskSecond = new Task(State.NEW, new GregorianCalendar(2017, 6, 04));
        taskSecond.addOperation(new Operation(State.NEW, State.PROSSESING, new GregorianCalendar(2017, 06, 04)));
        taskSecond.addOperation(new Operation(State.PROSSESING, State.RESOLVED, new GregorianCalendar(2017, 06, 05)));
        taskSecond.addOperation(new Operation(State.RESOLVED, State.CLOSED, new GregorianCalendar(2017, 06, 06)));
        tasks.add(taskSecond);
        taskSecond.closeTask(new GregorianCalendar(2017, 06, 06));

        report.reportTrend(tasks,
                new GregorianCalendar(2017, 06, 01),
                new GregorianCalendar(2017, 07, 01),
                Calendar.MONTH);

        assertThat(outputReport.getStringBuilder().toString(), is("2017 авг 01 00:00:00 ;    0;   2;   2;   2;"));
    }
    /**
     * Test method reportTrend.
     */
    @Test
    public void whenPutDataThanReportToConsole() {
        OutputReport outputReport = new ConsoleOutputReport();
        Report report = new Report(outputReport);
        List<Task> tasks = new ArrayList<>();

        Task taskFirst = new Task(State.NEW, new GregorianCalendar(2017, 06, 01));
        taskFirst.addOperation(new Operation(State.NEW, State.PROSSESING, new GregorianCalendar(2017, 06, 01)));
        taskFirst.addOperation(new Operation(State.PROSSESING, State.RESOLVED, new GregorianCalendar(2017, 06, 02)));
        taskFirst.addOperation(new Operation(State.RESOLVED, State.CLOSED, new GregorianCalendar(2017, 06, 03)));
        tasks.add(taskFirst);
        taskFirst.closeTask(new GregorianCalendar(2017, 06, 03));

        Task taskSecond = new Task(State.NEW, new GregorianCalendar(2017, 06, 04));
        taskSecond.addOperation(new Operation(State.NEW, State.PROSSESING, new GregorianCalendar(2017, 06, 04)));
        taskSecond.addOperation(new Operation(State.PROSSESING, State.RESOLVED, new GregorianCalendar(2017, 06, 05)));
        taskSecond.addOperation(new Operation(State.RESOLVED, State.CLOSED, new GregorianCalendar(2017, 06, 06)));
        tasks.add(taskSecond);
        taskSecond.closeTask(new GregorianCalendar(2017, 06, 06));

        report.reportTrend(tasks,
                new GregorianCalendar(2017, 06, 01),
                new GregorianCalendar(2017, 07, 01),
                Calendar.DAY_OF_MONTH);
     }
}