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
        int x = 7 * gp.tileSize;
        int y = 8 * gp.tileSize;
        int width = (int) (size * gp.tileSize);
        int height = (int) (size * gp.tileSize);
        entity = new Plumber(x, y, width, height);
    }

    @Override
    public void update() {
        Tile tile = getTileFromEntity(0, 0);

        entity.collision = Objects.equals(tile.name, "pipe");

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

        if ((keyH.mPressed || keyH.nPressed) && Objects.equals(tile.name, "cistern")) {
            Tile toGenerate = null;
            switch (entity.direction) {
                case Directions.UP:
                    toGenerate = getTileFromEntity(0, -1);
                    break;
                case Directions.DOWN:
                    toGenerate = getTileFromEntity(0, 1);
                    break;
                case Directions.LEFT:
                    toGenerate = getTileFromEntity(-1, 0);
                    break;
                case Directions.RIGHT:
                    toGenerate = getTileFromEntity(1, 0);
            }
            if (keyH.mPressed) {
                toGenerate.buildPipeElement("pump");
            } else if (keyH.nPressed) {
                toGenerate.buildPipeElement("pipe");
            }
        }

        if (keyH.shiftPressed) {
            if(((Plumber)entity).picked == null) {
                Tile toPick = null;
                switch (entity.direction) {
                    case Directions.UP:
                        toPick = getTileFromEntity(0, -1);
                        break;
                    case Directions.DOWN:
                        toPick = getTileFromEntity(0, 1);
                        break;
                    case Directions.LEFT:
                        toPick = getTileFromEntity(-1, 0);
                        break;
                    case Directions.RIGHT:
                        toPick = getTileFromEntity(1, 0);
                }
                ((Plumber) entity).pickElement(toPick.pickPipeElement());
            }
        }

        if (keyH.ctrlPressed) {
            Tile toPlace = null;
            switch (entity.direction) {
                case Directions.UP:
                    toPlace = getTileFromEntity(0, -1);
                    break;
                case Directions.DOWN:
                    toPlace = getTileFromEntity(0, 1);
                    break;
                case Directions.LEFT:
                    toPlace = getTileFromEntity(-1, 0);
                    break;
                case Directions.RIGHT:
                    toPlace = getTileFromEntity(1, 0);
            }
            toPlace.placePipeElement(((Plumber)(entity)).picked);
            ((Plumber)entity).dropElement();
        }

        if (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {
            entity.Move();
            gp.collisionChecker.checkEntityEntity(entity, gp.saboteur.entity);
            gp.collisionChecker.checktile(entity);
        }
    }
}