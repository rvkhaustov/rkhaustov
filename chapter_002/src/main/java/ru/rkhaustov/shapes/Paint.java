package ru.rkhaustov.shapes;

/**
 * @author rkhaustov
 * @version 1.0
 * @since 04.2017
 */
public class Paint  {
    /**
     *
     * @param shape interface Shape.
     */
    public void draw(Shape shape) {
        System.out.println(shape.pic());
    }
}
