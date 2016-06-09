/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author DanielSQ
 */
public class FileLoader {
    ObjectOutputStream outputFile;
    ObjectInputStream inputFile;
    
    public FileLoader()
    {
        if(loadFile())
        {
            System.out.println("Archivo cargado");
        }
        else
        {
            System.out.println("Error al cargar el archivo");
            createFile();
        }
    }
    
    public boolean loadFile()
    {
        boolean load = false;
        
        try
        {
            inputFile = new ObjectInputStream(new FileInputStream("File/times.dat"));
            load = true;
            System.out.println("Archivo cargado");
        }
        catch(Exception e)
        {
            System.out.println("Error al cargar archivo: "+e);
            e.printStackTrace();
        }
        
        return load;
    }
    
    public void createFile()
    {
        try
        {
            outputFile = new ObjectOutputStream(new FileOutputStream("File/times.dat"));
            System.out.println("Archivo creado");
        }
        catch(Exception e)
        {
            System.out.println("Error al crear archivo: "+e);
            e.printStackTrace();
        }
    }
    
    public void addObject(Time[] time)
    {
        try
        {
            outputFile.writeObject(time);
            System.out.println("Archivo escrito");
        }
        catch(Exception e)
        {
            System.out.println("Error al escribir al archivo: "+e);
            e.printStackTrace();
        }
    }
    
    public Time[] returnFileInfo()
    {       
        Time[] time = new Time[3];
        
        try
        {
            while(true)
            {
                time = (Time[])inputFile.readObject();
            }
        }
        catch(Exception e)
        {
            System.out.println("Alcanzado final del archivo");
        }
        
        return time;
    }
}
