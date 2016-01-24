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
        cam = new OrthographicCamera(128, 128);
        fvp = new FitViewport(wrld.getWidth() * ppux, wrld.getHeight() * ppuy, cam);
        cam.position.set(128, 128, 0);
        cam.update();
    }

    public void render (float delta) {
        fpsl.log();
        cam.update();
        batch.setProjectionMatrix(cam.combined);
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();

        int size = 15;

        for (int lig = 0; lig < wrld.getHeight(); lig++){
            for (int col = 0; col < wrld.getWidth(); col++){

                GameElement currentGE = wrld.getGE(lig, col);

                if (currentGE != null)
                    currentGE.draw(batch, ppux, ppuy);

            }
        }

        wrld.getPak38().draw(batch, ppux, ppuy);

        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        fvp.update(width, height);
    }
}
