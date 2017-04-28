package ru.rkhaustov.shapes;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author rkhaustov
 * @version 1.0
 * @since 04.2017
 */
public class PaintTest {
    /**
     * Test Triangle.
     */
    @Test
    public void whenTriangleThenPrintTriangle() {
        Paint paint = new Paint();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        paint.draw(new Triangle());
        String ecpected = "    *\r\n   * *\r\n  *   *\r\n *     *\r\n*********\r\n";
        assertThat(out.toString(), is(ecpected));
    }
    /**
     * Test Square.
     */
    @Test
    public void whenSquareThenPrintSquare() {
        Paint paint = new Paint();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        paint.draw(new Square());
        String ecpected = " ******\r\n *    *\r\n *    *\r\n ******\r\n";
        assertThat(out.toString(), is(ecpected));
    }
}
