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
    int health;
    
    String looking = "right";
    public LiveSprite(int x, int y, Window window, int health)
    {
        this.window = window;
        this.x = x;
        this.y = y;
        this.health = health;
        super.setLocation(x, y);
        jumpInt = 200;
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
    
    public void moveOnXStatic()
    {
        System.out.println("Moviendo jugador estático");
        if(dx > 0)
        {
            if(collisionRight)
            {
                x += -dx;
            }
        }
        if(dx < 0)
        {
            if(collisionLeft)
            {
                x += -dx;
            }
        }
        
        super.setLocation(x, y);
    }
    
    public void prepareJump()
    {
        if(!collisionTop && collisionBot && !brinco)
        {
            jumpLim = getY()-jumpInt;
            brinco = true;
            movingUp = true;
        }
    }
    
    public void jump()
    {  
        restingLim = jumpLim;
        if(brinco && !collisionTop)
        {
            if(getY() > getJumpLim())
            {
                y = y-gameSpeed;
                restingLim= restingLim-gameSpeed;
            }
            else
            {
                brinco = false;
                movingUp = false;
                jumpLim = 0;
                restingLim = 0;
            }
        }
        else
        {
            movingUp = false;
            brinco = false;
            restingLim = 0;
        }
        
        super.setLocation(x, y);
    }

    public void fall()
    {
        if(!collisionBot && !brinco)
        {
            dy = gameSpeed;
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
    
    public void setMovingDown()
    {
        if(!collisionBot && !brinco)
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
        if(looking.equals("right"))
        {
            xBull = x2-5;
            yBull = y+42;
        }
        if(looking.equals("left"))
        {
            xBull = x+5;
            yBull = y+42;
        }
        Bullet bullet = new Bullet(xBull, yBull, looking);
        window.getBullets(bullet);
    }
    
    public void raiseHealth(int raise)
    {
        health+= raise;
    }
    
    public void lowerHealth(int damage)
    {
        health-= damage;
    }
    
    public int getHealth()
    {
        return health;
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
