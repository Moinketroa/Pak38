package fr.univ_lorraine.pacman.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import fr.univ_lorraine.pacman.Pak38;

/**
 * Created by debicki3u on 22/01/16.
 */

public class GameScreen extends ScreenAdapter {

    Pak38 mod;
    SpriteBatch batch;
    Texture img;
    FPSLogger fpsl;

    public GameScreen(Pak38 pc){
        mod = pc;
        fpsl = new FPSLogger();
        batch = new SpriteBatch();
        img = new Texture("image/badlogic.jpg");
    }

    public void render (float delta) {
        fpsl.log();
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, 0, 0);
        batch.end();
    }

}
