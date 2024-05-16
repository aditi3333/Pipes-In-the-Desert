package Entity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import main.KeyHandler;
import main.GamePanel;


public class Plumber extends Entity{
    GamePanel gp;
    KeyHandler keyH;

    public Plumber(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;
        setDefaultValues();
        getPlayerImage();
    }
    public void getPlayerImage(){
        try{
            plumber = ImageIO.read(getClass().getResourceAsStream("/res/plumber.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 4;
    }
    public void update(){
        if(keyH.upPressed == true){
            y -= speed;

        }
        else if(keyH.downPressed == true){
            y += speed;
        }
        else if(keyH.leftPressed == true){
            x -= speed;
        }
        else if(keyH.rightPressed == true){
            x += speed;
        }
    }
    public void draw(Graphics2D g2){
        //g2.setColor(Color.white);
        //g2.fillRect(x,y,gp.tileSize,gp.tileSize );
        BufferedImage image = null;
        image = plumber;
        g2.drawImage(image,x,y,gp.tileSize,gp.tileSize,null);
    }
}
