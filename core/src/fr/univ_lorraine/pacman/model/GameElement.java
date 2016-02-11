package fr.univ_lorraine.pacman.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import java.util.logging.Logger;

/**
 * Created by debicki3u on 22/01/16.
 */
public abstract class GameElement {

    private Vector2 position;
    private int width;
    private int height;

    protected World w;

    int ppux = 48;
    int ppuy = 48;

    public GameElement(Vector2 pos, World monde){
        position = pos;
        width = 1;
        height = 1;

        w = monde;
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

    public float getX(){
        return position.x;
    }

    public float getY(){
        return position.y;
    }

    public void setX(float x){
        position.x = x;
    }

    public void setY(float y){
        position.y = y;
    }

    public void draw(SpriteBatch spb, int sizex, int sizey){
        spb.draw(this.getTexture(), position.x * sizex, position.y * sizey, getWidth() * sizex, getHeight() * sizey);
    }

    public abstract TextureRegion getTexture();

    public abstract BoundingBox getBoundingBox();

    public boolean hasCollision(GameElement ge){
        return this.getBoundingBox().overlaps(ge.getBoundingBox());
    }
}
