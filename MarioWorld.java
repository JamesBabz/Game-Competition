import greenfoot.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

public class MarioWorld extends World
{

    //The keys to use to control
    final String moveUp = "w";
    final String moveLeft = "a";
    final String moveRight = "d";

    int level = 1;
    int levelLength = 0;
    int mapWidth;
    int mapHeight;
    int gridSize;
    Player player = new Player();

    final int groundHeight = 2;
    final int levelHeight = getHeight();
    final int placeFromBottom = levelHeight-groundHeight;
    final int finishHeight = 11;
    List<Integer> groundHoles = new ArrayList<Integer>();
    String groundImage;
    String blockImage;
    int[] blocksX;
    int[] blocksY;

    String breakableBlocksImage;
    int[] breakableBlocksX;
    int[] breakableBlocksY;

    String QBlocksImage;
    int[] QBlocksX;
    int[] QBlocksY;

    String pipeImage;
    int[] pipeTopX;
    int[] pipeTopY;

    int finishLine;
    int castleX;

    String bgImage1; String bgImage2; String bgImage3;  
    int[] bgImage1X; int[] bgImage2X; int[] bgImage3X;
    int[] bgImage1Y; int[] bgImage2Y; int[] bgImage3Y;

    String bgImage4; String bgImage5; String bgImage6;
    int[] bgImage4X; int[] bgImage5X; int[] bgImage6X;
    int[] bgImage4Y; int[] bgImage5Y; int[] bgImage6Y;

    String bgImage7; String bgImage8; String bgImage9;
    int[] bgImage7X; int[] bgImage8X; int[] bgImage9X;
    int[] bgImage7Y; int[] bgImage8Y; int[] bgImage9Y;

    public MarioWorld()
    {    
        super(24, 14, 16, false);
        mapWidth = getWidth();
        mapHeight = getHeight();
        gridSize = getCellSize();
        if(gridSize == 0)
        {
            gridSize = 1;
        }
        Greenfoot.setSpeed(45);
        initLevelVars(level);
        createLevel();
        setPaintOrder(Player.class, SolidBlock.class);
    }

    public void initLevelVars(int level)
    {
        if(level == 1)
        {
            levelLength = 211;

            groundImage = "groundblock.png";
            setHoles(69, 70, 86, 87, 88, 153, 154);

            blockImage = "block.png";
            blocksX = new int []{ // Every line is for a new set of stairs
                137, 137, 136, 137, 136, 135, 137, 136, 135, 134, 
                140, 140, 141, 140, 141, 142, 140, 141, 142, 143,
                151, 152, 150, 151, 152, 149, 150, 151, 152, 148, 149, 150, 151, 152,
                155, 155, 156, 155, 156, 157, 155, 156, 157, 158,
                188, 189, 187, 188, 189, 186, 187, 188, 189, 185, 186, 187, 188, 189, 184, 185, 186, 187, 188, 189, 183, 184, 185, 186, 187, 188, 189, 182, 183, 184, 185, 186, 187, 188, 189, 181, 182, 183, 184, 185, 186, 187, 188, 189,
                198
            };
            blocksY = new int []{ // Every line is for a new set of stairs
                4, 3, 3, 2, 2, 2, 1, 1, 1, 1,
                4, 3, 3, 2, 2, 2, 1, 1, 1, 1,
                4, 4, 3, 3, 3, 2, 2, 2, 2, 1, 1, 1, 1, 1,
                4, 3, 3, 2, 2, 2, 1, 1, 1, 1,
                8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 5, 5, 4, 4, 4, 4, 4, 4, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1

            };

            breakableBlocksImage = "brick.png";

            breakableBlocksX = new int []{
                20, 22, 24, 77, 79, 80, 81, 82, 83, 84, 85, 86, 87, 91, 92, 93, 94, 100, 118, 121, 122, 123, 128, 129, 130, 131, 168, 169, 171
            };

            breakableBlocksY = new int []{
                4, 4, 4, 4, 4, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 4, 4, 4, 8, 8, 8, 8, 4, 4, 8, 4, 4, 4
            };

            QBlocksImage = "qblock.png";
            QBlocksX = new int []{
                16, 21, 22, 23, 78, 94, 106, 109, 109, 112, 129, 130, 170
            };

            QBlocksY = new int []{
                4, 4, 8, 4, 4, 8, 4, 8, 4, 4, 8, 8, 4
            };

            
            pipeImage = "pipe_top.png";

            pipeTopX = new int[]{
                28, 38, 46, 57, 163, 179
            };
            pipeTopY = new int[]{
                2, 3, 4, 4, 2, 2
            };

            finishLine = 198;
            castleX = 204;

            //The single clouds
            bgImage1 = "images/cloud.png";

            bgImage1X = new int[]{
                9, 20, 57, 68, 105, 116, 153, 164, 201
            };

            bgImage1Y = new int[]{
                10, 11, 10, 11, 10, 11, 10, 11, 10
            };

            //The dual clouds
            bgImage2 = "images/cloud-2.png";

            bgImage2X = new int[]{
                37, 85, 133, 181
            };

            bgImage2Y = new int[]{
                11, 11, 11, 11
            };

            //The triple clouds
            bgImage3 = "images/cloud-3.png";

            bgImage3X = new int[]{
                28, 76, 124, 172, 
            };

            bgImage3Y = new int[]{
                10, 10, 10, 10
            };

            //The single bush
            bgImage4 = "images/bush.png";

            bgImage4X = new int[]{
                24, 72, 120, 158, 168, 206
            };

            bgImage4Y = new int[]{
                1, 1, 1, 1, 1, 1
            };

            //The dual bush
            bgImage5 = "images/bush-2.png";

            bgImage5X = new int[]{
                42, 90, 138
            };

            bgImage5Y = new int[]{
                1, 1, 1
            };

            //The triple bush
            bgImage6 = "images/bush-3.png";

            bgImage6X = new int[]{
                12, 60, 108
            };

            bgImage6Y = new int[]{
                1, 1, 1
            };

            //The small hill
            bgImage7 = "images/small-hill.png";

            bgImage7X = new int[]{
                17, 65, 113, 161, 209
            };

            bgImage7Y = new int[]{
                1, 1, 1, 1, 1
            };

            //The big hill
            bgImage8 = "images/big-hill.png";

            bgImage8X = new int[]{
                1, 48, 96, 146, 192
            };

            bgImage8Y = new int[]{
                1, 1, 1, 1, 1
            };

        }
    }

    public void createLevel()
    {
        GreenfootImage background = new GreenfootImage(getWidth(), getHeight());
        background.setColor(Color.CYAN);
        background.fillRect(0, 0, getWidth(), getHeight());
        setBackground(background);
        addObject(player, getWidth()/2, placeFromBottom-1);
        createGround();
        createBlocks();
        createPipes();
        createFinish();
        createBackground();
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
                SolidBlock groundBlock = new SolidBlock();
                groundBlock.setImage(groundImage);
                addObject(groundBlock, l, levelHeight-h);
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
        for (int i = 0; i < blocksX.length; i++) {
            SolidBlock block = new SolidBlock();
            block.setImage(blockImage);
            addObject(block, blocksX[i], placeFromBottom-blocksY[i]);
        }

        for (int i = 0; i < breakableBlocksX.length; i++) {
            BreakableBlock breakableBlock = new BreakableBlock();
            breakableBlock.setImage(breakableBlocksImage);
            addObject(breakableBlock, breakableBlocksX[i], placeFromBottom-breakableBlocksY[i]);
        }

        for (int i = 0; i < QBlocksX.length; i++) {
            QBlock QBlock = new QBlock();
            QBlock.setImage(QBlocksImage);
            addObject(QBlock, QBlocksX[i], placeFromBottom-QBlocksY[i]);
        }
    }

    public void createPipes()
    {
        for (int i = 0; i < pipeTopX.length; i++) {
            Pipe pipeTop = new Pipe();
            pipeTop.setImage(pipeImage);
            addObject(pipeTop, pipeTopX[i], placeFromBottom-pipeTopY[i]);
            for(int k = pipeTopY[i]-1; k > 0; k--)
            {
                Pipe pipePart = new Pipe();
                pipePart.setImage("images/pipe_part.png");
                addObject(pipePart, pipeTopX[i], placeFromBottom-k);
            }
        }
    }

    public void createFinish()
    {
        Finish finishTop = new Finish();
        finishTop.setImage("poleTop.png");
        addObject(finishTop, finishLine, placeFromBottom-finishHeight);
        for (int i = 2; i < finishHeight; i++) {
            Finish finishPole = new Finish();
            finishPole.setImage("polePart.png");
            addObject(finishPole, finishLine, placeFromBottom-i);
        }
    }

    public void createBackground()
    {
        if (bgImage1X != null)
        {
            for (int i = 0; i < bgImage1X.length; i++) {
                BackgroundImage bgImg = new BackgroundImage();
                bgImg.setImage(bgImage1);
                addObject(bgImg, bgImage1X[i], placeFromBottom-bgImage1Y[i]);
            }
        }

        if (bgImage2X != null)
        {
            for (int i = 0; i < bgImage2X.length; i++) {
                BackgroundImage bgImg = new BackgroundImage();
                bgImg.setImage(bgImage2);
                addObject(bgImg, bgImage2X[i], placeFromBottom-bgImage2Y[i]);
            }
        }

        if (bgImage3X != null)
        {
            for (int i = 0; i < bgImage3X.length; i++) {
                BackgroundImage bgImg = new BackgroundImage();
                bgImg.setImage(bgImage3);
                addObject(bgImg, bgImage3X[i], placeFromBottom-bgImage3Y[i]);
            }
        }

        if (bgImage4X != null)
        {
            for (int i = 0; i < bgImage4X.length; i++) {
                BackgroundImage bgImg = new BackgroundImage();
                bgImg.setImage(bgImage4);
                addObject(bgImg, bgImage4X[i], placeFromBottom-bgImage4Y[i]);
            }
        }

        if (bgImage5X != null)
        {
            for (int i = 0; i < bgImage5X.length; i++) {
                BackgroundImage bgImg = new BackgroundImage();
                bgImg.setImage(bgImage5);
                addObject(bgImg, bgImage5X[i], placeFromBottom-bgImage5Y[i]);
            }
        }

        if (bgImage6X != null)
        {
            for (int i = 0; i < bgImage6X.length; i++) {
                BackgroundImage bgImg = new BackgroundImage();
                bgImg.setImage(bgImage6);
                addObject(bgImg, bgImage6X[i], placeFromBottom-bgImage6Y[i]);
            }
        }

        if (bgImage7X != null)
        {
            for (int i = 0; i < bgImage7X.length; i++) {
                BackgroundImage bgImg = new BackgroundImage();
                bgImg.setImage(bgImage7);
                addObject(bgImg, bgImage7X[i], placeFromBottom-bgImage7Y[i]);
            }
        }

        if (bgImage8X != null)
        {
            for (int i = 0; i < bgImage8X.length; i++) {
                BackgroundImage bgImg = new BackgroundImage();
                bgImg.setImage(bgImage8);
                addObject(bgImg, bgImage8X[i], placeFromBottom-bgImage8Y[i]);
            }
        }

        if (bgImage9X != null)
        {
            for (int i = 0; i < bgImage9X.length; i++) {
                BackgroundImage bgImg = new BackgroundImage();
                bgImg.setImage(bgImage9);
                addObject(bgImg, bgImage9X[i], placeFromBottom-bgImage9Y[i]);
            }
        }

        BackgroundImage castle = new BackgroundImage();
        castle.setImage("castle.png");
        addObject(castle, castleX, placeFromBottom - castle.getImage().getHeight()/2/gridSize);

    }

}