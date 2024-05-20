package Entity;

import main.Directions;

import java.awt.*;

public class Entity {
    public final float size = 0.8f;
    public Rectangle solidarea;
    public int speed;
    public Directions direction = Directions.UP;
    public boolean collision = false;
    public boolean collisionOn = false;

    Entity(int x, int y, int width, int height) {
        solidarea = new Rectangle(x, y, width, height);
        speed = 4;
    }

    public void Move() {
        if(collisionOn)
        {
            collisionOn = false;
            return;
        }
        switch (direction) {
            case Directions.UP:
                solidarea.y -= speed;
                break;
            case Directions.DOWN:
                solidarea.y += speed;
                break;
            case Directions.LEFT:
                solidarea.x -= speed;
                break;
            case Directions.RIGHT:
                solidarea.x += speed;
                break;
            default:
                break;
        }
    }
}
