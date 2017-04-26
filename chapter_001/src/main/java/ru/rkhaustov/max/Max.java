package ru.rkhaustov.max;

/**
 *
 * @author rkhaustov
 * @since 1.0
 * @version 1.0
 */
public class Max {
  /**
   * Метод возвращает максимальное число.
   * @param first - first
   * @param second - second
   * @return result
   */
  public int max(int first, int second) {
  return first > second ? first : second;
  }
  /**
  * Метод возвращает максимальное число.
   * @param first - first
   * @param second - second
   * @param third - third
   * @return result
   */
    public int max(int first, int second, int third) {
    return max(max(first, second), third);
}
}