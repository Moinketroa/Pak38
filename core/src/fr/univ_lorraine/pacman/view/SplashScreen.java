package fr.univ_lorraine.pacman.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import fr.univ_lorraine.pacman.Pak38;

/**
 * Created by debicki3u on 22/01/16.
 */
public class SplashScreen extends ScreenAdapter {

    private long startTime;
    private SpriteBatch spb;
    private Texture img;

    private Pak38 mod;

    public SplashScreen(Pak38 pc){
        mod = pc;
        startTime = System.currentTimeMillis();
        spb = new SpriteBatch();
        img = new Texture("image/logo_UL_DI.jpg");
    }

    public void render (float delta) {

        if (System.currentTimeMillis() - startTime >= 1000){
            mod.setScreen(new GameScreen(mod));
        } else {
            Gdx.gl.glClearColor(1, 0, 0, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            spb.begin();
            spb.draw(img, 0, 0);
            spb.end();
        }
    }

}
