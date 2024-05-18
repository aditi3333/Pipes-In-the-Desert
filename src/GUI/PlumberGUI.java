package GUI;

import Entity.Plumber;
import main.KeyHandler;
import main.GamePanel;
import main.Directions;


public class PlumberGUI extends EntityGUI {
    KeyHandler keyH;

    public PlumberGUI(GamePanel gp, KeyHandler keyH) {
        super(gp, "/main/res/plumber.png");
        this.keyH = keyH;
        entity = new Plumber();
    }

    @Override
    public void update() {
        if (keyH.upPressed) {
            entity.Move(Directions.UP);
        } else if (keyH.downPressed) {
            entity.Move(Directions.DOWN);
        } else if (keyH.leftPressed) {
            entity.Move(Directions.LEFT);
        } else if (keyH.rightPressed) {
            entity.Move(Directions.RIGHT);
        }
    }
}