/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.AI;

import Assets.Enemy;

/**
 *
 * @author DanielSQ
 */
public class SlimAI extends EnemyAI
{
    public SlimAI(Enemy enemy)
    {
        super(enemy);
        distance = 200;
    }
    
    @Override
    public void runOps()
    {
        //System.out.println("Corriendo operaciones para Slim");
        setIniPos();
        
        setFinalPos();
        
        moveEnemy();
    }
    
    public void setIniPos()
    {
        if(!moving)
        {
            iniPos = enemy.getX();
            //System.out.println("Posición inicial: "+iniPos);
            curX = enemy.getX();
        }
    }
    
    public void setFinalPos()
    {
        if(firstMove)
        {
            finalPos = (iniPos - distance);
            //System.out.println("Posición final: "+finalPos);
        }
        else
        {
            finalPos = (iniPos + distance);
            //System.out.println("Posición final: "+finalPos);
        }
    }
    
    public void moveEnemy()
    {
        if(enemy.isCollisionLeft())
        {
            moving = false;
            firstMove = false;
            setIniPos();
            setFinalPos();
        }
        if(enemy.isCollisionRight())
        {
            moving = false;
            firstMove = true;
            setIniPos();
            setFinalPos();
        }
        if(firstMove)
        {
            if(enemy.getX() > finalPos)
            {
                moving = true;
                enemy.setArtX(-5);
            }
            else
            {
                moving = false;
                firstMove = false;
                setIniPos();
                setFinalPos();
            }
        }
        else
        {
            if(enemy.getX() < finalPos)
            {
                moving = true;
                enemy.setArtX(5);
            }
            else
            {
                moving = false;
                firstMove = true;
                setIniPos();
                setFinalPos();
            }
        }
    }
}
