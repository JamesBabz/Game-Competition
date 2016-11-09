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
    String lastMove="";

    private int MushroomsTaken = 0;
    private int CoinsTaken = 0;

    public static boolean isAlive = true; 

    public void act()
    {
        objects = getWorld().getObjects(Movers.class);
        movement();
        checkCollision();
        takeConsumable();
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
            lastMove="right";
        }
    }

    public void moveToTheLeft()
    {

        for(int i = 0; i < objects.size(); i++)
        {
            getWorld().getObjects(Movers.class).get(i).moveRight(speed);
            lastMove="left";
        }
    }

    public void moveUpwards()
    {
        
            jumpHeight++;
            for(int i = 0; i < objects.size(); i++)
            {
                getWorld().getObjects(Movers.class).get(i).moveDown(speed);
                lastMove="up";
            }
    }

    public void moveDownwards()
    {
        jumpHeight--;
        for(int i = 0; i < objects.size(); i++)
        {
            getWorld().getObjects(Movers.class).get(i).moveUp(speed);
            lastMove="down";
        }
    }

    public void takeConsumable()
    {
        Consumable consumable = (Consumable) getOneObjectAtOffset(0,0, Consumable.class);
        if (consumable != null)
        {
            consumable.take();
        }
    }

    public void checkCollision()
    {
        if(getOneIntersectingObject(SolidBlock.class)!=null)
        {
            checkWall();
        }
        if(! isTouchingGround() && ! Greenfoot.isKeyDown(moveUp))
        {
            moveDownwards();
        }

        /*
        checkRightWall();
        checkLeftWall();*/
    }

    public void checkWall()
    {
        int spriteWidth = getImage().getWidth();
        int xDistance = (int)((spriteWidth/2))/16;

        Actor wall = getOneObjectAtOffset(xDistance, 0, SolidBlock.class);

        if(wall != null)
        {
            if(lastMove.equals("right"))
                moveToTheLeft();
            else if(lastMove.equals("left"))
                moveToTheRight();
            else if(lastMove.equals("up"))
                moveDownwards();
            else if(lastMove.equals("down"))
                moveUpwards();
        }
    }

    public void stopByRightWall ()
    {

        //int wallWidth = (rightWall.getImage().getWidth())/16;
        //int newX = rightWall.getX() - ((wallWidth + getImage().getWidth())/2)/16;
        //setLocation(newX -1, getY());
    }

    public void checkLeftWall()
    {
        int spriteWidth = getImage().getWidth();
        int xDistance = (int)((spriteWidth/2))/16;

        Actor leftWall = getOneObjectAtOffset(xDistance, 0, SolidBlock.class);

        if(leftWall != null)
        {
            stopByLeftWall();
        }
    }

    public void stopByLeftWall ()
    {
        moveToTheRight();
        //int wallWidth = (rightWall.getImage().getWidth())/16;
        //int newX = rightWall.getX() - ((wallWidth + getImage().getWidth())/2)/16;
        //setLocation(newX -1, getY());
    }

    private boolean isTouchingGround()
    {
        Actor groundBlock = getOneObjectAtOffset(0, 1, SolidBlock.class);
        if(groundBlock != null)
        {
            return true;
        }
        else{
            return false;
        }
    }

    public void die()
    {
        isAlive = false; 
        getWorld().removeObject(this);
        Greenfoot.playSound("mariodies.wav");
    }

}
