package WorldObject;

import javax.imageio.ImageIO;
import java.io.IOException;

public class D extends SuperObject {
    public D()
    {
        name = "D";
        try{

            image = ImageIO.read(getClass().getResourceAsStream("/D.png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
