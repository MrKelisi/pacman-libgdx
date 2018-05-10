package net.feragon.pacman.model;

import com.badlogic.gdx.math.Vector2;

public abstract class GameElement {
	private Vector2 position;
	protected World world;
	private boolean show = true;
	
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

	public boolean isShown() {
		return show;
	}

	public void setShow(boolean sh) {
		show = sh;
	}
}
