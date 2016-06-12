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
public class PuniAI extends EnemyAI{
    
    public PuniAI(Enemy enemy) {
        super(enemy);
        
        distance = 50;
        speed = 15;
    }
    
    
     @Override
    public void runOps()
    {
        setIniPosOnX();
        
        setFinalPosOnX();
        
        moveEnemyOnX();
    }
    
}
