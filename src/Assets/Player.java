/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assets;

import java.awt.event.KeyEvent;

/**
 *
 * @author DanielSQ
 */
public class Player extends Sprite
{
    int restingLim;
    /*
    Estados: cayendo, suelo, subiendo
    */
    
    public Player(int x, int y)
    {        
        this.x = x;
        this.y = y;
        super.setLocation(x, y);
        icon = (new javax.swing.ImageIcon(getClass().getResource("/IMG/CharkIdleAnim.gif"))); 
        super.setIcon(icon);
        setImageDimensions();
        jumpInt = 150;
    }
    
    public void moveOnX()
    {
        //System.out.println("Colision Izquierda: "+collisionLeft);
        if(dx > 0)
        {
            if(collisionRight == false)
            {
                x += dx;
            }
        }
        if(dx < 0)
        {
            if(collisionLeft == false)
            {
                x += dx;
            }
        }
        super.setLocation(x, y);
    }
    
    public void prepareJump()
    {
        if(!collisionTop && collisionBot && !brinco)
        {
            jumpLim = getY()-jumpInt;
            brinco = true;
            movingUp = true;
        }
    }
    
    public void jump()
    {  
        restingLim = jumpLim;
        if(brinco && !collisionTop)
        {
            //System.out.println("brinco?: "+brinco);
            if(getY() > getJumpLim())
            {
                System.out.println("Y: "+getY());
                y = y-1;
                restingLim= restingLim-1;
                //System.out.println("Limite: "+jumpLim);
            }
            else
            {
                //System.out.println("Terminando brinco");
                brinco = false;
                movingUp = false;
                jumpLim = 0;
                restingLim = 0;
            }
            //System.out.println("brinco?: "+brinco);
        }
        else
        {
            movingUp = false;
            brinco = false;
            restingLim = 0;
        }
        
        super.setLocation(x, y);
    }

    public void fall()
    {
        if(!collisionBot && !brinco)
        {
            //System.out.println("Brinco?: "+brinco);
            dy = 1;
            y += dy;
            movingDown = true;
        }
        else
        {
            dy = 0;
            movingDown = false;
        }
        
        super.setLocation(x, y);
    }
    
    public void setMovingDown()
    {
        if(!collisionBot && !brinco)
        {

            movingDown = true;
        }
        else
        {
            movingDown = false;
        }
    }
    
    public int getRestingLim()
    {
        return restingLim;
    }
    
    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();
        
        if(key == KeyEvent.VK_LEFT)
        {
            dx = -1;
            movingLeft = true;        
            icon = (new javax.swing.ImageIcon(getClass().getResource("/IMG/MovementAnimLeft.gif")));
        }
        
        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
            movingRight = true;
            icon = (new javax.swing.ImageIcon(getClass().getResource("/IMG/MovementAnim.gif")));
        }
        
        if(key == KeyEvent.VK_UP) {
            System.out.println("Presionado brincar");
            prepareJump();            
        }
        
        super.setIcon(icon);
    }
    
    
    public void keyReleased(KeyEvent e) {
        
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
            movingLeft = false;
            icon = (new javax.swing.ImageIcon(getClass().getResource("/IMG/CharkIdleAnimLeft.gif"))); 
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
            movingRight = false;
            icon = (new javax.swing.ImageIcon(getClass().getResource("/IMG/CharkIdleAnim.gif"))); 
        }
        
        super.setIcon(icon);
    }
}
