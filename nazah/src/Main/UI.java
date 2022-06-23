package Main;

import WorldObject.*;

import java.awt.*;
import java.awt.image.BufferedImage;

// handles on screen UI
public class UI {
    GamePanel gamePanel;
    Font arial_40;
    BufferedImage block1, block2, block3, block4, block5;
    BufferedImage letter1, letter2, letter3, letter4, letter5;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;
    public UI(GamePanel gamePanel)
    {
        this.gamePanel = gamePanel;
        arial_40 = new Font("Arial",Font.PLAIN,40);
        Underscore underscore = new Underscore();
        C c = new C();
        L l = new L();
        O o = new O();
        U u = new U();
        D d = new D();

        letter1 = c.image;
        letter2 = l.image;
        letter3 = o.image;
        letter4 = u.image;
        letter5 = d.image;
        block1 = underscore.image;
        block2 = underscore.image;
        block3 = underscore.image;
        block4 = underscore.image;
        block5 = underscore.image;

    }
    public void draw(Graphics2D graphics2D)
    {
        if(gameFinished==true)
        {
            graphics2D.setFont(arial_40);
            graphics2D.setColor(Color.white);

            String text;
            int textLength;
            int x, y;

            text = "You've got CLOUD!";
            textLength = (int)graphics2D.getFontMetrics().getStringBounds(text,graphics2D).getWidth();
            x = gamePanel.screenWidth/2 - textLength/2;
            y = gamePanel.screenHeight/2 - (gamePanel.tileSize*3);

            graphics2D.drawString(text,x,y);
            gamePanel.gameThread = null;
        }
        else {
            graphics2D.setFont(arial_40);
            graphics2D.setColor(Color.white);
            graphics2D.drawImage(block1, gamePanel.tileSize / 2, gamePanel.tileSize / 2, gamePanel.tileSize, gamePanel.tileSize, null);
            graphics2D.drawImage(block2, gamePanel.tileSize / 2 + 48, gamePanel.tileSize / 2, gamePanel.tileSize, gamePanel.tileSize, null);
            graphics2D.drawImage(block3, gamePanel.tileSize / 2 + 96, gamePanel.tileSize / 2, gamePanel.tileSize, gamePanel.tileSize, null);
            graphics2D.drawImage(block4, gamePanel.tileSize / 2 + 144, gamePanel.tileSize / 2, gamePanel.tileSize, gamePanel.tileSize, null);
            graphics2D.drawImage(block5, gamePanel.tileSize / 2 + 192, gamePanel.tileSize / 2, gamePanel.tileSize, gamePanel.tileSize, null);
            if (gamePanel.player.hasC > 0) {
                block1 = null;
                graphics2D.drawImage(letter1, gamePanel.tileSize / 2, gamePanel.tileSize / 2, gamePanel.tileSize, gamePanel.tileSize, null);
                if (messageOn == true) {
                    graphics2D.setFont(graphics2D.getFont().deriveFont(30));
                    graphics2D.drawString(message, gamePanel.tileSize / 2, gamePanel.tileSize * 5);
                    messageCounter++;
                    if (messageCounter > 120) {
                        messageCounter = 0;
                        messageOn = false;

                    }
                }
            }
            if (gamePanel.player.hasL > 0) {
                block2 = null;
                graphics2D.drawImage(letter2, gamePanel.tileSize / 2 + 48, gamePanel.tileSize / 2, gamePanel.tileSize, gamePanel.tileSize, null);
                if (messageOn == true) {
                    graphics2D.setFont(graphics2D.getFont().deriveFont(30));
                    graphics2D.drawString(message, gamePanel.tileSize / 2, gamePanel.tileSize * 5);
                    messageCounter++;
                    if (messageCounter > 120) {
                        messageCounter = 0;
                        messageOn = false;

                    }
                }
            }
            if (gamePanel.player.hasO > 0) {
                block3 = null;
                graphics2D.drawImage(letter3, gamePanel.tileSize / 2 + 96, gamePanel.tileSize / 2, gamePanel.tileSize, gamePanel.tileSize, null);
                if (messageOn == true) {
                    graphics2D.setFont(graphics2D.getFont().deriveFont(30));
                    graphics2D.drawString(message, gamePanel.tileSize / 2, gamePanel.tileSize * 5);
                    messageCounter++;
                    if (messageCounter > 120) {
                        messageCounter = 0;
                        messageOn = false;

                    }
                }
            }
            if (gamePanel.player.hasU > 0) {
                block4 = null;
                graphics2D.drawImage(letter4, gamePanel.tileSize / 2 + 144, gamePanel.tileSize / 2, gamePanel.tileSize, gamePanel.tileSize, null);
                if (messageOn == true) {
                    graphics2D.setFont(graphics2D.getFont().deriveFont(30));
                    graphics2D.drawString(message, gamePanel.tileSize / 2, gamePanel.tileSize * 5);
                    messageCounter++;
                    if (messageCounter > 120) {
                        messageCounter = 0;
                        messageOn = false;

                    }
                }
            }
            if (gamePanel.player.hasD > 0) {
                block5 = null;
                graphics2D.drawImage(letter5, gamePanel.tileSize / 2 + 192, gamePanel.tileSize / 2, gamePanel.tileSize, gamePanel.tileSize, null);
                if (messageOn == true) {
                    graphics2D.setFont(graphics2D.getFont().deriveFont(30));
                    graphics2D.drawString(message, gamePanel.tileSize / 2, gamePanel.tileSize * 5);
                    messageCounter++;
                    if (messageCounter > 120) {
                        messageCounter = 0;
                        messageOn = false;

                    }
                }
            }
        }




    }
    public void showMessage(String message)
    {
        this.message = message;
        messageOn = true;
    }


}
