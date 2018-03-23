package net.feragon.pacman.model;

import net.feragon.pacman.model.Strategy;

import com.badlogic.gdx.math.Vector2;

public class PinkMonster extends Monster {
	public PinkMonster(Vector2 position, World world) {
		super(position, world);
	}
	
	@Override
	protected Direction getNewDirection() {
		Pacman pacman = world.getMaze().getPacman();
		return Strategy.reduceXThenY(getPosition(), pacman.getPosition(), getPossibleDirections());
	}
}
