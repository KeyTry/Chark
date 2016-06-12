/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Levels;

import Assets.Sprites.LiveSprites.Enemies.Slim;
import Assets.Sprites.LiveSprites.Enemies.Reck;
import Assets.Sprites.LiveSprites.Enemies.Enemy;
import Assets.Sprites.StaticSprites.Platform;
import Assets.Sprites.StaticSprites.Other;
import Assets.Sprites.LiveSprites.Player;
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
        player = new Player(400, 50,window,144);
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
        Enemy slim2 = new Slim(300,180,window);
        Enemy slim3 = new Slim(900,180,window);
        Enemy slim4 = new Slim(1000,180,window);
        Enemy slim5 = new Slim(800,180,window);
        Enemy slim6 = new Slim(500,180,window);
        Enemy slim8 = new Slim(400,180,window);
        Enemy slim7 = new Slim(1100,180,window);
        Enemy slim9 = new Slim(1200,180,window);
        
        enemy.add(slim1);
        enemy.add(slim2);
        enemy.add(slim3);
        enemy.add(slim4);
        enemy.add(slim5);
        enemy.add(slim6);
        enemy.add(slim7);
        enemy.add(slim8);
        enemy.add(slim9);
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
