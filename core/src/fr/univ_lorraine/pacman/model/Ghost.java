package fr.univ_lorraine.pacman.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import fr.univ_lorraine.pacman.view.BoundingBoxFactory;
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
        sto = State.HUNTING;
        speed = (float) .0012;
    }

    @Override
    public TextureRegion getTexture() {
        return TextureFactory.getInstance().getTextureGhost(num, this);
    }

    @Override
    public BoundingBox getBoundingBox() { return BoundingBoxFactory.getInstance().getBBGhost(getPosition()); }

}
