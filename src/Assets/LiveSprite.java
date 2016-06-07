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
    
    String looking = "right";
    public LiveSprite(int x, int y, Window window)
    {
        this.window = window;
        this.x = x;
        this.y = y;
        super.setLocation(x, y);
        jumpInt = 150;
    }
    
    public void moveOnX()
    {
        //System.out.println("Colision Izquierda: "+collisionLeft);
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
            //System.out.println("brinco?: "+brinco);
            if(getY() > getJumpLim())
            {
                //System.out.println("Y: "+getY());
                y = y-gameSpeed;
                restingLim= restingLim-gameSpeed;
                //System.out.println("Limite: "+jumpLim);
            }
            else
            {
                //System.out.println("Terminando brinco");
                brinco = false;
                movingUp = false;
                jumpLim = 0;
                restingLim = 0;
            }
            //System.out.println("brinco?: "+brinco);
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
    
    public void showCollisions()
    {
        if(collisionBot)
        {
            System.out.println("Colisiones abajo!");
        }
        if(collisionTop)
        {
            System.out.println("Colisiones arriba!");

        }
        if(collisionRight)
        {
            System.out.println("Colisiones derecha!");

        }
        if(collisionLeft)
        {
            System.out.println("Colisiones izquierda!");

        }
    }
}
