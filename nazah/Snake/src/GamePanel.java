import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.security.Key;
import java.util.ArrayList;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener{

    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 25; /// how big we want the objects in our game. basically 25 pixels in this screen
    static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE; /// number of objects in the screen

    static final int DELAY = 200; /// delay for our timer. this timer will call the action listener after a delay
    final int x[] = new int[GAME_UNITS]; // body part of the snake, the snake cannot be bigger than the game itself
    final int y[] = new int[GAME_UNITS];



//    public ArrayList<Point> mazeParts = new ArrayList<Point>();
//    public int[] mazeCoord = new int[2];

    ArrayList<Maze> walls = new ArrayList<>();


    int bodyParts = 6;
    int applesEaten;
    int appleX; /// random location of apple
    int appleY; /// random location of apple

    char direction = 'R'; /// at the beginning it'll go right

    boolean running = false;
    public boolean paused = false;

    Timer timer;
    Random random;

    /// BUG FIX REQUIRED:
    /*
    1. CHECK noMaze() - while generating random location of apple
     */


    /// FEATURES TO BE ADDED:
    /*
    - complex maze
    - random alphabet and check collison
     */
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
//        mazeParts.clear();
        paused = false;
        newApple();
        running = true; // game is running now
        timer = new Timer(DELAY,this); /// action listener interfsce

//        for (int i = 0; i < 10; i++) {
//            mazeCoord = generateMazePart();
//            mazeParts.add(new Point(mazeCoord[0], mazeCoord[1]));        }
        timer.start();
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g); /// eitay ki korbe bujhinai :v

//        for(int i=0;i<SCREEN_HEIGHT/UNIT_SIZE;i++)
//        {
//
//            g.drawLine(i*UNIT_SIZE,0,i*UNIT_SIZE,SCREEN_HEIGHT);
//            g.drawLine(0,i*UNIT_SIZE,SCREEN_WIDTH,i*UNIT_SIZE);
//        }
        draw(g);

    }
//    public int[] generateMazePart () {
//        int[] coord = new int[2];
//        coord[0] = 0;
//
//        for(int i=0;i<2;i++)
//        {
//            coord[0] = random.nextInt(SCREEN_WIDTH/UNIT_SIZE);
//            coord[1] = random.nextInt(SCREEN_WIDTH/UNIT_SIZE);
//        }
////        do {
////            coord[0] = random.nextInt(SCREEN_WIDTH/UNIT_SIZE);
////            coord[1] = random.nextInt(SCREEN_WIDTH/UNIT_SIZE);
////
////        }
////        while (coord[1] < 3);
//
//        return coord;
//    }
    public void draw(Graphics g)
    {

        /// grid
        for(int i=0;i<SCREEN_WIDTH/UNIT_SIZE;i++)
        {
            for(int j=0;j<SCREEN_HEIGHT/UNIT_SIZE;j++)
            {
                if((i+j)%2==0)
                {
                    g.setColor(new Color(0x7fa278));
                }
                else {
                    g.setColor(new Color(0x93bb8b));
                }
                g.fillRect(i*UNIT_SIZE,j*UNIT_SIZE,UNIT_SIZE,UNIT_SIZE);

            }
        }
        if(running)
        /// apple
        {

            // draw rect


            walls.add(new Maze(50,25,75,25)); ///a
            walls.add(new Maze(50,50,25,175)); // b
            walls.add(new Maze(25,100,25,25)); /// c
            walls.add(new Maze(75,200,150,25)); /// d
            walls.add(new Maze(200,175,25,25)); /// e
            walls.add(new Maze(125,125,25,50)); /// f
            walls.add(new Maze(150,125,100,25)); /// g
            walls.add(new Maze(225,25,25,100)); /// h
            walls.add(new Maze(250,25,75,25)); /// i
            walls.add(new Maze(325,25,25,275)); //j
            walls.add(new Maze(350,275,50,25)); // k
            walls.add(new Maze(400,175,25,125)); // l
            walls.add(new Maze(425,175,50,25)); // m
            walls.add(new Maze(475,175,25,50)); // n
            walls.add(new Maze(475,225,75,25)); /// o
            walls.add(new Maze(525,250,25,200)); // p
            walls.add(new Maze(550,325,25,25)); // q
            walls.add(new Maze(425,225,50,25));


            for(Maze wall: walls)
            {
                wall.draw((Graphics2D) g);
            }


            /// maze
            g.setColor(new Color(0x5B3F3A));
//            for (Point point : mazeParts) g.fillRect(point.x * UNIT_SIZE, point.y * UNIT_SIZE, UNIT_SIZE, UNIT_SIZE);

            g.setColor(new Color(217,8,18,255));
            g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);



            // body of snake

            for (int i = 0; i < bodyParts; i++) {
                if (i == 0) {
                    g.setColor(new Color(0x1F332E));
                    g.fillOval(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                } else {
                    g.setColor(new Color(0x415840));
                    g.fillOval(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                }
            }
            g.setColor(new Color(0xC51D2A));
            g.setFont( new Font("Courier New",Font.BOLD, 30));
            FontMetrics metrics = getFontMetrics(g.getFont());


            g.drawString("Score: "+applesEaten, (SCREEN_WIDTH - metrics.stringWidth("Score: "+applesEaten))/2, g.getFont().getSize());
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
        if(!paused)
        {
            for(int i = bodyParts;i>0;i--)
            {
                x[i] = x[i-1]; /// . . . <- this one will move
                y[i] = y[i-1];
            }
            switch (direction) {
                case 'U' -> y[0] = y[0] - UNIT_SIZE;
                case 'D' -> y[0] = y[0] + UNIT_SIZE;
                case 'R' -> x[0] = x[0] + UNIT_SIZE;
                case 'L' -> x[0] = x[0] - UNIT_SIZE;
            }
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
                break;
            }
        }
        //// head of snake collides with maze
//        for (Point point: mazeParts)
//        {
//            if (point.x*UNIT_SIZE == x[0] && point.y*UNIT_SIZE == y[0]) {
//                running = false;
//                break;
//            }
//        }



        for(Maze wall: walls)
        {
            if(wall.hitBox.intersects(new Rectangle(x[0],y[0],UNIT_SIZE,UNIT_SIZE))){
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
        g.setColor(new Color(0xC51D2A));
        g.setFont( new Font("Courier New",Font.BOLD, 30));
        FontMetrics metrics1 = getFontMetrics(g.getFont());
        g.drawString("Score: "+applesEaten, (SCREEN_WIDTH - metrics1.stringWidth("Score: "+applesEaten))/2, g.getFont().getSize());
        /// game over - text
        g.setColor(new Color(0x1d1817));
        g.setFont(new Font("Courier New",Font.ITALIC,75));

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
                case KeyEvent.VK_SPACE:

                        paused = !paused; //toggles paused boolean
                        break;

            }
        }

    }
}
