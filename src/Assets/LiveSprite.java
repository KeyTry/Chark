/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assets;

import View.Window;

/**
 *
 * @author DanielSQ
 */
public class LiveSprite extends Sprite{
    
    Window window;
    public int health;
    
    String facing = "right";
    
    int jumpQuant;
    
    public boolean jumping;
    public boolean falling;
    
    double jumpSpeed;
    double fallSpeed;
    int restJumpLimit;
    
    public LiveSprite(int x, int y, Window window, int health)
    {
        this.window = window;
        this.x = x;
        this.y = y;
        this.health = health;
        super.setLocation(x, y);
        jumpInt = 200;
    }

    /**
     * @return the restLimit
     */
    public int getRestJumpLimit() {
        return restJumpLimit;
    }

    /**
     * @param restLimit the restLimit to set
     */
    public void setRestJumpLimit(int restJumpLimit) {
        this.restJumpLimit = restJumpLimit;
    }

    /**
     * @return the falling
     */
    public boolean isFalling() {
        return falling;
    }

    /**
     * @param falling the falling to set
     */
    public void setFalling(boolean falling) {
        this.falling = falling;
    }

    /**
     * @return the jumping
     */
    public boolean isJumping() {
        return jumping;
    }

    /**
     * @param jumping the jumping to set
     */
    public void setJumping(boolean jumping) {
        this.jumping = jumping;
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
    
    public void moveOnXStatic()
    {
        System.out.println("Moviendo jugador estático");
        if(dx > 0)
        {
            if(isCollisionRight())
            {
                x += -dx;
            }
        }
        if(dx < 0)
        {
            if(isCollisionLeft())
            {
                x += -dx;
            }
        }
        
        super.setLocation(x, y);
    }
    
    /*public void prepareJump()
    {
        if(!collisionTop && collisionBot && !playerJumping)
        {
            jumpLim = getY()-jumpInt;
            playerJumping = true;
            movingUp = true;
        }
    }
    
    public boolean jump()
    {  
        boolean jumping = false;
        restingLim = jumpLim;
        
        if(playerJumping && !collisionTop)
        {
            if(getY() > getJumpLim())
            {
                y = y-gameSpeed;
                restingLim = restingLim-gameSpeed;
                jumping = true;
            }
            else
            {
                playerJumping = false;
                movingUp = false;
                jumpLim = 0;
                restingLim = 0;
                jumping = false;
            }
        }
        else
        {
            movingUp = false;
            playerJumping = false;
            restingLim = 0;
            if(collisionTop)
            {
                window.setRestingLim(restingLim);
            }
            jumping = false;
        }
        
        super.setLocation(x, y);
        
        return jumping;
    }*/
    
    public void prepareFall()
    {
        if(!falling && !isCollisionBot() && !jumping)
        {
            setFalling(true);
        }
    }

    public void fall()
    {      
        if(!isCollisionBot() && !jumping && falling)
        {
            y += gameSpeed;
            setFalling(true);
        }
        else
        {
            setFalling(false);
        }
        
        super.setLocation(x, y);
    }
    
    public void setMovingDown()
    {
        if(!isCollisionBot() && !playerJumping)
        {
            movingDown = true;
        }
        else
        {
            movingDown = false;
        }
    }
    
    public int getRestingLim()
    {
        return restingLim;
    }
    
    public void createBullet()
    {
        int xBull = 0;
        int yBull = 0;
        if(facing.equals("right"))
        {
            xBull = x2-5;
            yBull = y+42;
        }
        if(facing.equals("left"))
        {
            xBull = x+5;
            yBull = y+42;
        }
        Bullet bullet = new Bullet(xBull, yBull, facing);
        window.getBullets(bullet);
    }
    
    public void raiseHealth(int raise)
    {
        setHealth(getHealth() + raise);
    }
    
    public void lowerHealth(int damage)
    {
        setHealth(getHealth() - damage);
    }
    
    public int getHealth()
    {
        return health;
    }

    /**
     * @param health the health to set
     */
    public void setHealth(int health) {
        this.health = health;
    }
    
    public void setDx(int dx)
    {
        this.dx = dx;
    }
    
    public void setDy(int dy)
    {
        this.dy = dy;
    }
}
