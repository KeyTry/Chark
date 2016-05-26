/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Levels;

import Assets.Platform;

/**
 *
 * @author DanielSQ
 */
public class Level1 extends Level
{
    public Level1()
    {
        platform = new Platform[4];
        setPlatforms();
    }
    
    public void setPlatforms()
    {
        platform[0] = new Platform(20,200,"Platform");
        platform[1] = new Platform(300,400,"Platform");
        platform[2] = new Platform(650,200,"Platform");
        platform[3] = new Platform(-460,0,"Platform");
        
        
        for(int i = 0; i<platform.length; i++)
        {
            platform[i].update();
        }
    }
}
