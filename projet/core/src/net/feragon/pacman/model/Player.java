package net.feragon.pacman.model;

import com.badlogic.gdx.math.Vector2;

public class Player extends GameElement {
	private Direction _direction;
	private int _points;
	
	public Player(Vector2 position, World world) {
		super(position, world);
		_direction = Direction.LEFT;
		_points = 0;
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

	/**
	 * @return int Points du joueur
	 */
	public int points() {
		return _points;
	}

	/**
	 * Ajoute des points au joueur
	 * @param points nombre de points
	 */
	public void addPoints(int points) {
		_points += points;
	}
}
