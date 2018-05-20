package net.feragon.pacman;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;

import net.feragon.pacman.input.PacmanInputProcessor;
import net.feragon.pacman.input.TitleInputProcessor;
import net.feragon.pacman.screens.GameScreen;
import net.feragon.pacman.screens.TitleScreen;

public class PacmanGDX extends Game {

	private InputMultiplexer indexMultiplexer;
	
	public PacmanGDX() {
		indexMultiplexer = new InputMultiplexer();
	}


	public void setUpTitleScreen() {
		if(this.screen != null)
			this.getScreen().dispose();
		this.setScreen(new TitleScreen(this));

		indexMultiplexer.clear();
		//indexMultiplexer.addProcessor(new TitleInputProcessor(this));
		//Gdx.input.setInputProcessor(indexMultiplexer);
	}

	public void setUpGameScreen() {
		if(this.screen != null)
			this.getScreen().dispose();
		this.setScreen(new GameScreen(this));

		GameScreen gs = (GameScreen) this.getScreen();
		indexMultiplexer.clear();
		indexMultiplexer.addProcessor(new PacmanInputProcessor(gs.getWorld().getMaze().getPacman(), this));
		Gdx.input.setInputProcessor(indexMultiplexer);
	}

	@Override
	public void create () {
		setUpTitleScreen();
	}

	@Override
	public void render () {
		super.render();

	}
	
	@Override
	public void dispose () {
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);

	}

	@Override
	public void pause() {
		super.pause();

	}

	@Override
	public void resume() {
		super.resume();

	}
	
	
}
