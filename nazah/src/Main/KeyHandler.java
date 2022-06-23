package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener
{
    public boolean upPressed, downPressed, leftPressed, rightPressed;
    GamePanel gamePanel;
    public KeyHandler(GamePanel gamePanel)
    {
        this.gamePanel = gamePanel;
    }
    @Override
    public void keyTyped(KeyEvent e) {
        // we dont need this
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        int code = e.getKeyCode(); // will return the number of the key that was pressed
        if(code==KeyEvent.VK_UP)
        {
            upPressed = true;
        }
        else if(code==KeyEvent.VK_DOWN)
        {
            downPressed = true;
        }
        else if(code==KeyEvent.VK_LEFT)
        {
            leftPressed = true;
        }
        else if(code==KeyEvent.VK_RIGHT)
        {
            rightPressed = true;
        }
        else if(code==KeyEvent.VK_UP)
        {
            upPressed = true;
        }
//        else if(code==KeyEvent.VK_W)
//        {
//             gamePanel.zoomInOut(1);
//        }
//        else if(code==KeyEvent.VK_S)
//        {
//            gamePanel.zoomInOut(-1);
//        }

    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        int code = e.getKeyCode();
        if(code==KeyEvent.VK_UP)
        {
            upPressed = false;
        }
        else if(code==KeyEvent.VK_DOWN)
        {
            downPressed = false;
        }
        else if(code==KeyEvent.VK_LEFT)
        {
            leftPressed = false;
        }
        else if(code==KeyEvent.VK_RIGHT)
        {
            rightPressed = false;
        }

    }
}
