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
    public int x;
    public int y;
    public int x2;
    public int y2;
    public int w;
    public int h;
        
    public int dx;
    public int dy;
    
    public boolean collisionBot;
    public boolean collisionTop;
    public boolean collisionLeft;
    public boolean collisionRight;
    
    public boolean movingLeft;
    public boolean movingRight;
    public boolean movingDown = true;
    public boolean movingUp = true;
    public int jumpLim;
    int jumpInt;
    
    public boolean brinco = false;
    
    public int gameSpeed = 6;
        
    int downLim;
    int restingLim;
    
    boolean limEst;
    
    
    public ImageIcon icon;
    
    boolean vis;
    Image image;
    
    public Sprite()
    {
        setVis(true);
    }
    
    public void setAssetLocation(int x, int y)
    {
        this.x = x-3;
        this.y = y-3;
        
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
        x2 = (x + w)-3;
        y2 = (y + h)-3;
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
    public boolean isCollisionBot() {
        return collisionBot;
    }

    /**
     * @param collisionBot the collisionBot to set
     */
    public void setCollisionBot(boolean collisionBot) {
        this.collisionBot = collisionBot;
    }

    /**
     * @return the collisionTop
     */
    public boolean isCollisionTop() {
        return collisionTop;
    }

    /**
     * @param collisionTop the collisionTop to set
     */
    public void setCollisionTop(boolean collisionTop) {
        this.collisionTop = collisionTop;
    }

    /**
     * @return the collisionLeft
     */
    public boolean isCollisionLeft() {
        return collisionLeft;
    }

    /**
     * @param collisionLeft the collisionLeft to set
     */
    public void setCollisionLeft(boolean collisionLeft) {
        this.collisionLeft = collisionLeft;
    }

    /**
     * @return the collisionRight
     */
    public boolean isCollisionRight() {
        return collisionRight;
    }

    /**
     * @param collisionRight the collisionRight to set
     */
    public void setCollisionRight(boolean collisionRight) {
        this.collisionRight = collisionRight;
    }

    /**
     * @return the movingLeft
     */
    public boolean isMovingLeft() {
        return movingLeft;
    }

    /**
     * @param movingLeft the movingLeft to set
     */
    public void setMovingLeft(boolean movingLeft) {
        this.movingLeft = movingLeft;
    }

    /**
     * @return the movingRight
     */
    public boolean isMovingRight() {
        return movingRight;
    }

    /**
     * @param movingRight the movingRight to set
     */
    public void setMovingRight(boolean movingRight) {
        this.movingRight = movingRight;
    }

    /**
     * @return the movingDown
     */
    public boolean isMovingDown() {
        return movingDown;
    }

    /**
     * @param movingDown the movingDown to set
     */
    public void setMovingDown(boolean movingDown) {
        this.movingDown = movingDown;
    }

    /**
     * @return the movingUp
     */
    public boolean isMovingUp() {
        return movingUp;
    }

    /**
     * @param movingUp the movingUp to set
     */
    public void setMovingUp(boolean movingUp) {
        this.movingUp = movingUp;
    }

    /**
     * @return the jumpLim
     */
    public int getJumpLim() {
        return jumpLim;
    }

    /**
     * @param jumpLim the jumpLim to set
     */
    public void setJumpLim(int jumpLim) {
        this.jumpLim = jumpLim;
    }

    /**
     * @return the brinco
     */
    public boolean isBrinco() {
        return brinco;
    }

    /**
     * @param brinco the brinco to set
     */
    public void setBrinco(boolean brinco) {
        this.brinco = brinco;
    }
}
