package net.feragon.pacman.screens;

import net.feragon.pacman.model.World;
import net.feragon.pacman.view.TextureFactory;
import net.feragon.pacman.view.WorldRenderer;

public class GameScreen {
	private WorldRenderer renderer;
	private World world;
	
	public GameScreen() {
		world = new World();
		renderer = new WorldRenderer(world);
	}

	public void show() {
		
	}
	
	public void render(float elapsedTime) {
		renderer.render();
	}
	
	public void resize(int width, int height) {
	
	}
	
	public void pause() {
		
	}
	
	public void resume() {
		
	}
	
	public void dispose() {
		renderer.dispose();
		TextureFactory.getInstance().dispose();
	}

	public World getWorld() {
		return world;
	}
}
