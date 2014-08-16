package fractalart;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ramit
 */
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class ColoredTriangle extends JFrame {
    // instance variables	

    private Point p1;    // first endpoint	
    private Point p2;    // second endpoint	
    private Point p3;    // third endpoint	
    private Color color; // triangle color	

    // ColoredTriangle(): default constructor	
    public ColoredTriangle() {
        Point a = new Point(1, 1);
        Point b = new Point(2, 2);
        Point c = new Point(3, 3);
        setPoint(1, a);
        setPoint(2, b);
        setPoint(3, c);
        //Container con=getContentPane();
        //con.setBackground(Color.BLACK);
        setVisible(true);
    }

    // ColoredTriangle(): specific constructor	
    public ColoredTriangle(Point a, Point b, Point c, Color d) {
        setPoint(1, a);
        setPoint(2, b);
        setPoint(3, c);
        //Container con=getContentPane();
        //con.setBackground(Color.BLACK);
        //setVisible(true);	
        setColor(d);
    }

    // getPoint(): endpoint accessor	
    public Point getPoint(int i) {
        switch (i) {
            case 1:
                return p1;
            case 2:
                return p2;
            case 3:
                return p3;
            default:
                System.out.println("Unexpected endpoint access: " + i);
                System.exit(i);
                return null;
        }
    }

    // setPoint(): endpoint mutator	
    public void setPoint(int i, Point v) {
        switch (i) {
            case 1:
                p1 = new Point(v.x, v.y);
                return;
            case 2:
                p2 = new Point(v.x, v.y);
                return;
            case 3:
                p3 = new Point(v.x, v.y);
                return;
            default:
                System.out.println("Unexpected endpoint access: " + i);
                System.exit(i);
        }
    }

    // getColor(): color accessor	
    public Color getColor() {
        return color;
    }

    // setColor(): color mutator	
    public void setColor(Color c) {
        color = c;
    }

    // paint(): render facilitator	
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g; // cast graphics object

        Point v1 = getPoint(1);
        Point v2 = getPoint(2);
        Point v3 = getPoint(3);
        Color c = new Color((int) ((Math.random() * 20000) % 256), (int) ((Math.random() * 10000) % 256), (int) ((Math.random() * 30000) % 256));
        //Color c=new Color(8,(int)((Math.random()*256)%10),8);

        Polygon t = new Polygon();
        System.out.println(v1.x + "," + v1.y + " " + v2.x + "," + v2.y + " " + v3.x + "," + v3.y + " ");
        t.addPoint(v1.x, v1.y);
        t.addPoint(v2.x, v2.y);
        t.addPoint(v3.x, v3.y);

        //g2d.fillPolygon(t);
        g2d.setColor(c);

        g2d.fillPolygon(t);
    }
}
