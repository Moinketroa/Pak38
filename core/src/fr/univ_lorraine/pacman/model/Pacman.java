package fr.univ_lorraine.pacman.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import fr.univ_lorraine.pacman.view.BoundingBoxFactory;
import fr.univ_lorraine.pacman.view.TextureFactory;

/**
 * Created by debicki3u on 22/01/16.
 */
public class Pacman extends GameMoveableElement {



    public Pacman(Vector2 pos, World w){
        super(pos, w);

        isMoving = false;
        dir = Direction.LEFT;
        sto = State.HAUNTED;
        speed = (float) .0012;
    }

    public void manageCollision(GameElement ge) {
        if (hasCollision(ge)){
            String s = ge.getClass().getSimpleName();
            if (s.equals("Block")) {

            } else if (s.equals("Ghost")) {

            } else if (s.equals("Pellet")) {
                w.destroy(ge);
            } else if (s.equals("SuperPellet")) {
                w.destroy(ge);
                this.sto = State.HUNTING;
            }

        }
    }

    public Texture getTexture(){
        return TextureFactory.getInstance().getTexturePacMan(this.dir);
    }

    public BoundingBox getBoundingBox() { return BoundingBoxFactory.getInstance().getBBPak38(getPosition(), dir);}


}
