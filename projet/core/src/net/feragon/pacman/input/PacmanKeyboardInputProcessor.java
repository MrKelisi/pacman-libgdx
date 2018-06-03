package net.feragon.pacman.input;

import com.badlogic.gdx.Input;

import net.feragon.pacman.PacmanGDX;
import net.feragon.pacman.model.Direction;
import net.feragon.pacman.model.Pacman;

public class PacmanKeyboardInputProcessor extends PacmanInputProcessor {
	public PacmanKeyboardInputProcessor(Pacman pacman, PacmanGDX game) {
		super(pacman, game);
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		if(super.keyDown(keycode)) {
			return true;
		}
		
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

	
}
