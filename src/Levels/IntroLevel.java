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
        platform = new Platform[6];
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
        platform[0] = new Platform(-47,-60,"top1");
        platform[1] = new Platform(-50,400,"bot1");
        platform[2] = new Platform(-20,-5,"Side");
        platform[3] = new Platform(740,-5,"Side");
        platform[4] = new Platform(230,250,"Wooden");
        platform[5] = new Platform(560,220,"Wooden");
        
        for(int i = 0; i<platform.length; i++)
        {
            platform[i].update();
        }
    }
    
    public void setOther()
    {
        Other chest = new Other(280,360,"Chest.gif","Chest");
        Other door1 = new Other(630,257,"door1.png","door1");
        Other door2 = new Other(630,20,"door1.png","door2");
        Other logo = new Other(45,60,"Logo.png","logo");
        Other fondo = new Other(0,0,"FondoIntro.png","fondo");
        
        other.add(door1);
        other.add(chest);
        other.add(door2);
        other.add(logo);
        other.add(fondo);
    }
    
    public void setEnemies()
    {
    }
}
