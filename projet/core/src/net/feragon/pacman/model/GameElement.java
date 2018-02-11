package net.feragon.pacman.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public abstract class GameElement {
	private Vector2 position;
	protected World world;
	
	public GameElement(Vector2 position, World world) {
		this.position = position;
		this.world = world;
	}

	public Vector2 getPosition() {
		return position;
	}
	
	public void setPosition(Vector2 position) {
		this.position = position;
	}

	public float getWidth() {
		return getTexture().getWidth();
	}
	
	public float getHeight() {
		return getTexture().getHeight();
	}
	
	public abstract Texture getTexture();
}
