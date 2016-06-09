/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Levels;

import Assets.Other;
import Assets.Platform;
import Assets.Player;
import View.Window;

/**
 *
 * @author DanielSQ
 */
public class IntroLevel extends Level
{
    public IntroLevel(Window window)
    {
        super(window);
        levelName = "Intro";
        platform = new Platform[5];
        player = new Player(160,260,window,144);
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
        platform[0] = new Platform(-10,-60,"top1");
        platform[1] = new Platform(-20,400,"bot1");
        platform[2] = new Platform(-20,-5,"Side");
        platform[3] = new Platform(740,-5,"Side2");
        platform[4] = new Platform(560,220,"Wooden");
        
        for(int i = 0; i<platform.length; i++)
        {
            platform[i].update();
        }
    }
    
    public void setOther()
    {
        Other chest = new Other(280,355,"Intro/Chest.gif","chest1");
        Other door1 = new Other(630,257,"Intro/door1.png","door1");
        Other board = new Other(600,100,"Intro/boardObj.png","Board");
        Other logo = new Other(120,100,"Intro/Logo.png","logo");
        Other fondo = new Other(0,0,"Intro/FondoIntro.png","fondo");
        
        other.add(door1);
        other.add(chest);
        other.add(board);
        other.add(logo);
        other.add(fondo);
    }
    
    public void setEnemies()
    {
    }
}
