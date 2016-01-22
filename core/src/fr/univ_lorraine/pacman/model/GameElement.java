package fr.univ_lorraine.pacman.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by debicki3u on 22/01/16.
 */
public abstract class GameElement {

    private Vector2 position;
    private int width;
    private int height;

    public GameElement(Vector2 pos, World monde){

    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public Vector2 getPosition(){
        return position;
    }

    public abstract Texture getTexture();
}
