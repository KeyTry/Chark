/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.LevelMethods;

import View.Window;
import java.applet.AudioClip;

/**
 *
 * @author DanielSQ
 */
public class IntroMethods extends LevelMethods
{    
    boolean musicPlayed = false;
    boolean showingScores = false;
    public IntroMethods(Window window)
    {
        super(window);
        window.resetTime();
    }
    
    @Override
    public void ops()
    {
        enterDoor1();
        enterScoreBoard();
        createRectangles();
        showHidden("chest1", "MusAtt");
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
            window.removeScores();
            window.loadLevel(window.getLevel1());
            window.startTime();
            window.showHealthLabel();
            if(!musicPlayed)
            {
                window.playMusic(window.getChibiNinja());
                musicPlayed = true;
            }
        }
    }
    
    public void enterScoreBoard()
    {
        int index = -1;
        
        for(int i = 0;i<arrayOther.size();i++)
        {
            if(arrayOther.get(i).getName().equals("Board"))
            {
                index = i;
            }
        }
        
        if((player.getY2() <= arrayOther.get(index).getY2()) && (player.getY()>=arrayOther.get(index).getY()) && (player.getX()>=arrayOther.get(index).getX()))
        {
            if(!showingScores)
            {
                System.out.println("Mostrando puntuaciones");
                window.showScores();
                showingScores = true;
            }
        }
        else
        {
            if(showingScores)
            {
                window.removeScores();                
                showingScores = false;
            }
        }
    }
}
