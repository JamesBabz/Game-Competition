import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mushrooms here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mushrooms extends Consumables 
{
    /**
     * Act - do whatever the Mushrooms wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    public void take()
    {
        setImage("Mariobigpt1.png"); 
        getWorld().removeObject(this);
        Greenfoot.playSound("growing.wav");
    }
}
