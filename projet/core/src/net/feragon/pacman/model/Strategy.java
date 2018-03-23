package net.feragon.pacman.model;

import java.util.EnumSet;
import java.util.Random;

import com.badlogic.gdx.math.Vector2;

public class Strategy {
	static Direction reduceXThenY(Vector2 monsterPosition, Vector2 targetPosition, EnumSet<Direction> availableDirections) {
		if(targetPosition.x < monsterPosition.x && availableDirections.contains(Direction.LEFT)) {
			return Direction.LEFT;
		}
		else if(targetPosition.x > monsterPosition.x && availableDirections.contains(Direction.RIGHT)) {
			return Direction.RIGHT;
		}
		else if(targetPosition.y > monsterPosition.y && availableDirections.contains(Direction.UP)) {
			return Direction.UP;
		}
		else if(targetPosition.y < monsterPosition.y && availableDirections.contains(Direction.DOWN)) {
			return Direction.DOWN;
		}
		else {
			return (Direction) availableDirections.toArray()[0];
		}
	}
	
	static Direction getRandomDirection(EnumSet<Direction> possibleDirections) {
		Random random = new Random();
		return (Direction) possibleDirections.toArray()[random.nextInt(possibleDirections.size())];
	}
}
