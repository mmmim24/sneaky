package WorldObject;

import javax.imageio.ImageIO;
import java.io.IOException;

public class C extends SuperObject{
    public C()
    {
        name = "C";
        try{

            image = ImageIO.read(getClass().getResourceAsStream("/C.png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
