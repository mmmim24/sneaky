import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.security.Key;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener{

    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 25; /// how big we want the objects in our game. basically 25 pixels in this screen
    static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE; /// number of objects in the screen

    static final int DELAY = 75; /// delay for our timer. this timer will call the action listener after a delay
    final int x[] = new int[GAME_UNITS]; // body part of the snake, the snake cannot be bigger than the game itself
    final int y[] = new int[GAME_UNITS];
    int bodyParts = 6;
    int applesEaten;
    int appleX; /// random location of apple
    int appleY; /// random location of apple

    char direction = 'R'; /// at the beginning it'll go right

    boolean running = false;

    Timer timer;
    Random random;



    GamePanel()
    {
        random = new Random();
        setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();

    }
    public void startGame()
    {
        // when we start this game, the first thing we need to do is, randomly locate the apple
        newApple();
        running = true; // game is running now
        timer = new Timer(DELAY,this); /// action listener interfsce
        timer.start();
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g); /// eitay ki korbe bujhinai :v
        draw(g);
    }
    public void draw(Graphics g)
    {
        /// grid

        if(running)
        /// apple
        {
            for(int i=0;i<SCREEN_HEIGHT/UNIT_SIZE;i++)
            {

                g.drawLine(i*UNIT_SIZE,0,i*UNIT_SIZE,SCREEN_HEIGHT);
                g.drawLine(0,i*UNIT_SIZE,SCREEN_WIDTH,i*UNIT_SIZE);
            }
            g.setColor(Color.red);
            g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);


            // body of snake

            for (int i = 0; i < bodyParts; i++) {
                if (i == 0) {
                    g.setColor(new Color(0x47051));
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                } else {
                    g.setColor(new Color(0xeab6c));
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                }
            }
        }
        else
        {
            gameOver(g);
        }

    }
    public void newApple() /// everytime apple khabe notun location generate korbe
    {
        appleX = random.nextInt((int)SCREEN_WIDTH/UNIT_SIZE)*UNIT_SIZE; /// placed evenly within the boxes
        appleY = random.nextInt((int)SCREEN_HEIGHT/UNIT_SIZE)*UNIT_SIZE;
    }
    public void move()
    {
        /// moving the snake
        // iterating through the body parts of the snake
        for(int i = bodyParts;i>0;i--)
        {
            x[i] = x[i-1]; /// . . . <- this one will move
            y[i] = y[i-1];
        }
        switch(direction)
        {
            case 'U':
                y[0] = y[0] - UNIT_SIZE;
                break;

            case 'D':
                y[0] = y[0] + UNIT_SIZE;
                break;

            case 'R':
                x[0] = x[0] + UNIT_SIZE;
                break;

            case 'L':
                x[0] = x[0] - UNIT_SIZE;
                break;
        }
    }
    public void checkApple() // if apple khaise
    {
        if(x[0]==appleX && y[0] == appleY)
        {
            bodyParts++;
            applesEaten++;
            newApple();
        }
    }
    public void checkCollision()
    {
        /// head of the snake collides with the body
        for(int i=bodyParts;i>0;i--)
        {
            if((x[0]==x[i]) && (y[0]==y[i]))
            {
                running = false;
            }
        }
        /// check if head touches the borders;

        if(x[0]<0)  // left border
        {
            running = false;
        }
        if(x[0]>SCREEN_WIDTH-UNIT_SIZE) // right border
        {
            running = false;
        }
        if(y[0]<0)
        {
            running = false;
        }
        if(y[0]>SCREEN_HEIGHT-UNIT_SIZE)
        {
            running = false;
        }

    }
    public void gameOver(Graphics g) /// new popup
    {
        /// game over - text
        g.setColor(Color.GRAY);
        g.setFont(new Font("Ariel",Font.ITALIC,75));

        FontMetrics metric = getFontMetrics(g.getFont());
        g.drawString("Game over!",(SCREEN_WIDTH-metric.stringWidth("Game over!"))/2,SCREEN_HEIGHT/2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(running)
        {
            move();
            checkApple();
            checkCollision();
        }
        repaint();

    }
    /// key adapter is an abstract class where u wont have to implement all the abstract methods

    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e)
        {
            switch (e.getKeyCode())
            {
                case KeyEvent.VK_LEFT:
                    if(direction!='R')
                    {
                        direction = 'L';
                    }
                    break;

                case KeyEvent.VK_RIGHT:
                    if(direction!='L')
                    {
                        direction = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if(direction!='D')
                    {
                        direction = 'U';
                    }
                    break;

                case KeyEvent.VK_DOWN:
                    if(direction!='U')
                    {
                        direction = 'D';
                    }
                    break;
            }
        }

    }
}