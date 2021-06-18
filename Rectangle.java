/**
 * [Rectangle.java]
 * This class is a subclass of the superclass
 * "Shape" and it represents a rectangle
 * @author Edwin Sun
 * @version 1.0 May 10, 2021
 */

class Rectangle extends Shape implements Moveable{
  
  /**
   * Rectangle
   * This constructor creates a rectangle with the specified x coordinate, y coordinate, colour, height, and width
   * @param x A double representing the x coordinate for the center of the rectangle
   * @param y A double representing the y coordinate for the center of the rectangle
   * @param redAmount An integer representing the red RGB value for the colour of the rectangle
   * @param greenAmount An integer representing the green RGB value for the colour of the rectangle
   * @param blueAmount An integer representing the blue RGB value for the colour of the rectangle
   * @param height A double representing the height of the rectangle
   * @param width A double representing the width of the rectangle
   */
  Rectangle(double x, double y, int redAmount, int greenAmount, int blueAmount, double height, double width){
    super(x, y, redAmount, greenAmount, blueAmount);
    this.setType("Rectangle");
    this.setHeight(height);
    this.setWidth(width);
    this.setArea(this.computeArea());
    this.setPerimeter(this.computePerimeter());
  }
  
  /**
   * computeArea
   * This method returns the area of the rectangle
   * @return A double representing the area of the rectangle
   */
  public double computeArea(){
    return this.getHeight() * this.getWidth();
  }
  
  /**
   * computePerimeter
   * This method returns the perimeter of the rectangle
   * @return A double representing the perimeter of the rectangle
   */
  public double computePerimeter(){
    return this.getHeight() * 2 + this.getWidth() * 2;
  }
  
  /**
   * shiftX
   * This method accepts an integer x, and increments the x coordinate of the rectangle's center by x
   * @param x An integer representing the amount to shift along the x axis
   */
  public void shiftX(int x){
    this.setX(this.getX() + x);
  }
  
  /**
   * shiftY
   * This method accepts an integer y, and increments the y coordinate of the rectangle's center by y
   * @param y An integer representing the amount to shift along the y axis
   */
  public void shiftY(int y){
    
    // Incrementing the y coordinate by y on the coordinate plane is equivalent to 
    // decrementing the y coordinate by y on the Java Graphics plane
    this.setY(this.getY() - y);
  }
}