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
                    System.out.println("COLISIÓN IZQUIERDA");
                    System.out.println("Y Plataforma: "+platformsY[i]);
                    System.out.println("Y bala: "+bullet.getY());
                    System.out.println("Y2: "+platformsY2[i]);
                    System.out.println("Y2 bala: "+bullet.getY2());
                    colisiones++;
                }
            }
        }
        if(colisiones != 0)
        {
            collisionLeft = true;
            System.out.println("BALA: Hay colisiones a la izquierda!");
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
                    System.out.println("COLISIÓN DERECHA");
                    System.out.println("Y Plataforma: "+platformsY[i]);
                    System.out.println("Y bala: "+bullet.getY());
                    System.out.println("Y2: "+platformsY2[i]);
                    System.out.println("Y2 bala: "+bullet.getY2());
                    colisiones++;
                }
            }
        }        
        if(colisiones != 0)
        {
            collisionRight = true;
            System.out.println("BALA: Hay colisiones a la derecha!");
        }
        else
        {
            collisionRight = false;
        }
        
        return collisionRight;
    }
}
