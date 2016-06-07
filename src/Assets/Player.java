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
    
    public Player(int x, int y, Window window)
    {
        super(x,y,window);
        this.window = window; 
        icon = (new javax.swing.ImageIcon(getClass().getResource("/IMG/CharkIdleAnim.gif"))); 
        super.setIcon(icon);
        setImageDimensions();
        prepareJump();   
    }
    
    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();
        
        if(key == KeyEvent.VK_LEFT)
        {
            looking = "left";
            dx = -gameSpeed;
            movingLeft = true;        
            icon = (new javax.swing.ImageIcon(getClass().getResource("/IMG/MovementAnimLeft.gif")));
        }
        
        if (key == KeyEvent.VK_RIGHT) {
            looking = "right";
            dx = gameSpeed;
            movingRight = true;
            icon = (new javax.swing.ImageIcon(getClass().getResource("/IMG/MovementAnim.gif")));
        }
        
        if(key == KeyEvent.VK_UP) {
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
        
        if(key == KeyEvent.VK_SPACE){
            System.out.println("Disparando!");
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
