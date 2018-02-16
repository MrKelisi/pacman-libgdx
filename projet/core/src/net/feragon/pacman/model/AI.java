package net.feragon.pacman.model;

import com.badlogic.gdx.math.Vector2;

public interface AI {
	/**
	 * Donne une nouvelle position
	 * @return Position
	 */
	Vector2 getNewPosition();
}
