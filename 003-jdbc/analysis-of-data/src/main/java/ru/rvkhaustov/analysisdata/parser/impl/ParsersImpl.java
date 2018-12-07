package ru.rvkhaustov.analysisdata.parser.impl;

import org.jetbrains.annotations.Nullable;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.LoggerFactory;
import ru.rvkhaustov.analysisdata.dao.ParserDao;
import ru.rvkhaustov.analysisdata.dto.Vacancy;
import ru.rvkhaustov.analysisdata.parser.Parsers;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Matcher;

import static ru.rvkhaustov.analysisdata.util.StaticParameters.CLASS_ALT_COL;
import static ru.rvkhaustov.analysisdata.util.StaticParameters.CLASS_POSTS_LIST_TOPIC;
import static ru.rvkhaustov.analysisdata.util.StaticParameters.DATE_TIME_FORMATTER_TOPIC;
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
     * TODAY.
     */
    private static final String TODAY = "сегодня";
    /**
     * YESTERDAY.
     */
    private static final String YESTERDAY = "вчера";
    /**
     * HH_MM.
     */
    private static final String HH_MM = "HH:mm";
    /**
     * DATE_TIME_FORMATTER_TOPICS.
     */
    private static final DateTimeFormatter DATE_TIME_FORMATTER_TOPICS = DateTimeFormatter.ofPattern("[d MMM yy HH:mm][dd MMM yy HH:mm]").withLocale(Locale.getDefault()); //.forLanguageTag("ru","RU"));


    /**
     * @param parsersDao impl dao.
     */
    @Override
    public void parseSite(@Nullable ParserDao parsersDao) {
        LocalDateTime fromDateTime = parsersDao.lastDateTime();
        LOGGER.info(START_PARSERS, fromDateTime.format(DATE_TIME_FORMATTER_TOPIC));
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
                    LocalDateTime dateUpdateTopic = getDate(elementDateUpdateTopics.get(indexDateUpdateTopics).text());
                    if (indexDateUpdateTopics > 10 && dateUpdateTopic.isBefore(fromDateTime)) {
                        stopSearch = true;
                        break;
                    }
                    indexDateUpdateTopics += 2;
                    String text = elem.text();
                    String ref = elem.attr("href");
                    Matcher matcher = PATTERN.matcher(text);
                    if (matcher.find()) {
                        vacancy = parseToVacancy(text, ref, fromDateTime);
                        if (vacancy != null) {
                            parsersDao.insert(vacancy);
                        }
                    }
                }
            } catch (IOException | ParseException e) {
                LOGGER.error(e.getMessage(), e);
            }
        }
        parsersDao.insertConfig();
        LOGGER.info(String.format("Search Finished. Pages viewed: %s", page - 1));
    }

    /**
     * @param text          text
     * @param ref           ref
     * @param localDateTime last date
     * @return vacancy.
     */
    private Vacancy parseToVacancy(final String text, final String ref, final LocalDateTime localDateTime) {
        Vacancy vacancy = null;
        try {
            Document doc = Jsoup.connect(ref).userAgent(USER_AGENT).validateTLSCertificates(false).get();
            Element element = doc.getElementsByClass("msgTable").first();
            Element el = element.child(0);
            String body = el.getElementsByClass("msgBody").last().text();
            LocalDateTime vacancyDateTime = this.getDate(el.getElementsByClass("msgFooter").last().text());
            if (vacancyDateTime.isAfter(localDateTime)) {
                vacancy = new Vacancy(text, body, ref, vacancyDateTime);
                LOGGER.info(vacancy.toString());
            }
        } catch (IOException | ParseException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return vacancy;
    }

    /**
     * @param text string with date.
     * @return LocalDateTime
     * @throws ParseException ParseException
     */
    private LocalDateTime getDate(final String text) throws ParseException {
        String textDateTimes = text
                .replaceAll("\u00a0", "")
                .replaceAll(",", "")
                .replace("май", "мая")
                .split("\\[")[0].trim();
        if (textDateTimes.contains(TODAY)) {
            return LocalDateTime.of(LocalDate.now(),
                    LocalTime.parse(textDateTimes.split(" ")[1], DateTimeFormatter.ofPattern(HH_MM)));
        } else if (textDateTimes.contains(YESTERDAY)) {
            return LocalDateTime.of(LocalDate.now().minusDays(1),
                    LocalTime.parse(textDateTimes.split(" ")[1], DateTimeFormatter.ofPattern(HH_MM)));
        }
        return LocalDateTime.parse(textDateTimes, DATE_TIME_FORMATTER_TOPICS);
    }
}

