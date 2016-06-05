package Model;

import Assets.Platform;
import Assets.Bullet;

/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

/**
 *
 * @author DanielSQ
 */
public class BulletCollisionDetect
{
    Bullet bullet;
    Platform[] platform;
    
    boolean collisionTop;
    boolean collisionBot;
    boolean collisionLeft;
    boolean collisionRight;
    
    int[] platformsX;
    int[] platformsY;
    int[] platformsX2;
    int[] platformsY2;
    
    public BulletCollisionDetect()
    {
    }
    
    
    public void setBullet(Bullet bullet)
    {
        this.bullet = bullet;
    }
    
    public void setPlatform(Platform[] platform)
    {
        this.platform = platform;
    }
    
    public void setPlatformVariables(int[] platformsX, int[] platformsY, int[] platformsX2, int[] platformsY2)
    {
        this.platformsX = platformsX;
        this.platformsY = platformsY;
        this.platformsX2 = platformsX2;
        this.platformsY2 = platformsY2;
    }
    
    public boolean collisionTop()
    {
        boolean collisionTop = false;
        
        int colisiones = 0;
        for(int i = 0; i<platform.length;i++)
        {
            if((((bullet.getX()) >= (platformsX[i])) && ((bullet.getX()) <= (platformsX2[i]))) || (((bullet.getX2()) >= (platformsX[i])) && ((bullet.getX2()) <= (platformsX2[i]))))
            {
                if(((bullet.getY()) > (platformsY[i]-1)) && ((bullet.getY()) < (platformsY2[i]+1)))
                {
                    colisiones++;
                }
            }
        }
        if(colisiones != 0)
        {
            //System.out.println("Hay colisiones arriba!");
            collisionTop = true;
        }
        else
        {
            collisionTop = false;
        }
        
        return collisionTop;
    }
    
    public boolean collisionBot()
    {
        boolean collisionBot = false;
        
        int colisiones = 0;
        for(int i = 0; i<platform.length;i++)
        {
            if((((bullet.getX()) >= (platformsX[i])) && ((bullet.getX()) <= (platformsX2[i]))) || (((bullet.getX2()) >= (platformsX[i])) && ((bullet.getX2()) <= (platformsX2[i]))))
            {
                if(((bullet.getY2()) <= (platformsY2[i]+1)) && ((bullet.getY2()) >= (platformsY[i]-1)))
                {
                    colisiones++;
                }
            }
        }        
        if(colisiones != 0)
        {            
            //System.out.println("Hay colisiones abajo!");
            collisionBot = true;
        }
        else
        {
            collisionBot = false;
        }
        
        return collisionBot;
    }
    
    public boolean collisionLeft()
    {
        boolean collisionLeft = false;
        
        int colisiones = 0;
        for(int i = 0; i<platform.length;i++)
        {
            if((((bullet.getY()) > platformsY[i]) && ((bullet.getY()) < platformsY2[i])) || (((bullet.getY2()) > platformsY[i]) && ((bullet.getY2()) < platformsY2[i])))
            {
                if(((bullet.getX()) > (platformsX[i]-2)) && ((bullet.getX()) < (platformsX2[i]+2)))
                {
                    colisiones++;
                }
            }
        }
        if(colisiones != 0)
        {
            collisionLeft = true;
            //System.out.println("Hay colisiones a la izquierda!");
        }
        else
        {
            collisionLeft = false;
        }
        
        return collisionLeft;
    }
    
    public boolean collisionRight()
    {
        boolean collisionRight = false;
        
        int colisiones = 0;
        for(int i = 0; i<platform.length;i++)
        {
            if((((bullet.getY()) > platformsY[i]) && ((bullet.getY()) < platformsY2[i])) || (((bullet.getY2()) > platformsY[i]) && ((bullet.getY2()) < platformsY2[i])))
            {
                if((bullet.getX2() < platformsX2[i]+3) && (bullet.getX2() > platformsX[i]-3))
                {
                    colisiones++;
                }
            }
        }        
        if(colisiones != 0)
        {
            collisionRight = true;
            //System.out.println("Hay colisiones a la derecha!");
        }
        else
        {
            collisionRight = false;
        }
        
        return collisionRight;
    }
}
