/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fractalart;

import java.util.Scanner;

/**
 *
 * @author ramit
 */
public class FractalArt {

    /**5
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        check t=new check();
        try {t.draw();}
        catch(Exception e){}
        recTree r=new recTree();
        try {r.draw();}
        catch(Exception e){}
        /*System.out.println("press any key 2 exit!");
        Scanner stdin = new Scanner(System.in);
	stdin.nextLine();
        System.exit(0);*/
       SierpinskiFractal a=new SierpinskiFractal();
        a.disp("");
         }
}
