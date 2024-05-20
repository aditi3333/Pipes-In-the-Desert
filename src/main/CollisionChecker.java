package main;

import Entity.Entity;
import Tile.Tile;

import java.awt.*;

public class CollisionChecker {
    GamePanel gp;

    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
    }

    public void checktile(Entity entity) {

        int entityLeftX = entity.solidarea.x;
        int entityRightX = entity.solidarea.x + entity.solidarea.width;
        int entityTopY = entity.solidarea.y;
        int entityBottomY = entity.solidarea.y + entity.solidarea.height;

        int entityleftcol = entityLeftX / gp.tileSize;
        int entityrightcol = entityRightX / gp.tileSize;
        int entitytoprow = entityTopY / gp.tileSize;
        int entitybottomrow = entityBottomY / gp.tileSize;

        Tile tile1;
        Tile tile2;

        switch (entity.direction) {
            case Directions.UP:
                entitytoprow = (entityTopY - entity.speed) / gp.tileSize;
                tile1 = gp.tileManager.tile[entityleftcol][entitytoprow];
                tile2 = gp.tileManager.tile[entityrightcol][entitytoprow];
                if (tile1.collision || tile2.collision) {
                    entity.collisionOn = true;
                }
                break;
            case Directions.DOWN:
                entitybottomrow = (entityBottomY + entity.speed) / gp.tileSize;
                tile1 = gp.tileManager.tile[entityleftcol][entitybottomrow];
                tile2 = gp.tileManager.tile[entityrightcol][entitybottomrow];
                if (tile1.collision || tile2.collision) {
                    entity.collisionOn = true;
                }
                break;
            case Directions.LEFT:
                entityleftcol = (entityLeftX - entity.speed) / gp.tileSize;
                tile2 = gp.tileManager.tile[entityleftcol][entitytoprow];
                tile1 = gp.tileManager.tile[entityleftcol][entitybottomrow];
                if (tile1.collision || tile2.collision) {
                    entity.collisionOn = true;
                }
                break;
            case Directions.RIGHT:
                entityrightcol = (entityRightX + entity.speed) / gp.tileSize;
                tile1 = gp.tileManager.tile[entityrightcol][entitytoprow];
                tile2 = gp.tileManager.tile[entityrightcol][entitybottomrow];
                if (tile1.collision || tile2.collision) {
                    entity.collisionOn = true;
                }
                break;

        }
    }

    public boolean checkEntityEntity(Entity entity1, Entity entity2)
    {
        boolean flag = false;
        Rectangle solidareaE1;
        Rectangle solidareaE2;
        if (entity1 != null) {
            solidareaE1 = new Rectangle(entity1.solidarea);
            solidareaE2 = new Rectangle(entity2.solidarea);

            switch (entity1.direction) {
                case Directions.UP:
                    solidareaE1.y -= entity1.speed;
                    break;
                case Directions.DOWN:
                    solidareaE1.y += entity1.speed;
                    break;
                case Directions.LEFT:
                    solidareaE1.x -= entity1.speed;
                    break;
                case Directions.RIGHT:
                    solidareaE1.x += entity1.speed;
                    break;
            }

            switch (entity2.direction) {
                case Directions.UP:
                    solidareaE2.y -= entity2.speed;
                    break;
                case Directions.DOWN:
                    solidareaE2.y += entity2.speed;
                    break;
                case Directions.LEFT:
                    solidareaE2.x -= entity2.speed;
                    break;
                case Directions.RIGHT:
                    solidareaE2.x += entity2.speed;
                    break;
            }

            if (entity1.solidarea.intersects(entity2.solidarea)) {
                if (entity1.collision || entity2.collision) {
                    switch(entity1.direction)
                    {
                        case Directions.UP:
                            entity1.solidarea.y = entity2.solidarea.y + entity1.solidarea.height;
                            break;
                        case Directions.DOWN:
                            entity1.solidarea.y = entity2.solidarea.y - entity1.solidarea.height;
                            break;
                        case Directions.LEFT:
                            entity1.solidarea.x = entity2.solidarea.x + entity1.solidarea.width;
                            break;
                        case Directions.RIGHT:
                            entity1.solidarea.x = entity2.solidarea.x - entity1.solidarea.width;
                            break;
                    }
                    entity1.collisionOn = true;
                    flag = true;
                }
            }
        }
        return flag;
    }

//    public int checkObject(Entity entity, boolean player) {
//        int index = 999;
//
//        for (int i = 0; i < gp.obj_coins.length; i++) {
//            if (gp.obj_coins[i] != null) {
//                entity.solidarea.x = entity.x + entity.solidarea.x;
//                entity.solidarea.y = entity.y + entity.solidarea.y;
//
//                gp.obj_coins[i].solidarea.x = gp.obj_coins[i].worldx + gp.obj_coins[i].solidarea.x;
//                gp.obj_coins[i].solidarea.y = gp.obj_coins[i].worldy + gp.obj_coins[i].solidarea.y;
//
//                switch (entity.direction) {
//                    case "up":
//                        entity.solidarea.y -= entity.speed;
//                        if (entity.solidarea.intersects(gp.obj_coins[i].solidarea)) {
//                            if (gp.obj_coins[i].collision) {
//                                entity.collisionon = true;
//                            }
//                            if (player) {
//                                index = i;
//                            }
//                        }
//                        break;
//                    case "down":
//                        entity.solidarea.y += entity.speed;
//                        if (entity.solidarea.intersects(gp.obj_coins[i].solidarea)) {
//                            if (gp.obj_coins[i].collision) {
//                                entity.collisionon = true;
//                            }
//                            if (player) {
//                                index = i;
//                            }
//                        }
//                        break;
//                    case "left":
//                        entity.solidarea.x -= entity.speed;
//                        if (entity.solidarea.intersects(gp.obj_coins[i].solidarea)) {
//                            if (gp.obj_coins[i].collision) {
//                                entity.collisionon = true;
//                            }
//                            if (player) {
//                                index = i;
//                            }
//                        }
//                        break;
//                    case "right":
//                        entity.solidarea.x += entity.speed;
//                        if (entity.solidarea.intersects(gp.obj_coins[i].solidarea)) {
//                            if (gp.obj_coins[i].collision) {
//                                entity.collisionon = true;
//                            }
//                            if (player) {
//                                index = i;
//                            }
//                        }
//                        break;
//                }
//                entity.solidarea.x = entity.solidareadefaultX;
//                entity.solidarea.y = entity.solidareadefaultY;
//                gp.obj_coins[i].solidarea.x = gp.obj_coins[i].solidareadefaultX;
//                gp.obj_coins[i].solidarea.y = gp.obj_coins[i].solidareadefaultY;
//            }
//
//        }
//
//        return index;
//    }

}