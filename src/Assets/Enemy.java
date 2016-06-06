/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assets;

/**
 *
 * @author DanielSQ
 */
public class Enemy extends Sprite{
    public Enemy(int x, int y)
    {        
        this.x = x;
        this.y = y;
        super.setLocation(x, y);
    }
}
