package Entity;

import Main.GamePanel;
import Main.KeyHandler;
import Main.UI;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity
{
    GamePanel gamePanel;
    KeyHandler keyHandler;

    public final int screenX;
    public final int screenY;
    public int hasC = 0;
    public int hasL = 0;
    public int hasO = 0;
    public int hasU = 0;
    public int hasD = 0;

    public Player(GamePanel gamePanel, KeyHandler keyHandler)
    {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;
        screenX = gamePanel.screenWidth/2 - gamePanel.tileSize/2;
        screenY = gamePanel.screenHeight/2 - gamePanel.tileSize/2;
        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 32;
        solidArea.height = 32;


        setDefaultValues();
        getPlayerImage();

    }
    public void setDefaultValues()
    {
        worldX = gamePanel.tileSize * 24;
        worldY = gamePanel.tileSize*21;
//        speed = 4;
        speed = gamePanel.worldWidth/600;
        direction = "down";
    }
    public void getPlayerImage()
    {
        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/up-1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/up-2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/down-1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/down-2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/left-1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/left-2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/right-1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/right-2.png"));

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void update()
    {
        if(keyHandler.upPressed == true || keyHandler.downPressed == true || keyHandler.leftPressed == true || keyHandler.rightPressed == true)
        {
            if(keyHandler.upPressed)
            {
                direction = "up";

            }
            else if(keyHandler.downPressed)
            {
                direction = "down";

            }
            else if(keyHandler.leftPressed)
            {
                direction = "left";

            }
            else if(keyHandler.rightPressed)
            {
                direction = "right";

            }
            // CHECK TILE COLLISION
            collisionOn = false;
            gamePanel.collisionChecker.checkTile(this);

            // CHECK OBJECT COLLISION
            int objIndex = gamePanel.collisionChecker.checkObject(this,true);
            pickUpObject(objIndex);

            // IF COLLISION IS FALSE, PLAYER CAN MOVE
            if(collisionOn == false)
            {
                switch (direction)
                {
                    case "up":
                        worldY-=speed;
                        break;
                    case "down":
                        worldY+=speed;
                        break;
                    case "left":
                        worldX-=speed;
                        break;
                    case "right":
                        worldX+=speed;
                        break;
                }
            }
            spriteCounter++;
            if(spriteCounter > 12)
            {
                if(spriteNum == 1)
                {
                    spriteNum = 2;
                }
                else if(spriteNum == 2)
                {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }

    }

    public void pickUpObject(int i)
    {
        if(i != 999)
        {
           String objectName = gamePanel.obj[i].name;

           switch (objectName)
           {
               case "C":
                   gamePanel.playSoundEffect(1);
                   hasC++;
                   gamePanel.obj[i] = null;
                   gamePanel.ui.showMessage("you've got C!");
                   break;

               case "L":
                   gamePanel.playSoundEffect(1);
                   hasL++;
                   gamePanel.obj[i] = null;
                   gamePanel.ui.showMessage("you've got L!");
                   break;

               case "O":
                   gamePanel.playSoundEffect(1);
                   hasO++;
                   gamePanel.obj[i] = null;
                   gamePanel.ui.showMessage("you've got O!");
                   break;

               case "U":
                   gamePanel.playSoundEffect(1);
                   hasU++;
                   gamePanel.obj[i] = null;
                   gamePanel.ui.showMessage("you've got U!");
                   break;


               case "D":
                   gamePanel.playSoundEffect(1);
                   hasD++;
                   gamePanel.ui.showMessage("you've got D!");
                   gamePanel.obj[i] = null;
                   break;


               case "Apple":
                   gamePanel.playSoundEffect(2);
                   speed+=1;
                   gamePanel.obj[i] = null;
                   break;


           }
           if(hasC == 1 && hasL == 1 && hasO == 1 && hasU == 1 & hasD == 1)
           {
               gamePanel.ui.gameFinished = true;
//               gamePanel.stopMusic();
               gamePanel.playSoundEffect(3);
           }
        }
    }
    public void draw(Graphics2D graphics2D)
    {
//        graphics2D.setColor(Color.white);
//        graphics2D.fillRect(x,y, gamePanel.tileSize,gamePanel.tileSize);

        BufferedImage image = null;
        switch (direction)
        {
            case "up":
                if(spriteNum == 1)
                {
                    image = up1;
                }
                if(spriteNum == 2)
                {
                    image = up2;
                }
                break;

            case "down":
                if(spriteNum == 1)
                {
                    image = down1;
                }
                if(spriteNum == 2)
                {
                    image = down2;
                }
                break;
            case "left":
                if(spriteNum == 1)
                {
                    image = left1;
                }
                if(spriteNum == 2)
                {
                    image = left2;
                }
                break;
            case "right":
                if(spriteNum == 1)
                {
                    image = right1;
                }
                if(spriteNum == 2)
                {
                    image = right2;
                }
                break;




        }
        graphics2D.drawImage(image,screenX,screenY,gamePanel.tileSize,gamePanel.tileSize,null);

    }
}
