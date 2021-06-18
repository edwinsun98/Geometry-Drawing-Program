/**
 * [Triangle.java]
 * This class is a subclass of the superclass
 * "Shape" and it represents a triangle
 * @author Edwin Sun
 * @version 1.0 May 10, 2021
 */

class Triangle extends Shape implements Moveable{
  
  private double sideLength;
  private int[] xPoints = new int[3];
  private int[] yPoints = new int[3];
  
  /**
   * Triangle
   * This constructor creates a triangle with the specified x coordinate, y coordinate, colour, and the side length
   * @param x A double representing the x coordinate for the center of the triangle
   * @param y A double representing the y coordinate for the center of the triangle
   * @param redAmount An integer representing the red RGB value for the colour of the triangle
   * @param greenAmount An integer representing the green RGB value for the colour of the triangle
   * @param blueAmount An integer representing the blue RGB value for the colour of the triangle
   * @param sideLength A double representing the side length of the triangle
   */
  Triangle(double x, double y, int redAmount, int greenAmount, int blueAmount, double sideLength){
    super(x, y, redAmount, greenAmount, blueAmount);
    this.setType("Triangle");
    this.sideLength = sideLength;
    this.setHeight(Math.sqrt(sideLength * sideLength - (sideLength / 2) * (sideLength / 2)));
    this.setWidth(sideLength);
    this.setArea(this.computeArea());
    this.setPerimeter(this.computePerimeter());
    
    // Determine the vertex coordinates of the triangle using the property of the centroid
    xPoints[0] = (int)(x - sideLength / 2);
    yPoints[0] = (int)(y + sideLength / 4);
    xPoints[1] = (int)(x + sideLength / 2);
    yPoints[1] = (int)(y + sideLength / 4);
    xPoints[2] = (int)x;
    yPoints[2] = (int)(y - (this.getHeight() - sideLength / 4));
  }
  
  /**
   * getSideLength
   * This method returns a double representing the side length of the triangle
   * @return A double representing the side length of the triangle
   */
  public double getSideLength(){
    return this.sideLength;
  }
  
  /**
   * getXPoints
   * @return An integer array representing the x values of the triangle's vertices in counterclockwise order
   */
  public int[] getXPoints(){
    return this.xPoints;
  }
  
  /**
   * getYPoints
   * @return An integer array representing the y values of the triangle's vertices in counterclockwise order
   */
  public int[] getYPoints(){
    return this.yPoints;
  }
  
  /**
   * computeArea
   * This method returns the area of the triangle
   * @return A double representing the area of the triangle
   */
  public double computeArea(){
    return Math.sqrt(3) * this.getSideLength() * this.getSideLength() / 4;
  }
  
  /**
   * computePerimeter
   * This method returns the perimeter of the triangle
   * @return A double representing the perimeter of the triangle
   */
  public double computePerimeter(){
    return this.getSideLength() * 3;
  }
  
  /**
   * shiftX
   * This method accepts an integer x, and increments the x coordinates of the triangle's vertices by x
   * @param x An integer representing the amount to shift along the x axis
   */
  public void shiftX(int x){
    for(int i = 0; i < xPoints.length; i++){
      xPoints[i] += x;
    }
  }
  
  /**
   * shiftY
   * This method accepts an integer y, and increments the y coordinate of the triangle's center by y
   * @param y An integer representing the amount to shift along the y axis
   */
  public void shiftY(int y){
    for(int i = 0; i < yPoints.length; i++){
      
      // Incrementing the y coordinate by y on the coordinate plane is equivalent to 
      // decrementing the y coordinate by y on the Java Graphics plane
      yPoints[i] -= y;
    }
  }
  
}