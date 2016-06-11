/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assets;

import View.Window;
import java.awt.event.KeyEvent;

/**
 *
 * @author DanielSQ
 */
public class Player extends LiveSprite
{
    /*
    Estados: cayendo, suelo, subiendo
    */
    
    
    int jumpQuant;
        
    double jumpSpeed;
    double fallSpeed;
    public int restJumpLimit;
    
    public Player(int x, int y, Window window, int health)
    {
        super(x,y,window,health);
        this.window = window; 
        icon = (new javax.swing.ImageIcon(getClass().getResource("/IMG/Chark/CharkIdleAnim.gif"))); 
        super.setIcon(icon);
        setImageDimensions();
        jumpQuant = 200;
        //prepareJump();   
    }

    /**
     * @return the restJumpLimit
     */
    public int getRestJumpLimit() {
        return restJumpLimit;
    }

    /**
     * @param restJumpLimit the restJumpLimit to set
     */
    public void setRestJumpLimit(int restJumpLimit) {
        this.restJumpLimit = restJumpLimit;
    }

    /**
     * @return the jumping
     */
    public boolean isJumping() {
        return jumping;
    }

    /**
     * @param jumping the jumping to set
     */
    public void setJumping(boolean jumping) {
        this.jumping = jumping;
    }
    
    public void prepareJump()
    {
        if(!isJumping() && isCollisionBot())
        {
            jumpLim = getY() - jumpQuant;
            setJumping(true);
        }
    }
    
    public void jump()
    {
        if(isJumping() && !falling)
        {
            if(y > jumpLim && !isCollisionTop())
            {
                y -= gameSpeed;
                setRestJumpLimit(y - jumpLim);
                setJumping(true);
                super.setLocation(x, y);
            }
            else
            {
                setRestJumpLimit(0);
                fall();
                setJumping(false);
            }
        }
        else
        {   
            setJumping(false);
            fall();
        }
    }
    
    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();
        
        if((key == KeyEvent.VK_LEFT) || (key == KeyEvent.VK_LEFT && key == KeyEvent.VK_RIGHT))
        {
            facing = "left";
            dx = -gameSpeed;
            movingLeft = true;        
            icon = (new javax.swing.ImageIcon(getClass().getResource("/IMG/Chark/MovementAnimLeft.gif")));
        }
        
        if ((key == KeyEvent.VK_RIGHT) || (key == KeyEvent.VK_RIGHT && key == KeyEvent.VK_LEFT)) {
            facing = "right";
            dx = gameSpeed;
            movingRight = true;
            icon = (new javax.swing.ImageIcon(getClass().getResource("/IMG/Chark/MovementAnim.gif")));
        }
        
        if(key == KeyEvent.VK_UP) {
            prepareJump();  
        }            
                
        super.setIcon(icon);
    }
    
    public void keyReleased(KeyEvent e) {
        
        int key = e.getKeyCode();

        if((key == KeyEvent.VK_LEFT) || (key == KeyEvent.VK_LEFT && key == KeyEvent.VK_RIGHT))
        {
            dx = 0;
            movingLeft = false;
            icon = (new javax.swing.ImageIcon(getClass().getResource("/IMG/Chark/CharkIdleAnimLeft.gif"))); 
        }

        if ((key == KeyEvent.VK_RIGHT) || (key == KeyEvent.VK_RIGHT && key == KeyEvent.VK_LEFT)) {
            dx = 0;
            movingRight = false;
            icon = (new javax.swing.ImageIcon(getClass().getResource("/IMG/Chark/CharkIdleAnim.gif"))); 
        }
        
        if(key == KeyEvent.VK_UP) {
            //prepareJump();         
        }     
        
        if(key == KeyEvent.VK_SPACE){
            try
            {
                createBullet();
            }
            catch(Exception exc)
            {
                System.out.println("Error al crear bala");
            }
        }    
        
        super.setIcon(icon);
    }
}
