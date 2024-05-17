package Entity;

import main.GamePanel;

import main.SaboteurKeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Saboteur extends Entity{
    GamePanel gp;
    SaboteurKeyHandler keyH;

    public Saboteur(GamePanel gp, SaboteurKeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;
        setDefaultValues();
        getPlayerImage();
    }
    public void draw(Graphics2D g2){
        //g2.setColor(Color.white);
        //g2.fillRect(x,y,gp.tileSize,gp.tileSize );
        BufferedImage image = null;
        image = plumber;
        g2.drawImage(image,x,y,gp.tileSize,gp.tileSize,null);
    }
    public void getPlayerImage(){
        try{
            plumber = ImageIO.read(getClass().getResourceAsStream("/res/saboteur.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public void setDefaultValues(){
        x = 200;
        y = 200;
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
}
