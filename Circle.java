/**
 * [Circle.java]
 * This class is a subclass of the superclass
 * "Shape" and it represents a circle
 * @author Edwin Sun
 * @version 1.0 May 10, 2021
 */

class Circle extends Shape implements Moveable{

  private double radius;
  
  /**
   * Circle
   * This constructor creates a circle with the specified x coordinate, y coordinate, colour, and radius
   * @param x A double representing the x coordinate for the center of the circle
   * @param y A double representing the y coordinate for the center of the circle
   * @param redAmount An integer representing the red RGB value for the colour of the circle
   * @param greenAmount An integer representing the green RGB value for the colour of the circle
   * @param blueAmount An integer representing the blue RGB value for the colour of the circle
   * @param radius A double representing the radius of the circle
   */
  Circle(double x, double y, int redAmount, int greenAmount, int blueAmount, double radius){
    super(x, y, redAmount, greenAmount, blueAmount);
    this.setType("Circle");
    this.radius = radius;
    this.setHeight(radius + radius);
    this.setWidth(radius + radius);
    this.setArea(this.computeArea());
    this.setPerimeter(this.computePerimeter());
  }
  
  /**
   * getRadius
   * This method returns the radius of the circle
   * @return A double representing the radius of the circle
   */
  public double getRadius(){
    return this.radius;
  }
  
  /**
   * computeArea
   * This method returns the area of the circle
   * @return A double representing the area of the circle
   */
  public double computeArea(){
    return Math.PI * this.getRadius() * this.getRadius();
  }
  
  /**
   * computePerimeter
   * This method returns the perimeter of the circle
   * @return A double representing the perimeter of the circle
   */
  public double computePerimeter(){
    return 2 * Math.PI * this.getRadius();
  }
  
  /**
   * shiftX
   * This method accepts an integer x, and increments the x coordinate of the circle's center by x
   * @param x An integer representing the amount to shift along the x axis
   */
  public void shiftX(int x){
    this.setX(this.getX() + x);
  }
  
  /**
   * shiftY
   * This method accepts an integer y, and increments the y coordinate of the circle's center by y
   * @param y An integer representing the amount to shift along the y axis
   */
  public void shiftY(int y){
    
    // Incrementing the y coordinate by y on the coordinate plane is equivalent to 
    // decrementing the y coordinate by y on the Java Graphics plane
    this.setY(this.getY() - y);
  }
  
}