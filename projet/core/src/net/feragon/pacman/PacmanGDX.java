package net.feragon.pacman;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;

import net.feragon.pacman.input.GameModeInputProcessor;
import net.feragon.pacman.input.PacmanInputProcessor;
import net.feragon.pacman.input.MenuInputProcessor;
import net.feragon.pacman.screens.EndScreen;
import net.feragon.pacman.screens.GameScreen;
import net.feragon.pacman.screens.PlayModeScreen;
import net.feragon.pacman.screens.TitleScreen;

public class PacmanGDX extends Game {

	private InputMultiplexer indexMultiplexer;
	
	public PacmanGDX() {
		indexMultiplexer = new InputMultiplexer();
	}

	/**
	 * Change le Screen actuel pour celui du menu
	 */
	public void setUpTitleScreen() {
		if(this.screen != null) {
			this.getScreen().dispose();
		}
		TitleScreen ts = new TitleScreen(this);
		this.setScreen(ts);

		indexMultiplexer.clear();
		indexMultiplexer.addProcessor(ts.getStage());
		indexMultiplexer.addProcessor(new MenuInputProcessor(this));
		Gdx.input.setInputProcessor(indexMultiplexer);

	}

	/**
	 * Change le Screen actuel pour celui du jeu
	 * @param gameMode Mode d'entrée pour le jeu
	 */
	public void setUpGameScreen(char gameMode) {
		if(this.screen != null) {
			this.getScreen().dispose();
		}
		GameScreen gs = new GameScreen(this);
		this.setScreen(gs);

		indexMultiplexer.clear();
		indexMultiplexer.addProcessor(new PacmanInputProcessor(gs.getWorld().getMaze().getPacman(), gameMode, this));
		Gdx.input.setInputProcessor(indexMultiplexer);
	}

	/**
	 * Change le Screen actuel pour celui de fin
	 * @param message Message de fin
	 */
	public void setUpEndScreen(String message) {
		if(this.screen != null) {
			this.getScreen().dispose();
		}
		EndScreen es = new EndScreen(this, message);
		this.setScreen(es);

		indexMultiplexer.clear();
		indexMultiplexer.addProcessor(es.getStage());
		indexMultiplexer.addProcessor(new MenuInputProcessor(this));
		Gdx.input.setInputProcessor(indexMultiplexer);

	}

	/**
	 * Change le Screen actuel pour celui de selection du mode d'entrée
	 */
	public void setUpPlayModeScreen() {
		if(this.screen != null) {
			this.getScreen().dispose();
		}
		PlayModeScreen pms = new PlayModeScreen(this);
		this.setScreen(pms);

		indexMultiplexer.clear();
		indexMultiplexer.addProcessor(pms.getStage());
		indexMultiplexer.addProcessor(new GameModeInputProcessor(this));
		Gdx.input.setInputProcessor(indexMultiplexer);

	}

	@Override
	public void create () {
		setUpTitleScreen();
	}
}
