package net.feragon.pacman.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import net.feragon.pacman.model.AI;
import net.feragon.pacman.model.GameElement;
import net.feragon.pacman.model.Pacman;
import net.feragon.pacman.model.World;

public class WorldRenderer {
	private SpriteBatch spriteBatch;
	private World world;
	private Vector2 size;
	private OrthographicCamera camera;
	
	public WorldRenderer(World world) {
		spriteBatch = new SpriteBatch();
		this.world = world;
		size = new Vector2(16, 16);
		
		camera = new OrthographicCamera();
		float width = world.getWidth() * size.x;
		float height = world.getHeight() * size.y;
		
		camera.setToOrtho(false, width, height);
		camera.position.set(width/2, height/2, 0);
	}
	
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(0, 0, 0, 1);
		
		spriteBatch.setProjectionMatrix(camera.combined);
		
		spriteBatch.begin();
		for(GameElement ge : world) {
			spriteBatch.draw(ge.getTexture(), ge.getPosition().x * size.x, ge.getPosition().y * size.y, size.x, size.y);
		}
		
		spriteBatch.end();
	}
	
	public void dispose() {
		spriteBatch.dispose();
	}
}
