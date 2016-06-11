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
public class StaticSprite extends Sprite{
    public boolean playerJumping;
    public boolean playerFalling;
    public boolean staticsJumping;
    
    int jumpLimit;
    
    public StaticSprite(int x, int y)
    {
        this.x = x;
        this.y = y;
        super.setLocation(x, y);
    }

    /**
     * @return the playerFalling
     */
    public boolean isPlayerFalling() {
        return playerFalling;
    }

    /**
     * @param playerFalling the playerFalling to set
     */
    public void setPlayerFalling(boolean playerFalling) {
        this.playerFalling = playerFalling;
    }

    /**
     * @return the playerJumping
     */
    public boolean isPlayerJumping() {
        return playerJumping;
    }

    /**
     * @param playerJumping the playerJumping to set
     */
    public void setPlayerJumping(boolean playerJumping) {
        this.playerJumping = playerJumping;
    }

    /**
     * @return the staticsJumping
     */
    public boolean isStaticsJumping() {
        return staticsJumping;
    }

    /**
     * @param staticsJumping the staticsJumping to set
     */
    public void setStaticsJumping(boolean staticsJumping) {
        this.staticsJumping = staticsJumping;
    }
    
    public void moveOnX()
    {
        if(dx > 0)
        {
            if(isCollisionRight() == false)
            {
                x += dx;
            }
        }
        if(dx < 0)
        {
            if(isCollisionLeft() == false)
            {
                x += dx;
            }
        }
        
        super.setLocation(x, y);
    }
    
    public void playerJump(boolean collisionTop, double restingLimit, boolean jumping)
    {
        
        if(!isStaticsJumping())
        {
            jumpLimit = (int) (y+restingLimit);
            setStaticsJumping(true);
            setPlayerJumping(true);            
            System.out.println("Alcanzado arriba! Resting lim: "+restingLim);

            System.out.println("Alcanzado arriba! calculando limite: "+jumpLimit);
        }
        
        if(isStaticsJumping() && !collisionTop)
        {
            System.out.println("Moviendo mundo");
            if(jumping)
            {
                if(y < jumpLimit)
                {
                    System.out.println("Intentando mover mundo!");
                    y += gameSpeed;
                    super.setLocation(x, y);
                    setPlayerJumping(true);
                    setStaticsJumping(true);
                }
                else
                {
                    setPlayerJumping(false);
                    setStaticsJumping(false);
                }
            }
        }
    }
    
    public void playerFall(boolean falling)
    {
        if(falling)
        {
            y-=gameSpeed;
            super.setLocation(x, y);
        }
    }
    
    /*public void prepareJump(int restingLim)
    {
        if(restingLim != 0)
        {
            if(!limEst)
            {
                this.restingLim = restingLim;
                downLim = getY2() +- this.restingLim;
                limEst = true;
            }
        }
    }
    
    public void jump(boolean playerJumping, boolean movingUp)
    {   
        this.playerJumping = playerJumping;
        this.movingUp = movingUp;
        
        if(restingLim != 0)
        {        
            this.playerJumping = playerJumping;
            this.movingUp = movingUp;
            if(limEst)
            {
                if(playerJumping && !collisionTop)
                {
                    if(getY2() < downLim)
                    {
                        y = y+gameSpeed;
                    }
                    else
                    {
                        this.playerJumping = false;
                        this.movingUp = false;
                        jumpLim = 0;
                        limEst = false;
                    }
                }
                else
                {
                    this.movingUp = false;
                    this.playerJumping = false;
                    limEst = false;
                }
            }
        }
        
        super.setLocation(x, y);
    }
    
    public void fall(boolean playerJumping, boolean movingDown)
    {
        if(!collisionBot && !playerJumping)
        {
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
    }*/
        
    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();
        
        if((key == KeyEvent.VK_LEFT) || (key == KeyEvent.VK_LEFT && key == KeyEvent.VK_RIGHT))
        {
            dx = gameSpeed;
        }
        
        if (key == KeyEvent.VK_RIGHT) {
            dx = -gameSpeed;
        }
        
        if(key == KeyEvent.VK_UP) {
            dy = gameSpeed;
            super.playerJumping = true;
        }
    }
    
    public void keyReleased(KeyEvent e) {
        
        int key = e.getKeyCode();

        if((key == KeyEvent.VK_LEFT) || (key == KeyEvent.VK_LEFT && key == KeyEvent.VK_RIGHT))
        {
            dx = 0;
        }

        if ((key == KeyEvent.VK_RIGHT) || (key == KeyEvent.VK_RIGHT && key == KeyEvent.VK_LEFT)){
            dx = 0;
        }
    }
}
