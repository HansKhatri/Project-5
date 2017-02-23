/**
 * Collaboration:
 *
 * TODO: Put notes on collaboration here.
 */

import java.util.*;
import java.io.*;
import java.awt.*;

public class MountainPaths 
{
    
  public static void main(String[] args) throws Exception{
      
       //construct DrawingPanel, and get its Graphics context
        DrawingPanel panel = new DrawingPanel(844, 480);
        Graphics g = panel.getGraphics();
        
        //Test Step 1 - construct mountain map data
        Scanner S = new Scanner(new File("Colorado_844x480.dat"));
        int[][] grid = read(S, 480, 844);
        
        //Test Step 2 - min, max
        int min = findMinValue(grid);
        System.out.println("Min value in map: "+min);
        
        int max = findMaxValue(grid);
        System.out.println("Max value in map: "+max);
        
        
        //Test Step 3 - draw the map
        drawMap(g, grid);
        
        //Test Step 4 - draw a greedy path
        
        // 4.1 implement indexOfMinInCol
        int minRow = indexOfMinInCol(grid, 0); // find the smallest value in col 0
        System.out.println("Row with lowest val in col 0: "+minRow);
        
        // 4.2 use minRow as starting point to draw path
        g.setColor(Color.RED); //can set the color of the 'brush' before drawing, then method doesn't need to worry about it
        int totalChange = drawLowestElevPath(g, grid, minRow); //
        System.out.println("Lowest-Elevation-Change Path starting at row "+minRow+" gives total change of: "+totalChange);
        
        //Test Step 5 - draw the best path
        g.setColor(Color.RED);
        int bestRow = indexOfLowestElevPath(g, grid);
        
        //map.drawMap(g); //use this to get rid of all red lines
        g.setColor(Color.GREEN); //set brush to green for drawing best path
        totalChange = drawLowestElevPath(g, grid, bestRow);
        System.out.println("The Lowest-Elevation-Change Path starts at row: "+bestRow+" and gives a total change of: "+totalChange);
        
    
    
    }
  
  /**
   * @param s a Scanner instantiated and pointing at a file
   * @param numRows the number of rows represented in the file
   * @param numCols the number of cols represented in the file
   * @return a 2D array (rows x cols) of the data from the file read
   */
  public static int[][] read(Scanner s, int numRows, int numCols){
      
       int[][] grid = new int[numRows][numCols];

       for (int j = 1; j < numCols; j++) {
         for (int i = 1; i < numRows; i++) {
           grid[i][j] = s.nextInt();
           
         }
       }
       
         
         
       return grid;
  }
  
  
  /**
   * @param grid a 2D array from which you want to find the smallest value
   * @return the smallest value in the given 2D array
   */
  public static int findMinValue(int[][] grid) {
      int minInt = Integer.MAX_VALUE;
      int r = grid.length;
      int c = grid[0].length;
      
      for (int j = 1; j < c; j++) {
        for (int i = 1; i < r; i++) {
           if (grid[i][j] < minInt)
             minInt = grid[i][j];
         }
       }
          return minInt;
      
  }
  
  /**
   * @param grid a 2D array from which you want to find the largest value
   * @return the largest value in the given 2D array
   */
  public static int findMaxValue(int[][] grid){
    int maxInt = Integer.MIN_VALUE;
    int r = grid.length;
    int c = grid[0].length;
       for (int j = 1; j < c; j++) {
         for (int i = 1; i < r; i++) {
           if (grid[i][j] > maxInt)
             maxInt = grid[i][j];
         }
       }
    
       return maxInt; 
      
  }
  
  /**
   * Given a 2D array of elevation data create a image of size rows x cols, 
   * drawing a 1x1 rectangle for each value in the array whose color is set
   * to a a scaled gray value (0-255).  Note: to scale the values in the array 
   * to 0-255 you must find the min and max values in the original data first.
   * @param g a Graphics context to use
   * @param grid a 2D array of the data
   */
  public static void drawMap(Graphics g, int[][] grid){
    int max = findMaxValue(grid);
    int min = findMinValue(grid);
    int d = 0;
    for (int row = 0; row < grid.length; row++) {
      for (int col = 0; col < grid[0].length; col++) {
        
        if (grid[row][col] == min) 
          d = 0;
        else 
         d = (grid[row][col]) / 17;
        
         g.setColor(new Color(d, d, d));
         g.fillRect(col, row, 1, 1);
      }
    }


    
    
  }
  
  /**
   * Scan a single column of a 2D array and return the index of the
   * row that contains the smallest value
   * @param grid a 2D array
   * @col the column in the 2D array to process
   * @return the index of smallest value from grid at the given col
   */
  public static int indexOfMinInCol(int[][] grid, int col){
      // your code
      return -1;
  }
  
  
  
  /**
   * Find the minimum elevation-change route from West-to-East in the given grid, from the
   * given starting row, and draw it using the given graphics context
   * @param g - the graphics context to use
   * @param grid - the 2D array of elevation values
   * @param row - the starting row for traversing to find the min path
   * @return total elevation of the route
   */
  public static int drawLowestElevPath(Graphics g, int[][] grid, int row){
     
    return -1;      
  }
  
  /**
   * Generate all west-to-east paths, find the one with the lowest total elevation change,
   * and return the index of the row that path starts on.
   * @param g - the graphics context to use
   * @param grid - the 2D array of elevation values
   * @return the index of the row where the lowest elevation-change path starts.
   */
  public static int indexOfLowestElevPath(Graphics g, int[][] grid){
      
      
      return -1;
  }
     
}
