package net.feragon.pacman.model;

import java.util.EnumSet;

import com.badlogic.gdx.math.Vector2;

public abstract class Monster extends Player implements IUpdateable {
	public static final double WEAK_TIME = 10;
	private double _weakTime;
	private boolean dead;
	
	public Monster(Vector2 position, World world) {
		super(position, world);
		dead = false;
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
			if(!isDead() && isIntersection()) {
				Direction direction = direction();
				EnumSet<Direction> directions = getPossibleDirections();
				
				if(directions.contains(Direction.LEFT) && !direction.equals(Direction.RIGHT)) {
					setDirection(Direction.LEFT);
				}
				else if(directions.contains(Direction.UP) && !direction.equals(Direction.DOWN)) {
					setDirection(Direction.UP);
				}
				else if(directions.contains(Direction.RIGHT) && !direction.equals(Direction.LEFT)) {
					setDirection(Direction.RIGHT);
				}
				else if(directions.contains(Direction.DOWN) && !direction.equals(Direction.UP)) {
					setDirection(Direction.DOWN);
				}
				else if(directions.size() > 0) {
					setDirection(directions.iterator().next());
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

	/**
	 * @return Temps de vulnérabilité restant
	 */
	public double getWeakTime() {
		return _weakTime;
	}

	/**
	 * Rend le monstre vulnérable
	 */
	public void setWeak() {
		_weakTime = WEAK_TIME;
	}
	
	/**
	 * Enlève la vulnérabilité du monstre
	 */
	private void resetWeak() {
		_weakTime = 0;
	}

	/**
	 * @return Vrai si le monstre est mort
	 */
	public boolean isDead() {
		return dead;
	}
	
	/**
	 * Tue le monstre
	 */
	public void setDead() {
		dead = true;
	}
	
	/**
	 * Ressucite le monstre
	 */
	public void resetDead() {
		dead = false;
	}
	
	@Override
	public void update(double timeElapsed) {
		if(_weakTime > 0) {
			_weakTime -= timeElapsed;
		}
	}
}
