package ru.job4j.condition;

/**
 * Area triangle.
 * @author rkhaustov
 * @version 1
 * @since 04.2017
 */
public class Triangle {
 /**
  * Point a.
  */
  private Point a;
 /**
  * Point b.
  */
  private Point b;
 /**
  * Point c.
  */
  private Point c;
  /**
   * Construction.
   * @param a - a
   * @param b - b
   * @param c - c
   */
  public Triangle(Point a, Point b, Point c) {
  this.a = a;
  this.b = b;
  this.c = c;
  }
 /**
  * @return area triangle.
  */
  public double area() {
   return 1d / 2 * Math.abs((b.getx() - a.getx())
                        * (c.gety() - a.gety())
                        - (c.getx() - a.getx())
                        * (b.gety() - a.gety()));
  }
  /**
   * Method calculating lehngth.
   * @param a - a
   * @param b - b
   * @return length side
   */
   public double lengthSide(Point a, Point b) {
   return Math.hypot(a.getx() - b.getx(), a.gety() - b.gety());
   }
   /**
    * Method check for existencw trangle.
    * @return true or false
    */
    public boolean validate() {
    double ab = lengthSide(a, b);
    double ac = lengthSide(a, c);
    double bc = lengthSide(b, c);

    return ((ab < ac + bc)
         && (ac < ab + bc)
         && (bc < ab + ac));
    }
}

