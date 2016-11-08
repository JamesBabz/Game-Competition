import greenfoot.*;
import java.util.ArrayList;
import java.util.List;

public class MarioWorld extends World
{

    //The keys to use to control
    String moveUp = "w";
    String moveLeft = "a";
    String moveRight = "d";

    int level = 1;
    int levelLength = 0;

    GreenfootImage bgi = new GreenfootImage("images/blueBG.jpg"); 

    Player player = new Player();

    final int groundHeight = 2;
    final int levelHeight = 14;
    List<Integer> groundHoles = new ArrayList<Integer>();
    // List<Integer> brickX = new ArrayList<Integer>();
    // List<Integer> brickY = new ArrayList<Integer>();
    int[] blocksX;
    int[] blocksY;

    public MarioWorld()
    {    
        super(24, 14, 16, false);
        if(level == 1)
        {
            levelLength = 211;
            setHoles(69, 70, 86, 87, 88, 153, 154);
            blocksX = new int []{ // Every line is for a new set of staris
                137, 137, 136, 137, 136, 135, 137, 136, 135, 134, 
                140, 140, 141, 140, 141, 142, 140, 141, 142, 143,
                151, 152, 150, 151, 152, 149, 150, 151, 152, 148, 149, 150, 151, 152,
                155, 155, 156, 155, 156, 157, 155, 156, 157, 158,
                188, 189, 187, 188, 189, 186, 187, 188, 189, 185, 186, 187, 188, 189, 184, 185, 186, 187, 188, 189, 183, 184, 185, 186, 187, 188, 189, 182, 183, 184, 185, 186, 187, 188, 189, 181, 182, 183, 184, 185, 186, 187, 188, 189,
            };
            blocksY = new int []{ // Every line is for a new set of staris
                8, 9, 9, 10, 10, 10, 11, 11, 11, 11,
                8, 9, 9, 10, 10, 10, 11, 11, 11, 11,
                8, 8, 9, 9, 9, 10, 10, 10, 10, 11, 11, 11, 11, 11,
                8, 9, 9, 10, 10, 10, 11, 11, 11, 11,
                4, 4, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 11, 11, 11, 11, 11, 11, 11, 11, 11
                
            };
        }
        groundHoles.add(69);
        getBackground().drawImage(bgi, 0, 0);
        addObject(player, getWidth()/2, 10);
        Greenfoot.setSpeed(45);
        createGround();
        createBlocks();
    }

    public void createGround()
    {

        for(int h = 1; h < groundHeight+1; h++)
        {
            for(int l = 0; l < levelLength; l++)
            {
                if(groundHoles.contains(l))
                {
                    continue;
                }
                addObject(new GroundBlock(), l, getHeight()-h);
            }
        }
    }

    public void setHoles(int... holes)
    {
        for (int hole : holes) {
            groundHoles.add(hole);
        }
    }

    public void createBlocks()
    {
        int k = 0;
        for (int i = 0; i < blocksX.length; i++) {
                addObject(new Block(), blocksX[i], blocksY[i]);
        }
    }

}