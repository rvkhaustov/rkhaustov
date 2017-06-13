package ru.rkhaustov.threads;

/**
 * Created by rvkha_000 on 13.06.2017.
 */
public class CountInText {

    /**
     * text.
     */
    private String text;

    /**
     * @param text text
     */
    public CountInText(String text) {
        this.text = text;
    }

    /**
     * @return number space.
     */
    public int countSpace() {
        int countSpace = 0;
        for (int index = 0; index < text.length(); index++) {
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
        } while (true);
        return ++countWord;
    }
  }
