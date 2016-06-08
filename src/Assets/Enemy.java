 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assets;

import Model.AI.EnemyAI;
import View.Window;
import static java.lang.Thread.sleep;
import javax.swing.Timer;

/**
 *
 * @author DanielSQ
 */
public class Enemy extends NPLiveSprite{
    public EnemyAI ai;
    String hitDrawing;
    String defaultDrawing;
    
    public int damage;
    
    public Enemy(int x, int y, Window window, int health)
    {
        super(x,y,window,health);
    }

    /**
     * @return the damage
     */
    public int getDamage() {
        return damage;
    }

    /**
     * @param damage the damage to set
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }
    
    public void setDefaultDrawing(String defaultDrawing)
    {
        this.defaultDrawing = defaultDrawing;
    }
    
    public void setHitDrawing(String hitDrawing)
    {
        this.hitDrawing = hitDrawing;
    }
    
    public void showHitDrawing()
    {
        icon = new javax.swing.ImageIcon(getClass().getResource("/IMG/Enemies/"+hitDrawing+""));
        super.setIcon(icon);
    }
    
    public void showDefaultDrawing()
    {
        icon = new javax.swing.ImageIcon(getClass().getResource("/IMG/Enemies/"+defaultDrawing+""));
        super.setIcon(icon);
    }
    
    public void aiOps()
    {
        ai.runOps();
    }
    
    public void fixEnemyPosition()
    {
    }
}
