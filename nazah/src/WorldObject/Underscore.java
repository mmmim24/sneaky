package WorldObject;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Underscore extends SuperObject {
    public Underscore()
    {
        name = "Underscore";
        try{

            image = ImageIO.read(getClass().getResourceAsStream("/underscore.png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
