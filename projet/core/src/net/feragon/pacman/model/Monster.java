package net.feragon.pacman.model;

import java.util.EnumSet;

import com.badlogic.gdx.math.Vector2;

public abstract class Monster extends Player {
	public static final double WEAK_TIME = 10;
	private double _weakTime;
	private boolean dead = false;
	
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
	 * @return Vrai si le monstre se trouve dans la maison
	 */
	private boolean isInHome() {
		GameElement ge = world.getMaze().get(getPosition());
		
		return ge instanceof Blocking || ge instanceof Monster;
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
		
		if(isInHome()) {
			//TODO: sortir de la maison sans dépendre du niveau
			if(!isDead()) {
				if(getPosition().x <= 12) {
					setDirection(Direction.RIGHT);
				}
				else if(getPosition().x >= 14) {
					setDirection(Direction.LEFT);
				}
				else {
					setDirection(Direction.UP);
				}
			}
			else {
				setDirection(getNewDirection());
			}
		}
		else if(isIntersection()) {
			setDirection(getNewDirection());
		}
	}

	public double getWeakTime() {
		return _weakTime;
	}

	public void setWeak() {
		_weakTime = WEAK_TIME;
	}
	
	private void resetWeak() {
		_weakTime = 0;
	}

	public boolean isDead() {
		return dead;
	}
	public void setDead() {
		dead = true;
	}
	public void resetDead() {
		dead = false;
	}
	
	public void update(double timeElapsed) {
		if(_weakTime > 0) {
			_weakTime -= timeElapsed;
		}
	}
}
