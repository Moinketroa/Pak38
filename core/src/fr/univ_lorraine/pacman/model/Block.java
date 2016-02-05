package fr.univ_lorraine.pacman.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import fr.univ_lorraine.pacman.view.BoundingBoxFactory;
import fr.univ_lorraine.pacman.view.TextureFactory;

/**
 * Created by debicki3u on 22/01/16.
 */
public class Block extends GameElement{

    public Block(Vector2 pos, World w){
        super(pos, w);
    }

    public Texture getTexture(){
        return TextureFactory.getInstance().getTextureBlock();
    }

    public BoundingBox getBoundingBox() { return BoundingBoxFactory.getInstance().getBBBlock(getPosition()); }

}
