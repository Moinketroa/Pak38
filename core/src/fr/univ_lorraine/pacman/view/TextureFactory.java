package fr.univ_lorraine.pacman.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import fr.univ_lorraine.pacman.model.Direction;

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
    private Texture pacmanRight = new Texture("image/pacmanRight.png");
    private Texture pacmanUp = new Texture("image/pacmanUp.png");
    private Texture pacmanDown = new Texture("image/pacmanDown.png");

    private Texture pellet = new Texture("image/pellet.png");
    private Texture pelletSuper = new Texture("image/superPellet.png");

    private Texture ghost1 = new Texture("image/ghost1.png");
    private Texture ghost2 = new Texture("image/ghost2.png");
    private Texture ghost3 = new Texture("image/ghost3.png");
    private Texture ghost4 = new Texture("image/ghost4.png");


    public Texture getTextureBlock(){
        return block;
    }

    public Texture getTexturePellet() { return pellet; }

    public Texture getTextureSuperPellet() { return pelletSuper; }

    public Texture getTextureGhost(int whichOne){
        switch (whichOne){
            case 1:
                return ghost1;
            case 2:
                return ghost2;
            case 3:
                return ghost3;
            case 4:
                return ghost4;
            default:
                return null;
        }
    }

    public Texture getTexturePacMan(Direction dir){
        switch (dir){
            case UP:
                return pacmanUp;
            case DOWN:
                return pacmanDown;
            case LEFT:
                return pacmanLeft;
            case RIGHT:
                return pacmanRight;
            default:
                return null;
        }
    }
}
