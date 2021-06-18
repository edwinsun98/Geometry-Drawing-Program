/**
 * [Square.java]
 * This class is a subclass of the superclass
 * "Shape" and it represents a square
 * @author Edwin Sun
 * @version 1.0 May 10, 2021
 */

class Square extends Shape implements Moveable{
  
  private double sideLength;
  
  /**
   * Square
   * This constructor creates a square with the specified x coordinate, y coordinate, colour, and the side length
   * @param x A double representing the x coordinate for the center of the square
   * @param y A double representing the y coordinate for the center of the square
   * @param redAmount An integer representing the red RGB value for the colour of the square
   * @param greenAmount An integer representing the green RGB value for the colour of the square
   * @param blueAmount An integer representing the blue RGB value for the colour of the square
   * @param sideLength A double representing the side length of the square
   */
  Square(double x, double y, int redAmount, int greenAmount, int blueAmount, double sideLength){
    super(x, y, redAmount, greenAmount, blueAmount);
    this.setType("Square");
    this.sideLength = sideLength;
    this.setHeight(sideLength);
    this.setWidth(sideLength);
    this.setArea(this.computeArea());
    this.setPerimeter(this.computePerimeter());
  }
  
  /**
   * getSideLength
   * This method returns a double representing the side length of the square
   * @return A double representing the side length of the square
   */
  public double getSideLength(){
    return this.sideLength;
  }
  
  /**
   * computeArea
   * This method returns the area of the square
   * @return A double representing the area of the square
   */
  public double computeArea(){
    return this.getSideLength() * this.getSideLength();
  }
  
  /**
   * computePerimeter
   * This method returns the perimeter of the square
   * @return A double representing the perimeter of the square
   */
  public double computePerimeter(){
    return this.getSideLength() * 4;
  }
  
  /**
   * shiftX
   * This method accepts an integer x, and increments the x coordinate of the square's center by x
   * @param x An integer representing the amount to shift along the x axis
   */
  public void shiftX(int x){
    this.setX(this.getX() + x);
  }
  
  /**
   * shiftY
   * This method accepts an integer y, and increments the y coordinate of the square's center by y
   * @param y An integer representing the amount to shift along the y axis
   */
  public void shiftY(int y){
    
    // Incrementing the y coordinate by y on the coordinate plane is equivalent to 
    // decrementing the y coordinate by y on the Java Graphics plane
    this.setY(this.getY() - y);
  }
  
}