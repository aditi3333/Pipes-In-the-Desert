package Tile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

import PipeElement.Pipe;
import PipeElement.ActiveElement;
import PipeElement.Pump;
import PipeElement.Spring;
import PipeElement.Cistern;
import PipeElement.PipeElement;

public class Tile {
    public String name;
    public BufferedImage image;
    public boolean collision = false;
    PipeElement pipeElement;

    Tile(String name)
    {
        switch(name){
            case "pipe":
                this.name = "pipe";
                pipeElement = new Pipe();
                break;
            case "pump":
                this.name = "pump";
                pipeElement = new Pump();
                break;
            case "cistern":
                this.name = "cistern";
                pipeElement = new Cistern();
                break;
            case "spring":
                this.name = "spring";
                pipeElement = new Spring();
                break;
            default:
                this.name = "desert";
                pipeElement = null;
                collision = true;
        }
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(STR."/main/res/\{name}.png")));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void breakTile()
    {
        if(pipeElement != null)
        {
            pipeElement.breakPipeElement();
        }
        if(Objects.equals(name, "pipe") || Objects.equals(name, "pump"))
        {
            try {
                image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(STR."/main/res/broken\{name}.png")));
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    public void fixTile()
    {
        if(pipeElement != null)
        {
            pipeElement.fixPipeElement();
        }
        if(Objects.equals(name, "pipe") || Objects.equals(name, "pump"))
        {
            try {
                image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(STR."/main/res/\{name}.png")));
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}