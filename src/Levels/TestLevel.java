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
        platform = new Platform[9];
        player = new Player(60, 50,window,144);
        init();
    }
    
    public void init()
    {
        setPlatforms();
        setEnemies();
        setOther();
    }
    
    public Player getPlayer()
    {
        return player;
    }
    
    public void setPlatforms()
    {
        platform[0] = new Platform(-200,300,"Platform");
        platform[1] = new Platform(50,300,"Platform");
        platform[2] = new Platform(200,300,"Platform");
        platform[3] = new Platform(400,300,"Platform");
        platform[4] = new Platform(600,425,"Platform");
        platform[5] = new Platform(800,425,"Platform");
        platform[6] = new Platform(1000,425,"Platform");
        platform[7] = new Platform(1300,300,"Platform");
        platform[8] = new Platform(90,40,"Wooden");
        platform[8] = new Platform(150,40,"Wooden");
        
        for(int i = 0; i<platform.length; i++)
        {
            platform[i].update();
        }
    }
    
    public void setEnemies()
    {
        Enemy slim1 = new Slim(900, 25,window);
        Enemy reck1 = new Reck(250, 180,window);
        Enemy reck2 = new Reck(175, 150,window);
        Enemy reck3 = new Reck(325, 115,window);
        
        enemy.add(slim1);
        enemy.add(reck1);
        enemy.add(reck2);
        enemy.add(reck3);
    }
    
    public void setOther()
    {
        Other chest = new Other(1400,100,"Chest.gif","Chest");
        
        other.add(chest);
    }
}
