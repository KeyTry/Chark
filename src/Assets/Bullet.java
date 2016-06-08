/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assets;

import java.awt.event.KeyEvent;

/**
 *
 * @author Daniel
 */
public class Bullet extends Sprite{
    int bulletSpeed = gameSpeed;
    int damage = 10;
    boolean exploding = false;
    
    String facing;
    public Bullet(int x, int y, String facing)
    {        
        this.facing = facing;
        this.x = x;
        this.y = y;
        super.setLocation(x, y);
        if(facing.equals("right"))
        {
            icon = (new javax.swing.ImageIcon(getClass().getResource("/IMG/Bullet/bullet.png"))); 
        }
        if(facing.equals("left"))
        {
            icon = (new javax.swing.ImageIcon(getClass().getResource("/IMG/Bullet/bulletLeft.png"))); 
        }
        super.setIcon(icon); 
        setImageDimensions();
        super.setBounds(0, 0, getW(), getH());
    }
    
    public void move()
    {
        if(facing.equals("right"))
        {
            dx=bulletSpeed;
        }
        if(facing.equals("left"))
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
            this.restingLim = restingLim;
            downLim = getY2() +- this.restingLim;
            limEst = true;
        }
    }
    
    public void jump(boolean brinco, boolean movingUp)
    {   
        this.brinco = brinco;
        this.movingUp = movingUp;
        
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
    
    public void showExplosion()
    {
        icon = (new javax.swing.ImageIcon(getClass().getResource("/IMG/Bullet/explosion.gif")));
        super.setIcon(icon);
    }
    
    public void setExploding(boolean exploding)
    {
        this.exploding = exploding;
    }
    
    public boolean isExploding()
    {
        return exploding;
    }
    
    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();
        
        if((key == KeyEvent.VK_LEFT) || (key == KeyEvent.VK_LEFT && key == KeyEvent.VK_RIGHT))
        {
            dx = gameSpeed;
        }
        
        if ((key == KeyEvent.VK_RIGHT) || (key == KeyEvent.VK_RIGHT && key == KeyEvent.VK_LEFT)) {
            dx = -gameSpeed;
        }
        
        if(key == KeyEvent.VK_UP) {
            dy = gameSpeed;
            brinco = true;
        }
    }
    
    public void keyReleased(KeyEvent e) {
        
        int key = e.getKeyCode();

        if((key == KeyEvent.VK_LEFT) || (key == KeyEvent.VK_LEFT && key == KeyEvent.VK_RIGHT)) {
            dx = 0;
        }

        if ((key == KeyEvent.VK_RIGHT) || (key == KeyEvent.VK_RIGHT && key == KeyEvent.VK_LEFT)) {
            dx = 0;
        }
    }
    
    public int getDamage()
    {
        return damage;
    }
    
    public void stop()
    {
        bulletSpeed  = 0;
    }
}
