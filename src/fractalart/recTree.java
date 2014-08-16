/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ramit
 */
package fractalart;

import TurtleGraphics.*;
import java.awt.Color;
import java.io.*;
import java.util.Scanner;

public class recTree {
    int maxlen=20;
    int[] len=new int[1000];
    public void initialize_len(int l)
    {
        len[0]=1;len[l+1]=maxlen;
        int diff=maxlen/l-1;
        do{
            len[l]=l*diff;
        }while(l-->0);
    }
    public void drawrecTree(Pen p, int level)
    {
        this.drawBranch(p,level,len[level]<<1,45);
        this.drawBranch(p,level,len[level],10);
        this.drawBranch(p,level,len[level]<<1,-15);
        
    }
    public void drawBranch(Pen p,int level, int length, int angle)
    {
        if(level==1)
        {
            p.turn(angle);
            p.move(length);
            p.up();p.turn(180);
            p.move(length);p.turn(180-angle);
            p.down();
        }
        else{
            p.turn(angle);
            p.move(length);
            level--;
            this.drawBranch(p,level,len[level]<<1,45);
            this.drawBranch(p,level,len[level],10);
            this.drawBranch(p,level,len[level]<<1,-15);
            p.up();p.turn(180);
            p.move(length);p.turn(180-angle);
            p.down();
        }
        System.out.println(len[level]);
    }
    public void draw()throws IOException
    { //TurtleTest t=new TurtleTest();
        System.out.println("How many levels of branches do you want to see?(less than 25)");
        Scanner scan = new Scanner(System.in);
	int a = scan.nextInt();
	System.out.println();
        this.initialize_len(a);
        Pen obj=new StandardPen();String s=new String("MOTIF");
        obj.setColor(Color.DARK_GRAY);
        obj.up();
        obj.turn(180);obj.move(150);//obj.turn(90);
        obj.turn(180);obj.down();
        obj.setWidth(5);obj.move(100);//stem
        obj.setColor(Color.GREEN);
        obj.setWidth(1);
        this.drawrecTree(obj,a);
        obj.up();
        //obj.turn(180);
        obj.move(100);obj.down();
        obj.setColor(Color.DARK_GRAY);
        obj.drawString(s);
    }
}
