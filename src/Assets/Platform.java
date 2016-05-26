/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assets;

/**
 *
 * @author DanielSQ
 */
public class Platform extends Sprite{
    
    public Platform(int x, int y, String type)
    {        
        this.x = x;
        this.y = y;
        super.setLocation(x, y);
        icon = (new javax.swing.ImageIcon(getClass().getResource("/IMG/"+type+".png"))); 
        super.setIcon(icon);
        setImageDimensions();
    }
    
}
