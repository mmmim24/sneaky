package WorldObject;

import javax.imageio.ImageIO;
import java.io.IOException;

public class U extends SuperObject {
    public U()
    {
        name = "U";
        try{

            image = ImageIO.read(getClass().getResourceAsStream("/U.png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
