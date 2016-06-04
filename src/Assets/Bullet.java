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
    public Bullet(int x, int y)
    {        
        this.x = x;
        this.y = y;
        super.setLocation(x, y);
        icon = (new javax.swing.ImageIcon(getClass().getResource("/IMG/bullet.png"))); 
        super.setIcon(icon);
        setImageDimensions();
        update();
    }
    
    
}
