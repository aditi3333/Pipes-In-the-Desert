package GUI;

import main.GamePanel;
import Entity.Entity;
import Tile.Tile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public abstract class EntityGUI {
    public BufferedImage image;
    final float size = 0.8f;
    public Entity entity;
    GamePanel gp;

    EntityGUI(GamePanel gp, String imagePath)
    {
        this.gp = gp;
        getPlayerImage(imagePath);
    }

    public void getPlayerImage(String imagePath){
        try{
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(imagePath)));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public abstract void update();

    public void draw(Graphics2D g2){
        g2.drawImage(image, entity.solidarea.x , entity.solidarea.y, entity.solidarea.width, entity.solidarea.height,null);
    }

    public Tile getTileFromEntity(int col_offset, int row_offset)
    {
        int entityMiddleX = entity.solidarea.x + (entity.solidarea.width/2);
        int entityMiddleY = entity.solidarea.y + (entity.solidarea.height/2);
        int entityMiddleCol = entityMiddleX / gp.tileSize;
        int entityMiddleRow = entityMiddleY / gp.tileSize;

        if(gp.tileManager.tile.length < entityMiddleCol + col_offset)
            return null;
        if(gp.tileManager.tile[0].length < entityMiddleRow + row_offset)
            return null;
        return gp.tileManager.tile[entityMiddleCol + col_offset][entityMiddleRow + row_offset];
    }
}