package fr.univ_lorraine.pacman.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;

import fr.univ_lorraine.pacman.Pak38;
import fr.univ_lorraine.pacman.controller.GameListener;
import fr.univ_lorraine.pacman.model.GameElement;
import fr.univ_lorraine.pacman.model.World;

/**
 * Created by debicki3u on 22/01/16.
 */

public class GameScreen extends ScreenAdapter {

    Pak38 mod;
    SpriteBatch batch;
    FPSLogger fpsl;
    World wrld;
    FitViewport fvp;
    OrthographicCamera cam;

    int ppux = 48;
    int ppuy = 48;

    public GameScreen(Pak38 pc){
        mod = pc;

        fpsl = new FPSLogger();
        batch = new SpriteBatch();
        wrld = new World();
        Gdx.input.setInputProcessor(new GameListener(wrld.getPak38()));

        cam = new OrthographicCamera();
        fvp = new FitViewport(wrld.getWidth() * ppux,
                              wrld.getHeight() * ppuy,
                              cam);
        cam.position.set(wrld.getWidth() * ppux / 2F,
                         wrld.getHeight() * ppuy / 2F,
                         0);
        cam.update();
    }

    public void render (float delta) {
        fpsl.log();
        cam.update();
        batch.setProjectionMatrix(cam.combined);
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();

        for (int lig = 0; lig < wrld.getHeight(); lig++){
            for (int col = 0; col < wrld.getWidth(); col++){

                GameElement currentGE = wrld.getGE(lig, col);

                if (currentGE != null) {
                    currentGE.draw(batch, ppux, ppuy);
                    wrld.getPak38().manageCollision(currentGE);
                }
                    //batch.draw(currentGE.getTexture(),col*ppux,lig*ppuy, currentGE.getWidth()*ppux, currentGE.getHeight()*ppuy);

            }
        }

        for (int i = 0; i < 4; i++){
            wrld.getGhost(i).update(delta);
            wrld.getGhost(i).draw(batch, ppux, ppuy);
            wrld.getPak38().manageCollision(wrld.getGhost(i));
        }

        wrld.getPak38().update(delta);
        wrld.getPak38().draw(batch, ppux, ppuy);

        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        fvp.update(width, height);
    }
}
