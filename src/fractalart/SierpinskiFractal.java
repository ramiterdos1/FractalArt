package fractalart;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ramit
 */

import fractalart.ColoredTriangle;
import java.awt.Color;
import java.awt.Point;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class SierpinskiFractal  {
	// midpoint(): midpoint facilitator
	public static Point midpoint(Point p1, Point p2) {
		return new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
	}
	
	// Sierpinski(): draws the Sierpinski Fractal
	public static void Sierpinski(Graphics g, Point p1, Point p2, Point p3, Color c, int depth) {
		g.setColor(Color.BLUE);
		if (depth == 1) {
			ColoredTriangle ct = new ColoredTriangle(p1, p2, p3, c);
			ct.paint(g);
		}
		else {
			Color d =new Color((int)((Math.random()*20000)%256),(int)((Math.random()*10000)%256),(int)((Math.random()*30000)%256));
                	Point p4 = midpoint(p1, p2);
			Point p5 = midpoint(p2, p3);
			Point p6 = midpoint(p3, p1);
			Sierpinski(g, p1, p4, p6, d, depth-1);
			Sierpinski(g, p4, p2, p5, d, depth-1);
			Sierpinski(g, p6, p5, p3, d, depth-1);
		}
		
	}
	
	// main(): application entry point
	public  void disp (String args) {
		// set up scanner
                Scanner scan = new Scanner(System.in);
		
		// display program's purpose
		System.out.println("This program will draw a Sierpinski Fractal to the user's specified depth.\n");
		
		// determine desired cycles and color
		System.out.println("How many cycles would you like the Sierpinski Fractal to be taken out to?\n");
		int a = scan.nextInt();
		System.out.println();
		
		// produce Sierpinski Fractal
		Point p1 = new Point(50, 50);
		Point p2 = new Point(50, 450);
		Point p3 = new Point(450, 50);
		//Color c =new Color((int)((Math.random()*20000)%256),(int)((Math.random()*10000)%256),(int)((Math.random()*30000)%256));
                Color c=Color.BLACK;
		JFrame window = new JFrame("Sierpinski Fractal-"+a+".");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(500, 500);
		window.setVisible(true);
		
		Graphics g = window.getGraphics();
		Graphics2D g2d = ( Graphics2D ) g;
                //Container con=getContentPane();
                //con.setBackground(Color.BLACK);
		
		//g2d.setBackground(Color.BLACK);
                System.out.println("\nEnter any character when ready.\n");
		Scanner stdin = new Scanner(System.in);
		stdin.nextLine();
		
		Sierpinski(g, p1, p2, p3, c, a);
                System.out.println("\nEnter any character if you wish to exit!\n");
                stdin = new Scanner(System.in);
		stdin.nextLine();
                System.exit(0);
	}
}
