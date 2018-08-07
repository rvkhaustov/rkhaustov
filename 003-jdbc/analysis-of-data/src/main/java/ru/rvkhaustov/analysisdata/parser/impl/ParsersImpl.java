package ru.rvkhaustov.analysisdata.parser.impl;

import org.jetbrains.annotations.Nullable;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.LoggerFactory;
import ru.rvkhaustov.analysisdata.dao.ParserDao;
import ru.rvkhaustov.analysisdata.parser.Parsers;
import ru.rvkhaustov.analysisdata.pojo.Vacancy;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;

import static ru.rvkhaustov.analysisdata.util.StaticParameters.CLASS_ALT_COL;
import static ru.rvkhaustov.analysisdata.util.StaticParameters.CLASS_POSTS_LIST_TOPIC;
import static ru.rvkhaustov.analysisdata.util.StaticParameters.PATTERN;
import static ru.rvkhaustov.analysisdata.util.StaticParameters.START_PARSERS;
import static ru.rvkhaustov.analysisdata.util.StaticParameters.STRING_SERCH;
import static ru.rvkhaustov.analysisdata.util.StaticParameters.USER_AGENT;

/**
 * Created by rvkha_000 on 12.05.2018.
 */
public class ParsersImpl implements Parsers {
    /**
     * Logger.
     */
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ParsersImpl.class);

    /**
     * @param parsersDao impl dao.
     */
    @Override
    public void parseSite(@Nullable ParserDao parsersDao)  {

        Long fromDate = null;
        boolean dao = true;
        if (parsersDao != null) {
            fromDate = parsersDao.lastDate();
        } else {
            fromDate = Calendar.getInstance().getTimeInMillis() - 2592000000L; // last 30 day
            dao = false;
        }
        Calendar date = Calendar.getInstance();
        date.setTimeInMillis(fromDate);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yy HH:mm");
        LOGGER.info(START_PARSERS, simpleDateFormat.format(date.getTime()));

        boolean stopSearch = false;
        int page = 1;

        while (!stopSearch) {
            try {
                Document doc = Jsoup
                        .connect(String.format(STRING_SERCH, page++))
                        .userAgent(USER_AGENT)
                        .get();
                Elements elementTopics = doc.getElementsByClass(CLASS_POSTS_LIST_TOPIC);
                Elements elementDateUpdateTopics = doc.getElementsByClass(CLASS_ALT_COL);
                Vacancy vacancy;
                Integer indexDateUpdateTopics = 1;
                for (Element element : elementTopics) {
                    Element elem = element.child(0);
                    Long dateUpdateTopic = getDate(elementDateUpdateTopics.get(indexDateUpdateTopics).text()).getTimeInMillis();
                    if (indexDateUpdateTopics > 10 && dateUpdateTopic <= fromDate) {
                        stopSearch = true;
                        break;
                    }
                    indexDateUpdateTopics += 2;
                    String text = elem.text();
                    String ref = elem.attr("href");
                    Matcher matcher = PATTERN.matcher(text);
                    if (matcher.find()) {
                        vacancy = parseToVacancy(text, ref, fromDate);
                        if (dao && vacancy != null) {
                            parsersDao.insert(vacancy);
                        }
                    }
                }
            } catch (IOException | ParseException e) {
                LOGGER.error(e.getMessage(), e);
            }
        }
        parsersDao.insertConfig();
        LOGGER.info("Search Finished.");
        LOGGER.info(String.format("Pages viewed: %s", page - 1));
    }

    /**
     * @param text text
     * @param ref ref
     * @param lastDate last date
     * @return vacancy.
     */
    private Vacancy parseToVacancy(final String text, final String ref, final Long lastDate) {
        Vacancy vacancy = null;
        try {
            Document doc = Jsoup.connect(ref).userAgent(USER_AGENT).get();
            Element element = doc.getElementsByClass("msgTable").first();
            Element el = element.child(0);
            String body = el.getElementsByClass("msgBody").last().text();
            Calendar date = this.getDate(el.getElementsByClass("msgFooter").last().text());
            if (date.getTimeInMillis() > lastDate) {
                vacancy = new Vacancy(text, body, ref, date);
                LOGGER.info(vacancy.toString());
            }
        } catch (IOException | ParseException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return vacancy;
    }

    /**
     * @param text string with date.
     * @return Calendar
     * @throws ParseException ParseException
     */
    private Calendar getDate(final String text) throws ParseException {
        final long day = 86400000L;
        SimpleDateFormat spd = new SimpleDateFormat("dd MMM yy HH:mm");
        long milliseconds;
        String result = text.replaceAll("\u00a0", "").replaceAll(",", "").split("\\[")[0];
        if (result.contains("сегодня")) {
            milliseconds = getTimeMillis(result.split(" ")[1]);
        } else if (result.contains("вчера")) {
            milliseconds = getTimeMillis(result.split(" ")[1]) - day;
        } else {
            milliseconds = spd.parse(result).getTime();
        }
        Calendar date = Calendar.getInstance();
        date.setTimeInMillis(milliseconds);
        return date;
    }


    /**
     * @param s string with date.
     * @return millis.
     */
    private long getTimeMillis(final String s) {
        int hour;
        int minute;
        String[] tmp = s.split(":");
        hour = Integer.parseInt(tmp[0]);
        minute = Integer.parseInt(tmp[1]);
        Calendar calendarToday = Calendar.getInstance();
        return new GregorianCalendar(calendarToday.get(Calendar.YEAR),
                calendarToday.get(Calendar.MONTH),
                calendarToday.get(Calendar.DAY_OF_MONTH),
                hour,
                minute).getTimeInMillis();
    }
}

