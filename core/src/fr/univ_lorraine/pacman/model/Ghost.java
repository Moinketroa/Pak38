package fr.univ_lorraine.pacman.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import fr.univ_lorraine.pacman.view.TextureFactory;

/**
 * Created by J-M on 31/01/2016.
 */
public class Ghost extends GameMoveableElement {

    int num;

    public Ghost(Vector2 p, World w, int whichOne){
        super(p, w);

        num = whichOne;

        isMoving = false;
        dir = Direction.LEFT;
        speed = (float) .0012;
    }

    @Override
    public Texture getTexture() {
        return TextureFactory.getInstance().getTextureGhost(num);
    }
}
