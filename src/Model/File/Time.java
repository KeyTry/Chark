/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.File;

import java.io.Serializable;

/**
 *
 * @author DanielSQ
 */
public class Time implements Serializable
{
    public int time;   

    public Time()
    {
        
    }
    
    public Time(int time) 
    {
        this.time = time;
    }

    /**
     * @return the time
     */
    public int getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(int time) {
        this.time = time;
    }
}
