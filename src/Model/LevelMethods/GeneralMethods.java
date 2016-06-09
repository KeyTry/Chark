/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.LevelMethods;

import Model.LevelMethods.LevelMethods;
import View.Window;

/**
 *
 * @author DanielSQ
 */
public class GeneralMethods extends LevelMethods{
    
    public GeneralMethods(Window window) {
        super(window);
    }
    
    public void ops()
    {
        createRectangles();
        touchChest();
        touchLifeSmall();
        touchLifeBig();
    }
    
    public void touchChest()
    {
        int index = -1;
        
        for(int i = 0;i<arrayOther.size();i++)
        {
            if(arrayOther.get(i).getName().equals("Chest"))
            {
                index = i;
            }
        }
        
        if(index != -1)
        {
            if(playerRect.intersects(arrayOtherRect[index]))
            {
                try
                {
                    window.showVictoryScreen();
                }
                catch(Exception e)
                {
                    
                }
            }
        }
    }
    
    public void touchLifeSmall()
    {
        int indice = -1;
        int raise = 30;
        
        for(int i = 0;i<arrayOther.size();i++)
        {
            if(arrayOther.get(i).getName().equals("Life"))
            {
                indice = i;
            }
        }
        
        if(indice != -1)
        {
            if(playerRect.intersects(arrayOtherRect[indice]))
            {
                window.raisePlayerHealth(raise);
                window.removeOther(indice);
            }
        }
    }
    
    public void touchLifeBig()
    {
        int indice = -1;
        int raise = 60;
        
        for(int i = 0;i<arrayOther.size();i++)
        {
            if(arrayOther.get(i).getName().equals("LifeBig"))
            {
                indice = i;
            }
        }
        
        if(indice != -1)
        {
            if(playerRect.intersects(arrayOtherRect[indice]))
            {
                window.raisePlayerHealth(raise);
                window.removeOther(indice);
            }
        }
    }
}
