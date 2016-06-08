/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.LevelMethods;

import Assets.Other;
import Assets.Player;
import View.Window;
import java.util.ArrayList;

/**
 *
 * @author DanielSQ
 */
public class IntroMethods
{
    Window window;
    private ArrayList<Other> arrayOther;
    private Player player;
    
    public IntroMethods(Window window)
    {
        this.window = window;
        window.resetTime();
    }
    
    public void ops()
    {
        enterDoor1();
    }
    
    public void enterDoor1()
    {
        int index = -1;
        
        for(int i = 0;i<arrayOther.size();i++)
        {
            if(arrayOther.get(i).getName().equals("door1"))
            {
                index = i;
            }
        }
        
        if((player.getY()>=arrayOther.get(index).getY()) && (player.getX()>=arrayOther.get(index).getX()))
        {
            window.loadLevel(window.getTestLevel());
            window.startTime();
            window.createHealthLabel();
            window.showHealthLabel();
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
