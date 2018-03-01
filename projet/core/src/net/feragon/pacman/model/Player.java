package net.feragon.pacman.model;
import com.badlogic.gdx.math.Vector2;

public class Player extends GameElement {
	private Direction _direction;
	private Direction _nextDirection;
	private Vector2 _origin;
	private int _points;
	
	public Player(Vector2 position, World world) {
		super(position, world);
		_origin = position;
		_direction = Direction.LEFT;
		_nextDirection = Direction.LEFT;
		_points = 0;
	}

	@Override
	public void setPosition(Vector2 position) {
		super.setPosition(position);
		_origin = position;
	}

	/**
	 * @return Direction du joueur
	 */
	public Direction direction() {
		return _direction;
	}

	/**
	 * Change la direction du joueur
	 * @param direction Nouvelle direction
	 */
	public void setDirection(Direction direction) {
		if(direction == null) {
			throw new NullPointerException("Direction null");
		}
		_direction = direction;
	}

    /**
     * Change la prochaine direction du joueur
     * @param nextDirection Nouvelle direction
     */
	public void setNextDirection(Direction nextDirection) {
		if(nextDirection == null) {
			throw new NullPointerException("Direction null");
		}
	    _nextDirection = nextDirection;
    }

	/**
	 * Donne la position d'origine du joueur
	 * @return Position d'origine
	 */
	public Vector2 getOrigin() {
		return _origin;
	}

	/**
	 * @return int Points du joueur
	 */
	public int points() {
		return _points;
	}

	/**
	 * Ajoute des points au joueur
	 * @param points nombre de points
	 */
	public void addPoints(int points) {
		_points += points;
	}
	
	/**
	 * Donne la prochaine position du joueur
	 * @return Prochaine position
	 */
	private Vector2 getNextPosition(Direction direction) {
		return _origin.cpy().add(direction.moveVector());
	}
	
	/**
	 * Déplace le joueur d'une case complète
	 */
	public void move() {
		Vector2 newPos = getNextPosition(_direction);

        if(world.getMaze().get(newPos) instanceof Blocking) {
        	newPos = _origin.cpy();
        }
        else {
            if(newPos.x < 0) {
                newPos.set(world.getWidth() - 1, newPos.y);
            }
            else if(newPos.x > world.getWidth() - 1) {
            	newPos.set(0, newPos.y);
            }
            
            setPosition(newPos);
        }
        
        Vector2 newDirectionNextPos = newPos.cpy().add(_nextDirection.moveVector());
        if(!(world.getMaze().get(newDirectionNextPos) instanceof Blocking)) {
        	_direction = _nextDirection;
        }
	}
	
	/**
	 * Déplace le joueur précisément
	 * @param timeElapsed Temps écoulé depuis le dernier déplacement complet
	 * @TODO: la recherche de position peut être optimisée
	 */
	public void move(float timeElapsed) {
		Vector2 newPos = getNextPosition(_direction);
		Vector2 oldOrigin = _origin.cpy();

        if(!(world.getMaze().get(newPos) instanceof Blocking)) {
        	Vector2 moveVector = direction().moveVector().scl(timeElapsed / World.TICK_TIME);
    		setPosition(_origin.cpy().add(moveVector));
        }
        
        _origin = oldOrigin;
	}
}
