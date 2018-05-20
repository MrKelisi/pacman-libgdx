package net.feragon.pacman.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import net.feragon.pacman.model.World;
import net.feragon.pacman.view.WorldRenderer;

public class GameScreen implements Screen {
	private WorldRenderer renderer;
	private World world;
	
	public GameScreen(Game game) {
		world = new World();
		renderer = new WorldRenderer(world);
	}

	public void show() {
		
	}

	@Override
	public void render(float elapsedTime) {
		renderer.render(elapsedTime);
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
