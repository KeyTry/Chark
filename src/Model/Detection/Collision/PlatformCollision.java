package Model.Detection.Collision;

import Assets.Platform;
import Assets.Player;
import Assets.Sprite;

/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

/**
 *
 * @author DanielSQ
 */
public class PlatformCollision
{
    Sprite sprite;
    Platform[] platform;
    
    boolean collisionTop;
    boolean collisionBot;
    boolean collisionLeft;
    boolean collisionRight;
    
    int[] platformsX;
    int[] platformsY;
    int[] platformsX2;
    int[] platformsY2;
    
    int leeway = 12;
    
    public PlatformCollision()
    {
    }
    
    public void setSprite(Sprite sprite)
    {
        this.sprite = sprite;
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
        collisionTop = false;
        
        int colisiones = 0;
        for(int i = 0; i<platform.length;i++)
        {
            if((((sprite.getX()) >= (platformsX[i])) && ((sprite.getX()) <= (platformsX2[i]))) || (((sprite.getX2()) >= (platformsX[i])) && ((sprite.getX2()) <= (platformsX2[i]))))
            {
                if(((sprite.getY()) > (platformsY[i]-leeway)) && ((sprite.getY()) < (platformsY2[i]+leeway)))
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
        collisionBot = false;
        
        int colisiones = 0;
        for(int i = 0; i<platform.length;i++)
        {
            if((((sprite.getX()) >= (platformsX[i])) && ((sprite.getX()) <= (platformsX2[i]))) || (((sprite.getX2()) >= (platformsX[i])) && ((sprite.getX2()) <= (platformsX2[i]))))
            {
                if(((sprite.getY2()) <= (platformsY2[i]+leeway)) && ((sprite.getY2()) >= (platformsY[i]-leeway)))
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
        collisionLeft = false;
        
        int colisiones = 0;
        for(int i = 0; i<platform.length;i++)
        {
            if((((sprite.getY()) > platformsY[i]) && ((sprite.getY()) < platformsY2[i])) || (((sprite.getY2()) > platformsY[i]) && ((sprite.getY2()) < platformsY2[i])))
            {
                if(((sprite.getX()) > (platformsX[i]-(leeway+2))) && ((sprite.getX()) < (platformsX2[i]+(leeway+2))))
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
        collisionRight = false;
        
        int colisiones = 0;
        for(int i = 0; i<platform.length;i++)
        {
            if((((sprite.getY()) > platformsY[i]) && ((sprite.getY()) < platformsY2[i])) || (((sprite.getY2()) > platformsY[i]) && ((sprite.getY2()) < platformsY2[i])))
            {
                if((sprite.getX2() < platformsX2[i]+(leeway+2)) && (sprite.getX2() > platformsX[i]-(leeway+2)))
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
