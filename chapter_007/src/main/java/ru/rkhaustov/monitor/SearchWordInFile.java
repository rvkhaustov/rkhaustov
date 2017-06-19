package ru.rkhaustov.monitor;

import java.io.IOException;
import java.io.File;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rvkha_000 on 18.06.2017.
 */
public class SearchWordInFile {
    /**
     * threads.
     */
    private List<Thread> threads = new ArrayList<>();
    /**
     * interrupt.
     */
    private Boolean interrupt = true;
    /**
     * interruptFind.
     */
    private static Boolean interruptFind = false;

    /**
     * searchWord.
     */
    private static String searchWord;

    /**
     * @param folder folder
     */
    public void fillThread(File folder) {
        File[] folderEntries = folder.listFiles();
        for (File entry : folderEntries) {
            if (entry.isDirectory()) {
                fillThread(entry);
                continue;
            }
            this.threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    try (BufferedReader reader = new BufferedReader(
                            new InputStreamReader(
                                    new FileInputStream(entry), StandardCharsets.UTF_8))) {
                        String line = reader.readLine();
                        while (line != null && interrupt) {
                            if (line.contains(searchWord) && interrupt) {
                                output(String.format("File:%s Serach word: %s", entry, line));
                            }
                            line = reader.readLine();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }));
        }
    }

    /**
     * @param text text
     */
    public  synchronized void output(String text) {
        if (interrupt) {
            System.out.println(text);
        }
        this.interrupt = this.interruptFind ? false : true;
    }


    /**
     * @param args args
     * @throws  IOException IOException
     */
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            throw new IllegalArgumentException("Error, please, enter: pathDirectory searchText -f (-f found text in the first file, else found text in the all files). Repeet pl");
        }
        File path = new File(args[0]);


        if (!path.isDirectory() || !path.exists()) {
            throw new IllegalArgumentException("Path do not exist");
        }
        searchWord = args[1];

        if (args.length >= 3 && "-f".equals(args[2])) {
            interruptFind = true;
        }

        SearchWordInFile searchWordInFile = new SearchWordInFile();
        searchWordInFile.fillThread(path);

        for (Thread t : searchWordInFile.threads) {
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Finish search.");
    }
}
