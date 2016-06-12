/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assets.Sprites.StaticSprites;

import Assets.Sprites.StaticSprites.StaticSprite;
import java.awt.event.KeyEvent;

/**
 *
 * @author DanielSQ
 */
public class Platform extends StaticSprite{
    
    public Platform(int x, int y, String type)
    {       
        super(x,y);
        icon = (new javax.swing.ImageIcon(getClass().getResource("/IMG/Platforms/"+type+".png"))); 
        super.setIcon(icon);
        setImageDimensions();
    }
}
