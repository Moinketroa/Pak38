package fr.univ_lorraine.pacman.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by debicki3u on 22/01/16.
 */
public abstract class GameElement {

    private Vector2 position;
    private int width;
    private int height;

    int ppux = 48;
    int ppuy = 48;

    public GameElement(Vector2 pos, World monde){
        position = pos;
        width = 1;
        height = 1;
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

    public void setPosition(float x, float y){
        position.set(x, y);
    }

    public void draw(SpriteBatch spb, int sizex, int sizey){
        spb.draw(this.getTexture(), position.x * sizex, position.y * sizey, getWidth() * sizex, getHeight() * sizey);
    }

    public abstract Texture getTexture();
}
