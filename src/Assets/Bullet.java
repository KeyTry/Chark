/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assets;

/**
 *
 * @author Daniel
 */
public class Bullet extends Sprite{
    String looking;
    public Bullet(int x, int y, String looking)
    {        
        System.out.println("Bala creada");
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
            dx=1;
        }
        if(looking.equals("left"))
        {
            dx=-1;
        }
        x+=dx;
        super.setLocation(x,y);
    }
    
    public boolean getColl()
    {
        boolean collision = false;
        if(collisionBot || collisionLeft || collisionRight || collisionTop)
        {
            collision = true;
        }
        return collision;
    }
}
