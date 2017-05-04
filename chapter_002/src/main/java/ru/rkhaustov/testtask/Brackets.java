package ru.rkhaustov.testtask;

/**
 * Created by rvkha_000 on 04.05.2017.
 */
public class Brackets {
    /**
     * checkBrackets - correct ()().
     * @param brakets - ask text
     * @return true if ()() and false (()))
     */
    public boolean checkBrackets(String brakets) {
        boolean result = false;
        int bracketFirst = 0;
        int bracketSecond = 0;
        for (int index = 0; index < brakets.length(); index++) {
         if (brakets.charAt(index) == '(') {
             bracketFirst++;
         } else if (brakets.charAt(index) == ')') {
             bracketSecond++;
         }
         if ((bracketFirst - bracketSecond) < 0) {
//             result = false;
             break;
         }
        }
        result = ((bracketFirst - bracketSecond) == 0) ? true : false;

        return result;
}
}
