package GUI;

import Entity.Plumber;
import Tile.Tile;
import main.KeyHandler;
import main.GamePanel;
import main.Directions;

import java.util.Objects;


public class PlumberGUI extends EntityGUI {
    KeyHandler keyH;

    public PlumberGUI(GamePanel gp, KeyHandler keyH) {
        super(gp, "/main/res/plumber.png");
        this.keyH = keyH;
        int x = 7*gp.tileSize;
        int y = 8*gp.tileSize;
        int width = (int)(size*gp.tileSize);
        int height = (int)(size*gp.tileSize);
        entity = new Plumber(x, y, width, height);
    }

    @Override
    public void update() {
        Tile tile = getEntityTile();

        entity.collision = Objects.equals(tile.name, "pump");

        if (keyH.upPressed) {
            entity.direction = Directions.UP;
        } else if (keyH.downPressed) {
            entity.direction = Directions.DOWN;
        } else if (keyH.leftPressed) {
            entity.direction = Directions.LEFT;
        } else if (keyH.rightPressed) {
            entity.direction = Directions.RIGHT;
        }

        if (keyH.pPressed) {
            tile.fixTile();
        }

        if(keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {
            entity.Move();
            gp.collisionChecker.checkEntityEntity(entity, gp.saboteur.entity);
            gp.collisionChecker.checktile(entity);
        }
    }
}