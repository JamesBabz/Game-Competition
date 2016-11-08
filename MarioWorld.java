import greenfoot.*;
import java.util.Arrays;

public class MarioWorld extends World
{

    //The keys to use to control
    String moveUp = "w";
    String moveLeft = "a";
    String moveRight = "d";

    int level = 1;
    int levelLength = 0;
    int groundHoles[];

    int groundHeight = 2;
    
    GreenfootImage bgi = new GreenfootImage("images/blueBG.jpg"); 
    
    Player player = new Player();

    public MarioWorld()
    {    
        super(24, 15, 16, false);
        getBackground().drawImage(bgi, 0, 0);
        addObject(player, getWidth()/2, 10);
        Greenfoot.setSpeed(45);
        createGround();
    }

    public void createGround()
    {
        if(level == 1)
        {
            levelLength = 211;
            int groundHoles[] = {69, 70, 86, 87, 88, 153, 154};
        }
        for(int h = 1; h < groundHeight+1; h++)
        {
            for(int l = 0; l < levelLength; l++)
            {
                if(Arrays.asList(groundHoles).contains(l))
                {
                    continue;
                }
                addObject(new GroundBlock(), l, getHeight()-h);
            }
        }
    }

}