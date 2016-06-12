/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Levels;

import Assets.Sprites.LiveSprites.Enemies.Reck;
import Assets.Sprites.LiveSprites.Enemies.Slim;
import Assets.Sprites.LiveSprites.Enemies.Enemy;
import Assets.Sprites.StaticSprites.Other;
import Assets.Sprites.StaticSprites.Platform;
import Assets.Sprites.LiveSprites.Player;
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
        platform = new Platform[24];
        
        /*platform[] = new Platform();
        platform[] = new Platform();
        platform[] = new Platform();
        platform[] = new Platform();
        platform[] = new Platform();
        platform[] = new Platform();
        platform[] = new Platform();
        platform[] = new Platform();
        platform[] = new Platform();
        platform[] = new Platform();
        platform[] = new Platform();
        platform[] = new Platform();
        platform[] = new Platform();
        platform[] = new Platform();
        platform[] = new Platform();
        platform[] = new Platform();
        platform[] = new Platform();*/

        
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
