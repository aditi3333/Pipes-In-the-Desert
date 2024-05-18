package GUI;

import main.GamePanel;
import Entity.Entity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public abstract class EntityGUI {
    public BufferedImage image;
    Entity entity;
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
        g2.drawImage(image, entity.x , entity.y,gp.tileSize,gp.tileSize,null);
    }
}