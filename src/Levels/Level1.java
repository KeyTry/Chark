/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Levels;

import Assets.Enemies.Reck;
import Assets.Enemies.Slim;
import Assets.Enemy;
import Assets.Other;
import Assets.Platform;
import Assets.Player;
import View.Window;

/**
 *
 * @author DanielSQ
 */
public class Level1 extends Level{
    
    public Level1(Window window) {
        super(window);
        levelName = "Level1";
        player = new Player(60, 400,window,144);
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
        platform = new Platform[9];
        
        platform[0] = new Platform(-200,-50,"wall1");
        platform[1] = new Platform(-50,600,"Platform");
        platform[2] = new Platform(150,600,"Platform");
        platform[3] = new Platform(300,600,"Platform");
        platform[4] = new Platform(450,600,"Platform");
        platform[5] = new Platform(600,800,"Platform");
        platform[6] = new Platform(750,800,"Platform");
        platform[7] = new Platform(900,1000,"Platform");
        platform[8] = new Platform(1050,1000,"Platform");
        
        
        for(int i = 0; i<platform.length; i++)
        {
            platform[i].update();
        }
    }
    
    public void setEnemies()
    {

    }
    
    public void setOther()
    {
        Other enterDoor = new Other(0,450,"door1.png","enterDoor");
                
        other.add(enterDoor);
    }
    
}
