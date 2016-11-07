import greenfoot.*;
import java.util.List;

public class ScrollWorld extends World
{
    //The keys to use to control
    String moveUp = "w";
    String moveLeft = "a";
    String moveRight = "d";
    
    int antX = 0;
    int maxJumpHeight = 50;
    int jumpHeight = 0;
    int speed = 1;
    // 'bgi' stands for BackGroundImage
    GreenfootImage bgi = new GreenfootImage("images/lvl1BG.png"); 
    int bgiWidth = bgi.getWidth();
    int bgiHeight = bgi.getHeight();
    Player player = new Player();
    Brick brick = new Brick();
    List objects;
    int baseX = 0;
    int baseY = 0;
    int leftEdge = 0;
    boolean jumpKeyDown = false;
    boolean isJumping = false;

    public ScrollWorld()
    {    
        super(400, 272, 1, false);
        getBackground().drawImage(bgi, baseX, baseY);
        addObject(player, getWidth()/2, 230);
        // addObject(brick, 300, 150);
        update();
    }

    public void act()
    {
        showText(bgiWidth+"||"+bgiHeight, 50, 150);
        update();
    }

    private void update()
    {
        objects = getObjects(Movers.class);
        if(Greenfoot.isKeyDown(moveRight))
        {   
            moveToTheRight();
        }
        else if(Greenfoot.isKeyDown(moveLeft) && leftEdge > 0)
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

        if(Greenfoot.isKeyDown("s"))
        {
            jumpHeight = 0;
        }

    }

    public void moveToTheRight()
    {
        baseX = (baseX + bgiWidth - 1) % bgiWidth;
        getBackground().drawImage(bgi, baseX - bgiWidth, baseY);
        leftEdge++;
        for(int i = 0; i < objects.size(); i++)
        {
            getObjects(Movers.class).get(i).moveLeft(speed);
        }
    }

    public void moveToTheLeft()
    {
        baseX = (baseX + bgiWidth + 1) % bgiWidth;
        getBackground().drawImage(bgi, baseX - bgiWidth, baseY);
        leftEdge--;
        for(int i = 0; i < objects.size(); i++)
        {
            getObjects(Movers.class).get(i).moveRight(speed);
        }
    }

    public void moveUpwards()
    {

        jumpHeight++;
        baseY = (baseY + bgiHeight + 1) % bgiHeight;
        getBackground().drawImage(bgi, baseX - bgiWidth, baseY);
        for(int i = 0; i < objects.size(); i++)
        {
            getObjects(Movers.class).get(i).moveDown(speed);
        }
    }

    public void moveDownwards()
    {
        jumpHeight--;
        baseY = (baseY + bgiHeight - 1) % bgiHeight;
        getBackground().drawImage(bgi, baseX - bgiWidth, baseY);
        for(int i = 0; i < objects.size(); i++)
        {
            getObjects(Movers.class).get(i).moveUp(speed);
        }
    }
}