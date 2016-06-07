/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assets.Enemies;

import Assets.Enemy;
import View.Window;

/**
 *
 * @author DanielSQ
 */
public class Slim extends Enemy{
    public Slim(int x, int y, Window window)
    {        
        super(x,y,window);
        icon = (new javax.swing.ImageIcon(getClass().getResource("/IMG/slim.gif"))); 
        super.setIcon(icon);
        setImageDimensions();
        super.setBounds(0, 0, getW(), getH());
        super.update();
        System.out.println("X: "+this.x);
        System.out.println("Y: "+this.y);
        System.out.println("X2: "+this.x2);
        System.out.println("Y2: "+this.y2);
        System.out.println("W: "+w);
        System.out.println("H: "+h);
    }
}
