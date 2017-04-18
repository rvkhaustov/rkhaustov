package ru.job4j.array;

/**
* @author Roman Khaustov
* @version 1.0
* @since 04.20117
*/
public class TestTask {
    /**
    * Method contains.
    * @param origin - string origin
    * @param sub - substring
    * @return true if irigin contains sub
    */
   public boolean contains(String origin, String sub) {
        int lengthOrigin = origin.length();
        int lengthSub = sub.length();
        int indexSub;
        for (int indexOrigin = 0; indexOrigin <= lengthOrigin - lengthSub; indexOrigin++) {
            for (indexSub = 0; indexSub < lengthSub; indexSub++) {
                if (origin.charAt(indexOrigin + indexSub) != sub.charAt(indexSub)) {
                 break;
                }
            }
            if (indexSub == lengthSub) {
                return true;
            }
        }
        return false;
    }
}
