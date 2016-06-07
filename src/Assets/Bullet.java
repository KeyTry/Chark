/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assets;

import java.awt.event.KeyEvent;
import static java.lang.Thread.sleep;

/**
 *
 * @author Daniel
 */
public class Bullet extends Sprite{
    int bulletSpeed = gameSpeed;
    
    String looking;
    public Bullet(int x, int y, String looking)
    {        
        this.looking = looking;
        this.x = x;
        this.y = y;
        super.setLocation(x, y);
        if(looking.equals("right"))
        {
            icon = (new javax.swing.ImageIcon(getClass().getResource("/IMG/bullet.png"))); 
        }
        if(looking.equals("left"))
        {
            icon = (new javax.swing.ImageIcon(getClass().getResource("/IMG/bulletLeft.png"))); 
        }
        super.setIcon(icon);
        System.out.println("Ícono: "+icon);
        setImageDimensions();
        
        super.setBounds(0, 0, getW(), getH());
    }
    
    public void move()
    {
        if(looking.equals("right"))
        {
            dx=bulletSpeed;
        }
        if(looking.equals("left"))
        {
            dx=-bulletSpeed;
        }
        x+=dx;
        super.setLocation(x,y);
    }
    
    public boolean getColl()
    {
        boolean collision = false;
        if(collisionLeft || collisionRight)
        {
            collision = true;
        }
        return collision;
    }
    
    public void moveOnX()
    {
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
    
    public void prepareJump(int restingLim)
    {
        if(!limEst)
        {
            //System.out.println("Limite Restante:"+restingLim);
            this.restingLim = restingLim;
            downLim = getY2() +- this.restingLim;
            limEst = true;
            //System.out.println("ASIGNANDO LIMITE:\nY2: "+getY2()+"\nLimite: "+downLim+"\n\n");
        }
    }
    
    public void jump(boolean brinco, boolean movingUp)
    {   
        //System.out.println();
        
        this.brinco = brinco;
        this.movingUp = movingUp;
        
        //System.out.println("Down lim: "+downLim);
        
        if(limEst)
        {
            if(brinco && !collisionTop)
            {
                
                System.out.println("Y2: "+getY2());
                System.out.println("Limite: "+downLim);
                if(getY2() < downLim)
                {
                    y = y+gameSpeed;
                }
                else
                {
                    this.brinco = false;
                    this.movingUp = false;
                    System.out.println("Brinco?: "+brinco);
                    jumpLim = 0;
                    limEst = false;
                }
                //System.out.println("brinco?: "+brinco);
            }
            else
            {
                this.movingUp = false;
                this.brinco = false;
                limEst = false;
            }
        }
        
        super.setLocation(x, y);
    }
    
    public void fall(boolean brinco, boolean movingDown)
    {
        if(!brinco)
        {
            //System.out.println("Brinco?: "+brinco);
            dy = -gameSpeed;
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
    
    public void setExplosion()
    {
        try
        {
            icon = (new javax.swing.ImageIcon(getClass().getResource("/IMG/explosion.png"))); 
            super.setIcon(icon);
            sleep(50);
        }
        catch(Exception e)
        {
            
        }
    }
    
        
    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();
        
        if(key == KeyEvent.VK_LEFT)
        {
            dx = gameSpeed;
        }
        
        if (key == KeyEvent.VK_RIGHT) {
            dx = -gameSpeed;
        }
        
        if(key == KeyEvent.VK_UP) {
            dy = gameSpeed;
            brinco = true;
        }
    }
    
    public void keyReleased(KeyEvent e) {
        
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }
    }
}
