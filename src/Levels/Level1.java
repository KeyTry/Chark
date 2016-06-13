/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Levels;

import Assets.Sprites.LiveSprites.Enemies.*;
import Assets.Sprites.StaticSprites.Other;
import Assets.Sprites.StaticSprites.Platform;
import Assets.Sprites.LiveSprites.Player;
import Assets.Sprites.StaticSprites.Hidden;
import View.Window;

/**
 *
 * @author DanielSQ
 */
public class Level1 extends Level{
    
    public Level1(Window window) {
        super(window);
        levelName = "Level1";
        player = new Player(390, 345,window,144);
        init();
    }
    
    @Override
    public void init()
    {
        setPlatforms();
        setEnemies();
        setOther();
        setHidden();
    }
    
    public void setPlatforms()
    {
        platform = new Platform[69];
        
        
        platform[0] = new Platform(0,0,"PlatWoodH");
        platform[1] = new Platform(0,240,"PlatWoodH");
        platform[2] = new Platform(0,480,"PlatWoodH");
        platform[3] = new Platform(360,480,"PlatWoodH");
        platform[4] = new Platform(360,0,"PlatDirtH");
        platform[5] = new Platform(720,0,"PlatDirtH");
        platform[6] = new Platform(720,540,"PlatWoodT");
        platform[7] = new Platform(810,600,"PlatWoodT");
        platform[8] = new Platform(900,600,"PlatDirtM");
        platform[9] = new Platform(720,0,"PlatDirtH");
        platform[10] = new Platform(1080,0,"PlatDirtH");
        platform[11] = new Platform(1440,0,"PlatDirtH");
        platform[12] = new Platform(1800,-50,"PlatDirtH");
        platform[13] = new Platform(2520,-50,"PlatDirtH");
        platform[14] = new Platform(1170,600,"PlatDirtS");
        platform[15] = new Platform(1350,540,"PlatDirtH");
        platform[16] = new Platform(1710,710,"PlatDirtH");
        platform[17] = new Platform(2070,710,"PlatDirtH");
        platform[18] = new Platform(2430,710,"PlatDirtH");
        platform[19] = new Platform(2880,-50,"PlatDirtH");
        platform[20] = new Platform(2790, 470, "PlatWoodM");
        platform[21] = new Platform(2190, 470, "PlatWoodT");
        platform[22] = new Platform(2700,520,"PlatWoodT");
        platform[23] = new Platform(2680,30,"PlatWoodH");
        platform[24] = new Platform(2160,-50,"PlatDirtH");
        platform[25] = new Platform(2790,470,"PlatDirtH");
        platform[26] = new Platform(3150,470,"PlatDirtH");
        platform[27] = new Platform(3240,-50,"PlatDirtH");
        platform[28] = new Platform(3600,-125,"PlatDirtH");
        platform[29] = new Platform(3510,710,"PlatWoodH");
        platform[30] = new Platform(3870,710,"PlatWoodH");
        platform[31] = new Platform(3040,30,"PlatWoodH");
        platform[32] = new Platform(3620,250, "PlatRockH");
        platform[33] = new Platform(3960,310,"PlatRockL");
        platform[34] = new Platform(4230,370,"PlatRockS");
        platform[35] = new Platform(4230,430,"PlatRockS");
        platform[36] = new Platform(4520,520,"PlatRockH");
        platform[37] = new Platform(4520,760,"PlatHardH");
        platform[38] = new Platform(3960,-150,"PlatDirtH");
        platform[39] = new Platform(4320,-150,"PlatHardH");
        platform[40] = new Platform(4680,-150,"PlatHardH");
        platform[41] = new Platform(4230,710,"PlatWoodH");
        platform[42] = new Platform(4680,1160,"PlatRockH");
        platform[43] = new Platform(4410,1160,"PlatHardM");
        platform[44] = new Platform(5040,-40,"PlatDirtH");
        platform[45] = new Platform(5040,200,"PlatDirtH");
        platform[46] = new Platform(5040,440,"PlatDirtH");
        platform[47] = new Platform(5040,680,"PlatRockH");
        platform[48] = new Platform(5040,920,"PlatHardH");
        platform[49] = new Platform(5040,1160,"PlatRockH");
        platform[50] = new Platform(4140,950,"PlatHardX");
        platform[51] = new Platform(4680,1400,"PlatHardM");
        platform[52] = new Platform(4320,1520,"PlatHardH");
        platform[53] = new Platform(4050,1520,"PlatHardW");
        platform[54] = new Platform(3600,1760,"PlatHardH");
        platform[55] = new Platform(3960,1760,"PlatHardH");
        platform[56] = new Platform(3330,1640,"PlatHardM");
        platform[57] = new Platform(3460,1210,"PlatHardW");
        platform[58] = new Platform(3190,1520,"PlatRockM");
        platform[59] = new Platform(3190,1340,"PlatRockX");
        platform[60] = new Platform(2920,1580,"PlatHardW");
        platform[61] = new Platform(2650,1520,"PlatHardM");
        platform[62] = new Platform(2470,1460,"PlatHardS");
        platform[63] = new Platform(2690,1270,"PlatHardW");
        platform[64] = new Platform(2140,1340,"PlatHardH");
        platform[65] = new Platform(2140,1220,"PlatHardV");
        platform[66] = new Platform(2140,950,"PlatHardY");
        platform[66] = new Platform(2140,1200,"PlatHardY");
        platform[67] = new Platform(2140,980,"PlatHardY");
        platform[68] = new Platform(2140,900,"PlatHardY");
        //platform[66] = new Platform(,,"");
        //platform[67] = new Platform(,,"");
        
        //platform[] = new Platform(,,"");

        
        for(int i = 0; i<platform.length; i++)
        {
            platform[i].update();
        }
    }
    
    public void setEnemies()
    {
        Enemy slim1 = new Slim(1720, 600, window);
        Enemy slim2 = new Slim(1940, 600, window);
        Enemy slim3 = new Slim(2230, 600, window);
        Enemy slim4 = new Slim(2470, 600, window);
        Enemy slim5 = new Slim(2650, 600, window);
        Enemy slim6 = new Slim(3700, 600, window);
        Enemy slim7 = new Slim(4000, 600, window);
        Enemy slim8 = new Slim(4300, 600, window);
        Enemy slim9 = new Slim(4300, 1410, window);
        Enemy slim10 = new Slim(3630,1650,window);
        Enemy slim11 = new Slim(2235,1236,window);
        Enemy slim12 = new Slim(2395,1235,window);
        
        Enemy reck1 = new Reck(2877, 288, window);
        Enemy reck2 = new Reck(2980, 360, window);
        Enemy reck3 = new Reck(3060, 280, window);
        Enemy reck4 = new Reck(3140, 370, window);
        Enemy reck5 = new Reck(3230, 290, window);
        Enemy reck6 = new Reck(3672, 530, window);
        Enemy reck7 = new Reck(3888, 615, window);
        Enemy reck8 = new Reck(4240, 525, window);
        Enemy reck9 = new Reck(3523,1045,window);
        Enemy reck10 = new Reck(2745,1060,window);
        Enemy reck11 = new Reck(2813,1152,window);
        Enemy reck12 = new Reck(2790,1360,window);
        
        Enemy puni1 = new Puni(4570,1060, window);
        Enemy puni2 = new Puni(4490, 1020, window);
        Enemy puni3 = new Puni(4420, 1030, window);
        Enemy puni4 = new Puni(4520,1345,window);
        Enemy puni5 = new Puni(3310,1410,window);
        Enemy puni6 = new Puni(2960,1530,window);
        Enemy puni7 = new Puni(2895,1215,window);
        Enemy puni8 = new Puni(2690,1170,window);
        Enemy puni9 = new Puni(2680,1400,window);
        
        
        
        enemy.add(slim1);
        enemy.add(slim2);
        enemy.add(slim3);
        enemy.add(slim4);
        enemy.add(slim5);
        enemy.add(slim6);
        enemy.add(slim7);
        enemy.add(slim8);
        enemy.add(slim9);
        enemy.add(slim10);
        enemy.add(slim11);
        enemy.add(slim12);
        
        enemy.add(reck1);
        enemy.add(reck2);
        enemy.add(reck3);
        enemy.add(reck4);
        enemy.add(reck5);
        enemy.add(reck6);
        enemy.add(reck7);
        enemy.add(reck8);
        enemy.add(reck9);
        enemy.add(reck10);
        enemy.add(reck11);
        enemy.add(reck12);
        
        enemy.add(puni1);
        enemy.add(puni2);
        enemy.add(puni3);
        enemy.add(puni4);
        enemy.add(puni5);
        enemy.add(puni6);
        enemy.add(puni7);
        enemy.add(puni8);
        enemy.add(puni9);
    }
    
    public void setOther()
    {
        Other enterDoor = new Other(350,330,"door1.png","enterDoor");
        Other pydsign = new Other(590,360,"PYDSign.png","PYD");
        Other life1 = new Other(2790,430,"Life.png","Life");
        Other life2 = new Other(3630,210,"LifeBig.png","LifeBig");
        Other life3 = new Other(4650,1490,"Life.png","Life");
        Other life4 = new Other(3654,1162,"LifeBig.png","LifeBig");
        Other chest = new Other(2250,1300,"Chest.gif","Chest");
        
        other.add(enterDoor);
        other.add(pydsign);
        other.add(life1);
        other.add(life2);
        other.add(life3);
        other.add(life4);
        other.add(chest);
    }
    
    public void setHidden()
    {
        Hidden pyd = new Hidden(700,50,"Sign.png","PYDSign");
        
        hidden.add(pyd);
    }
    
}
