/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.File;

import View.Window;
import java.util.ArrayList;

/**
 *
 * @author DanielSQ
 */
public class FileMethods 
{
    Time[] array;
    FileLoader loader;
    Window window;
    
    public FileMethods(Window window) 
    {
        this.window = window;
        loader = new FileLoader();
        setArrayTime();
    }
    
    public void setArrayTime()
    {
        array = loader.returnFileInfo();
    }
    
    public void orderTime()
    {
        Time temp;
        
        System.out.println("Ordenando tiempos");
        for(int i=0;i<array.length;i++)
        {
            for(int j=0;j<array.length;j++)
            {
                if(array[i] != null && array[j] != null)
                {
                    if(array[i].getTime() < array[j].getTime())
                    {
                        temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                    }
                }
            }
        }
    }
    
    public void writeTime(Time time)
    {
        int unavailable=0;
        
        for(int i=0;i<array.length;i++)
        {
            if(array[i] == null)
            {
                array[i] = time;
                System.out.println("Tiempo escrito: "+array[i].getTime());
                i=array.length;
            }
            else
            {
                unavailable++;
            }
        }
        
        orderTime();
        
        Time temp;
        Time temp2;
        Time temp3;
        int j;
        
        if(unavailable == 3)
        {
            for(int i=0;i<array.length;i++)
            {
                if(time.getTime()<array[i].getTime())
                {
                    temp = array[i];
                    array[i] = time;
                    j=i+1;
                    temp2 = temp;
                    while(j < (array.length-1))
                    {
                        System.out.println("calculando...");
                        temp3 = array[j];
                        array[j] = temp2;
                        array[j+1] = temp3;
                        temp2 = temp3;
                        j++;
                    }
                    i=array.length;
                }
            }
        }
        
        writeToFile();
    }
    
    public void writeToFile()
    {
        loader.createFile();
        loader.addObject(array);
    }
    
    public String[] getTimes()
    {
        String[] time = new String[3];
        int j = 0;
        
        //orderTime();
        
        for(int i=0;i<array.length;i++)
        {
            if(array[i] != null)
            {
                time[j] = (j+1)+". "+array[i].getTime();
                j++;
            }
        }
        
        return time;
    }
}