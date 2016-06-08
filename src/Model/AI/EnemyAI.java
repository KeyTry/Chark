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
public class EnemyAI 
{
    Enemy enemy;
    
    int curX;
    int distance;
    
    int iniPos;
    int finalPos;
    boolean firstMove = true;
    boolean moving = false;
    
    public EnemyAI(Enemy enemy)
    {
        this.enemy = enemy;
    }

    public void runOps()
    {
        
    }
    
    public void fixEnemyPosition(int dx)
    {
        if(dx > 0)
        {
            finalPos += dx;
        }
        if(dx < 0)
        {
            finalPos += dx;
        }
    }
}
