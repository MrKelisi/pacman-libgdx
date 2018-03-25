package net.feragon.pacman.model;

import com.badlogic.gdx.math.Vector2;

public class RedMonster extends Monster {
	public RedMonster(Vector2 position, World world) {
		super(position, world);
	}
	
	@Override
	protected Direction getNewDirection() {
		try {
			Direction direction = Strategy.flood(getPosition(), world.getMaze().getPacman().getPosition(), world);
			if(direction == null) {
				return world.getMaze().getPacman().nextDirection();
			}
			return direction;
		}
		catch (PathNotFoundException e) {
			return Strategy.getRandomDirection(getPossibleDirections());
		}
	}
}
