package WorldObject;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Apple extends SuperObject {
    public Apple()
    {
        name = "Apple";
        try{

            image = ImageIO.read(getClass().getResourceAsStream("/apple.png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
