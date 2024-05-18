package Entity;

import main.Directions;

import java.awt.image.BufferedImage;

public class Entity {
    public int x, y;
    public int speed;

    Entity() {
        x = 100;
        y = 100;
        speed = 4;
    }

    public void Move(Directions direction) {
        switch (direction) {
            case Directions.UP:
                y -= speed;
                break;
            case Directions.DOWN:
                y += speed;
                break;
            case Directions.LEFT:
                x -= speed;
                break;
            case Directions.RIGHT:
                x += speed;
                break;
        }
    }
}
