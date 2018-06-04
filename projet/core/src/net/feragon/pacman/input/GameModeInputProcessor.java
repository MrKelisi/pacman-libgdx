package net.feragon.pacman.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import net.feragon.pacman.PacmanGDX;

public class GameModeInputProcessor implements InputProcessor {

    private PacmanGDX _game;

    /**
     * InputProcessor pour le menu de selection du mode d'entrée
     * @param game
     */
    public GameModeInputProcessor(PacmanGDX game) {
        _game = game;
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.ESCAPE:
                _game.setUpTitleScreen();
                break;
            case Input.Keys.LEFT:
                _game.setUpGameScreen(true);
                break;
            case Input.Keys.RIGHT:
                _game.setUpGameScreen(false);
                break;

            default:
                return false;
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
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
