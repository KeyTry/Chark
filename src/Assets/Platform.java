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
    
    public void setRestingLim()
    {
        
    }
    
    public void jump(boolean brinco, boolean movingUp)
    {   
        System.out.println();
        int downLim = getY();
        this.brinco = brinco;
        this.movingUp = movingUp;
        
        System.out.println("Down lim: "+downLim);
        
        if(brinco && !collisionTop)
        {
            //System.out.println("brinco?: "+brinco);
            if(getY2() < downLim)
            {
                System.out.println("Y: "+getY());
                y = y+1;
                //System.out.println("Limite: "+jumpLim);
            }
            else
            {
                //System.out.println("Terminando brinco");
                this.brinco = false;
                this.movingUp = false;
                System.out.println("Brinco?: "+brinco);
                jumpLim = 0;
            }
            //System.out.println("brinco?: "+brinco);
        }
        else
        {
            this.movingUp = false;
            this.brinco = false;
        }
        
        super.setLocation(x, y);
    }
    
    public void fall(boolean brinco, boolean movingDown)
    {
        if(!collisionBot && !brinco)
        {
            //System.out.println("Brinco?: "+brinco);
            dy = -1;
            y += dy;
            movingDown = true;
        }
        else
        {
            dy = 0;
            movingDown = false;
        }
        
        super.setLocation(x, y);
    }
    
    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();
        
        if(key == KeyEvent.VK_LEFT)
        {
            dx = 1;
        }
        
        if (key == KeyEvent.VK_RIGHT) {
            dx = -1;
        }
        
        if(key == KeyEvent.VK_UP) {
            dy = 1;
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
