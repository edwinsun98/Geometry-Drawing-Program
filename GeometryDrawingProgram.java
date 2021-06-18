/**
 * [GeometryDrawingProgram.java]
 * This program allows the user to draw, delete
 * and translate 2D shapes on a coordinate plane
 * @author Edwin Sun
 * @version 1.0 May 10, 2021
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.util.Scanner;
import java.util.ArrayList;

class GeometryDrawingProgram {
  /* ================================ Class Variables ================================ */
  static JFrame frame;
  
  // ArrayList to store the shapes that are currently present
  static ArrayList<Shape> shapes = new ArrayList<Shape>();
  
  public static void main(String[] args) {  
    /* ================================ Variables ================================ */
    GeometryScreen gs = new GeometryScreen();
    Scanner input = new Scanner(System.in);
    int choice = 0;
    int shapeToAdd = 0;
    int redAmount = 0;
    int greenAmount = 0;
    int blueAmount = 0;
    int index = 0;
    int shiftByX = 0;
    int shiftByY = 0;
    double xCoordinate = 0.0;
    double yCoordinate = 0.0;
    double height = 0.0;
    double width = 0.0;
    double sideLength = 0.0;
    double radius = 0.0;
    
    /* ================================ Main Code ================================ */
    do{
      
      System.out.println("----Welcome to the Geometry Drawing Program!----");
      System.out.println("Please enter in '1' to display all shapes with relevant data.");
      System.out.println("Please enter in '2' to add a single shape.");
      System.out.println("Please enter in '3' to remove a single shape.");
      System.out.println("Please enter in '4' to translate a single shape.");
      System.out.println("Please enter in '5' to translate the entire drawing.");
      System.out.println("Please enter in '6' to quit the program.\n");
      System.out.println("Please enter in your choice:");
      
      choice = input.nextInt();
      
      if(choice == 1){
        if(shapes.size() == 0){
          System.out.println("The canvas is currently empty. Try adding a shape in the main menu.");
          
        // Loop through the ArrayList "shapes" and print out the relevant information of each shape, including the area,
        // perimeter, RGB values defining the colour, center coordinates of the shape, height, and the width
        }else{
          for(int i = 0; i < shapes.size(); i++){
            System.out.printf("# %d: Type: %s, Area: %.2f, Perimeter: %.2f, Colour RGB: (%d,%d,%d)\n", 
                              i+1, shapes.get(i).getType(), shapes.get(i).getArea(), shapes.get(i).getPerimeter(),
                              shapes.get(i).getRedAmount(), shapes.get(i).getGreenAmount(), 
                              shapes.get(i).getBlueAmount());
            
            // Output the x and y coordinates of the shape's center as if they
            // were on the Cartesian plane with (x = 0, y = 0) as the origin 
            System.out.printf("Center Point: (%.2f,%.2f), Height: %.2f, Width: %.2f\n", shapes.get(i).getX() - 250, 
                              (shapes.get(i).getY() - 250) * (-1), shapes.get(i).getHeight(), shapes.get(i).getWidth());
          }
        }
      }else if(choice == 2){
        System.out.println("Please enter in '1' to add a rectangle.");
        System.out.println("Please enter in '2' to add a square.");
        System.out.println("Please enter in '3' to add a triangle.");
        System.out.println("Please enter in '4' to add a rhombus.");
        System.out.println("Please enter in '5' to add a parallelogram.");
        System.out.println("Please enter in '6' to add a circle.");
        System.out.println("Please enter in '7' to add an ellipse.");
        System.out.println("Please enter in your choice.");
        
        shapeToAdd = input.nextInt();
        
        if((shapeToAdd < 1) || (shapeToAdd > 7)){
          System.out.println("The input was invalid, please enter an integer from 1 to 7.");
        }else{
          System.out.println("Please enter the red RGB colour value you want for your shape (0-255):");
          
          redAmount = input.nextInt();
          
          System.out.println("Please enter the green RGB colour value you want for your shape (0-255):");
          
          greenAmount = input.nextInt();
          
          System.out.println("Please enter the blue RGB colour value you want for your shape (0-255):");
          
          blueAmount = input.nextInt();
          
          // Make sure the red, green, and blue RGB values are in the valid range from 0 to 255
          if((redAmount >= 0) && (redAmount <= 255) && (greenAmount >= 0) && (greenAmount <= 255)
            && (blueAmount >= 0) && (blueAmount <= 255)){
            System.out.println("Please enter the x-coordinate for the center of your shape:");
            
            xCoordinate = input.nextDouble();
            
            System.out.println("Please enter the y-coordinate for the center of your shape:");
            
            yCoordinate = input.nextDouble();
            
            // Modify the x and y coordinates so it matches the Java
            // Graphics plane with (x = 0, y = 0) at the top left corner
            xCoordinate += 250;
            yCoordinate = 250 - yCoordinate;
            
            // If the shape being added is a rectangle, rhombus, parallelogram,
            // or ellipse, then take in the height and width of the shape
            if((shapeToAdd == 1) || (shapeToAdd == 4) || (shapeToAdd == 5) || (shapeToAdd == 7)){
              System.out.println("Please enter the height of your shape (must be > 0):");
              
              height = input.nextDouble();
              
              System.out.println("Please enter the width of your shape (must be > 0):");
              
              width = input.nextDouble();
              
              // Make sure the height and width are both greater than 0
              if((height > 0) && (width > 0)){
                if(shapeToAdd == 1){
                  Rectangle newShape = new Rectangle(xCoordinate, yCoordinate, redAmount, greenAmount, blueAmount, 
                                                     height, width);
                  shapes.add(newShape);
                }else if(shapeToAdd == 4){
                  Rhombus newShape = new Rhombus(xCoordinate, yCoordinate, redAmount, greenAmount, blueAmount, 
                                                 height, width);
                  shapes.add(newShape);
                }else if(shapeToAdd == 5){
                  Parallelogram newShape = new Parallelogram(xCoordinate, yCoordinate, redAmount, greenAmount, blueAmount, 
                                                             height, width);
                  shapes.add(newShape);
                }else{
                  Ellipse newShape = new Ellipse(xCoordinate, yCoordinate, redAmount, greenAmount, blueAmount, 
                                                 height, width);
                  shapes.add(newShape);
                }
              }else{
                System.out.println("The height and width must both be greater than 0.");
              }
              
            // If the shape being added is a square or a triangle, then take in
            // the side length of the shape, given that the triangles are equilateral
            }else if((shapeToAdd == 2) || (shapeToAdd == 3)){
              System.out.println("Please enter the side length of your shape (must be > 0):");
              
              sideLength = input.nextDouble();
              
              // Make sure the side length is greater than 0
              if(sideLength > 0){
                if(shapeToAdd == 2){
                  Square newShape = new Square(xCoordinate, yCoordinate, redAmount, greenAmount, blueAmount, sideLength);
                  shapes.add(newShape);
                }else{
                  Triangle newShape = new Triangle(xCoordinate, yCoordinate, redAmount, greenAmount, blueAmount, 
                                                   sideLength);
                  shapes.add(newShape);
                }
              }else{
                System.out.println("The side length must be greater than 0.");
              }
              
            // Otherwise if the shape is a circle, then take in the radius of the shape
            }else{
              System.out.println("Please enter the radius of your shape (must be > 0):");
              
              radius = input.nextDouble();
              
              // Make sure the radius is greater than 0
              if(radius > 0){
                Circle newShape = new Circle(xCoordinate, yCoordinate, redAmount, greenAmount, blueAmount, radius);
                shapes.add(newShape);
              }else{
                System.out.println("The radius must be greater than 0.");
              }
            }
          }else{
            System.out.println("The red, green, and blue RGB values must all be from 0 to 255 inclusive.");
          }
        }
      }else if(choice == 3){
        System.out.println("Please enter the index of the shape to be deleted, or enter in '0' to delete nothing:");
        
        index = input.nextInt();
        
        if(index == 0){
          System.out.println("No shapes have been deleted."); 
        }else{
          
          // If the index entered is a valid index in the ArrayList "shapes", then remove it
          if((index - 1 >= 0) && (index - 1 < shapes.size())){
            
            // Remove the shape at (index - 1) because the ArrayList "shapes" is 0-indexed 
            shapes.remove(index - 1);
          }else{
            System.out.println("Please specify a valid shape index.");
          }
        }
      }else if(choice == 4){
        System.out.println("Please enter the index of the shape to be shifted:");
        
        index = input.nextInt();
        
        System.out.println("Please enter an integer amount to shift along the x-axis:");
        
        shiftByX = input.nextInt();
        
        System.out.println("Please enter an integer amount to shift along the y-axis:");
        
        shiftByY = input.nextInt();
        
        // If the index entered is a valid index in the ArrayList "shapes", then translate it
        if((index - 1 >= 0) && (index - 1) < shapes.size()){
          
          // Call the translate method with (index - 1) because the ArrayList "shapes" is 0-indexed
          translate(index - 1, shiftByX, shiftByY);
        }else{
          System.out.println("Please specify a valid shape index.");
        }
      }else if(choice == 5){
        System.out.println("Please enter an integer amount to shift along the x-axis:");
        
        shiftByX = input.nextInt();
        
        System.out.println("Please enter an integer amount to shift along the y-axis:");
        
        shiftByY = input.nextInt();
        
        // Loop through the ArrayList "shapes" and translate each shape accordingly
        for(int i = 0; i < shapes.size(); i++){
          translate(i, shiftByX, shiftByY);
        }
      }else if(choice == 6){
        System.out.println("Thank you for using the program.");
        
        // Close the scanner and the JFrame
        input.close();
        frame.dispose();
      }
      
      // Update the screen
      frame.repaint(); 
      
    // Terminate the loop when the user enters '6' to quit, otherwise continue running
    }while(choice != 6);
  }
  
  /**
   * translate
   * This method accepts the index of the shape in the ArrayList "shapes" to be translated,
   * the amount to shift the shape along the x-axis, and the amount to shift the shape along
   * the y-axis. 
   * @param index An integer representing the index of the shape in the ArrayList "shapes"
   * @param shiftByX An integer representing the amount to shift the shape along the x-axis
   * @param shiftByY An integer representing the amount to shift the shape along the y-axis
   */
  public static void translate(int index, int shiftByX, int shiftByY){
    
    // To perform the appropriate translation, determine the subclass of each shape using "instanceof"
    if(shapes.get(index) instanceof Triangle){
      ((Triangle)shapes.get(index)).shiftX(shiftByX);
      ((Triangle)shapes.get(index)).shiftY(shiftByY);
    }else if(shapes.get(index) instanceof Parallelogram){
      ((Parallelogram)shapes.get(index)).shiftX(shiftByX);
      ((Parallelogram)shapes.get(index)).shiftY(shiftByY);
    }else if(shapes.get(index) instanceof Rhombus){
      ((Rhombus)shapes.get(index)).shiftX(shiftByX);
      ((Rhombus)shapes.get(index)).shiftY(shiftByY);
    }else if(shapes.get(index) instanceof Square){
      ((Square)shapes.get(index)).shiftX(shiftByX);
      ((Square)shapes.get(index)).shiftY(shiftByY);
    }else if(shapes.get(index) instanceof Rectangle){
      ((Rectangle)shapes.get(index)).shiftX(shiftByX);
      ((Rectangle)shapes.get(index)).shiftY(shiftByY);
    }else if(shapes.get(index) instanceof Circle){
      ((Circle)shapes.get(index)).shiftX(shiftByX);
      ((Circle)shapes.get(index)).shiftY(shiftByY);
    }else if(shapes.get(index) instanceof Ellipse){
      ((Ellipse)shapes.get(index)).shiftX(shiftByX);
      ((Ellipse)shapes.get(index)).shiftY(shiftByY);
    }
  }
  
  // This is an inner class - it has access to the static variables defined above
  public static class GeometryScreen {
    
    // Constructor - do no modify
    GeometryScreen() {
      frame = new JFrame("Geometry Drawing Program 1.0");
      
      // Create a new "custom" panel for graphics based on the inner class below
      JPanel graphicsPanel = new GraphicsPanel();
      
      // Add the panel and the frame to the window
      frame.getContentPane().add(graphicsPanel);
      
      // Set the frame to full screen 
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(520,540);
      frame.setUndecorated(false);  //Set to true to remove title bar
      frame.setVisible(true);
      
    } 
    
    // This is an inner class which contains all the details about drawing to screen.
    public static class GraphicsPanel extends JPanel {
      
      // The method that draws to the screen - you will need to add/modify code here
      public void paintComponent(Graphics g) {          
        setDoubleBuffered(true);   
        g.setColor(Color.BLACK);
        
        // Draw the X/Y Axis
        g.drawLine(250, 0, 250, 500);
        g.drawLine(0, 250, 500, 250);
        
        // Loop through the ArrayList "shapes" and draw each shape to the canvas
        for(int i = 0; i < shapes.size(); i++){
          
          // Get and set the colour of the current shape to be drawn
          Color currentColour = new Color(shapes.get(i).getRedAmount(), 
                                          shapes.get(i).getGreenAmount(), shapes.get(i).getBlueAmount());
          g.setColor(currentColour);
          
          // If the shape is a rectangle or a square, then use the drawRect method from the Graphics class to draw it
          if(shapes.get(i) instanceof Rectangle || shapes.get(i) instanceof Square){
            g.drawRect((int)(shapes.get(i).getX() - shapes.get(i).getWidth() / 2), 
                       (int)(shapes.get(i).getY() - shapes.get(i).getHeight() / 2), 
                       (int)(shapes.get(i).getWidth()), (int)(shapes.get(i).getHeight()));
            
          // If the shape is a circle or an ellipse, then use the drawOval method from the Graphics class to draw it
          }else if(shapes.get(i) instanceof Circle || shapes.get(i) instanceof Ellipse){
            g.drawOval((int)(shapes.get(i).getX() - shapes.get(i).getWidth() / 2), 
                       (int)(shapes.get(i).getY() - shapes.get(i).getHeight() / 2), 
                       (int)(shapes.get(i).getWidth()), (int)(shapes.get(i).getHeight()));
          
          // If the shape is a triangle, rhombus, or parallelogram, then
          // use the drawPolygon method from the Graphics class to draw it
          }else if(shapes.get(i) instanceof Triangle){
            g.drawPolygon(((Triangle)shapes.get(i)).getXPoints(), ((Triangle)shapes.get(i)).getYPoints(), 3);
          }else if(shapes.get(i) instanceof Rhombus){
            g.drawPolygon(((Rhombus)shapes.get(i)).getXPoints(), ((Rhombus)shapes.get(i)).getYPoints(), 4);
          }else{
            g.drawPolygon(((Parallelogram)shapes.get(i)).getXPoints(), ((Parallelogram)shapes.get(i)).getYPoints(), 4);
          }
        }
      }
    }
  }
}