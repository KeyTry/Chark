/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Thread;

import View.Window;

/**
 *
 * @author DanielSQ
 */
public class MainThread extends Thread
{
    Window window;
    
    public MainThread(Window window)
    {
        this.window = window;
    }
    
    @Override
    public void run()
    {
        try
        {
            while(true)
            {
                sleep(15);
                if(window.isLevelLoaded())
                {
                    window.update();  
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Error en la ejecución: "+e);
            e.printStackTrace();
        }
    }
}
