package fr.univ_lorraine.pacman.controller;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

import fr.univ_lorraine.pacman.model.Pacman;
import fr.univ_lorraine.pacman.model.State;

/**
 * Created by J-M on 31/01/2016.
 */
public class GameListener implements InputProcessor{

    protected Pacman pak;

    public GameListener(Pacman pc){
        pak = pc;
    }

    @Override
    public boolean keyDown(int keycode) {

        if (pak.getState() != State.DEAD) {
            switch (keycode) {
                case Input.Keys.LEFT:
                    pak.turnLeft();
                    break;
                case Input.Keys.RIGHT:
                    pak.turnRight();
                    break;
                case Input.Keys.DOWN:
                    pak.turnDown();
                    break;
                case Input.Keys.UP:
                    pak.turnUp();
                    break;
            }
        }

        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        pak.stop();

        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
