/**
 * [Rhombus.java]
 * This class is a subclass of the superclass
 * "Shape" and it represents a rhombus
 * @author Edwin Sun
 * @version 1.0 May 10, 2021
 */

class Rhombus extends Shape implements Moveable{
  
  private int[] xPoints = new int[4];
  private int[] yPoints = new int[4];
  
  /**
   * Rhombus
   * This constructor creates a rhombus with the specified x coordinate, y coordinate, colour, height, and width
   * @param x A double representing the x coordinate for the center of the rhombus
   * @param y A double representing the y coordinate for the center of the rhombus
   * @param redAmount An integer representing the red RGB value for the colour of the rhombus
   * @param greenAmount An integer representing the green RGB value for the colour of the rhombus
   * @param blueAmount An integer representing the blue RGB value for the colour of the rhombus
   * @param height A double representing the height of the rhombus
   * @param width A double representing the width of the rhombus
   */
  Rhombus(double x, double y, int redAmount, int greenAmount, int blueAmount, double height, double width){
    super(x, y, redAmount, greenAmount, blueAmount);
    this.setType("Rhombus");
    this.setHeight(height);
    this.setWidth(width);
    this.setArea(this.computeArea());
    this.setPerimeter(this.computePerimeter());
    
    // Determine the vertex coordinates of the rhombus
    xPoints[0] = (int)(x - width / 2);
    yPoints[0] = (int)y;
    xPoints[1] = (int)x;
    yPoints[1] = (int)(y + height / 2);
    xPoints[2] = (int)(x + width / 2);
    yPoints[2] = (int)y;
    xPoints[3] = (int)x;
    yPoints[3] = (int)(y - height / 2);
  }
  
  /**
   * getXPoints
   * @return An integer array representing the x values of the rhombus' vertices in counterclockwise order
   */
  public int[] getXPoints(){
    return this.xPoints;
  }
  
  /**
   * getYPoints
   * @return An integer array representing the y values of the rhombus' vertices in counterclockwise order
   */
  public int[] getYPoints(){
    return this.yPoints;
  }
  
  /**
   * computeArea
   * This method returns the area of the rhombus
   * @return A double representing the area of the rhombus
   */
  public double computeArea(){
    return getHeight() * getWidth() / 2;
  }
  
  /**
   * computePerimeter
   * This method returns the perimeter of the rhombus
   * @return A double representing the perimeter of the rhombus
   */
  public double computePerimeter(){
    return (Math.sqrt((getHeight() / 2) * (getHeight() / 2) + (getWidth() / 2) * (getWidth() / 2))) * 4;
  }
  
  /**
   * shiftX
   * This method accepts an integer x, and increments the x coordinates of the rhombus' vertices by x
   * @param x An integer representing the amount to shift along the x axis
   */
  public void shiftX(int x){
    for(int i = 0; i < xPoints.length; i++){
      xPoints[i] += x;
    }
  }
  
  /**
   * shiftY
   * This method accepts an integer y, and increments the y coordinates of the rhombus' vertices by y
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