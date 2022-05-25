import java.awt.*;

public class Maze {
    int x;
    int y;
    int width;
    int height;


    Rectangle hitBox;
    public Maze(int x, int y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        hitBox = new Rectangle(x,y,width,height);
    }
    public void draw(Graphics2D g)
    {
        g.setColor(new Color(0x5B3F3A));
        g.fillRect(x,y,width,height);


    }
}
