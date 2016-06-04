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
public class TestLevel extends Level
{
    public TestLevel()
    {
        platform = new Platform[3];
        setPlatforms();
    }
    
    public void setPlatforms()
    {
        platform[0] = new Platform(-50,200,"Platform");
        platform[1] = new Platform(600,200,"Platform");
        platform[2] = new Platform(400,300,"Platform");
        
        
        for(int i = 0; i<platform.length; i++)
        {
            platform[i].update();
        }
    }
}
