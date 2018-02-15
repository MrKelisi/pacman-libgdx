package net.feragon.pacman;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;

import net.feragon.pacman.input.PacmanInputProcessor;
import net.feragon.pacman.screens.GameScreen;

public class PacmanGDX extends ApplicationAdapter {
	private GameScreen gs;
	private InputMultiplexer indexMultiplexer;
	
	public PacmanGDX() {
		indexMultiplexer = new InputMultiplexer();
	}

	@Override
	public void create () {
		gs = new GameScreen();
		indexMultiplexer.addProcessor(new PacmanInputProcessor(gs.getWorld().getMaze().getPacman()));
		Gdx.input.setInputProcessor(indexMultiplexer);
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
