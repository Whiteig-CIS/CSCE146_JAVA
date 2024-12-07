/*
 * Written by Isaac White
 */
import javax.swing.*;
import java.awt.*;

public class Triangle extends Polygon {
    public int side;
    public int height;
    public int[] xPoints;
    public int[] yPoints;
    
    public Triangle() {
        this.setSide(100);  // default side length
        this.height = findHeight(side);
        this.updatePoints(0, 0, true);  // default position
    }
    
    public Triangle(int side, int x, int y, boolean up) 
    {
        this.setSide(side);
        this.height = findHeight(side);
        this.updatePoints(x, y, up);
    }
    
    public int getSide() 
    {
        return this.side;
    }
    
    public void setSide(int aSide) 
    {
       // this.side = (aSide > 0) ? aSide : 100;
    	if(aSide>0)
    		this.side = aSide;
    	else
    		aSide = 100;
        this.height = findHeight(this.side);
    }
    
    public static int findHeight(int size) 
    {
        return (int) (Math.sqrt(3) / 2 * size);
    }
    
    private void updatePoints(int x, int y, boolean up) 
    {
        this.xPoints = indexX(x);
        this.yPoints = indexY(y, up);
        
        // Clear the existing Polygon points and add updated ones
        this.reset();
        for (int i = 0; i < xPoints.length; i++) {
            this.addPoint(xPoints[i], yPoints[i]);
        }
    }
    
    private int[] indexX(int x) 
    {
        return new int[] {x, x + this.side / 2, x - this.side / 2};
    }
    
    private int[] indexY(int y, boolean up) 
    {
        if (up) 
        {
            return new int[] {y, y + this.height, y + this.height};
        } 
        else 
        {
            return new int[] {y, y - this.height, y - this.height};
        }
    }
}