package Main;

import Entity.Player;
import Tile.TileManager;
import WorldObject.*;
import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{
    // SCREEN SETTINGS

    final int originalTileSize = 16; // boxes
    final int scale = 3;

    public int tileSize = originalTileSize*scale; // 48 tile size
    public int maxScreenCol = 16;
    public int maxScreenRow = 12;
    public int screenWidth = tileSize*maxScreenCol; // 768 px
    public int screenHeight = tileSize*maxScreenRow; /// 576 px


    // WORLD SETTINGS
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = tileSize*maxWorldCol;
    public final int worldHeight = tileSize*maxWorldRow;



    int FPS = 60;

    TileManager tileManager = new TileManager(this);
    KeyHandler key = new KeyHandler(this);
    Sound music = new Sound();
    Sound soundEffect = new Sound();
    public CollisionChecker collisionChecker = new CollisionChecker(this);
    AssetSetter assetSetter = new AssetSetter(this);

    public UI ui = new UI(this);
    Thread gameThread;
    public Player player = new Player(this,key);
    public SuperObject obj[] = new SuperObject[10];



//    // set Player's default position
//    int playerX = 100;
//    int playerY = 100;
//    int playerSpeed = 4;

    public GamePanel()
    {
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);  // improves rendering performance
        this.addKeyListener(key);
        this.setFocusable(true);

    }
    public void setupGame()
    {
        assetSetter.setObject();
//        playMusic(0);
    }
//    public void zoomInOut(int i)
//    {
//        int oldWorldWidth = tileSize*maxWorldCol;
//        tileSize += i;
//        int newWorldWidth = tileSize*maxWorldCol;
//        player.speed = (int) newWorldWidth/600;
//        double multiplier = (double) newWorldWidth/oldWorldWidth;
//
//        double newPlayerWorldX = player.worldX*multiplier;
//        double newPlayerWorldY = player.worldY*multiplier;
//
//        player.worldX = (int) newPlayerWorldX;
//        player.worldY = (int) newPlayerWorldY;
//
//    }

    public void startGameThread()
    {
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run()
    {
        double drawInterval = 1000000000/FPS; // nano second as a calc unit
        double nextDrawTime = System.nanoTime() + drawInterval;


        while(gameThread!=null)
        {
//            long currentTime = System.nanoTime();
//            System.out.println(currentTime);
            // we can also use
//            long currentTime2 = System.currentTimeMillis();
            // UPDATE PLAYER POSITION - update()

            update();
            // DRAW SCREEN WITH UPDATED INFO - paintcomponent
            repaint();



            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;
                if(remainingTime<0)
                {
                    remainingTime = 0; // no time is left
                }
                Thread.sleep((long)remainingTime);

                nextDrawTime += drawInterval;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
    public void update()
    {
        player.update();
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        /// TILE
        tileManager.draw(graphics2D);
        // object
        for(int i=0; i < obj.length; i++)
        {
            if(obj[i] != null)
            {
                obj[i].draw(graphics2D,this);
            }
        }
        // PLAYER
        player.draw(graphics2D);
        ui.draw(graphics2D);


        graphics2D.dispose(); // to save memory

    }
    public void playMusic(int i)
    {
        music.setFile(i);
        music.play();
        music.loop();

    }
    public void stopMusic()
    {
        music.stop();
    }
    public void playSoundEffect(int i)
    {
        soundEffect.setFile(i);
        soundEffect.play();
    }
}
