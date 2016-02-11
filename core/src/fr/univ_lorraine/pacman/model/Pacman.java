package fr.univ_lorraine.pacman.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import fr.univ_lorraine.pacman.view.BoundingBoxFactory;
import fr.univ_lorraine.pacman.view.TextureFactory;

/**
 * Created by debicki3u on 22/01/16.
 */
public class Pacman extends GameMoveableElement {

    public static float TIME_OF_SUPER_PELLET = 70000;

    private float timeofSuper;

    public Pacman(Vector2 pos, World w){
        super(pos, w);

        timeofSuper = 0;

        isMoving = true;
        dir = Direction.LEFT;
        sto = State.HAUNTED;
        speed = (float) .0012;
    }

    public void manageCollision(GameElement ge) {
        if (hasCollision(ge)){
            String s = ge.getClass().getSimpleName();
            if (s.equals("Block")) {
                switch(dir){
                    case UP:
                        setY(ge.getY() - 1 - (float)0.01);
                        break;
                    case DOWN:
                        setY(ge.getY() + 1 + (float)0.01);
                        break;
                    case LEFT:
                        setX(ge.getX() + 1 + (float)0.01);
                        break;
                    case RIGHT:
                        setX(ge.getX() - 1 - (float)0.01);
                        break;
                }
            } else if (s.equals("Pellet")) {
                w.destroy(ge);
                w.incrScore(10);
            } else if (s.equals("SuperPellet")) {
                w.destroy(ge);
                w.incrScore(50);
                this.sto = State.HUNTING;
                this.setTimeofSuper(TIME_OF_SUPER_PELLET);
                w.setGhostsState(State.HAUNTED);
            }

        }
    }

    public void manageCollision(Ghost g){

        if (hasCollision(g)){
            switch (g.sto){
                case HAUNTED:
                    g.setState(State.DEAD);
                    switch(w.nbDeadGhost()) {
                        case 1:
                            w.incrScore(200);
                            break;
                        case 2:
                            w.incrScore(400);
                            break;
                        case 3:
                            w.incrScore(800);
                            break;
                        case 4:
                            w.incrScore(1600);
                            break;
                    }
                    break;
                case HUNTING:
                    setState(State.DEAD);
                    break;
                case DEAD:
                    break;
            }
        }
    }

    public void update(float delta){
        super.update(delta);

        switch (sto){
            case HAUNTED:
                break;
            case HUNTING:
                if (timeofSuper < 0) {
                    sto = State.HAUNTED;
                    w.setGhostsState(State.HUNTING);
                }else {
                    timeofSuper -= delta;
                }
                break;
            case DEAD:
                //fin de jeu
                break;
        }

    }

    public TextureRegion getTexture(){
        return TextureFactory.getInstance().getTexturePacMan(this);
    }

    public BoundingBox getBoundingBox() { return BoundingBoxFactory.getInstance().getBBPak38(getPosition(), dir);}

    public void setTimeofSuper(float f){
        timeofSuper = f;
    }
}
