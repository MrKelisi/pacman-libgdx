package net.feragon.pacman;

import com.badlogic.gdx.ApplicationAdapter;
import net.feragon.pacman.screens.GameScreen;

public class PacmanGDX extends ApplicationAdapter {
	private GameScreen gs;
	
	public PacmanGDX() {
		
	}

	@Override
	public void create () {
		gs = new GameScreen();
	}

	@Override
	public void render () {
		gs.render(0);
	}
	
	@Override
	public void dispose () {
		gs.dispose();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		
		gs.resize(width, height);
	}

	@Override
	public void pause() {
		super.pause();
		
		gs.pause();
	}

	@Override
	public void resume() {
		super.resume();
		
		gs.resume();
	}
	
	
}
