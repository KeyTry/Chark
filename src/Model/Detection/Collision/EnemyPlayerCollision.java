/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Detection.Collision;

import Assets.Enemy;
import Assets.Player;
import java.util.ArrayList;

/**
 *
 * @author DanielSQ
 */
public class EnemyPlayerCollision 
{
    ArrayList<Enemy> enemies;
    Player player;
    
    boolean collisionTop;
    boolean collisionBot;
    boolean collisionLeft;
    boolean collisionRight;
    
    int enemiesX[];
    int enemiesX2[];
    int enemiesY[];
    int enemiesY2[];
    
    int leeway = 5;
    
    public void EnemyPlayerDetection()
    {
    }
    
    public void setPlayer(Player player)
    {
        this.player = player;
    }
    
    public void setEnemies(ArrayList<Enemy> enemies)
    {
        this.enemies = enemies;
        setEnemyArrays();
    }
    
    public void setEnemyArrays()
    {
        enemiesX = new int[enemies.size()];
        enemiesX2 = new int[enemies.size()];
        enemiesY = new int[enemies.size()];
        enemiesY2 = new int[enemies.size()];
        
        for(int i=0;i<enemiesX.length;i++)
        {
            enemiesX[i] = enemies.get(i).getX();
        }
        
        for(int i=0;i<enemiesX2.length;i++)
        {
            enemiesX2[i] = enemies.get(i).getX2();
        }
        
        for(int i=0;i<enemiesY.length;i++)
        {
            enemiesY[i] = enemies.get(i).getY();
        }
        
        for(int i=0;i<enemiesY2.length;i++)
        {
            enemiesY2[i] = enemies.get(i).getY2();
        }
    }
    
    public boolean collisionTop()
    {
        collisionTop = false;
        
        int colisiones = 0;
        for(int i = 0; i<enemies.size();i++)
        {
            if((((player.getX()) >= (enemiesX[i])) && ((player.getX()) <= (enemiesX2[i]))) || (((player.getX2()) >= (enemiesX[i])) && ((player.getX2()) <= (enemiesX2[i]))))
            {
                if(((player.getY()) > (enemiesY[i]-leeway)) && ((player.getY()) < (enemiesY2[i]+leeway)))
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
        for(int i = 0; i<enemies.size();i++)
        {
            if((((player.getX()) >= (enemiesX[i])) && ((player.getX()) <= (enemiesX2[i]))) || (((player.getX2()) >= (enemiesX[i])) && ((player.getX2()) <= (enemiesX2[i]))))
            {
                if(((player.getY2()) <= (enemiesY2[i]+leeway)) && ((player.getY2()) >= (enemiesY[i]-leeway)))
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
        for(int i = 0; i<enemies.size();i++)
        {
            if((((player.getY()) > enemiesY[i]) && ((player.getY()) < enemiesY2[i])) || (((player.getY2()) > enemiesY[i]) && ((player.getY2()) < enemiesY2[i])))
            {
                if(((player.getX()) > (enemiesX[i]-(leeway+1))) && ((player.getX()) < (enemiesX2[i]+(leeway+1))))
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
        for(int i = 0; i<enemies.size();i++)
        {
            if((((player.getY()) > enemiesY[i]) && ((player.getY()) < enemiesY2[i])) || (((player.getY2()) > enemiesY[i]) && ((player.getY2()) < enemiesY2[i])))
            {
                if((player.getX2() < enemiesX2[i]+(leeway+1)) && (player.getX2() > enemiesX[i]-(leeway+1)))
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
