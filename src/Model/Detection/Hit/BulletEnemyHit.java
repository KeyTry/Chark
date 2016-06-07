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
public class BulletEnemyHit 
{
    Sprite bullet;
    Sprite enemy;
    
    Rectangle bulletRectangle;
    Rectangle enemyRectangle;
    
    boolean collision = false;
    
    public BulletEnemyHit()
    {
    }
    
    public void setBulletsEnemies(Sprite bullet, Sprite enemy)
    {
        this.bullet = bullet;
        this.enemy = enemy;
        createRectangles();
    }
    
    public void createRectangles()
    {
        enemyRectangle = new Rectangle(enemy.getX(), enemy.getY(), enemy.getW(), enemy.getH());
        bulletRectangle = new Rectangle(bullet.getX(), bullet.getY(), bullet.getW(), bullet.getH());
    }
    
    public boolean detectCollision()
    {
        if(bulletRectangle.intersects(enemyRectangle))
        {
            collision = true;
        }
        
        return collision;
    }
}
