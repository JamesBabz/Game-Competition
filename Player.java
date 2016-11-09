import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{

    String moveUp = "w";
    String moveLeft = "a";
    String moveRight = "d";
    int maxJumpHeight = 50;
    int jumpHeight = 0;
    int speed = 1;
    List objects;
   
    private int MushroomsTaken = 0;
    private int CoinsTaken = 0;
    
    public static boolean isAlive = true; 
   
    public void act()
    {
        objects = getWorld().getObjects(Movers.class);
        movement();
        takeMushrooms();
        takeCoins();
    }
    
    public void movement()
    {
        if(Greenfoot.isKeyDown(moveRight))
        {   
            moveToTheRight();
        }
        else if(Greenfoot.isKeyDown(moveLeft))
        {
            moveToTheLeft();
        }

        if(Greenfoot.isKeyDown(moveUp) && jumpHeight < maxJumpHeight)
        {
            moveUpwards();
        }
        else if(jumpHeight > 0)
        {
            moveDownwards();
        }

        if(Greenfoot.isKeyDown("s")) // Testing
        {
            // jumpHeight = 0;
        }

    }
    
     public void moveToTheRight()
    {
        for(int i = 0; i < objects.size(); i++)
        {
            getWorld().getObjects(Movers.class).get(i).moveLeft(speed);
        }
    }

    public void moveToTheLeft()
    {

        for(int i = 0; i < objects.size(); i++)
        {
            getWorld().getObjects(Movers.class).get(i).moveRight(speed);
        }
    }

    public void moveUpwards()
    {
        jumpHeight++;
        for(int i = 0; i < objects.size(); i++)
        {
            getWorld().getObjects(Movers.class).get(i).moveDown(speed);
        }
    }

    public void moveDownwards()
    {
        jumpHeight--;
        for(int i = 0; i < objects.size(); i++)
        {
            getWorld().getObjects(Movers.class).get(i).moveUp(speed);
        }
    }
    
     public void takeMushrooms()
    {
        Actor Mushrooms = getOneObjectAtOffset(0, 0, Mushrooms.class);
        if (Mushrooms != null) 
       {
            getWorld().removeObject(Mushrooms);
            setImage("Mariobigpt1.png");
            Greenfoot.playSound("growing.wav");
        
       }  
    }
    
      public void takeCoins()
   {
       Actor Coins = getOneObjectAtOffset(0,0, Coins.class);
      if (Coins != null)
      {
        getWorld().removeObject(Coins);
        Greenfoot.playSound("coin.wav");
        
      }
   }
    
    public void die()
   {
        isAlive = false; 
        getWorld().removeObject(this);
        Greenfoot.playSound("mariodies.wav");
   }
    
    
}
