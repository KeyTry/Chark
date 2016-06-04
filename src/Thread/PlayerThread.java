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
public class PlayerThread extends Thread {
    Window window;
    
    public PlayerThread(Window window)
    {
        this.window = window;
    }
    
    public void run()
    {
        try
        {
            while(true)
            {
                sleep(3);   
                window.update();
                window.collisionChecker();
            }
        }
        catch(Exception e)
        {
            System.out.println("Error en la ejecución del jugador: "+e);
        }
    }
}
