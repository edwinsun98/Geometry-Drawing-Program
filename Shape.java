/**
 * [Shape.java]
 * This is an abstract class which represents a 2D shape
 * @author Edwin Sun
 * @version 1.0 May 10, 2021
 */

abstract class Shape{
  
  private double x;
  private double y;
  private double height;
  private double width;
  private double area;
  private double perimeter;
  private int redAmount;
  private int greenAmount;
  private int blueAmount;
  private String type;
  
  /**
   * Shape
   * This constructor creates a shape with the specified x coordinate, y coordinate, and colour
   * @param x A double representing the x coordinate for the center of the shape
   * @param y A double representing the y coordinate for the center of the shape
   * @param redAmount An integer representing the red RGB value for the colour of the shape
   * @param greenAmount An integer representing the green RGB value for the colour of the shape
   * @param blueAmount An integer representing the blue RGB value for the colour of the shape
   */
  Shape(double x, double y, int redAmount, int greenAmount, int blueAmount){
    this.x = x;
    this.y = y;
    this.redAmount = redAmount;
    this.greenAmount = greenAmount;
    this.blueAmount = blueAmount;
  }
  
  /**
   * computeArea
   * This abstract method is supposed to return the area of the shape
   * @return A double representing the area of the shape
   */
  abstract double computeArea();
  
  /**
   * computePerimeter
   * This abstract method is supposed to return the perimeter of the shape
   * @return A double representing the perimeter of the shape
   */
  abstract double computePerimeter();
  
  /**
   * setArea
   * This method accepts a double representing the area of the shape and makes it the area of the shape
   * @param area A double representing the area of the shape
   */
  public void setArea(double area){
    this.area = area;
  }
  
  /**
   * setPerimeter
   * This method accepts a double representing the perimeter of the shape and makes it the perimeter of the shape
   * @param perimeter A double representing the perimeter of the shape
   */
  public void setPerimeter(double perimeter){
    this.perimeter = perimeter;
  }
  
  /**
   * setType
   * This method accepts a string representing the type of the shape and makes it the type of the shape
   * @param type A string representing the type of the shape
   */
  public void setType(String type){
    this.type = type;
  }
  
  /**
   * setX
   * This method accepts a double representing the x coordinate for the center
   * of the shape makes it the x coordinate for the center of the shape
   * @param x A double representing the x coordinate for the center of the shape
   */
  public void setX(double x){
    this.x = x;
  }
  
  /**
   * setY
   * This method accepts a double representing the y coordinate for the center
   * of the shape makes it the y coordinate for the center of the shape
   * @param y A double representing the y coordinate for the center of the shape
   */
  public void setY(double y){
    this.y = y;
  }
  
  /**
   * setHeight
   * This method accepts a double representing the height
   * of the shape and makes it the height of the shape
   * @param height A double representing the height of the shape
   */
  public void setHeight(double height){
    this.height = height;
  }
  
  /**
   * setWidth
   * This method accepts a double representing the width
   * of the shape and makes it the width of the shape
   * @param width A double representing the width of the shape
   */
  public void setWidth(double width){
    this.width = width;
  }
  
  /**
   * getX
   * This method returns a double representing the x coordinate for the center of the shape
   * @return A double representing the x coordinate for the center of the shape
   */
  public double getX(){
    return this.x;
  }
  
  /**
   * getY
   * This method returns a double representing the y coordinate for the center of the shape
   * @return A double representing the y coordinate for the center of the shape
   */
  public double getY(){
    return this.y;
  }
  
  /**
   * getHeight
   * This method returns a double representing the height of the shape
   * @return A double representing the height of the shape
   */
  public double getHeight(){
    return this.height;
  }
  
  /**
   * getWidth
   * This method returns a double representing the width of the shape
   * @return A double representing the width of the shape
   */
  public double getWidth(){
    return this.width;
  }
  
  /**
   * getArea
   * This method returns a double representing the area of the shape
   * @return A double representing the area of the shape
   */
  public double getArea(){
    return this.area;
  }
  
  /**
   * getPerimeter
   * This method returns a double representing the perimeter of the shape
   * @return A double representing the perimeter of the shape
   */
  public double getPerimeter(){
    return this.perimeter;
  }
  
  /**
   * getType
   * This method returns a string representing the type of the shape
   * @return A string representing the type of the shape
   */
  public String getType(){
    return this.type;
  }
  
  /**
   * getRedAmount
   * This method returns an integer representing the red RGB value of the shape
   * @return An integer representing the red RGB value of the shape
   */
  public int getRedAmount(){
    return this.redAmount;
  }
  
  /**
   * getGreenAmount
   * This method returns an integer representing the green RGB value of the shape
   * @return An integer representing the green RGB value of the shape
   */
  public int getGreenAmount(){
    return this.greenAmount;
  }
  
  /**
   * getBlueAmount
   * This method returns an integer representing the blue RGB value of the shape
   * @return An integer representing the blue RGB value of the shape
   */
  public int getBlueAmount(){
    return this.blueAmount;
  }
  
}    