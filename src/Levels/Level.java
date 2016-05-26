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
public class Level 
{
    Platform[] platform;
    
    public Level()
    {
        
    }
    
    public Platform[] getPlatforms()
    {
        return platform;
    }
    
    public int getSize()
    {
        return platform.length;
    }
}
