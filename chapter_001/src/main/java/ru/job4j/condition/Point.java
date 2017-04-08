package ru.job4j.condition;

/**
 * ���������� ��������� ����� �� ������.
 *@author rkhaustov
 *@since 04.2017
 *@version 1
 */
public class Point {
 /**
  * ����������.
  * @param x - x
  */
 private int x;
 /**
  * ����������.
  * @param y - y
  */
 private int y;
  /**
  * �����������.
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
  * ���������� ���������� ����� �� ������� y(x) = a * x + b.
  * @param a - a
  * @param b - b
  * @return ���������
  */
  public boolean is(int a, int b) {
    return (this.y == a * this.x + b) ? true : false;
  }
}