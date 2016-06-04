/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assets;

import java.awt.event.KeyEvent;

/**
 *
 * @author DanielSQ
 */
public class Platform extends Sprite{
    
    public Platform(int x, int y, String type)
    {        
        this.x = x;
        this.y = y;
        super.setLocation(x, y);
        icon = (new javax.swing.ImageIcon(getClass().getResource("/IMG/"+type+".png"))); 
        super.setIcon(icon);
        setImageDimensions();
    }
    
    public void moveOnX()
    {
        if(dx > 0)
        {
            if(collisionRight == false)
            {
                x += dx;
            }
        }
        if(dx < 0)
        {
            if(collisionLeft == false)
            {
                x += dx;
            }
        }
        super.setLocation(x, y);
    }
    
    public void moveOnY()
    {
        if(!collisionBot)
        {
            dy = -1;
            y += dy;
        }
        if(collisionBot && brinco)
        {
            y += dy;
        }
        else
        {
            dy = 0;
        }
        
        super.setLocation(x, y);
    }
    
    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();
        
        if(key == KeyEvent.VK_LEFT)
        {
            dx = 2;
        }
        
        if (key == KeyEvent.VK_RIGHT) {
            dx = -2;
        }
        
        if(key == KeyEvent.VK_UP) {
            dy = 2;
            brinco = true;
        }
    }
    
    
    public void keyReleased(KeyEvent e) {
        
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }
    }
    
}
