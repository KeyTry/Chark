/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Levels;

import Assets.Enemy;
import Assets.Platform;
import java.util.ArrayList;

/**
 *
 * @author DanielSQ
 */
public class Level 
{
    Platform[] platform;
    ArrayList<Enemy> enemy;
    
    public Level()
    {
        
    }
    
    public Platform[] getPlatforms()
    {
        return platform;
    }
    
    public ArrayList<Enemy> getEnemies()
    {
        return enemy;
    }
    
    public int getPlatformSize()
    {
        return platform.length;
    }
    
    public int getEnemySize()
    {
        return enemy.size();
    }
}
