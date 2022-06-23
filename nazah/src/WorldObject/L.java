package WorldObject;

import javax.imageio.ImageIO;
import java.io.IOException;

public class L extends SuperObject {
    public L()
    {
        name = "L";
        try{

            image = ImageIO.read(getClass().getResourceAsStream("/L.png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
