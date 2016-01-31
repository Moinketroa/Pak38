package fr.univ_lorraine.pacman.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import fr.univ_lorraine.pacman.view.TextureFactory;

/**
 * Created by debicki3u on 22/01/16.
 */
public class Pacman extends GameMoveableElement {

    public Pacman(Vector2 pos, World w){
        super(pos, w);

        isMoving = false;
        dir = Direction.LEFT;
        speed = (float) .0012;
    }

    public Texture getTexture(){
        return TextureFactory.getInstance().getTexturePacMan(this.dir);
    }
}
