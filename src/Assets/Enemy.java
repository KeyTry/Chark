/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assets;

import View.Window;
import java.awt.event.KeyEvent;
import static java.lang.Thread.sleep;

/**
 *
 * @author DanielSQ
 */
public class Enemy extends LiveAsset{
    public Enemy(int x, int y, Window window)
    {
        super(x,y,window);
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
            System.out.println("Limite Restante:"+restingLim);
            this.restingLim = restingLim;
            downLim = getY2() +- this.restingLim;
            limEst = true;
            System.out.println("ASIGNANDO LIMITE:\nY2: "+getY2()+"\nLimite: "+downLim+"\n\n");
        }
    }
    
    public void jump(boolean brinco, boolean movingUp)
    {   
        System.out.println();
        
        this.brinco = brinco;
        this.movingUp = movingUp;
        
        System.out.println("Down lim: "+downLim);
        
        if(limEst)
        {
            if(brinco && !collisionTop)
            {
                System.out.println("brinco Mundo?: "+brinco);
                
                System.out.println("Y2: "+getY2());
                System.out.println("Limite: "+downLim);
                if(getY2() < downLim)
                {
                    System.out.println("Moviendo Plataforma");
                    y = y+1;
                }
                else
                {
                    System.out.println("Terminando brinco (Plataforma)");
                    this.brinco = false;
                    this.movingUp = false;
                    System.out.println("Brinco?: "+brinco);
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
