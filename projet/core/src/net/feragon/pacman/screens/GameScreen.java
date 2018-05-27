package net.feragon.pacman.screens;

import com.badlogic.gdx.Screen;
import net.feragon.pacman.PacmanGDX;
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

	public void show() {
		
	}

	@Override
	public void render(float elapsedTime) {
		try {
			renderer.render(elapsedTime);

		} catch (Exception message) {
			game.setUpEndScreen(message.getMessage());
		}
	}
	
	public void resize(int width, int height) {
	
	}
	
	public void pause() {
		
	}
	
	public void resume() {
		
	}

	@Override
	public void hide() {

	}

	public void dispose() {
		renderer.dispose();
	}

	public World getWorld() {
		return world;
	}
}
