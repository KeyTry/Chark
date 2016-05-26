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
    /*
    Estados: cayendo, suelo, subiendo
    */
    private String estado = "";
    
    private int dx;
    private int dy;
    
    public Player(int x, int y)
    {        
        this.x = x;
        this.y = y;
        super.setLocation(x, y);
        icon = (new javax.swing.ImageIcon(getClass().getResource("/IMG/CharkIdleAnim.gif"))); 
        super.setIcon(icon);
        setImageDimensions();
    }
    
    public void move()
    {
        System.out.println("Colision Izquierda: "+collisionLeft);
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
    
    public void fall()
    {
        if(getCollisionBot() == false)
        {
            y += 1;
        }
        
        super.setLocation(x, y);
    }
    
    public void setEstado(String estado)
    {
        this.estado = estado;
    }
   
    public void locateOnTopSuelo(int y)
    {
        if(collisionBot)
        {
            x = this.getX();
            y = (y-1);
            
            super.setLocation(x, y);
        }
        update();
    }
    
    public String getEstado()
    {
        return estado;
    }
    
    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();
        
        if(key == KeyEvent.VK_LEFT)
        {
                dx = -2;
        }
        
        if (key == KeyEvent.VK_RIGHT) {
                dx = 2;
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
