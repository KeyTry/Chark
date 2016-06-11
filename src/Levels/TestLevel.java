/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Levels;

import Assets.Enemy;
import Assets.Platform;
import Assets.Enemies.*;
import Assets.Other;
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
        player = new Player(60, 50,window,144);
        init();
    }
    
    @Override
    public void init()
    {
        setPlatforms();
        setEnemies();
        setOther();
    }
    
    public void setPlatforms()
    {
        platform = new Platform[14];
        platform[0] = new Platform(-200,500,"Platform");
        platform[1] = new Platform(50,500,"Platform");
        platform[2] = new Platform(200,500,"Platform");
        platform[3] = new Platform(400,500,"Platform");
        platform[4] = new Platform(600,500,"Platform");
        platform[5] = new Platform(800,500,"Platform");
        platform[6] = new Platform(1000,300,"Platform");
        platform[7] = new Platform(1300,300,"Platform");
        platform[8] = new Platform(90,40,"Wooden");
        platform[8] = new Platform(150,40,"Wooden");
        platform[9] = new Platform(-200,-100,"wall1");
        platform[10] = new Platform(1400,-100,"wall2");
        platform[11] = new Platform(600,100,"Wooden");
        platform[12] = new Platform(1000,200,"Wooden");
        platform[13] = new Platform(-10,-400,"top1");
        
        for(int i = 0; i<platform.length; i++)
        {
            platform[i].update();
        }
    }
    
    public void setEnemies()
    {
        Enemy slim1 = new Slim(600,180,window);
        Enemy slim2 = new Slim(1000,180,window);
        Enemy reck1 = new Reck(250, 180,window);
        Enemy reck2 = new Reck(175, 150,window);
        Enemy reck3 = new Reck(325, 115,window);
        
        enemy.add(slim1);
        enemy.add(slim2);
        enemy.add(reck1);
        enemy.add(reck2);
        enemy.add(reck3);
    }
    
    public void setOther()
    {
        Other chest = new Other(1200,255,"Chest.gif","Chest");
        Other lifeB = new Other(400, 255,"LifeBig.png","LifeBig");
        Other lifeS = new Other(1600,255,"Life.gif","Life");
        Other lifeS2 = new Other(1300,100,"Life.gif","Life");
        Other door = new Other(0,125,"door1.png","Door");
        
        other.add(door);
        other.add(chest);
        other.add(lifeB);
        other.add(lifeS);
        other.add(lifeS2);
    }
}
