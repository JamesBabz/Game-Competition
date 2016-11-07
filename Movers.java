import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Movers here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Movers extends Actor
{
    public void moveLeft(int speed)
    {
        setLocation(getX()-speed, getY());
    }
    
    public void moveRight(int speed)
    {
        setLocation(getX()+speed, getY());
    }
    
    public void moveDown(int speed)
    {
        setLocation(getX(), getY()+speed);
    }
    
    public void moveUp(int speed)
    {
        setLocation(getX(), getY()-speed);
    }
}
