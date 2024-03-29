package net.feragon.pacman.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import net.feragon.pacman.PacmanGDX;
import net.feragon.pacman.model.Direction;
import net.feragon.pacman.model.Pacman;

public class PacmanInputProcessor implements InputProcessor {
	protected Pacman pacman;
	private PacmanGDX game;
	
	/**
	 * InputProcessor pour le jeu
	 * @param pacman
	 * @param gameMode
	 * @param game
	 */
	public PacmanInputProcessor(Pacman pacman, PacmanGDX game) {
		if(pacman == null) {
			throw new NullPointerException("Pacman null");
		}
		
		this.pacman = pacman;
		this.game = game;
	}
	
	@Override
	public boolean keyDown(int keycode) {
		if(keycode == Input.Keys.ESCAPE) {
			game.setUpTitleScreen();
			return true;
		}

		return false;
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
