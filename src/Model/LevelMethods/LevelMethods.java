/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.LevelMethods;

import Assets.Sprites.StaticSprites.Other;
import Assets.Sprites.LiveSprites.Player;
import View.Window;
import java.awt.Rectangle;
import java.util.ArrayList;

/**
 *
 * @author DanielSQ
 */
public class LevelMethods {
    public Window window;
    public ArrayList<Other> arrayOther;
    public Player player;
    public Rectangle[] arrayOtherRect;
    public Rectangle playerRect;
    
    public LevelMethods(Window window)
    {
        this.window = window;
    }
    
    public void ops()
    {
    }
    
    public void createRectangles()
    {
        playerRect = new Rectangle(player.getX(), player.getY(), player.getW(), player.getH());
        
        arrayOtherRect = new Rectangle[arrayOther.size()];
        
        for(int i=0; i<arrayOther.size();i++)
        {
                Rectangle tempRect = new Rectangle(arrayOther.get(i).getX(),arrayOther.get(i).getY(),arrayOther.get(i).getW(),arrayOther.get(i).getH());
                arrayOtherRect[i] = tempRect;
        }
    }
    
    /**
     * @return the arrayOther
     */
    public ArrayList<Other> getArrayOther() {
        return arrayOther;
    }

    /**
     * @param arrayOther the arrayOther to set
     */
    public void setArrayOther(ArrayList<Other> arrayOther) {
        this.arrayOther = arrayOther;
    }

    /**
     * @return the player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * @param player the player to set
     */
    public void setPlayer(Player player) {
        this.player = player;
    }
}
