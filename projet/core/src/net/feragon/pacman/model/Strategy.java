package net.feragon.pacman.model;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashSet;
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
	
	static Direction flood(Vector2 monsterPosition, Vector2 target, World world) throws PathNotFoundException {
		if(target == monsterPosition) {
			return null;
		}
		
		ArrayList<Vector2> nextBlocks = new ArrayList<Vector2>();
		HashSet<Vector2> closedBlocks = new HashSet<Vector2>();
		nextBlocks.add(target);
		closedBlocks.add(target);

		while(!nextBlocks.isEmpty()) {
			Vector2 block = nextBlocks.get(0);
			
			EnumMap<Direction, Vector2> neighbors = world.getMaze().neighbors(block);
			
			for(Direction direction : neighbors.keySet()) {
				Vector2 nextBlock = neighbors.get(direction);
				
				if(nextBlock.equals(monsterPosition)) {
					return direction.reverse();
				}
				
				if(world.getMaze().get(nextBlock) instanceof Blocking) {
					continue;
				}
				
				if(closedBlocks.contains(nextBlock)) {
					continue;
				}
				
				nextBlocks.add(nextBlock);
				closedBlocks.add(nextBlock);
			}
			
			nextBlocks.remove(0);
		}
		
		throw new PathNotFoundException("Chemin non trouvé");
	}
}
