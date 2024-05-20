package GUI;

import Entity.Saboteur;
import main.KeyHandler;
import main.GamePanel;
import main.Directions;
import Tile.Tile;


public class SaboteurGUI extends EntityGUI {
    GamePanel gp;
    KeyHandler keyH;

    public SaboteurGUI(GamePanel gp, KeyHandler keyH) {
        super(gp, "/main/res/saboteur.png");
        this.gp = gp;
        this.keyH = keyH;
        int x = 7*gp.tileSize;
        int y = 7*gp.tileSize;
        int width = (int)(size*gp.tileSize);
        int height = (int)(size*gp.tileSize);
        entity = new Saboteur(x, y, width, height);
    }

    @Override
    public void update() {
        if (keyH.wPressed) {
            entity.direction = Directions.UP;
        } else if (keyH.sPressed) {
            entity.direction = Directions.DOWN;
        } else if (keyH.aPressed) {
            entity.direction = Directions.LEFT;
        } else if (keyH.dPressed) {
            entity.direction = Directions.RIGHT;
        }

        if (keyH.xPressed) {
            Tile tile = getEntityTile();
            tile.breakTile();
        }

        if(keyH.wPressed || keyH.sPressed || keyH.aPressed || keyH.dPressed) {
            entity.Move();
            gp.collisionChecker.checkEntityEntity(entity, gp.plumber.entity);
            gp.collisionChecker.checktile(entity);
        }
    }
}