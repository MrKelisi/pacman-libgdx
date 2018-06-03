package net.feragon.pacman.input;

import com.badlogic.gdx.Gdx;

import net.feragon.pacman.PacmanGDX;
import net.feragon.pacman.model.Direction;
import net.feragon.pacman.model.Pacman;

public class PacmanMouseInputProcessor extends PacmanInputProcessor {
	public PacmanMouseInputProcessor(Pacman pacman, PacmanGDX game) {
		super(pacman, game);
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		if(super.touchDown(screenX, screenY, pointer, button)) {
			return true;
		}
		
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
}
