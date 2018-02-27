package net.feragon.pacman.model;

import com.badlogic.gdx.math.Vector2;

public class Player extends GameElement {
	private Direction _direction;
	
	public Player(Vector2 position, World world) {
		super(position, world);
		_direction = Direction.LEFT;
	}

	/**
	 * @return Direction du joueur
	 */
	public Direction direction() {
		return _direction;
	}

	/**
	 * Change la direction du joueur
	 * @param direction Nouvelle direction
	 */
	public void setDirection(Direction direction) {
		_direction = direction;
	}
	
	
}
