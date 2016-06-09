/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.LevelMethods;

import View.Window;
import static java.lang.Thread.sleep;

/**
 *
 * @author DanielSQ
 */
public class TestMethods extends LevelMethods{
    
    public TestMethods(Window window) 
    {
        super(window);
    }
    
    @Override
    public void ops()
    {
        createRectangles();
    }
}
