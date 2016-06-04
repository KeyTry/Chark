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
    int jumpLim;
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
    
    public void moveOnY()
    {
        if(!collisionBot && !brinco)
        {
            System.out.println("Brinco?: "+brinco);
            dy = 1;
            y += dy;
        }
        else
        {
            dy = 0;
        }
        
        super.setLocation(x, y);
    }
    
    public void prepareJump()
    {
        if(!collisionTop && collisionBot && !brinco)
        {
            jumpLim = getY()-150;
            brinco = true;
        }
    }
    
    public void jump()
    {   
        if(brinco && !collisionTop)
        {
            System.out.println("brinco?: "+brinco);
            if(getY() > jumpLim)
            {
                System.out.println("Y: "+getY());
                y = y-1;
                System.out.println("Limite: "+jumpLim);
            }
            else
            {
                System.out.println("Terminando brinco");
                brinco = false;
                System.out.println("Brinco?: "+brinco);
                jumpLim = 0;
            }
            System.out.println("brinco?: "+brinco);
        }
        else
        {
            brinco = false;
        }
    }
    
    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();
        
        if(key == KeyEvent.VK_LEFT)
        {
            dx = -1;
        }
        
        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
        }
        
        if(key == KeyEvent.VK_UP) {
            System.out.println("Presionado brincar");
            prepareJump();
        }
        
        icon = (new javax.swing.ImageIcon(getClass().getResource("/IMG/MovementAnim.gif")));
        super.setIcon(icon);
    }
    
    
    public void keyReleased(KeyEvent e) {
        
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }
        
        icon = (new javax.swing.ImageIcon(getClass().getResource("/IMG/CharkIdleAnim.gif"))); 
        super.setIcon(icon);
    }
}
