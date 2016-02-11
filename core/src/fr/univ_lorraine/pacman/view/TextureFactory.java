package fr.univ_lorraine.pacman.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Animation;

import fr.univ_lorraine.pacman.model.Direction;
import fr.univ_lorraine.pacman.model.Ghost;
import fr.univ_lorraine.pacman.model.Pacman;
import fr.univ_lorraine.pacman.model.State;

/**
 * Created by debicki3u on 22/01/16.
 */
public class TextureFactory {

    private static TextureFactory instance = new TextureFactory();
    public static TextureFactory getInstance(){
        return instance;
    }

    private TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("image/pack.atlas"));

    private static final float WALKING_FRAME_DURATION = (float)0.07999;


    private TextureRegion block = atlas.findRegion("bloc");

    private TextureRegion pellet = atlas.findRegion("pellet");
    private TextureRegion pelletSuper = atlas.findRegion("superPellet");

    private TextureRegion ghost1 = atlas.findRegion("ghost1");
    private TextureRegion ghost2 = atlas.findRegion("ghost2");
    private TextureRegion ghost3 = atlas.findRegion("ghost3");
    private TextureRegion ghost4 = atlas.findRegion("ghost4");

    private TextureRegion ghostDead = atlas.findRegion("ghostDead");

    private Animation walkLeftAnimation;
    private Animation walkRightAnimation;
    private Animation walkUpAnimation;
    private Animation walkDownAnimation;
    private Animation ghostHauntedAnimation;

    public TextureFactory(){
        TextureRegion[] walkLeftFrames = new TextureRegion[4];
        TextureRegion[] walkRightFrames = new TextureRegion[4];
        TextureRegion[] walkUpFrames = new TextureRegion[4];
        TextureRegion[] walkDownFrames = new TextureRegion[4];
        TextureRegion[] ghostHauntedFrames = new TextureRegion[2];

        walkLeftFrames[0] = atlas.findRegion("pacmanLeft");
        walkLeftFrames[1] = atlas.findRegion("pacmanLeft-2");
        walkLeftFrames[2] = atlas.findRegion("pacmanLeft");
        walkLeftFrames[3] = atlas.findRegion("pacman-3");

        walkRightFrames[0] = atlas.findRegion("pacmanRight");
        walkRightFrames[1] = atlas.findRegion("pacmanRight-2");
        walkRightFrames[2] = atlas.findRegion("pacmanRight");
        walkRightFrames[3] = atlas.findRegion("pacman-3");

        walkUpFrames[0] = atlas.findRegion("pacmanUp");
        walkUpFrames[1] = atlas.findRegion("pacmanUp-2");
        walkUpFrames[2] = atlas.findRegion("pacmanUp");
        walkUpFrames[3] = atlas.findRegion("pacman-3");

        walkDownFrames[0] = atlas.findRegion("pacmanDown");
        walkDownFrames[1] = atlas.findRegion("pacmanDown-2");
        walkDownFrames[2] = atlas.findRegion("pacmanDown");
        walkDownFrames[3] = atlas.findRegion("pacman-3");

        ghostHauntedFrames[0] = atlas.findRegion("ghostHunted");
        ghostHauntedFrames[1] = atlas.findRegion("ghostHuntedEnd");

        walkLeftAnimation = new Animation(WALKING_FRAME_DURATION, walkLeftFrames);
        walkRightAnimation = new Animation(WALKING_FRAME_DURATION, walkRightFrames);
        walkUpAnimation = new Animation(WALKING_FRAME_DURATION, walkUpFrames);
        walkDownAnimation = new Animation(WALKING_FRAME_DURATION, walkDownFrames);
        ghostHauntedAnimation = new Animation(WALKING_FRAME_DURATION, ghostHauntedFrames);
    }

    public TextureRegion getTextureBlock(){
        return block;
    }

    public TextureRegion getTexturePellet() { return pellet; }

    public TextureRegion getTextureSuperPellet() { return pelletSuper; }

    public TextureRegion getTextureGhost(int whichOne, Ghost g){

        switch (g.getState()) {
            case DEAD:
                return ghostDead;
            case HAUNTED:
                return ghostHauntedAnimation.getKeyFrame(g.getStateTime(), true);
            case HUNTING:
                switch (whichOne) {
                    case 1:
                        return ghost1;
                    case 2:
                        return ghost2;
                    case 3:
                        return ghost3;
                    case 4:
                        return ghost4;
                }
                break;
        }
        return null;
    }

    public TextureRegion getTexturePacMan(Pacman pc){
        switch (pc.getDir()){
            case UP:
                return walkUpAnimation.getKeyFrame(pc.getStateTime(), true);
            case DOWN:
                return walkDownAnimation.getKeyFrame(pc.getStateTime(), true);
            case LEFT:
                return walkLeftAnimation.getKeyFrame(pc.getStateTime(), true);
            case RIGHT:
                return walkRightAnimation.getKeyFrame(pc.getStateTime(), true);
            default:
                return null;
        }
    }
}
