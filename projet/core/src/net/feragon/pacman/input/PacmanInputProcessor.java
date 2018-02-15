package net.feragon.pacman.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

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
			case 19:
				pacman.setPosition(pacman.getPosition().add(0, 1));
				break;
			
			case 20:
				pacman.setPosition(pacman.getPosition().add(0, -1));
				break;
			
			case 21:
				pacman.setPosition(pacman.getPosition().add(-1, 0));
				break;
				
			case 22:
				pacman.setPosition(pacman.getPosition().add(1, 0));
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
		
		System.out.println(screenX);
		System.out.println(screenY);
		
		if(screenY > Math.abs(screenX)) {
			pacman.setPosition(pacman.getPosition().add(0, -1));
		}
		else if(screenY < -Math.abs(screenX)) {
			pacman.setPosition(pacman.getPosition().add(0, 1));
		}
		else if(screenX < Math.abs(screenY)) {
			pacman.setPosition(pacman.getPosition().add(-1, 0));
		}
		else {
			pacman.setPosition(pacman.getPosition().add(1, 0));
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
