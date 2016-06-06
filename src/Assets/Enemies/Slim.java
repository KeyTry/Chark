/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assets.Enemies;

import Assets.Enemy;

/**
 *
 * @author DanielSQ
 */
public class Slim extends Enemy{
    public Slim(int x, int y)
    {        
        super(x,y);
        icon = (new javax.swing.ImageIcon(getClass().getResource("/IMG/slim.gif"))); 
        super.setIcon(icon);
        setImageDimensions();
    }
}