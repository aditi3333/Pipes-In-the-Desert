package GUI;

import Entity.Plumber;
import main.KeyHandler;
import main.GamePanel;
import main.Directions;


public class SaboteurGUI extends EntityGUI {
    GamePanel gp;
    KeyHandler keyH;

    public SaboteurGUI(GamePanel gp, KeyHandler keyH) {
        super(gp, "/main/res/saboteur.png");
        this.gp = gp;
        this.keyH = keyH;
        entity = new Plumber();
    }

    @Override
    public void update() {
        if (keyH.wPressed) {
            entity.Move(Directions.UP);
        } else if (keyH.sPressed) {
            entity.Move(Directions.DOWN);
        } else if (keyH.aPressed) {
            entity.Move(Directions.LEFT);
        } else if (keyH.dPressed) {
            entity.Move(Directions.RIGHT);
        }
    }
}