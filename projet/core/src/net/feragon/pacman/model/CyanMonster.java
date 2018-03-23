package net.feragon.pacman.model;

import java.util.Random;

import com.badlogic.gdx.math.Vector2;

public class CyanMonster extends Monster {
	public CyanMonster(Vector2 position, World world) {
		super(position, world);
	}
	
	@Override
	protected Direction getNewDirection() {
		Random random = new Random();
		if(random.nextBoolean()) {
			return Strategy.getRandomDirection(getPossibleDirections());
		}
		else {
			return Strategy.reduceXThenY(getPosition(), world.getMaze().getPacman().getPosition(), getPossibleDirections());
		}
	}
}
