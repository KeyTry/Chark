/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Detection.Hit;

import Assets.Sprite;
import java.awt.Rectangle;

/**
 *
 * @author DanielSQ
 */
public class HitDetection 
{
    Sprite sprite1;
    Sprite sprite2;
    
    Rectangle sprite1Rectangle;
    Rectangle sprite2Rectangle;
    
    boolean collision = false;
    
    public HitDetection()
    {
    }
    
    public void setSprites(Sprite sprite1, Sprite sprite2)
    {
        this.sprite1 = sprite1;
        this.sprite2 = sprite2;
        createRectangles();
    }
    
    public void createRectangles()
    {
        sprite2Rectangle = new Rectangle(sprite2.getX(), sprite2.getY(), sprite2.getW(), sprite2.getH());
        sprite1Rectangle = new Rectangle(sprite1.getX(), sprite1.getY(), sprite1.getW(), sprite1.getH());
    }
    
    public boolean detectCollision()
    {
        if(sprite1Rectangle.intersects(sprite2Rectangle))
        {
            collision = true;
        }
        else
        {
            collision = false;
        }
        
        return collision;
    }
}
