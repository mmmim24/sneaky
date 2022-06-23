package Main;

import WorldObject.*;

public class AssetSetter{
    GamePanel gamePanel;
    public AssetSetter(GamePanel gamePanel)
    {
        this.gamePanel = gamePanel;
    }
    public void setObject()
    {
        gamePanel.obj[0] = new C();
        gamePanel.obj[0].worldX = 15 * gamePanel.tileSize;
        gamePanel.obj[0].worldY = 5 * gamePanel.tileSize;

        gamePanel.obj[1] = new L();
        gamePanel.obj[1].worldX = 2 * gamePanel.tileSize;
        gamePanel.obj[1].worldY = 25 * gamePanel.tileSize;

        gamePanel.obj[2] = new O();
        gamePanel.obj[2].worldX = 36 * gamePanel.tileSize;
        gamePanel.obj[2].worldY = 5 * gamePanel.tileSize;

        gamePanel.obj[3] = new U();
        gamePanel.obj[3].worldX = 37 * gamePanel.tileSize;
        gamePanel.obj[3].worldY = 32 * gamePanel.tileSize;

        gamePanel.obj[4] = new D();
        gamePanel.obj[4].worldX = 40 * gamePanel.tileSize;
        gamePanel.obj[4].worldY = 22 * gamePanel.tileSize;

        gamePanel.obj[5] = new Apple();
        gamePanel.obj[5].worldX = 24 * gamePanel.tileSize;
        gamePanel.obj[5].worldY = 9 * gamePanel.tileSize;

    }
}