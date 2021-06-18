/**
 * [Moveable.java]
 * This interface allows shapes to be shifted by an integer amount
 * along the x-axis and an integer amount along the y-axis
 * @author Edwin Sun
 * @version 1.0 May 10, 2021
 */

public interface Moveable{
  
  /**
   * shiftX
   * This method accepts an integer x and is supposed to shift the shape along the x-axis by x
   * @param x An integer representing the amount to shift along the x-axis
   */
  public void shiftX(int x);
  
  /**
   * shiftY
   * This method accepts an integer y and is supposed to shift the shape along the y-axis by y
   * @param y An integer representing the amount to shift along the y-axis
   */
  public void shiftY(int y);
  
}