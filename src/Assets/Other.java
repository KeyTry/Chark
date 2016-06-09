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
public class Other extends StaticObject{
    private String name;
    
    public Other(int x, int y, String type, String name)
    {        
        super(x,y);
        icon = (new javax.swing.ImageIcon(getClass().getResource("/IMG/Others/"+type+""))); 
        super.setIcon(icon);
        this.name = name;
        setImageDimensions();
    }

    /**
     * @return the name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }
}
