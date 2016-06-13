/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Levels;

import Assets.Sprites.LiveSprites.Enemies.Enemy;
import Assets.Sprites.StaticSprites.Other;
import Assets.Sprites.StaticSprites.Platform;
import Assets.Sprites.LiveSprites.Player;
import Assets.Sprites.StaticSprites.Hidden;
import View.Window;
import java.util.ArrayList;
import javax.swing.Icon;

/**
 *
 * @author DanielSQ
 */
public class Level 
{
    Platform[] platform;
    ArrayList<Enemy> enemy;
    ArrayList<Other> other;
    ArrayList<Hidden> hidden;
    Icon background;
    Player player;
    Window window;
    String levelName;
    
    public Level(Window window)
    {
        this.window = window;
        enemy = new ArrayList();
        other = new ArrayList();
        hidden = new ArrayList();
    }
    
    public void init()
    {
        
    }

    /**
     * @return the levelName
     */
    public String getLevelName() {
        return levelName;
    }

    /**
     * @param levelName the levelName to set
     */
    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }
    
    public Player getPlayer()
    {
        return player;
    }
    
    public Platform[] getPlatforms()
    {
        return platform;
    }
    
    public ArrayList<Enemy> getEnemies()
    {
        return enemy;
    }
    
    public ArrayList<Other> getOther()
    {
        return other;
    }
    
    public ArrayList <Hidden> getHidden()
    {
        return hidden;
    }
    
    public int getPlatformSize()
    {
        return platform.length;
    }
    
    public int getEnemySize()
    {
        return enemy.size();
    }
    
    public int getOtherSize()
    {
        return other.size();
    }
    
    public int getHiddenSize()
    {
        return hidden.size();
    }
}
