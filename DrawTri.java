/*
 * Written by Isaac White
 */
import java.awt.*;
import javax.swing.*;

public class DrawTri extends Canvas
{
	 public static void main(String[] args) 
	 	{
	        JFrame frame = new JFrame("Sierpinski's Triangle");
	        frame.setSize(900, 900);
	        DrawTri dt = new DrawTri();
	        frame.add(dt);
	        frame.setVisible(true);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }

	    public void paint(Graphics g) 
	    {
	        int size = this.getSize().height;
	        int height = findHeight(size);
	        int[] x = {0, size, size / 2};
	        int[] y = {height, height, 0};
	        drawRecursive(size,size/2,0,g);
	    }
	   
	    public void drawRecursive(int size,int x, int y,Graphics g)
	    {
	    	//Draws outer triangle
	    	int subDiv = size/2;
	    	Triangle start = new Triangle(size,x,y,true);
	        g.setColor(Color.BLACK);
	        g.fillPolygon(start); 
	        
	       
	        // draws inner triangle
	        Triangle inner = new Triangle(subDiv,x,y+findHeight(size),false);
	        g.setColor(Color.BLUE);
	        g.fillPolygon(inner);
	        if(subDiv>=4)
	        {
	        	//left
	        	drawRecursive(subDiv,x-subDiv/2,y+findHeight(subDiv),g);
	        	//top
	        	drawRecursive(subDiv,x,y,g);
	        	//right
	        	drawRecursive(subDiv,x+subDiv/2,y+findHeight(subDiv),g);
	        }
	    }
	    
	    public void drawTriangle(int[] xArry, int[] yArry, Graphics g) 
	    {
	        g.setColor(Color.BLACK);
	        g.fillPolygon(xArry, yArry, 3);
	    }

	    public void drawInvertedTriangle(int[] xArry, int[] yArry, Graphics g) {
	        g.setColor(Color.WHITE); // Fill center triangle with white to create the Sierpinski pattern
	        g.fillPolygon(xArry, yArry, 3);
	    }

	    public static int findHeight(int size) {
	        return (int) (Math.sqrt(3) / 2 * size);
	    }
}
