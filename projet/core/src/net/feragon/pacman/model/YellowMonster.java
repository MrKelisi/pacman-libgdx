package net.feragon.pacman.model;

import java.util.EnumSet;
import java.util.Random;

import com.badlogic.gdx.math.Vector2;

public class YellowMonster extends Monster {
	public YellowMonster(Vector2 position, World world) {
		super(position, world);
	}

	@Override
	protected Direction getNewDirection() {
		EnumSet<Direction> directions = getPossibleDirections();
		Random random = new Random();
		
		return (Direction) directions.toArray()[random.nextInt(directions.size())];
	}
}
