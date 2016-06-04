/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assets;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author DanielSQ
 */
public class Sprite extends JLabel
{
    int x;
    int y;
    int x2;
    int y2;
    int w;
    int h;
    
    boolean collisionBot;
    boolean collisionTop;
    boolean collisionLeft;
    boolean collisionRight;
    
    
    int dx;
    int dy;
    
    boolean brinco = false;
    
    
    ImageIcon icon;
    
    boolean vis;
    Image image;
    
    public Sprite()
    {
        setVis(true);
    }
    
    public void setAssetLocation(int x, int y)
    {
        this.x = x;
        this.y = y;
        
        super.setLocation(x, y);
    }
    
    public void setVis(boolean vis)
    {
        this.vis = vis;
    }
    
    public boolean getVis()
    {
        return vis;
    }

    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
    
    public int getW()
    {
        return w;
    }
    
    public int getH()
    {
        return h;
    }
    
    public int getX2()
    {
        return x2;
    }
    
    public int getY2()
    {
        return y2;
    }
    
    public ImageIcon getIcon()
    {
        return icon;
    }
    
    public void setImageDimensions()
    {
        w = icon.getIconWidth();
        h = icon.getIconHeight();
    }
    
    public void setSecBound()
    {
        x2 = x + w;
        y2 = y + h;
    }
    
    public int getDy()
    {
        return dy;
    }
    
    public void update()
    {
        setImageDimensions();
        setSecBound();
    }
  
    /**
     * @return the collisionBot
     */
    public boolean getCollisionBot() {
        return collisionBot;
    }

    /**
     * @param colisionAbajo the collisionBot to set
     */
    public void setCollisionBot(boolean colisionAbajo) {
        this.collisionBot = colisionAbajo;
    }

    /**
     * @return the collisionTop
     */
    public boolean getCollisionTop() {
        return collisionTop;
    }

    /**
     * @param colisionArriba the collisionTop to set
     */
    public void setCollisionTop(boolean colisionArriba) {
        this.collisionTop = colisionArriba;
    }

    /**
     * @return the collisionLeft
     */
    public boolean getCollisionLeft() {
        return collisionLeft;
    }

    /**
     * @param colisionIzquierda the collisionLeft to set
     */
    public void setCollisionLeft(boolean colisionIzquierda) {
        this.collisionLeft = colisionIzquierda;
    }

    /**
     * @return the collisionRight
     */
    public boolean getCollisionRight() {
        return collisionRight;
    }

    /**
     * @param colisionRight the collisionRight to set
     */
    public void setCollisionRight(boolean colisionRight) {
        this.collisionRight = colisionRight;
    }
}
