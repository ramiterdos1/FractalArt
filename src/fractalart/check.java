/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fractalart;

/**
 *
 * @author ramit
 */
import TurtleGraphics.*;
import java.lang.*;
import java.io.*;

public class check {
    static BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
  public void DrawRegularPolygon(Pen p,int n,int length)
   {
      for(int i=1;i<=n;i++)
        { p.move(length);p.turn(360/n);}
   }  
 public void draw()throws IOException
  { //TurtleTest t=new TurtleTest();
    Pen obj=new StandardPen();obj.down();
    System.out.println("Displying objects...->"+this+" , "+obj+"....\n"); 
   for(int j=3;j<11;j++)
     { DrawRegularPolygon(obj,j,100);
       obj.up();
       obj.turn(180);obj.move(50);//obj.turn(90);
       obj.down();
     }
    //obj.up();
    System.out.println("END DRAWING");
    /*System.out.println("Type any key to Exit!");
    char c=r.readLine().charAt(0);
    if(c>0){System.out.println("EXiTTing....");System.exit(0);} */
    return;
   }

}
