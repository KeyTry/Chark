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
        platform = new Platform[4];
        enemy = new ArrayList();
        player = new Player(60,50,window);
        setPlatforms();
        setEnemies();
    }
    
    public void setPlatforms()
    {
        platform[0] = new Platform(-50,200,"Platform");
        platform[1] = new Platform(600,200,"Platform");
        platform[2] = new Platform(400,300,"Platform");
        platform[3] = new Platform(300,-200,"Platform");
        
        
        for(int i = 0; i<platform.length; i++)
        {
            platform[i].update();
        }
    }
    
    public void setEnemies()
    {
        Enemy enemy1 = new Slim(300, 50,window);
        enemy.add(enemy1);
    }
}
