package net.feragon.pacman.model;

import net.feragon.pacman.model.Strategy;

import com.badlogic.gdx.math.Vector2;

public class PinkMonster extends Monster {
	public PinkMonster(Vector2 position, World world) {
		super(position, world);
	}
	
	@Override
	protected Direction getNewDirection() {
		try {
			if (isDead()) {
				Direction direction = Strategy.flood(getPosition(), getStartPos(), world);
				if (direction == null) {
					resetDead();
					return Direction.DOWN;
				}
				return direction;
			}
		} catch(PathNotFoundException e) {
			return Strategy.getRandomDirection(getPossibleDirections());
		}

		Pacman pacman = world.getMaze().getPacman();
		return Strategy.reduceXThenY(getPosition(), pacman.getPosition(), getPossibleDirections());
	}
}
