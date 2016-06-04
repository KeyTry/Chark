/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Assets.*;
import Levels.*;
import Model.CollisionChecker;
import Thread.MainThread;
import Thread.PlayerThread;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 *
 * @author DanielSQ
 */
public class Window extends javax.swing.JFrame implements ActionListener{
    Player player;
    Platform platform[];
    int[] platformsX;
    int[] platformsY;
    int[] platformsX2;
    int[] platformsY2;
    
    Thread mThread;
    Thread pThread;
    
    CollisionChecker collChck;
    
    /**
     * Creates new form Window
     */
    public Window() {
        initComponents();
        initWindow();
    }
    
    public void initWindow()
    {
        this.setLocationRelativeTo(null);
        
        player = new Player(60, 50);
        getContentPane().add(player);
        player.setBounds(0,0, player.getW(), player.getH());
        
        TestLevel level1 = new TestLevel();
        loadLevel(level1);
        
        collChck = new CollisionChecker();
        
        //mThread = new MainThread(this);
        //mThread.start();
        
        pThread = new PlayerThread(this);
        pThread.start();
        
        for(int i = 0; i < platform.length; i++)
        {
            platform[i].prepareJump(getRestingLim());
        }
    }
    
    public void loadLevel(Level level)
    {
        platform = level.getPlatforms();
        
        platformsX = new int[level.getSize()];
        platformsY = new int[level.getSize()];
        platformsX2 = new int[level.getSize()];
        platformsY2 = new int[level.getSize()];

        for(int i = 0; i<level.getSize(); i++)
        {
            getContentPane().add(platform[i]);
        }
        
        updatePlatforms();
    }
    
    public void updatePlatforms()
    {
        for(int i = 0; i<platform.length; i++)
        {
            platform[i].setBounds(0,0, platform[i].getW(), platform[i].getH());
            platformsX[i] = platform[i].getX();
            platformsY[i] = platform[i].getY();
            platformsX2[i] = platform[i].getX2();
            platformsY2[i] = platform[i].getY2();
        }  
    }
    
    public void collisionChecker()
    {
        collChck.setPlatform(platform);
        collChck.setPlayer(player);
        collChck.setPlatformVariables(platformsX, platformsY, platformsX2, platformsY2);
        
        player.setCollisionBot(collChck.collisionBot());
        player.setCollisionTop(collChck.collisionTop());
        player.setCollisionRight(collChck.collisionRight());
        player.setCollisionLeft(collChck.collisionLeft());
        
        for(int i = 0; i < platform.length; i++)
        {
            platform[i].setCollisionBot(collChck.collisionBot());
            platform[i].setCollisionTop(collChck.collisionTop());
            platform[i].setCollisionRight(collChck.collisionRight());
            platform[i].setCollisionLeft(collChck.collisionLeft());        
        }
    }
    
    public void update()
    {
        //System.out.println("Intentando actualizar");
        player.update();
        
        for(int i = 0; i < platform.length; i++)
        {
            platform[i].update();
        }
        
        updatePlatforms();
        
        collisionChecker();
        
        player.setMovingDown();
        
        if(player.isMovingLeft() && player.getX() > 50)
        {
            movePlayerOnX();
        }
        if(player.isMovingLeft() && player.getX() <= 50)
        {
            moveWorldOnX();
        }
        if(player.isMovingRight() && player.getX2() < 750)
        {            
            movePlayerOnX();
        }
        if(player.isMovingRight() && player.getX2() >= 750)
        {  
            moveWorldOnX();
        }
        if(player.isMovingUp() && player.getY() > 12)
        {
            movePlayerOnY();
        }
        if(player.isMovingUp() && player.getY() <= 12)
        {
            for(int i = 0; i < platform.length; i++)
            {
                platform[i].prepareJump(getRestingLim());
            }
            jumpWorld();
        }
        if(player.isMovingDown() && player.getY2() < 350)
        {
            movePlayerOnY();
        }
        if(player.isMovingDown() && player.getY2() >= 350)
        {
            fallWorld();
        }
    }
    
    public void movePlayerOnX()
    {
        player.moveOnX();
    }
    
    public void movePlayerOnY()
    {
        player.fall();
        player.jump();
    }
    
    public void jumpWorld()
    {
        System.out.println("Brincando Mundo");
        
        for(int i = 0; i < platform.length; i++)
        {
            platform[i].jump(player.isBrinco(), player.isMovingUp());
        }
        
        player.setBrinco(platform[0].isBrinco());
        player.setMovingUp(platform[0].isMovingUp());
    }
    
    public void fallWorld()
    {
        for(int i = 0; i < platform.length; i++)
        {
            platform[i].fall(player.isBrinco(), player.isMovingDown());
        }
    }
    
    public void moveWorldOnX()
    {
        for(int i = 0; i < platform.length; i++)
        {
            platform[i].moveOnX();
        }
    }
    
    public int getRestingLim()
    {
        return player.getRestingLim();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 450));
        setPreferredSize(new java.awt.Dimension(800, 450));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 450));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });
        getContentPane().setLayout(null);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        player.keyPressed(evt);
        for(int i = 0; i < platform.length; i++)
        {
            platform[i].keyPressed(evt);
        }
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        player.keyReleased(evt);
        for(int i = 0; i < platform.length; i++)
        {
            platform[i].keyReleased(evt);
        }
    }//GEN-LAST:event_formKeyReleased
   
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Window().setVisible(true);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
