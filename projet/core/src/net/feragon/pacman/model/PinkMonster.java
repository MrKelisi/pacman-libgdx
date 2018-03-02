package net.feragon.pacman.model;

import java.util.EnumSet;

import com.badlogic.gdx.math.Vector2;

public class PinkMonster extends Monster {
	public PinkMonster(Vector2 position, World world) {
		super(position, world);
	}
	
	@Override
	protected Direction getNewDirection() {
		EnumSet<Direction> directions = getPossibleDirections();
		
		Vector2 pacman = world.getMaze().getPacman().getPosition();
		if(pacman.x < getPosition().x && directions.contains(Direction.LEFT)) {
			return Direction.LEFT;
		}
		else if(pacman.x > getPosition().x && directions.contains(Direction.RIGHT)) {
			return Direction.RIGHT;
		}
		else if(pacman.y > getPosition().y && directions.contains(Direction.UP)) {
			return Direction.UP;
		}
		else if(pacman.y < getPosition().y && directions.contains(Direction.DOWN)) {
			return Direction.DOWN;
		}
		else {
			return (Direction) directions.toArray()[0];
		}
	}
}
