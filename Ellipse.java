/**
 * [Ellipse.java]
 * This class is a subclass of the superclass
 * "Shape" and it represents an ellipse
 * @author Edwin Sun
 * @version 1.0 May 10, 2021
 */

class Ellipse extends Shape implements Moveable{
  
  /**
   * Ellipse
   * This constructor creates an ellipse with the specified x coordinate, y coordinate, colour, height, and width
   * @param x A double representing the x coordinate for the center of the ellipse
   * @param y A double representing the y coordinate for the center of the ellipse
   * @param redAmount An integer representing the red RGB value for the colour of the ellipse
   * @param greenAmount An integer representing the green RGB value for the colour of the ellipse
   * @param blueAmount An integer representing the blue RGB value for the colour of the ellipse
   * @param height A double representing the height of the ellipse
   * @param width A double representing the width of the ellipse
   */
  Ellipse(double x, double y, int redAmount, int greenAmount, int blueAmount, double height, double width){
    super(x, y, redAmount, greenAmount, blueAmount);
    this.setType("Ellipse");
    this.setHeight(height);
    this.setWidth(width);
    this.setArea(this.computeArea());
    this.setPerimeter(this.computePerimeter());
  }
  
  /**
   * computeArea
   * This method returns the area of the ellipse
   * @return A double representing the area of the ellipse
   */
  public double computeArea(){
    return Math.PI * (this.getHeight() / 2) * (this.getWidth() / 2);
  }
  
  /**
   * computePerimeter
   * This method returns the perimeter of the ellipse
   * @return A double representing the perimeter of the ellipse
   */
  public double computePerimeter(){
    
    // Approximating ellipse perimeter using Ramanujan's formula
    double h = Math.pow((this.getWidth() / 2) - 
                        (this.getHeight() / 2), 2) / Math.pow((this.getWidth() / 2) + (this.getHeight() / 2), 2);
    return Math.PI * ((this.getWidth() / 2) + (this.getHeight() / 2)) * (1 + (3 * h) / (10 + Math.sqrt(4 - 3 * h)));
  }
  
  /**
   * shiftX
   * This method accepts an integer x, and increments the x coordinate of the ellipse's center by x
   * @param x An integer representing the amount to shift along the x axis
   */
  public void shiftX(int x){
    this.setX(this.getX() + x);
  }
  
  /**
   * shiftY
   * This method accepts an integer y, and increments the y coordinate of the ellipse's center by y
   * @param y An integer representing the amount to shift along the y axis
   */
  public void shiftY(int y){
    
    // Incrementing the y coordinate by y on the coordinate plane is equivalent to 
    // decrementing the y coordinate by y on the Java Graphics plane
    this.setY(this.getY() - y);
  }
  
}