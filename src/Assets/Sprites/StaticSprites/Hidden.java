/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assets.Sprites.StaticSprites;

import Assets.Sprite;

/**
 *
 * @author DanielSQ
 */
public class Hidden extends StaticSprite{
    
    public String name;
    
    public Hidden(int x, int y, String type, String name)
    {        
        super(x,y);
        icon = (new javax.swing.ImageIcon(getClass().getResource("/IMG/Hidden/"+type+""))); 
        super.setIcon(icon);
        this.name = name;
        setImageDimensions();
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
