package fr.univ_lorraine.pacman.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by J-M on 30/01/2016.
 */
public abstract class GameMoveableElement extends GameElement {

    protected float speed;
    protected boolean isMoving;

    protected Direction dir;
    protected State sto;

    public GameMoveableElement(Vector2 pos, World monde){
        super(pos, monde);

        isMoving = false;
    }

    public void stop(){
        isMoving = false;
    }

    public void turnUp(){
        isMoving = true;
        dir = Direction.UP;
    }

    public void turnDown(){
        isMoving = true;
        dir = Direction.DOWN;
    }

    public void turnLeft(){
        isMoving = true;
        dir = Direction.LEFT;
    }

    public void turnRight(){
        isMoving = true;
        dir = Direction.RIGHT;
    }

    public void update(float delta){
        if (this.isMoving){
            float deplacement = speed * delta;

            float x = this.getPosition().x;
            float y = this.getPosition().y;

            switch (dir){
                case UP:
                    this.setPosition(x, y + deplacement);
                    break;
                case DOWN:
                    this.setPosition(x, y - deplacement);
                    break;
                case LEFT:
                    this.setPosition(x - deplacement, y);
                    break;
                case RIGHT:
                    this.setPosition(x + deplacement, y);
                    break;
            }
        }
    }
}
