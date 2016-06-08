/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Levels;

import Assets.Enemy;
import Assets.Platform;
import java.util.ArrayList;
import Assets.Enemies.*;
import Assets.Player;
import View.Window;

/**
 *
 * @author DanielSQ
 */
public class TestLevel extends Level
{
    public TestLevel(Window window)
    {
        super(window);
        levelName = "Test";
        platform = new Platform[8];
        player = new Player(60,50,window,144);
        setPlatforms();
        setEnemies();
    }
    
    public Player getPlayer()
    {
        return player;
    }
    
    public void setPlatforms()
    {
        platform[0] = new Platform(-200,200,"Platform");
        platform[1] = new Platform(50,200,"Platform");
        platform[2] = new Platform(200,200,"Platform");
        platform[3] = new Platform(400,200,"Platform");
        platform[4] = new Platform(600,325,"Platform");
        platform[5] = new Platform(800,325,"Platform");
        platform[6] = new Platform(1000,325,"Platform");
        platform[7] = new Platform(1300,200,"Platform");
        
        for(int i = 0; i<platform.length; i++)
        {
            platform[i].update();
        }
    }
    
    public void setEnemies()
    {
        Enemy enemy1 = new Slim(600, 25,window);
        
        enemy.add(enemy1);
    }
}
