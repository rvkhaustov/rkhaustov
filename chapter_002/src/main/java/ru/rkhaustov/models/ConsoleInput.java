package ru.rkhaustov.models;

import java.util.Scanner;

/**
 * Created by rvkha_000 on 25.04.2017.
 * @version 1.0
 * @since 04.2017
 */
public class ConsoleInput implements Input {
    /**
     * @param scanner - Keyboard input.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Method ask.
     * @param question Question parameter
     * @return Response of the user
     */
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
}
