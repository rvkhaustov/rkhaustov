package ru.rkhaustov.map;

import org.junit.Test;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rvkha_000 on 01.06.2017.
 */
public class UserTest {
    /**
     * Test.
     */
    @Test
    public void whenNoEqualsHashCodeThenResalt() {
        Calendar calendar = new GregorianCalendar(2010, 01, 01);
        SimpleDateFormat formatDate = new SimpleDateFormat("dd.MM.yyyy");
        Map<User, Object> map = new HashMap<>();
        User first = new User("Igor", 2, calendar);
        User second = new User("Igor", 2, calendar);
        User third = new User("Igorrr", 2, calendar);
        Object objectFirst = new String("Test1");
        Object objectSecond = new String("Test2");

        map.put(first, objectFirst);
        map.put(second, objectSecond);
        map.put(third, new Object());
        map.put(null, objectFirst);
        map.put(null, objectSecond);
        System.out.println(map);

    }

}