/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assets.Sprites.LiveSprites.Enemies;

import Model.AI.SlimAI;
import View.Window;

/**
 *
 * @author DanielSQ
 */
public class Puni extends Enemy{
    public Puni(int x, int y, Window window)
    {        
        super(x,y,window,90);
        ai = new SlimAI(this);
        damage = 15;
        String hitDrawing = "slimHit.gif";
        String defaultDrawing = "Slim.gif";
        super.setHitDrawing(hitDrawing);
        super.setDefaultDrawing(defaultDrawing);
        icon = (new javax.swing.ImageIcon(getClass().getResource("/IMG/Enemies/slim.gif"))); 
        super.setIcon(icon);
        setImageDimensions();
        super.setBounds(0, 0, getW(), getH());
        super.update();
    }
    
    
    @Override
    public void fixEnemyPosition()
    {
        ai.fixEnemyPositionOnX(dx);
        ai.fixEnemyPositionOnY(dy);
    }
    
    @Override
    public void fall()
    {
        dy = 0;
    }
}
