package net.feragon.pacman.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import net.feragon.pacman.model.Direction;
import net.feragon.pacman.model.Pacman;

public class PacmanInputProcessor implements InputProcessor {
	private Pacman pacman;
	
	public PacmanInputProcessor(Pacman pacman) {
		if(pacman == null) {
			throw new NullPointerException("Pacman null");
		}
		
		this.pacman = pacman;
	}
	
	@Override
	public boolean keyDown(int keycode) {
		switch (keycode) {
			case Input.Keys.LEFT:
                pacman.setNextDirection(Direction.LEFT);
				break;

            case Input.Keys.UP:
                pacman.setNextDirection(Direction.UP);
                break;

            case Input.Keys.RIGHT:
                pacman.setNextDirection(Direction.RIGHT);
                break;

            case Input.Keys.DOWN:
                pacman.setNextDirection(Direction.DOWN);
                break;
				
			default:
				return false;
		}
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		float halfWidth = Gdx.graphics.getWidth() / 2;
		float halfHeight = Gdx.graphics.getHeight() / 2;
		screenX -= halfWidth;
		screenY -= halfHeight;
		
		if(screenY > Math.abs(screenX)) {
			pacman.setNextDirection(Direction.DOWN);
		}
		else if(screenY < -Math.abs(screenX)) {
			pacman.setNextDirection(Direction.UP);
		}
		else if(screenX < Math.abs(screenY)) {
			pacman.setNextDirection(Direction.LEFT);
		}
		else {
			pacman.setNextDirection(Direction.RIGHT);
		}
		
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
