package ru.rkhaustov.threads;

/**
 * Created by rvkha_000 on 13.06.2017.
 */
public class CountInText {
    /**
     *
     */
 private boolean stopThreads;
    /**
     * text.
     */
    private String text;

    /**
     * @param stopThreads stopThreads
     */
    public void setStopThreads(boolean stopThreads) {
        this.stopThreads = stopThreads;
    }

    /**
     * @param text text
     */
    public CountInText(String text) {
        this.text = text;
        stopThreads = true;
    }

    /**
     * @return number space.
     */
    public int countSpace() {
        int countSpace = 0;
        for (int index = 0; (stopThreads && index < text.length()); index++) {
            if (Thread.currentThread().isInterrupted()) {
                return -1;
            }
            if (text.charAt(index) == ' ') {
                countSpace++;
            }
        }
        return countSpace;
    }

    /**
     * @return number Word
     */
    public int countWord() {
        String separator = System.getProperty("line.separator");
        int fromIndex = 0;
        int countWord = 0;
        do {
            int space = text.indexOf(' ', fromIndex);
            int endLine = text.indexOf(separator, fromIndex);
            if (space == -1 && endLine == -1) {
                break;
            }
            if (endLine == -1 || space < endLine) {
                fromIndex = space + 1;
                if (text.charAt(fromIndex) != ' ') {
                    countWord++;
                }
            } else {
                fromIndex = endLine + separator.length();
                countWord++;
            }
            if (Thread.currentThread().isInterrupted()) {
                return -1;
            }
        } while (stopThreads);
        return ++countWord;
    }
  }
