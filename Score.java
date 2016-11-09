import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor
{
    public static long scoreLong = 0;
    /**
     * Act - do whatever the score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(new GreenfootImage("Score: "+String.valueOf(scoreLong), 40, Color.BLACK, new Color(0, 0, 0, 0)));
        
    }    
    
    Score()
    {
        GreenfootImage scoreImage = new GreenfootImage("Score: "+String.valueOf(0), 40, Color.BLACK, new Color(0, 0, 0, 0));
        setImage(scoreImage);
        scoreLong = 0;
    }
}
