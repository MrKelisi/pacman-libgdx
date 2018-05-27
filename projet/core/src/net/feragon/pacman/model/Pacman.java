package net.feragon.pacman.model;

import com.badlogic.gdx.math.Vector2;

public class Pacman extends Player {
	private Direction _nextDirection;
	private int _points;
	private int _lifes;
	
	public Pacman(Vector2 position, World world) {
		super(position, world);
		_nextDirection = direction();
		_points = 0;
		_lifes = 2;
	}
	
	/**
     * Change la prochaine direction du joueur
     * @param nextDirection Nouvelle direction
     */
	public void setNextDirection(Direction nextDirection) {
		if(nextDirection == null) {
			throw new NullPointerException("Direction null");
		}
	    _nextDirection = nextDirection;
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

	@Override
	public void move() {
		super.move();
		
		Vector2 newDirectionNextPos = getPosition().cpy().add(_nextDirection.moveVector());
        if(!(world.getMaze().get(newDirectionNextPos) instanceof Blocking)) {
        	setDirection(_nextDirection);
        }
	}

	/**
	 * @return Prochaine direction du joueur
	 */
	public Direction nextDirection() {
		return _nextDirection;
	}
	
	public int getLifes() {
		return _lifes;
	}

	public void takeALife() {
		_lifes--;
	}
}
