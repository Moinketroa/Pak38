package fr.univ_lorraine.pacman.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import fr.univ_lorraine.pacman.view.BoundingBoxFactory;
import fr.univ_lorraine.pacman.view.TextureFactory;

/**
 * Created by J-M on 31/01/2016.
 */
public class SuperPellet extends GameElement {

    public SuperPellet(Vector2 p, World w){
        super(p, w);
    }

    @Override
    public Texture getTexture() {
        return TextureFactory.getInstance().getTextureSuperPellet();
    }

    public BoundingBox getBoundingBox() { return BoundingBoxFactory.getInstance().getBBSuperPellet(getPosition()); }

}
