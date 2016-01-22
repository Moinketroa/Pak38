package fr.univ_lorraine.pacman;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import fr.univ_lorraine.pacman.view.GameScreen;
import fr.univ_lorraine.pacman.view.SplashScreen;

public class Pak38 extends Game {

	@Override
	public void create() {
		setScreen(new SplashScreen(this));
	}

	public void render(){
		this.screen.render(100);
	}

}
