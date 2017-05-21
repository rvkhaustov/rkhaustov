package ru.rkhaustov.conversion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by rvkha_000 on 21.05.2017.
 */
public class UserConvertTest {
    /**
     * Test UserConvert.
     */
    @Test
    public void whenUserConvertSetListThenGetHashMap() {
        UserConvert userConvert = new UserConvert();
        List<User> list = new ArrayList<User>();
        list.add(new User(2, "Ivan", "Krasnoyarsk"));
        list.add(new User(4, "Igor", "Novosibirsk"));
        HashMap<Integer, User> result = userConvert.process(list);
        HashMap<Integer, User> expected = new HashMap<Integer, User>();
        expected.put(2, new User(2, "Ivan", "Krasnoyarsk"));
        expected.put(4, new User(4, "Igor", "Novosibirsk"));

        assertThat(result, is(expected));
    }
}