/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Levels;

import Assets.Sprites.StaticSprites.Other;
import Assets.Sprites.StaticSprites.Platform;
import Assets.Sprites.LiveSprites.Player;
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
        platform = new Platform[10];
        
        platform[0] = new Platform(-25,-200,"top1");
        platform[1] = new Platform(-200,650,"bot1");       
        platform[2] = new Platform(-200,0,"PlatWoodH");
        platform[3] = new Platform(-200,240,"PlatWoodH");
        platform[4] = new Platform(-200,480,"PlatWoodH");
        platform[5] = new Platform(1000,0,"PlatWoodH");
        platform[6] = new Platform(1000,240,"PlatWoodH");
        platform[7] = new Platform(1000,480,"PlatWoodH");
        platform[8] = new Platform(800,300,"PlatWoodW");
        platform[9] = new Platform(600,450,"PlatWoodW");
        
        
        for(int i = 0; i<platform.length; i++)
        {
            platform[i].update();
        }
    }
    
    public void setOther()
    {
        Other chest = new Other(350,605,"Intro/Chest.gif","chest1");
        Other door1 = new Other(900,500,"Intro/door1.png","door1");
        Other board = new Other(815,170,"Intro/boardObj.png","Board");
        Other logo = new Other(200,100,"Intro/Logo.png","logo");
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
