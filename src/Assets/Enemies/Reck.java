package Assets.Enemies;

import Assets.Enemy;
import Model.AI.ReckAI;
import Model.AI.SlimAI;
import View.Window;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DanielSQ
 */
public class Reck extends Enemy{
    ReckAI ai;
    public Reck(int x, int y, Window window)
    {        
        super(x,y,window,40);
        ai = new ReckAI(this);
        String hitDrawing = "ReckHit.png";
        String defaultDrawing = "Reck.gif";
        super.setHitDrawing(hitDrawing);
        super.setDefaultDrawing(defaultDrawing);
        icon = (new javax.swing.ImageIcon(getClass().getResource("/IMG/Enemies/Reck.gif"))); 
        super.setIcon(icon);
        setImageDimensions();
        super.setBounds(0, 0, getW(), getH());
        super.update();
    }
    
    @Override
    public void aiOps()
    {
        ai.runOps();
    }
    
    @Override
    public void fixEnemyPosition()
    {
        ai.fixEnemyPositionOnX(dx);
        ai.fixEnemyPositionOnY(dy);
    }
}
