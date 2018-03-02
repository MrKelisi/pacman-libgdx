package net.feragon.pacman.model;

import java.util.EnumSet;

import com.badlogic.gdx.math.Vector2;

public abstract class Monster extends Player {
	public Monster(Vector2 position, World world) {
		super(position, world);
	}

	@Override
	protected boolean isElementAccessible(GameElement ge) {
		if(ge instanceof Blocking) {
			return ((Blocking) ge).allowMonsters();
		}
		return true;
	}
	
	/**
	 * @return Vrai si le monstre se trouve sur une intersection
	 */
	private boolean isIntersection() {
		int directionsCount = 0;
		
		for(Direction direction : Direction.values()) {
			if(isElementAccessible(world.getMaze().get(getOrigin().cpy().add(direction.moveVector())))) {
				directionsCount++;
			}
			else if(direction.equals(direction())) {
				directionsCount++;
			}
			
			if(directionsCount > 2) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * @return Toutes les directions possibles
	 */
	protected EnumSet<Direction> getPossibleDirections() {
		EnumSet<Direction> directions = EnumSet.noneOf(Direction.class);
		
		for(Direction direction : Direction.values()) {
			if(isElementAccessible(world.getMaze().get(getOrigin().cpy().add(direction.moveVector())))) {
				directions.add(direction);
			}
		}
		
		return directions;
	}

	/**
	 * Donne une nouvelle direction
	 * @return Nouvelle direction
	 */
	abstract protected Direction getNewDirection();

	@Override
	public void move() {
		super.move();
		
		if(isIntersection()) {
			setDirection(getNewDirection());
		}
	}
	
	
}
