/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assets;

import View.Window;
import java.awt.event.KeyEvent;

/**
 *
 * @author DanielSQ
 */
public class NPLiveSprite extends LiveSprite{
    int artX;
    int artY;
    
    public NPLiveSprite(int x, int y, Window window, int health)
    {
        super(x,y,window,health);
    }
    
    @Override
    public void moveOnX()
    {
        if(artX > 0)
        {
            if(collisionRight == false)
            {
                x += artX;
            }
        }
        if(artX < 0)
        {
            if(collisionLeft == false)
            {
                x += artX;
            }
        }
        super.setLocation(x, y);
    }
    
        
    public void moveOnY()
    {
        if(artY > 0)
        {
            if(collisionBot == false)
            {
                y += artY;
            }
        }
        if(artY < 0)
        {
            if(collisionTop == false)
            {
                y += artY;
            }
        }
        super.setLocation(x, y);
    }
    
    public void moveOnXStaticEnemy()
    {
        if(dx > 0)
        {
            if(!collisionRight)
            {
                x += dx;
            }
        }
        if(dx < 0)
        {
            if(!collisionLeft)
            {
                x += dx;
            }
        }
        
        super.setLocation(x, y);
    }
    
    public void moveOnYStaticEnemy()
    {
        if(dy > 0)
        {
            if(!collisionBot)
            {
                y += dy;
            }
        }
        if(dy < 0)
        {
            if(!collisionTop)
            {
                y += dy;
            }
        }
        
        super.setLocation(x, y);
    }
    
    public void prepareJumpStatic(int restingLim)
    {
        if(!limEst)
        {
            this.restingLim = restingLim;
            downLim = getY2() +- this.restingLim;
            limEst = true;
        }
    }
    
    public void jumpStatic(boolean brinco, boolean movingUp)
    {   
        this.brinco = brinco;
        this.movingUp = movingUp;
        
        if(limEst)
        {
            if(brinco && !collisionTop)
            {
                if(getY2() < downLim)
                {
                    y = y+gameSpeed;
                }
                else
                {
                    this.brinco = false;
                    this.movingUp = false;
                    jumpLim = 0;
                    limEst = false;
                }
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
    
    public void fallStatic(boolean brinco, boolean movingDown)
    {
        System.out.println("Enemigo - Colision abajo: "+collisionBot);
        System.out.println("Enemigo - Brinco: "+brinco);
        if(!brinco)
        {
            System.out.println("Enemigo cayendo!");
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
    
    public void setArtX(int artX)
    {
        this.artX = artX;
    }
    
    public void setArtY(int artY)
    {
        this.artY = artY;
    }
    
    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();
        
        if((key == KeyEvent.VK_LEFT) || (key == KeyEvent.VK_LEFT && key == KeyEvent.VK_RIGHT))
        {
            dx = gameSpeed;
        }
        
        if ((key == KeyEvent.VK_RIGHT) || (key == KeyEvent.VK_RIGHT && key == KeyEvent.VK_LEFT))
        {
            dx = -gameSpeed;
        }
        
        if(key == KeyEvent.VK_UP) {
            dy = gameSpeed;
            brinco = true;
        }
    }
    
    public void keyReleased(KeyEvent e) {
        
        int key = e.getKeyCode();

        if((key == KeyEvent.VK_LEFT) || (key == KeyEvent.VK_LEFT && key == KeyEvent.VK_RIGHT))
        {
            dx = 0;
        }

        if ((key == KeyEvent.VK_RIGHT) || (key == KeyEvent.VK_RIGHT && key == KeyEvent.VK_LEFT)) {
            dx = 0;
        }
    }
}
