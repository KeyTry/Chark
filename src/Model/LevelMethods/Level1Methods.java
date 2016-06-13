/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.LevelMethods;

import View.Window;

/**
 *
 * @author DanielSQ
 */
public class Level1Methods extends LevelMethods
{
    public Level1Methods(Window window) {
        super(window);
    }
    
    @Override
    public void ops()
    {
        createRectangles();
        showHidden("PYD", "PYDSign");
    }
}
