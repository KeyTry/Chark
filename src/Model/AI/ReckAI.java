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
public class ReckAI extends EnemyAI{
    
    public ReckAI(Enemy enemy) {
        super(enemy);
        distance = 300;
        speed = 10;
    }
    
     @Override
    public void runOps()
    {
        setIniPosOnY();
        
        setFinalPosOnY();
        
        moveEnemyOnY();
    }
}
