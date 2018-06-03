package net.feragon.pacman.screens;

import com.badlogic.gdx.Screen;
import net.feragon.pacman.PacmanGDX;
import net.feragon.pacman.model.EndGameException;
import net.feragon.pacman.model.World;
import net.feragon.pacman.view.WorldRenderer;

public class GameScreen implements Screen {
	private WorldRenderer renderer;
	private World world;
	private PacmanGDX game;
	
	public GameScreen(PacmanGDX game) {
		world = new World();
		renderer = new WorldRenderer(world);
		this.game = game;
	}

	@Override
	public void show() {
		
	}

	@Override
	public void render(float elapsedTime) {
		try {
			renderer.render(elapsedTime);

		} catch (EndGameException message) {
			game.setUpEndScreen(message.getMessage());
		}
	}
	
	@Override
	public void resize(int width, int height) {
	
	}
	
	@Override
	public void pause() {
		
	}
	
	@Override
	public void resume() {
		
	}

	@Override
	public void hide() {

	}

	@Override
	public void dispose() {
		renderer.dispose();
	}

	/**
	 * @return Monde affiché
	 */
	public World getWorld() {
		return world;
	}
}
