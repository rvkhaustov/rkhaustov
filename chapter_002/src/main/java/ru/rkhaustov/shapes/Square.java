package ru.rkhaustov.shapes;

/**
 * Created by rvkha_000 on 28.04.2017.
 */
public class Square implements Shape {
    @Override
    public String pic() {
        StringBuilder paint = new StringBuilder();
        String paintEnter = System.getProperty("line.separator");
        paint.append(" ******");
        paint.append(paintEnter);
        paint.append(" *    *");
        paint.append(paintEnter);
        paint.append(" *    *");
        paint.append(paintEnter);
        paint.append(" ******");
        return paint.toString();
    }
}
