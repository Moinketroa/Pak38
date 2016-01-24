package fr.univ_lorraine.pacman.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by debicki3u on 22/01/16.
 */
public class TextureFactory {

    private static TextureFactory instance = new TextureFactory();

    public static TextureFactory getInstance(){
        return instance;
    }

    private Texture block = new Texture("image/bloc.png");
    private Texture pacmanLeft = new Texture("image/pacmanLeft.png");

    public Texture getTextureBlock(){
        return block;
    }

    public Texture getTexturePacMan(){
        return pacmanLeft;
    }
}
