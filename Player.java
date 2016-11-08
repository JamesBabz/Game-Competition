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
   
    public void act()
    {
        objects = getWorld().getObjects(Movers.class);
        movement();
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
        // baseX = (baseX + bgiWidth - 1) % bgiWidth;
        // getBackground().drawImage(bgi, baseX - bgiWidth, baseY);
        // leftEdge++;
        for(int i = 0; i < objects.size(); i++)
        {
            getWorld().getObjects(Movers.class).get(i).moveLeft(speed);
        }
    }

    public void moveToTheLeft()
    {
        // baseX = (baseX + bgiWidth + 1) % bgiWidth;
        // getBackground().drawImage(bgi, baseX - bgiWidth, baseY);
        // leftEdge--;
        for(int i = 0; i < objects.size(); i++)
        {
            getWorld().getObjects(Movers.class).get(i).moveRight(speed);
        }
    }

    public void moveUpwards()
    {

        jumpHeight++;
        // baseY = (baseY + bgiHeight + 1) % bgiHeight;
        // getBackground().drawImage(bgi, baseX - bgiWidth, baseY);
        for(int i = 0; i < objects.size(); i++)
        {
            getWorld().getObjects(Movers.class).get(i).moveDown(speed);
        }
    }

    public void moveDownwards()
    {
        jumpHeight--;
        // baseY = (baseY + bgiHeight - 1) % bgiHeight;
        // getBackground().drawImage(bgi, baseX - bgiWidth, baseY);
        for(int i = 0; i < objects.size(); i++)
        {
            getWorld().getObjects(Movers.class).get(i).moveUp(speed);
        }
    }

}
