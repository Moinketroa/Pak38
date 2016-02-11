package fr.univ_lorraine.pacman.view;


import com.badlogic.gdx.math.Vector2;

import fr.univ_lorraine.pacman.model.BoundingBox;
import fr.univ_lorraine.pacman.model.Direction;

/**
 * Created by debicki3u on 05/02/16.
 */
public class BoundingBoxFactory {

    private static BoundingBoxFactory instance = new BoundingBoxFactory();

    public static BoundingBoxFactory getInstance(){ return instance; }


    public BoundingBox getBBBlock(Vector2 v){
        return new BoundingBox(v.x, v.y, (float)0.80, (float)0.80);
    }

    public BoundingBox getBBGhost(Vector2 v){
        return new BoundingBox(v.x, v.y, (float)0.90, (float)0.90);
    }

    public BoundingBox getBBPak38(Vector2 v, Direction d){
        return new BoundingBox(v.x, v.y, (float)0.90, (float)0.90);
    }

    public BoundingBox getBBSuperPellet(Vector2 v){
        return new BoundingBox(v.x, v.y, (float)0.75, (float)0.75);
    }

    public BoundingBox getBBPellet(Vector2 v){
        return new BoundingBox(v.x, v.y, (float)0.25, (float)0.25);
    }
}
