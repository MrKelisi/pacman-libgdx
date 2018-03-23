package net.feragon.pacman.model;

import net.feragon.pacman.model.Strategy;

import com.badlogic.gdx.math.Vector2;

public class YellowMonster extends Monster {
	public YellowMonster(Vector2 position, World world) {
		super(position, world);
	}

	@Override
	protected Direction getNewDirection() {
		return Strategy.getRandomDirection(getPossibleDirections());
	}
}
