import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class coins here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coins extends Consumables
{
    /**
     * Act - do whatever the coins wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
            if (getOneIntersectingObject(Player.class) != null)
        {
            getWorld().removeObject(this);
            Score.scoreLong += 10;
            return;
        }
    }    
    public void take()
    {
        getWorld().removeObject(this);
        Greenfoot.playSound("coin.wav");
    }
}
