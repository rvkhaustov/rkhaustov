package ru.rkhaustov.loop;
/**
* @author rkvhaustov
* @version 1.0
* @since 04.2017
*/
public class Paint {
    /**
    * piramid.
    * @param hight - hight
    * @return dtring
    */
    public String piramid(int hight) {
        int width = hight + (hight - 1);
        StringBuilder paintBild = new StringBuilder();
        String paintStr;
        String separator = System.getProperty("line.separator");
        for (int indHight = 1; indHight <= hight; indHight++) {
        for (int indWidth = 1; indWidth <= width; indWidth++) {
                if (indWidth <= (hight - indHight)) {
                    paintBild.append(" ");
                } else if (indWidth > (width - hight + indHight)) {
                    paintBild.append(" ");
                } else {
                    paintBild.append("^");
                }
            }
            if (indHight < hight) {
                paintBild.append(separator);
            }
        }
        paintStr = paintBild.toString();
        return paintStr;
    }
   }