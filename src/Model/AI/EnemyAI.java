/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.AI;

import Assets.Sprites.LiveSprites.Enemies.Enemy;

/**
 *
 * @author DanielSQ
 */
public class EnemyAI 
{
    Enemy enemy;
    
    int distance;
    
    int speed;
    
    int iniPosX;
    int finPosX;
    
    int iniPosY;
    int finPosY;
    
    boolean firstMove = true;
    boolean moving = false;
    
    public EnemyAI(Enemy enemy)
    {
        this.enemy = enemy;
    }

    public void runOps()
    {
        
    }
    
    public void fixEnemyPositionOnX(int dx)
    {
        finPosX += dx;
        iniPosX += dx;
    }
    
    public void fixEnemyPositionOnY(int dy)
    {
        finPosY += dy;
        iniPosY += dy;
    }
    
    public void setIniPosOnY()
    {
        if(!moving)
        {
            iniPosY = enemy.getY2();
        }
    }
    
    public void setFinalPosOnY()
    {
        if(firstMove)
        {
            finPosY = (iniPosY - distance);
            //System.out.println("Posición final: "+finPosX);
        }
        else
        {
            finPosY = (iniPosY + distance);
            //System.out.println("Posición final: "+finPosX);
        }
    }
    
    public void moveEnemyOnY()
    {
        if(enemy.isCollisionBot())
        {
            moving = false;
            firstMove = true;
            setIniPosOnY();
            setFinalPosOnY();
        }
        if(enemy.isCollisionTop())
        {
            moving = false;
            firstMove = false;
            setIniPosOnY();
            setFinalPosOnY();
        }
        if(firstMove)
        {
            if(enemy.getY2() > finPosY)
            {
                moving = true;
                enemy.setArtY(-speed);
            }
            else
            {
                moving = false;
                firstMove = false;
                setIniPosOnY();
                setFinalPosOnY();
            }
        }
        else
        {
            if(enemy.getY2() < finPosY)
            {
                moving = true;
                enemy.setArtY(speed);
            }
            else
            {
                moving = false;
                firstMove = true;
                setIniPosOnY();
                setFinalPosOnY();
            }
        }
    }
    
    public void setIniPosOnX()
    {
        if(!moving)
        {
            iniPosX = enemy.getX();
        }
    }
    
    public void setFinalPosOnX()
    {
        if(firstMove)
        {
            finPosX = (iniPosX - distance);
            //System.out.println("Posición final: "+finPosX);
        }
        else
        {
            finPosX = (iniPosX + distance);
            //System.out.println("Posición final: "+finPosX);
        }
    }
    
    public void moveEnemyOnX()
    {
        if(enemy.isCollisionLeft())
        {
            moving = false;
            firstMove = false;
            setIniPosOnX();
            setFinalPosOnX();
        }
        if(enemy.isCollisionRight())
        {
            moving = false;
            firstMove = true;
            setIniPosOnX();
            setFinalPosOnX();
        }
        if(firstMove)
        {
            if(enemy.getX() > finPosX)
            {
                moving = true;
                enemy.setArtX(-speed);
            }
            else
            {
                moving = false;
                firstMove = false;
                setIniPosOnX();
                setFinalPosOnX();
            }
        }
        else
        {
            if(enemy.getX() < finPosX)
            {
                moving = true;
                enemy.setArtX(speed);
            }
            else
            {
                moving = false;
                firstMove = true;
                setIniPosOnX();
                setFinalPosOnX();
            }
        }
    }
}
