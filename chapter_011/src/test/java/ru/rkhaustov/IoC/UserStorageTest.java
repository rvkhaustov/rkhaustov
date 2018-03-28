package ru.rkhaustov.IoC;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by rvkha_000 on 25.09.2017.
 */
public class UserStorageTest {
    static void m(byte b) {
        System.out.println("b");
    }

    @Test
    public void rr() {

    }
    @Test
    public void whenAdd(){
        MemoryStorage memory =  new MemoryStorage();
        UserStorage storage = new UserStorage(memory);
        storage.add(new User());
    }

    @Test
    public void whenAddSpringContex() {
//        ApplicationContext context = new ClassPathXmlApplicationContext("s");
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        MemoryStorage memoryStorage = context.getBean(MemoryStorage.class);
        System.out.println(memoryStorage);
    }
    @Test
    public void whenAddSpringContexStorage() {
//        ApplicationContext context = new ClassPathXmlApplicationContext("s");
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        UserStorage storage = context.getBean(UserStorage.class);
      storage.add(new User());
      byte b =7;


    }

}