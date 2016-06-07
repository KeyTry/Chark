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
    
    public void prepareJump(int restingLim)
    {
        if(!limEst)
        {
            this.restingLim = restingLim;
            downLim = getY2() +- this.restingLim;
            limEst = true;
        }
    }
    
    public void jump(boolean brinco, boolean movingUp)
    {   
        this.brinco = brinco;
        this.movingUp = movingUp;
        
        if(limEst)
        {
            if(brinco && !collisionTop)
            {
                //System.out.println("brinco Mundo?: "+brinco);
                
                //System.out.println("Y2: "+getY2());
                //System.out.println("Limite: "+downLim);
                if(getY2() < downLim)
                {
                    //System.out.println("Moviendo Plataforma");
                    y = y+gameSpeed;
                }
                else
                {
                    this.brinco = false;
                    this.movingUp = false;
                    //System.out.println("Brinco?: "+brinco);
                    jumpLim = 0;
                    limEst = false;
                }
                //System.out.println("brinco?: "+brinco);
            }
            else
            {
                this.movingUp = false;
                this.brinco = false;
                limEst = false;
            }
        }
        
        super.setLocation(x, y);
    }
    
    public void fall(boolean brinco, boolean movingDown)
    {
        if(!collisionBot && !brinco)
        {
            //System.out.println("Brinco?: "+brinco);
            dy = -gameSpeed;
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
            dx = gameSpeed;
        }
        
        if (key == KeyEvent.VK_RIGHT) {
            dx = -gameSpeed;
        }
        
        if(key == KeyEvent.VK_UP) {
            dy = gameSpeed;
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
