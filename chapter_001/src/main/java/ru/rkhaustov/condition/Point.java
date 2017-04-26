package ru.rkhaustov.condition;

/**
 * Определить положение точки на прямой.
 *@author rkhaustov
 *@since 04.2017
 *@version 1
 */
public class Point {
 /**
  * Координаты.
  * @param x - x
  */
 private int x;
 /**
  * Координаты.
  * @param y - y
  */
 private int y;
  /**
  * Конструктор.
  * @param x - x
  * @param y - y
  */
 public Point(int x, int y) {
  this.x = x;
  this.y = y;
 }
 /**
  * Get x.
  * @return x
  */
 public int getx() {
 return this.x;
 }
/**
  * Get y.
  * @return y
  */
 public int gety() {
 return this.y;
 }
  /**
  * Определяет нахождения точки на функции y(x) = a * x + b.
  * @param a - a
  * @param b - b
  * @return результат
  */
  public boolean is(int a, int b) {
    return (this.y == a * this.x + b) ? true : false;
  }
}