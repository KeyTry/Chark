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
import static java.lang.Thread.sleep;

/**
 *
 * @author DanielSQ
 */
public class Enemy extends NPLiveSprite{
    public boolean playerJumping;
    public boolean playerFalling;
    public boolean staticsJumping;
    
    public EnemyAI ai;
    String hitDrawing;
    String defaultDrawing;
    
    public int damage;
    
    public int jumpLimit;
    
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

    /**
     * @return the jumpLimit
     */
    public int getJumpLimit() {
        return jumpLimit;
    }

    /**
     * @param jumpLimit the jumpLimit to set
     */
    public void setJumpLimit(int jumpLimit) {
        this.jumpLimit = jumpLimit;
    }

    /**
     * @return the playerFalling
     */
    public boolean isPlayerFalling() {
        return playerFalling;
    }

    /**
     * @param playerFalling the playerFalling to set
     */
    public void setPlayerFalling(boolean playerFalling) {
        this.playerFalling = playerFalling;
    }

    /**
     * @return the staticsJumping
     */
    public boolean isStaticsJumping() {
        return staticsJumping;
    }

    /**
     * @param staticsJumping the staticsJumping to set
     */
    public void setStaticsJumping(boolean staticsJumping) {
        this.staticsJumping = staticsJumping;
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
    
    public void playerJump(boolean collisionTop, double restingLimit, boolean jumping)
    {
        
        if(!isStaticsJumping())
        {
            setJumpLimit((int) (y+restingLimit));
            setStaticsJumping(true);
            setPlayerJumping(true);            
            System.out.println("Alcanzado arriba! Resting lim: "+restingLim);

            System.out.println("Alcanzado arriba! calculando limite: "+getJumpLimit());
        }
        
        if(isStaticsJumping() && !collisionTop)
        {
            System.out.println("Moviendo mundo");
            if(jumping)
            {
                if(y < getJumpLimit())
                {
                    System.out.println("Intentando mover mundo!");
                    y += gameSpeed;
                    super.setLocation(x, y);
                    setPlayerJumping(true);
                    setStaticsJumping(true);
                }
                else
                {
                    setPlayerJumping(false);
                    setStaticsJumping(false);
                }
            }
        }
    }
    
    public void playerFall(boolean falling)
    {
        if(falling)
        {
            y-=gameSpeed;
            super.setLocation(x, y);
        }
    }
    
    
    public void aiOps()
    {
        ai.runOps();
    }
    
    public void fixEnemyPosition()
    {
    }
}
