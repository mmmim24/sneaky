package WorldObject;

import javax.imageio.ImageIO;
import java.io.IOException;

public class O extends SuperObject {
    public O()
    {
        name = "O";
        try{

            image = ImageIO.read(getClass().getResourceAsStream("/O.png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
