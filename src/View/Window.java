/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.LevelMethods.GeneralMethods;
import Assets.*;
import Levels.*;
import Model.Detection.Collision.PlatformCollision;
import Model.Detection.Hit.HitDetection;
import Model.File.FileMethods;
import Model.File.Time;
import Model.LevelMethods.IntroMethods;
import Model.LevelMethods.LevelMethods;
import Model.LevelMethods.TestMethods;
import Thread.MainThread;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.JLabel;
import static java.lang.Thread.sleep;

/**
 *
 * @author DanielSQ
 */
public class Window extends javax.swing.JFrame implements ActionListener{
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
    Player player;
    Platform platform[];
    ArrayList <Enemy> arrayEnemies;
    ArrayList<Other> arrayOther;
    
    boolean bulletExploding = false;
    
    int[] platformsX;
    int[] platformsY;
    int[] platformsX2;
    int[] platformsY2;
    
    int[] enemiesX;
    int[] enemiesY;
    int[] enemiesX2;
    int[] enemiesY2;
    
    Thread mThread;
    
    Thread bThread;
    
    Level testLevel;
    Level introLevel;
    
    LevelMethods introMethods;
    LevelMethods testMethods;
    
    LevelMethods generalMethods;
    
    String levelName;
    
    boolean playerHit = false ;
    
    ArrayList <Bullet> arrayBullets = new ArrayList();
    
    JLabel health;
    
    long startTime;
    long endTime;
    long totalTime;
    
    FileMethods file;
    
    public boolean levelLoaded = false;
    
    JLabel board;
    JLabel scores;
    JLabel timesTitle;
    JLabel times1;
    JLabel times2;
    JLabel times3;
    
    /**
     * Creates new form Window
     */
    public Window() {
        initComponents();
        initWindow();
    }

    /**
     * @return the introLevel
     */
    public Level getIntroLevel() {
        return introLevel;
    }

    /**
     * @param introLevel the introLevel to set
     */
    public void setIntroLevel(Level introLevel) {
        this.introLevel = introLevel;
    }

    /**
     * @return the testLevel
     */
    public Level getTestLevel() {
        return testLevel;
    }

    /**
     * @param testLevel the testLevel to set
     */
    public void setTestLevel(Level testLevel) {
        this.testLevel = testLevel;
    }
    
    public void initWindow()
    {
        this.setLocationRelativeTo(null);
        file = new FileMethods(this);
        /*enterTimes();
        printTimes();*/
        getContentPane().setBackground(Color.BLACK);
        createLevels();
        loadLevel(getIntroLevel());
        createLevelMethods();
        mThread = new MainThread(this);
        mThread.start();
    }
    
    public void enterTimes(Time time)
    {
        file.writeTime(time);
        
        file.writeToFile();
    }
    
    public String[] printTimes()
    {
        String[] times = new String[3];
        
        file.orderTime();
        
        times[0] = file.getTimes()[0];
        times[1] = file.getTimes()[1];
        times[2] = file.getTimes()[2];
        
        return times;
    }
    
    public void createLevels()
    {
        setIntroLevel(new IntroLevel(this));
        setTestLevel(new TestLevel(this));
    }
    
    public void createLevelMethods()
    {
        generalMethods = new GeneralMethods(this);
        introMethods = new IntroMethods(this);
        testMethods = new TestMethods(this);
    }

    /**
     * @return the levelLoaded
     */
    public boolean isLevelLoaded() {
        return levelLoaded;
    }

    /**
     * @param levelLoaded the levelLoaded to set
     */
    public void setLevelLoaded(boolean levelLoaded) {
        this.levelLoaded = levelLoaded;
    }
    
    public void updateLevelMethods()
    {
        generalMethods.setArrayOther(arrayOther);
        generalMethods.setPlayer(player);
        generalMethods.ops();
        
        if(levelName.equals("Intro"))
        {
            introMethods.setArrayOther(arrayOther);
            introMethods.setPlayer(player);
            introMethods.ops();
        }
        if(levelName.equals("Test"))
        {
            testMethods.setArrayOther(arrayOther);
            testMethods.setPlayer(player);
            testMethods.ops();        
        }
    }
    
    public void startTime()
    {
        startTime = System.currentTimeMillis();
    }
    
    public void calculateTime()
    {
        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
    }
    
    public void clearLevel()
    {
        levelLoaded = false;
        try
        {
            player = null;
            platform = null;
            arrayEnemies = null;
            arrayOther = null;
            getContentPane().removeAll();
            createLevels();
            createLevelMethods();
        }
        catch(Exception e)
        {
            System.out.println("Error reiniciando frame: "+e);
            e.getStackTrace();
        }
    }
    
    public void loadLevel(Level level)
    {
        clearLevel();
        
        loadPlayer(level);
        loadPlatforms(level);
        loadEnemies(level);
        loadOther(level);
        loadLevelName(level);
        
        levelLoaded = true;
    }
    
    public void showHealthLabel()
    {
        health = new JLabel();
        health.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        health.setForeground(new java.awt.Color(255, 255, 255));
        
        getContentPane().add(health);
        getContentPane().setComponentZOrder(health, 0);
        health.setBounds(50, 50, 800, 50);
    }
    
    public void updateHealthLabel()
    {
        if(health != null)
        {
            health.setText("HEALTH: "+player.getHealth());
        }
    }
    
    public void loadPlatforms(Level level)
    {
        platform = level.getPlatforms();
        
        platformsX = new int[level.getPlatformSize()];
        platformsY = new int[level.getPlatformSize()];
        platformsX2 = new int[level.getPlatformSize()];
        platformsY2 = new int[level.getPlatformSize()];
        
        for(int i = 0; i<level.getPlatformSize(); i++)
        {
            getContentPane().add(platform[i]);
        }
        
        updatePlatforms();
    }
    
    public void loadEnemies(Level level)
    {
        arrayEnemies = level.getEnemies();
        
        enemiesX = new int[level.getEnemySize()];
        enemiesY = new int[level.getEnemySize()];
        enemiesX2 = new int[level.getEnemySize()];
        enemiesY2 = new int[level.getEnemySize()];
        
        for(int i = 0; i<level.getEnemySize(); i++)
        {
            getContentPane().add(arrayEnemies.get(i));
        }
        
        updateEnemies();
    }
    
    public void loadOther(Level level)
    {
        System.out.println("Nivel: ");
        
        arrayOther = level.getOther();
        
        for(int i = 0; i<level.getOtherSize(); i++)
        {
            getContentPane().add(arrayOther.get(i));
        }
        
        System.out.println("Tamaño de otros: "+level.getOtherSize());
        
        updateOther();
    }
    
    public void loadPlayer(Level level)
    {
        player = level.getPlayer();
        updatePlayer();
    }
    
    public void loadLevelName(Level level)
    {
        this.levelName = level.getLevelName();
    }
    
    public void update()
    {
        updateElements();
        
        decideMovements();
    }
    
    public void updateElements()
    {
        repaint();
        
        player.update();
        
        for(int i = 0; i < platform.length; i++)
        {
            platform[i].update();
        }
        
        moveEnemiesAI();
        
        updatePlatforms();
        
        playerCollDetect();
        
        updateBullets();
        
        updateEnemies();
        
        updateOther();
        
        setEnemyCollisions();
        
        moveEnemiesOnY();
        
        player.setMovingDown();
        
        detectBulletEnemyHit();
        
        detectEnemyPlayerHit();
        
        updateHealthLabel();
        
        runAIOps();
        
        updateLevelMethods();
        
        removeEnemies();
        
        checkPlayerHealth();
        
        repaint();
    }
    
    public void decideMovements()
    {
        if(player.isMovingLeft() && player.getX() > 50)
        {
            movePlayerOnX();
        }
        if(player.isMovingLeft() && player.getX() <= 50)
        {
            moveWorldOnX();
        }
        if(player.isMovingRight() && player.getX2() < 600)
        {            
            movePlayerOnX();
        }
        if(player.isMovingRight() && player.getX2() >= 600)
        {  
            moveWorldOnX();
        }
        if(player.isMovingUp() && player.getY() > 12)
        {
            movePlayerOnY();
        }
        if(player.isMovingUp() && player.getY() <= 12)
        {
            prepareJumpWorld();
            if(player.getRestingLim() != 0)
            {
                jumpWorld();
            }
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
    
    public void prepareJumpWorld()
    {
        for(int i = 0; i < platform.length; i++)
        {
            platform[i].prepareJump(getRestingLim());
        }
        for(int i = 0; i < arrayBullets.size(); i++)
        {
            arrayBullets.get(i).prepareJump(getRestingLim());
        }
        for(int i = 0; i < arrayEnemies.size(); i++)
        {
            arrayEnemies.get(i).prepareJumpStatic(getRestingLim());
        }
        for(int i = 0;i<arrayOther.size();i++)
        {
            arrayOther.get(i).prepareJump(getRestingLim());
            System.out.println("Brinco preparado para otro: "+arrayOther.get(i).getName());
        }
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
    
    public void updatePlayer()
    {
        getContentPane().add(player);
        player.setBounds(0,0, player.getW(), player.getH());
    }
    
    public void updateEnemies()
    {
        for(int i = 0; i<arrayEnemies.size(); i++)
        {
            arrayEnemies.get(i).update();
            arrayEnemies.get(i).setBounds(0,0, arrayEnemies.get(i).getW(), arrayEnemies.get(i).getH());
            enemiesX[i] = arrayEnemies.get(i).getX();
            enemiesY[i] = arrayEnemies.get(i).getY();
            enemiesX2[i] = arrayEnemies.get(i).getX2();
            enemiesY2[i] = arrayEnemies.get(i).getY2();
        }  
    }
    
    public void updateOther()
    {
        for(int i = 0; i<arrayOther.size(); i++)
        {
            arrayOther.get(i).update();
            arrayOther.get(i).setBounds(0,0, arrayOther.get(i).getW(), arrayOther.get(i).getH());
        }  
    }
    
    public void playerCollDetect()
    {
        PlatformCollision plCollDetect = new PlatformCollision();
        
        plCollDetect.setPlatform(platform);
        plCollDetect.setSprite(player);
        plCollDetect.setPlatformVariables(platformsX, platformsY, platformsX2, platformsY2);
        
        if(plCollDetect.collisionBot())
        {
            player.setCollisionBot(true);
        }
        else
        {
            player.setCollisionBot(false);
        }
        
        if(plCollDetect.collisionTop())
        {
            player.setCollisionTop(true);
        }
        else
        {
            player.setCollisionTop(false);
        }
        
        if(plCollDetect.collisionLeft())
        {
            player.setCollisionLeft(true);
        }
        else
        {
            player.setCollisionLeft(false);
        }
        
        if(plCollDetect.collisionRight())
        {
            player.setCollisionRight(true);
        }
        else
        {
            player.setCollisionRight(false);
        }
        
        for(int i = 0; i < platform.length; i++)
        {
            platform[i].setCollisionBot(plCollDetect.collisionBot());
            platform[i].setCollisionTop(plCollDetect.collisionTop());
            platform[i].setCollisionRight(plCollDetect.collisionRight());
            platform[i].setCollisionLeft(plCollDetect.collisionLeft());        
        }
    }
    
    public Bullet bulletCollDetect(Bullet bullet)
    {
        PlatformCollision bulCollDetect = new PlatformCollision();
        
        bulCollDetect.setPlatform(platform);
        bulCollDetect.setSprite(bullet);
        bulCollDetect.setPlatformVariables(platformsX, platformsY, platformsX2, platformsY2);
        
        bullet.setCollisionRight(bulCollDetect.collisionRight());
        bullet.setCollisionLeft(bulCollDetect.collisionLeft());
        
        if(bullet.isCollisionRight() || bullet.isCollisionLeft())
        {
            bulletExploding = true;
            bullet.setExploding(true);
        }
        
        for(int i = 0; i < platform.length; i++)
        {
            platform[i].setCollisionRight(bulCollDetect.collisionRight());
            platform[i].setCollisionLeft(bulCollDetect.collisionLeft());        
        }
        
        return bullet;
    }
    
    public Enemy enemyCollDetect(Enemy enemy)
    {
        PlatformCollision enCollDetect = new PlatformCollision();
        
        enCollDetect.setPlatform(platform);
        enCollDetect.setSprite(enemy);
        enCollDetect.setPlatformVariables(platformsX, platformsY, platformsX2, platformsY2);
        
        enemy.setCollisionBot(enCollDetect.collisionBot());
        enemy.setCollisionTop(enCollDetect.collisionTop());
        enemy.setCollisionRight(enCollDetect.collisionRight());
        enemy.setCollisionLeft(enCollDetect.collisionLeft());
        
        return enemy;
    }
    
    public void detectBulletEnemyHit()
    {
        HitDetection bullEnemHit = new HitDetection();
        
        for(int i = 0; i<arrayBullets.size();i++)
        {
            for(int j = 0; j<arrayEnemies.size();j++)
            {
                bullEnemHit.setSprites(arrayBullets.get(i), arrayEnemies.get(j));
                if(bullEnemHit.detectCollision())
                {
                    bulletExploding = true;
                    arrayBullets.get(i).setExploding(true);
                    goodbyeBullet(i);
                    arrayEnemies.get(j).lowerHealth(12);
                    showEnemyHit(j);
                    i=arrayBullets.size();
                    j=arrayEnemies.size();
                }
            }
        }
    }
    
    public void detectEnemyPlayerHit()
    {
        HitDetection enemyPlayerHit = new HitDetection();
        
        for(int i = 0; i<arrayEnemies.size();i++)
        {
            enemyPlayerHit.setSprites(player, arrayEnemies.get(i));
            if(enemyPlayerHit.detectCollision())
            {
                System.out.println("Player Hit?: "+playerHit);
                if(!playerHit)
                {
                    System.out.println("JUGADOR GOLPEADO POR ENEMIGO");
                    player.lowerHealth(arrayEnemies.get(i).getDamage());
                    arrayEnemies.get(i).lowerHealth(3);
                    System.out.println("Salud del enemigo: "+arrayEnemies.get(i).getHealth());
                    System.out.println("Player Hit?: "+playerHit);
                    System.out.println("Salud del jugador: "+player.getHealth());
                    playerHit = true;
                    System.out.println("Player Hit?: "+playerHit);
                }
            }
            else
            {
                if(playerHit)
                {
                    playerHit = false;
                    System.out.println("Player Hit?: "+playerHit);
                }
            }
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
    
    public void moveEnemiesOnY()
    {
        for(int i = 0; i < arrayEnemies.size(); i++)
        {
            arrayEnemies.get(i).setMovingDown();
            if(arrayEnemies.get(i).isMovingDown())
            {
                arrayEnemies.get(i).fall();
            }
        }
    }
    
    public void setEnemyCollisions()
    {        
        for(int i = 0; i < arrayEnemies.size(); i++)
        {
            arrayEnemies.set(i, enemyCollDetect(arrayEnemies.get(i)));
        }
    }
    
    public void jumpWorld()
    {       
        for(int i = 0; i < platform.length; i++)
        {
            platform[i].jump(player.isBrinco(), player.isMovingUp());
        }
        
        for(int i = 0; i < arrayBullets.size(); i++)
        {
            arrayBullets.get(i).jump(player.isBrinco(), player.isMovingUp());
        }
        
        for(int i = 0; i < arrayEnemies.size(); i++)
        {
            arrayEnemies.get(i).jumpStatic(player.isBrinco(), player.isMovingUp());
        }
        
        for(int i = 0; i<arrayOther.size(); i++)
        {
            arrayOther.get(i).jump(player.isBrinco(), player.isMovingUp());
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
        
        for(int i = 0; i < arrayBullets.size(); i++)
        {
            arrayBullets.get(i).fall(player.isBrinco(), player.isMovingDown());
        }
        
        for(int i = 0; i < arrayEnemies.size(); i++)
        {
            arrayEnemies.get(i).fallStatic(player.isBrinco(), player.isMovingDown());
        }
        
        for(int i = 0; i<arrayOther.size(); i++)
        {
            arrayOther.get(i).fall(player.isBrinco(), player.isMovingDown());
        }
    }
    
    public void moveWorldOnX()
    {
        for(int i = 0; i < platform.length; i++)
        {
            platform[i].moveOnX();
        }
        
        for(int i = 0; i<arrayBullets.size(); i++)
        {
            arrayBullets.get(i).moveOnX();
        }
        
        for(int i = 0; i<arrayEnemies.size(); i++)
        {
            arrayEnemies.get(i).moveOnXStaticEnemy();
            //arrayEnemies.get(i).moveOnYStaticEnemy();
            arrayEnemies.get(i).fixEnemyPosition();
        }
        
        for(int i = 0; i<arrayOther.size(); i++)
        {
            arrayOther.get(i).moveOnX();
        }
        
        if(player.isCollisionRight()|| player.isCollisionLeft())
        {
            player.moveOnXStatic();
        }
    }
    
    public void goodbyeBullet(int i)
    {
        try
        {
            explodeBullet(i);
            sleep(20);
            removeBullet(i);
        }
        catch(Exception e)
        {
            System.out.println("Error al eliminar bala: "+e);
            e.printStackTrace();
        }
    }
    
    public int getRestingLim()
    {
        return player.getRestingLim();
    }
    
    public void updateBullets()
    {
        for(int i=0;i<arrayBullets.size();i++)
        {
            arrayBullets.get(i).update();
            arrayBullets.get(i).move();
            arrayBullets.set(i, bulletCollDetect(arrayBullets.get(i)));
            if(arrayBullets.get(i).getX() < -1000 || arrayBullets.get(i).getX() > 1000)
            {
                bulletExploding = true;
                goodbyeBullet(i);
            }
            else
            {
                if(arrayBullets.get(i).getColl())
                {
                    bulletExploding = true;
                    goodbyeBullet(i);
                }
            }
        }
    }
    
    public void explodeBullet(int i)
    {
        arrayBullets.get(i).stop();
        arrayBullets.get(i).showExplosion();
    }
    
    public void removeBullet(int i)
    {
        arrayBullets.get(i).setExploding(false);
        bulletExploding = false;
        arrayBullets.get(i).setVisible(false);
        arrayBullets.remove(i);
    }
    
    public void showEnemyHit(int i)
    {
        try
        {
            arrayEnemies.get(i).showHitDrawing();
            sleep(20);
            arrayEnemies.get(i).showDefaultDrawing();
        }
        catch(Exception e)
        {
            System.out.println("Error al mostrar el dibujo del enemigo: "+e);
            e.printStackTrace();
        }
    }
    
    public void removeEnemies()
    {
        for(int i = 0; i<arrayEnemies.size();i++)
        {
            if(arrayEnemies.get(i).getHealth() < 1)
            {
                try{
                    arrayEnemies.get(i).setVisible(false);
                    sleep(3);
                    arrayEnemies.remove(i);
                }
                catch(Exception e)
                {
                    System.out.println("Error al remover enemigo! "+e);
                    e.printStackTrace();
                }
            }
        }
    }
    
    public boolean getBulletExploding()
    {
        return bulletExploding;
    }
    
    public void getBullets(Bullet bullet)
    {
        getContentPane().add(bullet);
        getContentPane().setComponentZOrder(bullet, 0);
        arrayBullets.add(bullet);
    }
    
    public void runAIOps()
    {
        for(int i = 0;i<arrayEnemies.size();i++)
        {
            //System.out.println("Realizando operaciones de inteligencia! enemigo: "+i);
            arrayEnemies.get(i).aiOps();
        }
    }
    
    public void moveEnemiesAI()
    {
        for(int i=0; i<arrayEnemies.size();i++)
        {
            arrayEnemies.get(i).moveOnX();
            arrayEnemies.get(i).moveOnY();
        }
    }
    
    public void checkPlayerHealth()
    {
        try
        {
            if(player.getHealth() < 1)
            {
                sleep(500);
                repaint();
                showOverScreen();
            }
        }
        catch(Exception e)
        {
            System.out.println("Error perdiendo: "+e);
            e.printStackTrace();
        }
    }
    
    public void raisePlayerHealth(int raise)
    {
        int currentHealth = player.getHealth();
        int newHealth = currentHealth + raise;
        if(newHealth > 144)
        {
           player.setHealth(144);
        }
        else
        {
            player.raiseHealth(raise);
        }
    }
    
    public void removeOther(int index)
    {
        arrayOther.get(index).setVisible(false);
        arrayOther.remove(index);
        repaint();
    }
    
    public void resetTime()
    {
        startTime = 0;
        endTime = 0;
        totalTime = 0;
    }
    
    public void showOverScreen()
    {
        Time time;
        calculateTime();
        System.out.println("Mostrando pantalla final");
        System.out.println("Tiempo total: "+totalTime);
        long showableTime = totalTime/1000;
        try
        {
            repaint();
            clearLevel();
            getContentPane().removeAll();
            getContentPane().setBackground(Color.black);
            repaint();
            
            JLabel gameOver = new JLabel("Game Over");
            gameOver.setFont(new java.awt.Font("Arial Black", 1, 48)); // NOI18N
            gameOver.setForeground(new java.awt.Color(255, 255, 255));
            gameOver.setText("Game Over");
            getContentPane().add(gameOver);
            gameOver.setBounds(240, 125, 340, 50);
            
            JLabel timeTaken = new JLabel();
            timeTaken.setFont(new java.awt.Font("Arial Black", 1, 48)); // NOI18N
            timeTaken.setForeground(new java.awt.Color(255, 255, 255));
            timeTaken.setText("Total Time: "+showableTime+" seconds");
            getContentPane().add(timeTaken);
            timeTaken.setBounds(75, 200, 800, 50);
            
            Icon brknChrk = new javax.swing.ImageIcon(getClass().getResource("/IMG/Others/BrokenChark.png"));
            JLabel brokenChark = new JLabel();
            brokenChark.setIcon(brknChrk);
            getContentPane().add(brokenChark);
            brokenChark.setBounds(350,290,brknChrk.getIconHeight()+50,brknChrk.getIconWidth()+50);
            
            repaint();
            sleep(3000);
            getContentPane().removeAll();
            clearLevel();
            loadLevel(getIntroLevel());
        }
        catch(Exception e)
        {
            System.out.println("Error al mostrar Game Over: "+e);
            e.printStackTrace();
        }
    }
    
    public void showVictoryScreen()
    {
        calculateTime();
        System.out.println("Mostrando pantalla final");
        System.out.println("Tiempo total: "+totalTime);
        long showableTime = totalTime/1000;
        try
        {
            repaint();
            clearLevel();
            getContentPane().removeAll();
            getContentPane().setBackground(Color.black);
            repaint();
            
            JLabel gameOver = new JLabel();
            gameOver.setFont(new java.awt.Font("Arial Black", 1, 48)); // NOI18N
            gameOver.setForeground(new java.awt.Color(255, 255, 255));
            gameOver.setText("Amazing!");
            getContentPane().add(gameOver);
            gameOver.setBounds(240, 125, 340, 50);
            
            JLabel timeTaken = new JLabel();
            timeTaken.setFont(new java.awt.Font("Arial Black", 1, 48)); // NOI18N
            timeTaken.setForeground(new java.awt.Color(255, 255, 255));
            timeTaken.setText("Total Time: "+showableTime+" seconds");
            getContentPane().add(timeTaken);
            timeTaken.setBounds(75, 200, 800, 50);
            
            Icon amazin = new javax.swing.ImageIcon(getClass().getResource("/IMG/Others/Amazing.png"));
            JLabel brokenChark = new JLabel();
            brokenChark.setIcon(amazin);
            getContentPane().add(brokenChark);
            brokenChark.setBounds(25,25,amazin.getIconHeight()+50,amazin.getIconWidth()+50);
            repaint();
            
            Time newTime = new Time((int) showableTime);
            file.writeTime(newTime);
            
            sleep(3000);
            getContentPane().removeAll();
            clearLevel();
            loadLevel(getIntroLevel());
        }
        catch(Exception e)
        {
            System.out.println("Error al mostrar Game Over: "+e);
            e.printStackTrace();
        }
    }
    
    public void setRestingLim(int restingLim)
    {
        for(int i = 0; i < platform.length; i++)
        {
            platform[i].prepareJump(restingLim);
        }
        for(int i = 0; i < arrayBullets.size(); i++)
        {
            arrayBullets.get(i).prepareJump(restingLim);
        }
        for(int i = 0; i < arrayEnemies.size(); i++)
        {
            arrayEnemies.get(i).prepareJumpStatic(restingLim);
        }
        for(int i = 0;i<arrayOther.size();i++)
        {
            arrayOther.get(i).prepareJump(restingLim);
            System.out.println("Brinco preparado para otro: "+arrayOther.get(i).getName());
        }
    }
    
    public void showScores()
    {
        revalidate();
        repaint();
        
        Icon scoreBoard = new javax.swing.ImageIcon(getClass().getResource("/IMG/Others/board.png"));
        board = new JLabel();
        board.setIcon(scoreBoard);
        board.setBounds(250,55,scoreBoard.getIconHeight()+50,scoreBoard.getIconWidth()+50);
        
        timesTitle = new JLabel();
        timesTitle.setFont(new java.awt.Font("Arial Black", 1, 32)); // NOI18N
        timesTitle.setForeground(new java.awt.Color(255, 255, 255));
        timesTitle.setText("Best Times");
        timesTitle.setBounds(300, 120, 800, 60);
        
        times1 = new JLabel();
        times1.setFont(new java.awt.Font("Arial Black", 1, 28)); // NOI18N
        times1.setForeground(new java.awt.Color(255, 255, 255));
        times1.setText(printTimes()[0]+" seconds");
        times1.setBounds(300, 175, 800, 50);
        
        times2 = new JLabel();
        times2.setFont(new java.awt.Font("Arial Black", 1, 20)); // NOI18N
        times2.setForeground(new java.awt.Color(255, 255, 255));
        times2.setText(printTimes()[1]+" seconds");
        times2.setBounds(330, 225, 800, 50);
        
        times3 = new JLabel();
        times3.setFont(new java.awt.Font("Arial Black", 1, 20)); // NOI18N
        times3.setForeground(new java.awt.Color(255, 255, 255));
        times3.setText(printTimes()[2]+" seconds");
        times3.setBounds(330, 275, 800, 50);
        
        getContentPane().add(board);
        getContentPane().setComponentZOrder(board, 0);
        
        getContentPane().add(timesTitle);
        getContentPane().setComponentZOrder(timesTitle, 0);
        
        getContentPane().add(times1);
        getContentPane().setComponentZOrder(times1, 0);
        
        getContentPane().add(times2);
        getContentPane().setComponentZOrder(times2, 0);
        
        getContentPane().add(times3);
        getContentPane().setComponentZOrder(times3, 0);
        
        revalidate();
        repaint();
    }
    
    public void removeScores()
    {
        if(board != null && timesTitle != null && times1 != null & times2 != null && times3 != null)
        {
            System.out.println("escondiendo puntuaciones");
            board.setVisible(false);
            getContentPane().remove(board);
            times1.setVisible(true);
            getContentPane().remove(times1);
            timesTitle.setVisible(true);
            getContentPane().remove(timesTitle);
            times2.setVisible(true);
            getContentPane().remove(times2);
            times3.setVisible(true);
            getContentPane().remove(times3);
            board = null;
            timesTitle = null;
            times1 = null;
            times2 = null;
            times3 = null;
            revalidate();
            repaint();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
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

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Game Over");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 100, 340, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        player.keyPressed(evt);
        for(int i = 0; i < platform.length; i++)
        {
            platform[i].keyPressed(evt);
        }
        for(int i = 0; i<arrayBullets.size(); i++)
        {
            arrayBullets.get(i).keyPressed(evt);
        }
        for(int i = 0; i<arrayEnemies.size(); i++)
        {
            arrayEnemies.get(i).keyPressed(evt);
        }
        for(int i = 0; i<arrayOther.size(); i++)
        {
            arrayOther.get(i).keyPressed(evt);
        }
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        player.keyReleased(evt);
        for(int i = 0; i < platform.length; i++)
        {
            platform[i].keyReleased(evt);
        }
        for(int i = 0; i<arrayBullets.size(); i++)
        {
            arrayBullets.get(i).keyReleased(evt);
        }
        for(int i = 0; i<arrayEnemies.size(); i++)
        {
            arrayEnemies.get(i).keyReleased(evt);
        }
        for(int i = 0; i<arrayOther.size(); i++)
        {
            arrayOther.get(i).keyReleased(evt);
        }
    }//GEN-LAST:event_formKeyReleased
   
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
